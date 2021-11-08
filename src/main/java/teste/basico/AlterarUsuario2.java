package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// usu�rio de id 5
		Usuario u1 = em.find(Usuario.class, 5L);
		u1.setNome("Olivia");

		// m�todo que faz o update
		// em.merge(u1);

		em.getTransaction().commit();

		em.close();
		emf.close();
		
	}

}
