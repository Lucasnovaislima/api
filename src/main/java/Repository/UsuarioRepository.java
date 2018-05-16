package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Entidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> ,CrudRepository<Usuario, Long>{
	
		
	    
	   
	 
	
	  

	}



