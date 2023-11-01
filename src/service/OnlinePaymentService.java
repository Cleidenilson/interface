package service;

public interface OnlinePaymentService {
	double paymentefee(Double amount);

	double interest(Double amount, Integer months);

}
