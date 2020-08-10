package com.cartoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartoes.controller.entrada.EntradaPagamento;
import com.cartoes.entity.Pagamento;
import com.cartoes.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @PostMapping()
    public ResponseEntity<Pagamento> criar(@RequestBody EntradaPagamento entradaPagamento) {
        return new ResponseEntity<Pagamento>(service.criar(entradaPagamento), new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/{id_cartao}")
    public List<Pagamento> buscaPorCartao(@PathVariable("id_cartao") Long id){

        return service.buscarPorCartao(id);

    }


}