package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

// select
public class ObterPedidos {

	public static void main(String[] args) {

		DAO<Pedido> dao = new DAO<>(Pedido.class);

		Pedido pedido = dao.obterPorId(1L);

		for (ItemPedido item : pedido.getItens()) {
			System.out.println(item.getQtde());
			System.out.println(item.getProduto().getNome());
		}
		
		dao.fechar();
	}

}
