package Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entidade.AuditoriaLog;
import Entidade.Cliente;
import Entidade.Produto;
import Repository.AuditoriaLogRepository;
import Repository.ClienteRepository;
import Repository.ProdutoRepository;

@RestController
@RequestMapping("/admin")
public class ClienteController {
	
	private static final Object INSERIDO = "INSERIDO";
	private static final Object ERRO = "ERRO";
	@Autowired
	ClienteRepository repository;
	
	@Autowired
	AuditoriaLogRepository repositoryLog;
	
	
	@RequestMapping(value = "/clientes" , method = RequestMethod.POST)
	public ResponseEntity<Cliente> salvar( @RequestParam("nomeCliente")String nomeCliente
			){
		
		Map<String, Object> registro = new HashMap<String, Object>();
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(nomeCliente);	
		
		
		repository.save(cliente);
		
		
		
		registro.put("INSERIDO",HttpStatus.CREATED);
		registro.put("ERRO",HttpStatus.BAD_REQUEST);
		
		AuditoriaLog registroLog = new AuditoriaLog();
		
		
		if (registro.containsKey(INSERIDO)){
			

			 registroLog.setStatus(registro.get(INSERIDO));
			 registroLog.setDescricao(nomeCliente);
			
			
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.CREATED);
		
		}
		
		 registroLog.setStatus(registro.get(ERRO));
		 registroLog.setDescricao("ERRO AO TENTAR INCLUIR "+nomeCliente);
		
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.BAD_REQUEST);
		
	}

}
