package DevJucelio.com.encrypt_api.serviced;

import DevJucelio.com.encrypt_api.domain.operation.Operation;
import DevJucelio.com.encrypt_api.dto.OperationDTO;
import DevJucelio.com.encrypt_api.repositories.OperationRepository;

public class OperationService {

    private OperationRepository repository;
    private  EncryptService encryptService;

    public  OperationService(OperationRepository repository,
                             EncryptService encryptService){
        this.repository = repository;
        this.encryptService = encryptService;

    }

    public Operation create(OperationDTO operationDTO){
        Operation operation = new Operation();

        String userDocumentHashed = this.encryptService.encryptData(operationDTO.userDocument());
        String creditCardHashed = this.encryptService.encryptData(operationDTO.creditCardToken());


        operation.setCreditCardToken(creditCardHashed);
        operation.setUserDocument(userDocumentHashed);
        operation.setValue(operationDTO.operationValue());

        this.repository.save(operation);

        return operation;
    }

}
