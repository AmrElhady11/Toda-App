package com.authApp.response;

import com.authApp.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoResponse {
    private Integer userId;
    private String email;
    private List<Role> roles;
}
