package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

// mostrando que mesmo fora da trasa??o e sem o m?todo merge ele faz a altera??o
public class AlterarUsuario2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario u1 = em.find(Usuario.class, 5L);
		u1.setNome("Olivia");

		// em.merge(u1);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
