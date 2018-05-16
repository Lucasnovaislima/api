package Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>,CrudRepository<Produto, Long>{	
	
    
    List<Produto> findByNome(String nome);
     
 
    List<Produto> findByCategoria(String categoria);   
   
  

}
