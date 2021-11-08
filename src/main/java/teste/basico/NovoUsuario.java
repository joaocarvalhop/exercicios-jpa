package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

// Insert
public class NovoUsuario {

	public static void main(String[] args) {

		// o emf é criado para configurar o em, é passado a
		// classe Persistence p/ usar o método de criação
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		// o em manipula os dados e tbm estabelece uma conexão com o banco
		EntityManager em = emf.createEntityManager();

		Usuario novoUsuario = new Usuario("weed", "gang@lanche.com.br");

		em.getTransaction().begin();
		// esse método insere novos usários na tabela
		em.persist(novoUsuario);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
