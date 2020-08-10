package com.cartoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cartoes.controller.entrada.EntradaCartao;
import com.cartoes.entity.Cartao;
import com.cartoes.entity.Cliente;
import com.cartoes.repository.CartaoRepository;
import com.cartoes.repository.ClienteRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Service
public class CartaoService {

	@Autowired
	CartaoRepository repository;

	@Autowired
	ClienteRepository clienteRepository;

	public Cartao criar(EntradaCartao entradaCartao) {

		Optional<Cliente> cliente = clienteRepository.findById(entradaCartao.getClienteId());

		if (cliente.isPresent()) {
			Cartao cartao = new Cartao();
			cartao.setNumero(entradaCartao.getNumero());
			cartao.setClienteId(cliente.get());
			return repository.save(cartao);
		}

		throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possivel criar - cliente não encontrado");

	}


	public Cartao buscarPorId(Long id) {
		Optional<Cartao> optionalCartao = repository.findById(id);

		return optionalCartao.get();
	}

	public Cartao atualizar(String numeroCartao, EntradaCartao entradaCartao) {
		List<Cartao> listaCartao = repository.buscaPorNumero(numeroCartao);

		Optional<Cartao> optionalCartao = listaCartao.stream().findFirst();

		if (optionalCartao.isPresent()) {
			Cartao cartaoRetornado = optionalCartao.get();
			cartaoRetornado.setAtivo(entradaCartao.isAtivo());

			Cartao cartao = repository.save(cartaoRetornado);
			return cartao;
		}

		throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possivel atualizar - cartão não encontrado");

	}

	public List<Cartao> buscaPorNumero(String numeroCartao){

		List<Cartao> listaCartao = repository.buscaPorNumero(numeroCartao);
		return listaCartao;
	}



}
