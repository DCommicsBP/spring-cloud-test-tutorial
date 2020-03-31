package br.com.daione.pavan.api;

import br.com.daione.pavan.domain.Ticket;
import br.com.daione.pavan.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository repository;

    @GetMapping("/ticker")
    public List<Ticket> finAll(){
        return (List<Ticket>) this.repository.findAll();
    }
    @GetMapping("/ticker/{numeroticket}")
    public Ticket findByTicketId(@PathVariable Integer numeroticket){
        return this.repository.findByNumeroPremiado(numeroticket);
    }

    @GetMapping("/ticker/produto/{produtoid}")
    public Ticket findByProductId(@PathVariable("produtoid") Integer produtoid){
        Ticket allByProdutoId = this.repository.findAllByProdutoId(produtoid);
        return allByProdutoId;
    }

    @PostMapping
    public Ticket insert(@RequestBody Ticket ticket){
        return this.repository.save(ticket);
    }
}
