package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitospramuitos.NotaFilme;

public class ObterFilmes {

	public static void main(String[] args) {

		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		// primeiro o nome do parametro e dps o valor 
		List<NotaFilme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.4);
		
		System.out.println(filmes.size());
		for (NotaFilme filme : filmes) {
			System.out.println(filme.getNome());
		}
	}

}
