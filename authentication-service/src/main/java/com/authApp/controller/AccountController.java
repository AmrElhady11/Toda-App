package com.authApp.controller;

import com.authApp.request.ChangePasswordRequest;
import com.authApp.request.DeleteRequest;
import com.authApp.request.UpdateRequest;
import com.authApp.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
@Tag(name = "Account")
public class AccountController {
    private final AuthenticationService authenticationService;

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAccount(@RequestBody DeleteRequest deleteRequest) {
        authenticationService.deleteUser(deleteRequest);
        return ResponseEntity.ok("Account deleted");


    }
    @PutMapping("/update")
    public ResponseEntity<String> updateAccount(@RequestBody UpdateRequest updateRequest) {
        authenticationService.updateUser(updateRequest);
        return ResponseEntity.ok("Account updated");


    }
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        authenticationService.changePassword(changePasswordRequest);
        return ResponseEntity.ok("Password changed");
    }

}
