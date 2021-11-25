package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {

		Tio tia = new Tio("Maria");
		Tio tio = new Tio("Jos�");

		Sobrinho sobrinho = new Sobrinho("Jo�o");
		Sobrinho sobrinha = new Sobrinho("Ana");

		// rela��o bidireacional
		// Jo�o � sobrinho de Maria e Maria � tia de Jo�o
		tia.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tia);

		// Ana � sobrinha de Maria e Maria � tia de Ana
		tia.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tia);

		// Jo�o � sobrinho de Jos� e Jos� � tio de Jo�o
		tio.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tio);

		// Ana � sobrinha de Jos� e Jos� � tio de Ana
		tio.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tio);

		DAO<Object> dao = new DAO<>();

		dao.abrirT().incluir(tia).incluir(tio).incluir(sobrinho).incluir(sobrinha).fecharT().fechar();
	}

}
