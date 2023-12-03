package ru.netology.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.netology.moneytransferservice.exception.ErrorInputData;
import ru.netology.moneytransferservice.logger.Logger;
import ru.netology.moneytransferservice.model_dto.ConfirmationData;
import ru.netology.moneytransferservice.model_dto.OperationStatus;
import ru.netology.moneytransferservice.model_dto.TransferMoneyData;
import ru.netology.moneytransferservice.repository.TransferMoneyRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class TransferMoneyService {
    private final TransferMoneyRepository transferMoneyRepository;
    private final String LOGGER_PATH = "src/main/java/ru/netology/moneytransferservice/logs/logs.txt";

    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }
    public void transfer(TransferMoneyData transferMoneyData) {
        transferMoneyData.setId(String.valueOf(UUID.randomUUID()));
        Logger logger = new Logger(LOGGER_PATH);
        logger.log("Date : " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n"
                + "Card From : " + transferMoneyData.getCardFromNumber() + "\n"
                + "Card To : " + transferMoneyData.getCardToNumber() + "\n"
                + "Value : " + transferMoneyData.getAmount().getValue() / 100 + "\n"
                + "Commission : 1%" + "\n"
                + "ID : " + transferMoneyData.getId() + "\n");
        transferMoneyRepository.saveTransferData(transferMoneyData);
    }
    public OperationStatus confirm(ConfirmationData confirmationData) throws ErrorInputData {
        TransferMoneyData transferMoneyData = transferMoneyRepository.getTransfers().pop();
        String code = transferMoneyRepository.getOperations()
                .getOrDefault(transferMoneyData.getId(), "0000");
        if (confirmationData.getCode().equals(code)) {
            return transferMoneyRepository.saveConfirmationData(confirmationData);
        } else {
            throw new ErrorInputData("Wrong verification code!");
        }
    }






}
