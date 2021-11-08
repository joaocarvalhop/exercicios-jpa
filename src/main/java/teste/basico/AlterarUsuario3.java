package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

// o objetivo desse exerc�cio � tirar o objeto Usu�rio do estado gerenciado, a fim de s� poder alterar usando o m�todo merge
public class AlterarUsuario3 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario u1 = em.find(Usuario.class, 5L);
		// desassociar/ desanexar
		em.detach(u1);
		
		u1.setNome("Olivia");
		
		// sem o merge ele n�o atualiza a linha da tabela
		// em.merge(u1);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
