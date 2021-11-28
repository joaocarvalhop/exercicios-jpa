package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Double nota;

	// opera��o em cascata significa que quando for persistido um ator
	// autom�ticamente vai ser inserido um filme tamb�m
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "atores_filmes", joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id"))
	private List<Ator> atores;

	public Filme() {

	}

	public Filme(String nome, Double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		if (atores == null) {
			atores = new ArrayList<>();
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public void addAtores(Ator ator) {
		// se ator for nulo, ou se n�o estiver no filme
		if (ator == null && !getAtores().contains(ator)) {
			getAtores().add(ator);

			// se ator n�o estiver contido no filme, adicione ao filme
			if (!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}

}
