package com.generation.tucancha.dto.request;

import com.generation.tucancha.model.enums.RolUsuario;
import jakarta.validation.constraints.*;

public record UsuarioRequestDTO(

        @NotBlank(message = "El nombre completo es obligatorio")
        String nombre,

        @NotBlank(message = "El correo electrónico es obligatorio")
        @Email(message = "Debe ingresar un correo electrónico válido")
        String correo,

        @NotBlank(message = "El teléfono es obligatorio")
        @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "El número de teléfono no es válido")
        String telefono,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
                message = "La contraseña debe contener al menos una letra y un número")
        String password,

        @AssertTrue(message = "Debes aceptar los términos y condiciones para crear una cuenta")
        boolean estado
) {}