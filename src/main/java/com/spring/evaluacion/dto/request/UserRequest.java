package com.spring.evaluacion.dto.request;

import com.spring.evaluacion.validation.ValidPassword;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(
            regexp = "^[\\p{L} .'-]+$",
            message = "El nombre solo puede contener letras, espacios, guiones o apóstrofes"
    )
    private String name;

    @NotBlank(message = "El correo no puede estar vacío")
    @Size(min = 6, max = 150, message = "El correo debe tener máximo 150 caracteres")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @ValidPassword
    private String password;

    @Valid
    @NotEmpty(message = "Debe registrar al menos un teléfono")
    private List<PhoneRequest> phones;
}
