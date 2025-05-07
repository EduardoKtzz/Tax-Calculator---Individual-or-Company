package application;

//Importações
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Contribuentes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
	public static void main(String[] args) {
		
		//Iniciando scanner para conseguir os dados do usuario
		Scanner sc = new Scanner(System.in);
		System.out.println();

		//Criando uma lista para armazenar os dados de cada contribuente
		List<Contribuentes> taxPayers = new ArrayList<>();

		//Perguntando para o usuario o tamanho da lista de contribuentes
		System.out.println("Enter the number of tax payers: ");
		int numTaxPayers = sc.nextInt();

		//Repetição para realizar as ações
		for (int x = 0; x < numTaxPayers; x++) {
			System.out.println();
			System.out.println("Tax payer #" + (x + 1) + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);

			//Pegando nome
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();

			//Renda anual
			System.out.print("Anual income: ");
			double rendaAnual = sc.nextDouble();

			//Decidindo se é pessoa fisica ou juridica e armazendando ela em uma lista com polimorfismo
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				taxPayers.add(new PessoaFisica(name, rendaAnual, gastosSaude)); //Add ela na lista
			} else if (ch == 'c') {
				System.out.print("Number of employees: ");
				Integer numeroFuncionarios = sc.nextInt();
				taxPayers.add(new PessoaJuridica(name, rendaAnual, numeroFuncionarios)); //Add ela na lista
			} else {
				System.out.println("Opção invalida, tente novamente!"); //Caso a pessoa digite algo diferente do esperado 
				x--;
			}

		}

		//Exibindo todos itens da lista com os valores calculados de imposto
		System.out.println();
		System.out.println("TAXES PAID:");
		for (Contribuentes payer : taxPayers) {
			System.out.println(payer.getName() + ": $" + String.format("%.2f", payer.imposto()));
		}

		//Exibindo o valor total de todo imposto da lista
		double sum = 0.0;
		for (Contribuentes tax : taxPayers) {
			sum += tax.imposto();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + sum);

		sc.close();
	}
}
