package entities;

public class PessoaFisica extends Contribuentes {

	//Atributos
	private double gastosSaude;

	//Construtores
	public PessoaFisica() {

	}

	public PessoaFisica(String name, double rendaAnual, double gastosSaude) {
		super(name, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	//Get e set 
	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	//Métado reescrito da superclasse, com o objetivo de calcular as taxas de uma pessoa fisica
	@Override
	public double imposto() {
		double impostoBruto = 0.0;
		double gastosSaudeValor = 0.0;
		double impostoFinal = 0.0;

		if (getRendaAnual() < 20000.00) {	
			impostoBruto = getRendaAnual() * 0.15;
		} else {
			impostoBruto = getRendaAnual() * 0.25;
		}

		//Caso ela gaste dinheiro no sistema de saude, o valor do imposto é reduzido
		gastosSaudeValor = gastosSaude * 0.5;
		impostoFinal = impostoBruto - gastosSaudeValor;

		return impostoFinal;
	}
}
