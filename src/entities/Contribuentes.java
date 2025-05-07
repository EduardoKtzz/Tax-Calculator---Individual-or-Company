package entities;

public abstract class Contribuentes {

	//Atibutos
	private String name;
	private double rendaAnual;

	//Construtores
	public Contribuentes() {

	}

	public Contribuentes(String name, double rendaAnual) {
		this.name = name;
		this.rendaAnual = rendaAnual;
	}

	//Getters e setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}

	// Método abstrato de imposto
	public abstract double imposto();

}
