package com.frota.checklist.dto;

import lombok.Getter;

@Getter
public enum ChecklistTypeEnum {
    INICIO(1, "INÍCIO"),
    FIM(2, "FIM");

    private final int id;
    private final String description;

    ChecklistTypeEnum(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static ChecklistTypeEnum fromId(Long id) {
        for (ChecklistTypeEnum type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de checklist inválido!");
    }
}
