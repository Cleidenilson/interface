package service;

public class PaypalService implements OnlinePaymentService {

	@Override
	public Double paymentefee(Double amount) {
		return amount * 0.02;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		return amount * 0.01 * months;
	}

}
