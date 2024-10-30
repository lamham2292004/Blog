package com.mycompany.blog.dto.request;

import jakarta.validation.constraints.Email;
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
    @Email (message = "EMAIL_EXITED")
    String email;
    @Size(min = 8, message = "PASS_INVALID")
    String password;
    @Size(min = 3, message = "FIRSTNAME_INVALID")
    String firstName;
    @Size(min = 3, message = "LASTNAME_INVALID")
    String lastName;
    @Size(min = 2, message = "ADDRESS_INVALID")
    String address;
    LocalDate dob;
}
