package parades.mananciais.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Calculadora {

	// o arraylist de medições de represa contem somente as medições do mês de
	// referencia
	public String gerarRelatorioMensal(Sistema sistema) {
		Medicao  anterior;
		DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		
		String relatorio = "Relatório do Sistema " + sistema.getNome() + "\n\n";
		// FOR EACH,percorre o vetor represa
		for (Represa represa : sistema.getRepresas()) {
			relatorio += "\tRepresa: " + represa.getNome() + "\n";
			// 10S É 10 ESPACOS
			relatorio += String.format("%10s %12s %15s", "Data", "Volume", "Variação Diária\n");
			anterior = null;
			for (Medicao atual: represa.getMedicoes()) {
				// pega medicoes da represa
				relatorio += String.format("%10s %12.2f %15.2f", formater.format(atual.getData()), atual.getVolume(),
						calcularVariacaoDiaria(anterior, atual));
				relatorio += "\n";
				anterior = atual;
			}

			// calculando a variacao por Represa.
			relatorio += "------------------------------------------------";
			relatorio += "\nVariação Total da Represa: " + String.format("%12.2f", represa.volumeFinal());
			relatorio += "\n\n";

			// calculando volume final do Sistema. Somatorio do ultimo volume da
			// cada represa.
		}

		// calculando variacao total por Sistema.
		relatorio += "------------------------------------------------";
		relatorio += "\nVariação Total do Sistema: " + String.format("%12.2f", sistema.volumeFinal());
		relatorio += "\n\n";

		return relatorio;
	}

	public double calcularVariacaoDiaria(Medicao anterior, Medicao atual) {
		if (anterior == null)
			return 0;
		else
			return ((atual.getVolume() / anterior.getVolume()) - 1) * 100;

	}
}
