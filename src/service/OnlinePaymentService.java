package service;

public interface OnlinePaymentService {
	public Double paymentefee(Double amount);

	public Double interest(Double amount, Integer months);

}
