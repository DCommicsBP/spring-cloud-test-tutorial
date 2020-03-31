package br.com.daione.pavan.service;

import br.com.daione.pavan.domain.Ticket;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultTicket")
    public Ticket FindByProductId(Integer produtoid) {
        Ticket forObject = this.restTemplate
                .getForObject(
                        "http://TICKET-SERVE/ticker/produto/{produtoid}",
                        Ticket.class,
                        produtoid
                );

        return forObject;
    }

    private Ticket defaultTicket(Integer productid){
        return new  Ticket();
    }
}
