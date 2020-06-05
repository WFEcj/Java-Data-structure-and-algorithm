package system12306;

public class Ticket {
	private String start;
	private String end;
	private Float price;
	Ticket(String start,String end,Float price) {
		this.start=start;
		this.end=end;
		this.price=price;
	}
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}
	public Float getPrice() {
		return price;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		str.append(this.start);
		str.append("---->");
		str.append(this.end);
		str.append(":");
		str.append(this.price);
		str.append("]");
		return str.toString();
	}
}
