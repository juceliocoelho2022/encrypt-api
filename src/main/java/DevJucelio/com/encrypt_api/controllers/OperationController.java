package DevJucelio.com.encrypt_api.controllers;

import DevJucelio.com.encrypt_api.domain.operation.Operation;
import DevJucelio.com.encrypt_api.dto.OperationDTO;
import DevJucelio.com.encrypt_api.services.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/operation")
public class OperationController {

    final private OperationService service;


    public  OperationController(OperationService service){
       this.service = service;
    }

    @PostMapping
    public ResponseEntity<Operation> create(@RequestBody OperationDTO operationDTO, UriComponentsBuilder uriBuilder){
        Operation newOperation = this.service.create(operationDTO);

        var uri = uriBuilder.path("/api/operation/{id}").buildAndExpand(newOperation.getId()).toUri();

        return  ResponseEntity.created(uri).body(newOperation);
    }
}
