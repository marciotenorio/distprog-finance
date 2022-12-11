package br.imd.distprog.finance.controller;

import br.imd.distprog.finance.dto.billpayable.BillPayablePostRequestBody;
import br.imd.distprog.finance.dto.billpayable.BillPayablePutRequestBody;
import br.imd.distprog.finance.model.BillPayable;
import br.imd.distprog.finance.service.BillPayableService;
import br.imd.distprog.finance.util.Route;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Route.BILLS_PAYABLE)
@AllArgsConstructor
public class BillPayableController {

    private BillPayableService billPayableService;

    @GetMapping
    public ResponseEntity<List<BillPayable>> findAll(){
        return ResponseEntity.ok(billPayableService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillPayable> findById(@PathVariable Long id){
        return ResponseEntity.ok(billPayableService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<BillPayable> save(@RequestBody BillPayablePostRequestBody billPayablePostRequestBody){
        return new ResponseEntity<>(billPayableService.save(billPayablePostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody BillPayablePutRequestBody billPayablePutRequestBody){
        billPayableService.replace(billPayablePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        billPayableService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
