package Loan;
import java.util.Scanner;
import java.text.DecimalFormat;
public class TestLoan {
	public static void main(String[] args) {
		double interestrate,loanvalue;
		int loanperiod;
		Scanner in=new Scanner(System.in);
		System.out.println("请输入贷款年利率");
		interestrate=in.nextDouble();
		System.out.println("请输入贷款年限");
		loanperiod=in.nextInt();
		System.out.println("请输入贷款总额");
		loanvalue=in.nextDouble();
		Loan loan=new Loan(interestrate,loanperiod,loanvalue);
		DecimalFormat df=new DecimalFormat("#.00");
		System.out.println("等额本息情况下的月均还款额为："+df.format(loan.getMonthlyPayment())+"￥");
		System.out.println("贷款"+loanperiod+"年的总还款额为："+df.format(loan.getTotalPayment())+"￥");
	}
}
