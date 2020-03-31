package br.com.daione.pavan.domain;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
    @SequenceGenerator(sequenceName = "ticket_seq", allocationSize = 1, name = "TICKET_SEQ")
    private Integer id;
    private Integer numeroPremiado;
    private String status;
    private Integer produtoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroPremiado() {
        return numeroPremiado;
    }

    public void setNumeroPremiado(Integer numeroPremiado) {
        this.numeroPremiado = numeroPremiado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

//    @Override
//    public String toString() {
//        return "Ticke [ticketId=" + this.getId() + " Número premiado:" +this.getNumeroPremiado() + " Status: " + this.getStatus() + "produtoid: "+ this.getProdutoId() + "]";
//    }
}
