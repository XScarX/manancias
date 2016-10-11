package parades.mananciais.model;

import java.util.Date;

public class Medicao {
	private double volume;
	private Date data;
	
	
	public Medicao() {
	}


	public Medicao(double volume, Date data) {
		this.volume = volume;
		this.data = data;
	}


	public double getVolume() {
		return volume;
	}


	public void setVolume(double volume) {
		this.volume = volume;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Medicao [volume=" + volume + ", data=" + data + "]";
	}
	
	

}
