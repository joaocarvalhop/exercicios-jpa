package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {

		// o .class é usado quando é preciso fazer uma consulta no bd
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		
		Cliente cliente = dao.obterPorId(2L);
		System.out.println(cliente.getAssento().getNome());
		
		dao.fechar();
	}

}
