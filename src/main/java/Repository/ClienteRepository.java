package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Entidade.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long> ,CrudRepository<Cliente, Long> {

}
