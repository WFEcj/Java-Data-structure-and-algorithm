package chopstick;

public class test {
	public static void main(String[] args) {
		Chopsticks one = new Chopsticks(1);
		Chopsticks two = new Chopsticks(2);
		Chopsticks three = new Chopsticks(3);
		Chopsticks four = new Chopsticks(4);
		
		Philisopher p1 = new Philisopher("1",one,two);
		Philisopher p2 = new Philisopher("2",two,three);
		Philisopher p3 = new Philisopher("3",three,four);
		Philisopher p4 = new Philisopher("4",four,one);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
