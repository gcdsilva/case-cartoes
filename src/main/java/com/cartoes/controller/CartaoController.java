package com.cartoes.controller;

import com.cartoes.controller.entrada.EntradaCartao;
import com.cartoes.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cartoes.entity.Cartao;
import com.cartoes.service.CartaoService;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
	
	@Autowired
	CartaoService service;

	@GetMapping("/{numero}")
	public List<Cartao> buscarPorNumero(@PathVariable("numero") String id) {
		return service.buscaPorNumero(id);
	}

	@PatchMapping("/{numero}")
	public ResponseEntity<Cartao> atualizar(@PathVariable("numero") String numero, @RequestBody EntradaCartao entradaCarta) {

		return new ResponseEntity<Cartao>(service.atualizar(numero, entradaCarta), new HttpHeaders(), HttpStatus.OK);
	}

}
