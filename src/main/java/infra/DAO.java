package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

// generics 
public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// logar -> log4j a melhor api
		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}

	// atomico é quando a aplicação deve inserir/deletar
	// tudo que for pedido ou não fazer nada
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}

	// deslocamento: quando se tem mtos registros e se deve pegar de 10 em 10 etc
	public List<E> obterTodos(int qtde, int deslocamento) {

		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula!");
		}

		// + o nome da classe
		String jpql = "select e from" + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe).setMaxResults(qtde).setFirstResult(deslocamento);

		return query.getResultList();
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	public void fechar() {
		em.close();
	}
}
