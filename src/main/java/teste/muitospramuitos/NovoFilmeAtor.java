package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {

		Filme filmeA = new Filme("Scarface", 8.3);
		Filme filmeB = new Filme("O Poderoso Chefão", 9.1);
		
		Ator atorA = new Ator("Al Pacino");
		Ator atrizA = new Ator("Michelle Pfeiffer");
		
		filmeA.addAtores(atorA);
		filmeA.addAtores(atrizA);

		filmeB.addAtores(atorA);
		
		DAO<Filme> dao = new DAO<>();
		
		dao.incluirAtomico(filmeA);
	}

}
