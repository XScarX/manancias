package parades.mananciais.model;

import java.util.ArrayList;

public class Sistema {
	private String nome;
	private ArrayList<Represa> represas;
	
	public Sistema() {
		this.nome = "";
		this.represas = new ArrayList<>();	
	}
	public Sistema(String nome, ArrayList<Represa> represas) {
		this.nome = nome;
		this.represas = represas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Represa> getRepresas() {
		return represas;
	}
	public void setRepresas(ArrayList<Represa> represas) {
		this.represas = represas;
	}
	@Override
	public String toString() {
		return "Sistema [nome=" + nome + ", represas=" + represas + "]";
	}
	
	public double getVolumeInicial(){
		double volumeInicial = 0.0;
		for (Represa represa:represas){
			volumeInicial += represa.getVolumeInicial();
		}
		return volumeInicial;
	}
	
	public double getVolumeFinal(){
		double volumeFinal = 0.0;
		for (Represa represa:represas){
			volumeFinal += represa.getVolumeFinal();
		}
		return volumeFinal;
	}
	
	public double volumeFinal() {
		return ((getVolumeFinal()/getVolumeInicial())-1)*100;
	}

	
}
