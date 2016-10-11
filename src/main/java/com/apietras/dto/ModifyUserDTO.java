package com.apietras.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class ModifyUserDTO {

    @NotBlank
    @Size(min = 2)
    private String salutation;

    @NotBlank
    @Size(min = 2)
    private String firstName;


    @NotBlank
    @Size(min = 2)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String houseNumber;

    @NotBlank
    @Size(min = 3)
    private String street;

    @NotBlank
    @Size(min = 3)
    private String city;

    @NotBlank
    @Size(min = 3)
    private String country;

}

