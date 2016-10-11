package parades.mananciais.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Calculadora {

	// o arraylist de medi��es de represa contem somente as medi��es do m�s de
	// referencia
	public String gerarRelatorioMensal(Sistema sistema) {
		Medicao  anterior;
		DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		
		String relatorio = "Relat�rio do Sistema " + sistema.getNome() + "\n\n";
		// FOR EACH,percorre o vetor represa
		for (Represa represa : sistema.getRepresas()) {
			relatorio += "\tRepresa: " + represa.getNome() + "\n";
			// 10S � 10 ESPACOS
			relatorio += String.format("%10s %12s %15s", "Data", "Volume", "Varia��o Di�ria\n");
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
			relatorio += "\nVaria��o Total da Represa: " + String.format("%12.2f", represa.volumeFinal());
			relatorio += "\n\n";

			// calculando volume final do Sistema. Somatorio do ultimo volume da
			// cada represa.
		}

		// calculando variacao total por Sistema.
		relatorio += "------------------------------------------------";
		relatorio += "\nVaria��o Total do Sistema: " + String.format("%12.2f", sistema.volumeFinal());
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
