package modelo.umpramuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import modelo.basico.Produto;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// muitos itens pedidos para um pedido
	@ManyToOne
	private Pedido pedido;

	// Lazy � o valor deafult de fetch (...ToOne -> EAGER)
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;

	// n�o aceita valor nulo
	@Column(nullable = false)
	private int qtde;

	@Column(nullable = false)
	private Double preco;

	public ItemPedido() {

	}

	public ItemPedido(Pedido pedido, Produto produto, int qtde) {
		super();
		this.setPedido(pedido);
		;
		this.setProduto(produto);
		;
		this.setQtde(qtde);
		;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;

		if (produto != null && this.preco == null) {
			this.setPreco(produto.getPreco());
		}
	}

}
