package Entidade;

import java.util.Date;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue	
	private long id;
	
	
	
	private String nome;
	
	private String categoria;
	
	private Cliente cliente;
	
	private Map<String, Object> registro;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Map<String, Object> getRegistro() {
		return registro;
	}

	public void setRegistro(Map<String, Object> registro) {
		this.registro = registro;
	}

	public Date getDataHora() {
		return DataHora;
	}

	public void setDataHora(Date dataHora) {
		DataHora = dataHora;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private Date DataHora;
	
	//Produto String;
	//Cliente: String
	//DataHora: DateTime
	//Categoria: String
	//Registro: Map<String, Object>


}
