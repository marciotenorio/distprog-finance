package br.imd.distprog.finance.controller;

import br.imd.distprog.finance.client.InventoryManagementClient;
import br.imd.distprog.finance.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryManagementClient inventoryManagementClient;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(inventoryManagementClient.findAll());
    }
}
