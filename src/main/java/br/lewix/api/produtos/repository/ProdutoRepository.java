package br.lewix.api.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.lewix.api.produtos.model.ProdutoModel;

// responsavel por disponibilizar acoes
// de banco de dados


// faz o spring entender como repositorio e injecao de dependencias
@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long>{
  
}
