package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.NotaFilme;

public class NovoFilmeAtor {

	public static void main(String[] args) {

		NotaFilme filmeA = new NotaFilme("Scarface", 8.3);
		NotaFilme filmeB = new NotaFilme("O Poderoso Chefão", 9.1);
		
		Ator atorA = new Ator("Al Pacino");
		Ator atrizA = new Ator("Michelle Pfeiffer");
		
		filmeA.addAtores(atorA);
		filmeA.addAtores(atrizA);

		filmeB.addAtores(atorA);
		
		DAO<NotaFilme> dao = new DAO<>();
		
		dao.incluirAtomico(filmeA);
		dao.incluirAtomico(filmeB);
	}

}
