package com.authApp.service;

import com.authApp.entity.Otp;
import com.authApp.entity.User;
import com.authApp.exception.ExpirationException;
import com.authApp.exception.InvalidException;
import com.authApp.exception.NotFoundException;
import com.authApp.repository.OtpRepository;
import com.authApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpService {
    private final OtpRepository otpRepository;
    private final UserRepository userRepository;
    private JavaMailSender emailSender;

    @Autowired
    public OtpService (JavaMailSender emailSender, OtpRepository otpRepository, UserRepository userRepository) {
        this.emailSender = emailSender;
        this.otpRepository = otpRepository;
        this.userRepository = userRepository;
    }

    public void sendOTPCode(String email) {
        var user = getUser(email);

        String otpCode = generateOtpCode();
        var OTP = Otp.builder()
                .otp(otpCode)
                .expirationTime(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        otpRepository.save(OTP);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Active OTP Code");
        message.setText(String.format("Active OTP Code: %s\n"+"Please Do not share it with anyone", otpCode))  ;

        emailSender.send(message);

    }

    private String generateOtpCode() {

        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
    public void deleteAllOtpCodes(String email) {
        var user = getUser(email);

        otpRepository.deleteOtpByUserID(user.getId());

    }
    public void checkOtpCode(String email, String code) {
        var user = getUser(email);
        var otpCode = otpRepository.findValidOtpByUserID(user.getId());
        if (otpCode == null) {
            throw new NotFoundException("No OTP code found for this user");
        }

        if(otpCode.getExpirationTime().isBefore(LocalDateTime.now())) {
            throw new ExpirationException(String.format("OTP code is expired"));
        }
         if(!otpCode.getOtp().equals(code)){
             throw new InvalidException(String.format("Invalid OTP code"));
         }
    }
    private User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                ()->new NotFoundException(String.format("User with email %s not found", email)));
    }

}