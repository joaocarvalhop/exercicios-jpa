package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos", schema = "curso_java")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// nullable-->>not null
	@Column(name = "prod_nome", length = 200, nullable = false)
	private String nome;

	// precision o tamanho aceitável do número, e scale é quantos 
	// números exibir após o ponto flutuante bo caso os centavos
	@Column(name = "prod_preco", precision = 11, scale = 2, nullable = false)
	private Double preco;

	// toda classe que for mapeado pelo jpa deve possuir um construtor padrão
	public Produto() {

	}

	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
