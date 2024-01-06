package com.curso.api.dtos.category;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class SaveCategory implements Serializable {
    @NotBlank(message = "El nombre es requerido")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
