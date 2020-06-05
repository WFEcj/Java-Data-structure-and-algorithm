package system12306;

import java.util.Vector;

public class System12306 {
	private System12306() {}
	private static System12306 sy = new System12306();
	public static System12306 getSy() {
		return sy;
	}
	private Vector<Ticket> tickets = new Vector<Ticket>();
	{
		for(int i = 0;i<100;i++) {
			tickets.add(new Ticket("ÄÏ²ý","Èð²ý",(i%5+5)*25F));
		}
	}
	public Ticket getTicket() {
		try {
			return tickets.remove(0);
		}catch(Exception e) {
			return null;
		}
	}
	
}
