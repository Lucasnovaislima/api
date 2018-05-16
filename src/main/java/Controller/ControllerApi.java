package Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Entidade.Cliente;
import Entidade.Produto;
import Repository.ProdutoRepository;

public class ControllerApi {
	
	@Autowired
	ProdutoRepository repository;
	
	@RequestMapping(value = "salvar" , method = RequestMethod.POST)
	public String salvar(@RequestParam("nomeProduto")String nomeProduto, @RequestParam("nomeCliente")String nomeCliente,
			 @RequestParam("nomeCategoria")String nomeCategoria, @RequestParam("dataCadastro")Date dataCadastro){
		
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setCategoria(nomeCategoria);
		produto.setDataHora(dataCadastro);
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(nomeCliente);
		
		produto.setCliente(cliente);
		
		repository.save(produto);
		
		return "listaprodutos";
		
	}
	
	@RequestMapping(value = "/{nomeProduto}", method = RequestMethod.GET)
    public String listaProdutos(@RequestParam("nomeProdutor") String nomeProduto, Model model) {
          List<Produto> listaprodutos = repository.findByNome(nomeProduto);
          if (listaprodutos != null) {
                model.addAttribute("listaprodutos", listaprodutos);
          }
          return "listaprodutos";
    }
	
	@RequestMapping(value = "/{nomeCategoria}", method = RequestMethod.GET)
    public String listaProdutosCategoria(@RequestParam("nomeCategoria") String nomeCategoria, Model model) {
          List<Produto> listaprodutos = repository.findByCategoria(nomeCategoria);
          if (listaprodutos != null) {
                model.addAttribute("listaprodutos", listaprodutos);
          }
          return "listaprodutos";
    }

}
