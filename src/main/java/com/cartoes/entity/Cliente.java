package com.cartoes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;

    @NotNull
    private String nome;


    public Cliente() {
    }

    public Cliente(Long clienteId, String name) {
        this.clienteId = clienteId;
        this.nome = name;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }


    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

}
