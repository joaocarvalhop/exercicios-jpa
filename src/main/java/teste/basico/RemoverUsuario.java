package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

// Delete
public class RemoverUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		Usuario u1 = em.find(Usuario.class, 1L);

		if (u1 != null) {
			em.getTransaction().begin();
			em.remove(u1);
			em.getTransaction().commit();
		}

		em.close();
		emf.close();
	}

}
