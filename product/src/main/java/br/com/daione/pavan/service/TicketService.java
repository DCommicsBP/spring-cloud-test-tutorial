package br.com.daione.pavan.service;

import br.com.daione.pavan.domain.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="ticket-serve")
public interface TicketService {

    @GetMapping(value = "/ticker/produto/{produtoid}" )
    Ticket FindByProductId(@PathVariable("produtoid") Integer produtoid);
}
