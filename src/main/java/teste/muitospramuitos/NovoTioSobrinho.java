package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {

		Tio tia = new Tio("Maria");
		Tio tio = new Tio("José");

		Sobrinho sobrinho = new Sobrinho("João");
		Sobrinho sobrinha = new Sobrinho("Ana");

		// relação bidireacional
		// João é sobrinho de Maria e Maria é tia de João
		tia.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tia);

		// Ana é sobrinha de Maria e Maria é tia de Ana
		tia.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tia);

		// João é sobrinho de José e José é tio de João
		tio.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tio);

		// Ana é sobrinha de José e José é tio de Ana
		tio.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tio);

		DAO<Object> dao = new DAO<>();

		dao.abrirT().incluir(tia).incluir(tio).incluir(sobrinho).incluir(sobrinha).fecharT().fechar();
	}

}
