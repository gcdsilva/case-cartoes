package com.cartoes.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cartoes.controller.entrada.EntradaPagamento;
import com.cartoes.entity.Cartao;
import com.cartoes.entity.Pagamento;
import com.cartoes.repository.CartaoRepository;
import com.cartoes.repository.PagamentoRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    @Autowired
    CartaoRepository repositoryCartao;

    public Pagamento criar(EntradaPagamento entradaPagamento) {

        Optional<Cartao> cartaoOptional = repositoryCartao.findById(entradaPagamento.getCartao_id());


        if(cartaoOptional.isPresent() && cartaoOptional.get().isAtivo()) {
            Pagamento pagamento = new Pagamento();
            pagamento.setCartao(cartaoOptional.get());
            pagamento.setDescricao(entradaPagamento.getDescricao());
            pagamento.setValor(entradaPagamento.getValor());
            return repository.save(pagamento);
        }

        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possivel criar pagamento - cartão não encontrado");

    }


    public List<Pagamento> buscarPorCartao(Long id) {

        List<Pagamento> listaPagamento = repository.buscaPorCartao(id);

        if(listaPagamento.isEmpty()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não encontrado nenhum pagamento");
        }

        return listaPagamento;

    }

}