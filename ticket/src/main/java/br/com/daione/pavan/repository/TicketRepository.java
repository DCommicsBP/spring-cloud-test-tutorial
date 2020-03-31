package br.com.daione.pavan.repository;

import br.com.daione.pavan.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findAllByProdutoId(Integer produtoId);
    Ticket findByNumeroPremiado(Integer numeroPremiado);
}
