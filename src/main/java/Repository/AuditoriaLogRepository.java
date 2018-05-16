package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Entidade.AuditoriaLog;

public interface AuditoriaLogRepository extends JpaRepository<AuditoriaLog, Long> ,CrudRepository<AuditoriaLog, Long> {
	
}
