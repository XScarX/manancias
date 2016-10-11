package parades.mananciais.model;

import java.util.ArrayList;

public class Represa {
	private String nome;
	private ArrayList<Medicao> medicoes;

	public Represa() {
		this.nome = "";
		this.medicoes = new ArrayList<>();
	}

	public Represa(String nome, ArrayList<Medicao> medicoes) {
		this.nome = nome;
		this.medicoes = medicoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Medicao> getMedicoes() {
		return medicoes;
	}

	public void setMedicoes(ArrayList<Medicao> medicoes) {
		this.medicoes = medicoes;
	}

	public double getVolumeInicial() {
		return getMedicoes().get(0).getVolume();
	}

	public double getVolumeFinal() {
		return getMedicoes().get(getMedicoes().size() - 1).getVolume();
	}

	public double volumeFinal() {
		return ((getVolumeFinal() / getVolumeInicial()) - 1) * 100;
	}

	@Override
	public String toString() {
		return "Represa [nome=" + nome + ", medicoes=" + medicoes + "]";
	}

}
