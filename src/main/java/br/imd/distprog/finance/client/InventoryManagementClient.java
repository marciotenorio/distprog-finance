package br.imd.distprog.finance.client;

import br.imd.distprog.finance.exception.UnavailableResourceException;
import br.imd.distprog.finance.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class InventoryManagementClient {

    public List<Product> findAll(){
        try{
            Product[] products = new RestTemplate()
                    .getForObject("http://inventory-management/products", Product[].class);

            return Arrays.stream(products).toList();
        } catch (ResourceAccessException e){
            throw new UnavailableResourceException("External dependency unavailable.");
        }
    }
}
