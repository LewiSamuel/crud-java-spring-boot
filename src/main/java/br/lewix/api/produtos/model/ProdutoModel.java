package br.lewix.api.produtos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 *  Annotattions
 */
@Entity // saber que esse arquivo vai gerar uma tabela
@Table(name = "produtos") // especifica nome da tabela
@Getter
@Setter
public class ProdutoModel {

  // colunas da tabela
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigo;
  private String nome;
  private String marca;
  
}