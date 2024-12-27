package com.kiem.demoApiNomarlize.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 5, message = "UserName must be less than 5 character!")
    @NotBlank(message = "UserName can't have blank")
     String userName;
    @Size(min = 8, message = "Password must be less than 8 character")
     String password;
     String fullName;
     String address;
    @Past(message = "Date not in past invalid")
     LocalDate dob;
}
