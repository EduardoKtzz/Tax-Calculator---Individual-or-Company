package entities;

public class PessoaJuridica extends Contribuentes {
	//Atributos
	private Integer numeroFuncionarios;

	//Construtores
	public PessoaJuridica() {

	}

	public PessoaJuridica(String name, double rendaAnual, Integer numeroFuncionarios) {
		super(name, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	//get e set
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	//Métado reescrito da superclasse, com o objetivo de calcular as taxas de uma pessoa juridica
	@Override
	public double imposto() {
		double impostoBruto	= 0.0;

		if (getNumeroFuncionarios() <= 10) {
			impostoBruto = getRendaAnual() * 0.16;
		} else { 
			impostoBruto = getRendaAnual() * 0.14;
		}

		return impostoBruto;
	}
}

