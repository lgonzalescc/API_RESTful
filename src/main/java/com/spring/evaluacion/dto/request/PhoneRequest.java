package com.spring.evaluacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhoneRequest {

    @NotBlank(message = "El número de teléfono no puede estar vacío")
    @Size(min = 5, max = 15, message = "El número debe tener entre 5 y 15 dígitos")
    @Pattern(regexp = "^[0-9]+$", message = "El número de teléfono solo debe contener dígitos")
    private String number;

    @NotBlank(message = "El código de ciudad no puede estar vacío")
    @Size(min = 1, max = 5, message = "El código de ciudad debe tener entre 1 y 5 dígitos")
    @Pattern(regexp = "^[0-9]+$", message = "El código de ciudad solo debe contener números")
    private String citycode;

    @NotBlank(message = "El código de país no puede estar vacío")
    @Size(min = 1, max = 3, message = "El código de país debe tener entre 1 y 3 dígitos")
    @Pattern(regexp = "^[0-9]+$", message = "El código de país solo debe contener números")
    private String countrycode;
}
