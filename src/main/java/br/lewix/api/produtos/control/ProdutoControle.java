package br.lewix.api.produtos.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.lewix.api.produtos.model.ProdutoModel;
import br.lewix.api.produtos.model.RespostaModel;
import br.lewix.api.produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController // criar rotas
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // configura cors
public class ProdutoControle {
  
  @Autowired
  private ProdutoService produtoService;

  @DeleteMapping("/remover/{codigo}")
  public ResponseEntity<RespostaModel> remover(@PathVariable long codigo){
    return produtoService.remover(codigo);
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody ProdutoModel produtoModel){
    return produtoService.salvar(produtoModel, "create");
  }
  
  @PostMapping("/atualizar")
  public ResponseEntity<?> atualizar(@RequestBody ProdutoModel produtoModel){
    return produtoService.salvar(produtoModel, "update");
  }

  @GetMapping("/listar")
  public Iterable<ProdutoModel> listar() {
      return produtoService.listar();
  }


}
