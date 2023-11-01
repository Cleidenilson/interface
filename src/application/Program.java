package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entitties.Contract;
import entitties.Installment;
import service.ContractService;
import service.PaypalService;

public class Program {

	public static void main(String args[]) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Informe os dados do contrato:");
		System.out.println("Contrato:");
		int number = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy)");
		sc.nextLine();
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.println("Valor do Contrato:");
		double totalValue = sc.nextDouble();
		sc.nextLine();
		System.out.println("Entre com o número de parcelas:");
		Integer numberQuota = sc.nextInt();
		
		numberQuota.equals(number);
		Contract obj = new Contract(number, date, totalValue);
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(obj, numberQuota);

		System.out.println("Parcelas: ");
		for (Installment list : obj.getInstallemnt()) {
			System.out.println(list);

		}

		sc.close();
	}

}
