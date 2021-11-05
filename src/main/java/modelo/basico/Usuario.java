package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// mudan�a

@Entity
public class Usuario {

	// @Id faz a referencia a PK
	// @GeneratedValue significa que esse valor � auto_increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// por padr�o vai ser criada uma coluna do tipo varchar de 255 que aceita nulos,
	// mas vc pode especificar usando o @Column(name = "...", nullable = false)
	// nulable � n�o nulo*
	private String nome;

	// @Transient faz com que o atributo n�o seja mapeado para o banco de dados
	private String email;

	public Usuario() {

	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
