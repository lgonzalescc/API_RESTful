package com.spring.evaluacion.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Estructura estándar para errores de la API")
public class ErrorResponse {

    @Schema(description = "Código HTTP del error", example = "409")
    private int status;

    @Schema(description = "Tipo de error HTTP", example = "Conflict")
    private String error;

    @Schema(description = "Mensaje descriptivo del error", example = "El correo ya está registrado")
    private String message;

}
