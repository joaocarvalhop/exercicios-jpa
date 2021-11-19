package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {

		Produto p1 = new Produto("Tablet", 568.89);
		DAO<Produto> dao = new DAO<>(Produto.class);
		// abrir transaçao incluir produto e fechar transação
		// dao.abrirT().incluir(p1).fechar();
		dao.incluirAtomico(p1).fechar();
		
		System.out.println("Id do produto inserido: " + p1.getId());
	}

}
