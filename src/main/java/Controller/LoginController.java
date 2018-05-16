package Controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Entidade.Produto;
import Entidade.Usuario;
import Repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class LoginController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@RequestMapping(value="/autenticar" , consumes = MediaType.APPLICATION_JSON_TYPE , method = RequestMethod.GET).

	public LoginResponse autenticar(@RequestBody Usuario usuario){
		
		List<Usuario> usuariodto = repository.findAll();	
		
		String token = Jwts.builder().setSubject(usuariodto).singWitch(SignatureAlgorithm.HS512,"TESTE")
				                     .setExpiration(new Date(System.currentTimeMillis()+1 *60 *1000))
				                     .compact();
		
		return new LoginResponse(token);
		
	}
	
	
	public class LoginResponse{
		
		public String Token;
		
		public LoginResponse(String token){
			
			this.Token = token;
		}
	}

	

}
