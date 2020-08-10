package com.cartoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cartoes.entity.Pagamento;


@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

    @Query("from Pagamento p WHERE p.cartao.id = :cartaoID")
    public List<Pagamento> buscaPorCartao(@Param("cartaoID") Long cartaoID);

}