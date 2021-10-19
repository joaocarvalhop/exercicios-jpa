package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		// java persistence query language
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		// no máximo 5 resultados
		query.setMaxResults(5);

		List<Usuario> usuarios = query.getResultList();

		for (Usuario usuario : usuarios) {
			System.out.println("Id>>> " + usuario.getId() + " E-mail>>> " + usuario.getEmail());
		}

		em.close();
		emf.close();
	}
}
