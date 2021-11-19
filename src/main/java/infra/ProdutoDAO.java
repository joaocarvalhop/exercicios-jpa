package infra;

import modelo.basico.Produto;

public class ProdutoDAO extends DAO<Produto> {

	// métodos que só produtoDAO terá, como aplicar desconto para itens tipo X
	
	// construtor fazendo ref a classe pai 
	public ProdutoDAO() {
		super(Produto.class);
	}
}
