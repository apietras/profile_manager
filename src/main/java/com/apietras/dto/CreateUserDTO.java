package com.apietras.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CreateUserDTO extends ModifyUserDTO {

    @NotBlank
    @Size(min = 6, max = 50)
    private String password;

    @NotBlank
    @Size(min = 6, max = 50)
    private String retypePassword;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordValid() {
        return this.password != null && this.password.equals(this.retypePassword);
    }
}

