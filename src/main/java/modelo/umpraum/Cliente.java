package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	// joincolumn � usado para mapear campos que representam jun��o de tabelas
	// o unique garante que nenhum outro cliente use o assento de outro cliente
	// cascade -> realiza uma opera��o e cascata para a inser��o/persist como a
	// altera��o/merge
	// @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) pode usar dois
	// tipos de opera��o

	// @OneToOne(cascade = CascadeType.ALL) para todos
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "assento_id", unique = true)
	private Assento assento;

	public Cliente() {

	}

	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
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

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

}
