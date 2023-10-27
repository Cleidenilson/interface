package service;

import java.time.LocalDate;

import entitties.Contract;
import entitties.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {

		double basicQuota = contract.getTotalValue() / months;
		for (int i=1 ; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(basicQuota, i);
			double fee = onlinePaymentService.paymentefee(basicQuota + interest);
			double amount = basicQuota + interest + fee;
			contract.getInstallemnt().add(new Installment(dueDate, amount));
		}
	}
}
