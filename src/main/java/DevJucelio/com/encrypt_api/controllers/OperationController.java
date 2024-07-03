package DevJucelio.com.encrypt_api.controllers;

import DevJucelio.com.encrypt_api.domain.operation.Operation;
import DevJucelio.com.encrypt_api.dto.OperationDTO;
import DevJucelio.com.encrypt_api.dto.OperationResponseDTO;
import DevJucelio.com.encrypt_api.services.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/{id}")
    public ResponseEntity<OperationResponseDTO> create(@PathVariable Long id){
        OperationResponseDTO operation = this.service.read(id);


        return  ResponseEntity.ok(operation);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       this.service.delete(id);


        return  ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Operation> update(@RequestBody OperationDTO operationDTO, @PathVariable Long id){
       Operation updateOperation = this.service.update(operationDTO, id);


        return  ResponseEntity.ok(updateOperation);
    }
}
