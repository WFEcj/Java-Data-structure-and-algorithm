package Loan;
import java.util.Scanner;
import java.text.DecimalFormat;
public class TestLoan {
	public static void main(String[] args) {
		double interestrate,loanvalue;
		int loanperiod;
		Scanner in=new Scanner(System.in);
		System.out.println("���������������");
		interestrate=in.nextDouble();
		System.out.println("�������������");
		loanperiod=in.nextInt();
		System.out.println("����������ܶ�");
		loanvalue=in.nextDouble();
		Loan loan=new Loan(interestrate,loanperiod,loanvalue);
		DecimalFormat df=new DecimalFormat("#.00");
		System.out.println("�ȶϢ����µ��¾������Ϊ��"+df.format(loan.getMonthlyPayment())+"��");
		System.out.println("����"+loanperiod+"����ܻ����Ϊ��"+df.format(loan.getTotalPayment())+"��");
	}
}
