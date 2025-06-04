package com.authApp.controller;


import com.authApp.request.AuthenticationRequest;
import com.authApp.request.RegisterRequest;
import com.authApp.response.AuthenticationResponse;
import com.authApp.response.UserInfoResponse;
import com.authApp.service.AuthenticationService;
import com.authApp.service.JwtService;
import com.authApp.service.OtpService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final OtpService otpService;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest authRequest)
    {
        authenticationService.register(authRequest);
        String email = authRequest.getEmail();
        otpService.sendOTPCode(email);
        return ResponseEntity.ok(String.format("Successfully registered and OTP code has sent to %s", email));

    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));


    }
    @GetMapping("/activate")
    public ResponseEntity<String> activate(@RequestParam String email,@RequestParam String code){
            otpService.checkOtpCode(email,code);
            authenticationService.enableUser(email);
            return ResponseEntity.ok("Activated");

    }
    @GetMapping("/regenerateOTP")
    public ResponseEntity<String> regenerateOTP(@RequestParam String email){
        otpService.deleteAllOtpCodes(email);
        otpService.sendOTPCode(email);
        return ResponseEntity.ok("OTP Code Generated and has been reset");
    }

    @GetMapping("/checkToken")
    public ResponseEntity<UserInfoResponse> checkToken(@RequestParam String token){
        var user = jwtService.checkToken(token);
        return ResponseEntity.ok(user);

    }

}

