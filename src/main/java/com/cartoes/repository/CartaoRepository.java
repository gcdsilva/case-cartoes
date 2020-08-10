package com.cartoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cartoes.entity.Cartao;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long> {
	
	@Query("from Cartao c WHERE c.numero = :numeroID")
	public List<Cartao> buscaPorNumero(@Param("numeroID") String numeroCartao);


}
