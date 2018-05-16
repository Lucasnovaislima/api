package Entidade;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="auditoria")
public class AuditoriaLog {
	
	@Id
	@GeneratedValue	
	private long id;
	
	
	private Object status;	
	
	private String descricao;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getStatus() {
		return status;
	}


	public void setStatus(Object object) {
		
		this.status = object;
	}

	public String getDescricao() {
		return descricao;
	}

	

	public void setDescricao(String descricao) {
		
		this.descricao = descricao;
	}

	
	

}
