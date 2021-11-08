package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

// Insert
public class NovoUsuario {

	public static void main(String[] args) {

		// o emf � criado para configurar o em, � passado a
		// classe Persistence p/ usar o m�todo de cria��o
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		// o em manipula os dados e tbm estabelece uma conex�o com o banco
		EntityManager em = emf.createEntityManager();

		Usuario novoUsuario = new Usuario("weed", "gang@lanche.com.br");

		em.getTransaction().begin();
		// esse m�todo insere novos us�rios na tabela
		em.persist(novoUsuario);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
