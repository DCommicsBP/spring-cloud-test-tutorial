package br.com.daione.pavan.controller;

import br.com.daione.pavan.domain.Product;
import br.com.daione.pavan.domain.Ticket;
import br.com.daione.pavan.repository.ProductRepository;
import br.com.daione.pavan.service.TicketService;
import br.com.daione.pavan.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private TicketServiceImpl service;

    @GetMapping
    public List<Product> listProduct(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Product product(@PathVariable Integer id ){
        return this.repository.findById(id).get();
    }

    @GetMapping(value="/produto/{produtoid}")
    public Product findById(@PathVariable String produtoid) throws ExecutionException, InterruptedException {
        Product produto = this.repository.findById(Integer.parseInt(produtoid)).get();

        Ticket ticket = this.service.FindByProductId(Integer.parseInt(produtoid));
                produto.setTicket(ticket);

        return produto;
    }
}
