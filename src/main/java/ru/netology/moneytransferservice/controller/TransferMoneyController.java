package ru.netology.moneytransferservice.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.moneytransferservice.exception.ErrorInputData;
import ru.netology.moneytransferservice.model_dto.ConfirmationData;
import ru.netology.moneytransferservice.model_dto.OperationStatus;
import ru.netology.moneytransferservice.model_dto.TransferMoneyData;
import ru.netology.moneytransferservice.service.TransferMoneyService;
@CrossOrigin(origins = "https://serp-ya.github.io/")
@RestController
public class TransferMoneyController {
    private final TransferMoneyService transferMoneyService;
    public TransferMoneyController(TransferMoneyService transferMoneyService) {
        this.transferMoneyService = transferMoneyService;
    }
    @PostMapping("/transfer")
    public void transfer(@Validated @RequestBody TransferMoneyData transferMoneyData) {
        transferMoneyService.transfer(transferMoneyData);
    }
    @PostMapping("/confirmOperation")
    public OperationStatus confirmOperation(@RequestBody ConfirmationData confirmationData) throws ErrorInputData {
        return transferMoneyService.confirm(confirmationData);
    }
}
