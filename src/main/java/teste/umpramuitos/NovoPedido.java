package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

// insert
public class NovoPedido {

	public static void main(String[] args) {

		DAO<Object> dao = new DAO<>();

		// já está com a data de agora, pq foi instanciada no construtor
		Pedido pedido = new Pedido();
		Produto produto = new Produto("iPhone SE 128Gb", 2899.99);
		ItemPedido item = new ItemPedido(pedido, produto, 4);

		dao.abrirT().incluir(produto).incluir(pedido).incluir(item).fecharT().fechar();
	}

}
