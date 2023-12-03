package ru.netology.moneytransferservice.model_dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ConfirmationData {

    private String operationId;
    private String code;
    @Override
    public String toString() {
        return "ConfirmationData{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
