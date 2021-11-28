package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitospramuitos.Filme;

public class ObterFilmes {

	public static void main(String[] args) {

		DAO<Filme> dao = new DAO<>(Filme.class);
		// primeiro o nome do parametro e dps o valor 
		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.4);
		
		System.out.println(filmes.size());
		for (Filme filme : filmes) {
			System.out.println(filme.getNome());
		}
	}

}
