package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atores")
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	// operação em cascata significa que quando for persistido um filme
	// automáticamente vai ser inserido um ator também
	@ManyToMany(mappedBy = "atores", cascade = CascadeType.PERSIST)
	private List<NotaFilme> filmes = new ArrayList<>();

	public Ator() {

	}

	public Ator(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<NotaFilme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<NotaFilme> filmes) {
		this.filmes = filmes;
	}

}
