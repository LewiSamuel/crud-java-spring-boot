package br.lewix.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.lewix.api.produtos.model.ProdutoModel;
import br.lewix.api.produtos.model.RespostaModel;
import br.lewix.api.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private RespostaModel respostaModel;

  // Metodo para listar todos os produtos
  public Iterable<ProdutoModel> listar(){
    return produtoRepository.findAll();
  }

  // metodo para cadastrar ou alterar produtos
  public ResponseEntity<?> salvar(ProdutoModel produtoModel, String acao){

      if(produtoModel.getNome().equals("")){

        respostaModel.setMensagem("O nome do produto é obrigatorio");
        return new ResponseEntity<RespostaModel>(respostaModel, HttpStatus.BAD_REQUEST);

      }else if(produtoModel.getMarca().equals("")){

        respostaModel.setMensagem("O Nome da marca é obrigatorio");
        return new ResponseEntity<RespostaModel>(respostaModel, HttpStatus.BAD_REQUEST);
      
      }else{

        return new ResponseEntity<ProdutoModel>(
          produtoRepository.save(produtoModel),
          acao == "create" ? HttpStatus.CREATED : HttpStatus.OK);

      }
  }


  public ResponseEntity<RespostaModel> remover(long codigo){
    produtoRepository.deleteById(codigo);

    respostaModel.setMensagem("O Produto foi removido com sucesso");

    return new ResponseEntity<RespostaModel>(respostaModel, HttpStatus.OK);
  }



}