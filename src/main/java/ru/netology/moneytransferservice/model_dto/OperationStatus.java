package ru.netology.moneytransferservice.model_dto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class OperationStatus {
    private String id;
    private String description;
    public OperationStatus(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
