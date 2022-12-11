package br.imd.distprog.finance.client;


import br.imd.distprog.finance.dto.buyorder.BuyOrderPostRequestBody;
import br.imd.distprog.finance.dto.buyorder.BuyOrderPutRequestBody;
import br.imd.distprog.finance.exception.UnavailableResourceException;
import br.imd.distprog.finance.model.BuyOrder;
import br.imd.distprog.finance.model.Sale;
import br.imd.distprog.finance.util.Route;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProcurementClient {

    public Sale findSaleById(Long id){
        try{
            return new RestTemplate()
                    .getForObject(Route.PROCUREMENT_SALES, Sale.class, id);
        } catch (ResourceAccessException e){
            throw new UnavailableResourceException("External dependency unavailable.");
        }
    }

    public BuyOrder findBuyOrderById(Long id){
        try{
            return new RestTemplate()
                    .getForObject(Route.PROCUREMENT_BUY_ORDER_BY_ID, BuyOrder.class, id);
        } catch (ResourceAccessException e){
            throw new UnavailableResourceException("External dependency unavailable.");
        }
    }

    public BuyOrder saveBuyOrder(BuyOrderPostRequestBody buyOrder){
        try{
            return new RestTemplate()
                    .postForObject(Route.PROCUREMENT_BUY_ORDER, buyOrder, BuyOrder.class);
        } catch (ResourceAccessException e){
            throw new UnavailableResourceException("External dependency unavailable.");
        }
    }

    public void replaceBuyOrder(BuyOrderPutRequestBody buyOrderPutRequestBody) {
        try{
            new RestTemplate()
                    .put(Route.PROCUREMENT_BUY_ORDER, buyOrderPutRequestBody);
        } catch (ResourceAccessException e){
            throw new UnavailableResourceException("External dependency unavailable.");
        }
    }
}
