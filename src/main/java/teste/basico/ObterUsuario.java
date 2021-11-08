package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

// Select
public class ObterUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		// o Select não precisa do Transaction
		// L tipo long
		Usuario user = em.find(Usuario.class, 3L);
		System.out.println(user.getNome());

		em.close();
		emf.close();
	}
}
