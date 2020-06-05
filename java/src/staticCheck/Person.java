package staticCheck;

public class Person extends Animal{
	public Person(){
		System.out.println("这是Person的构造方法");
	}
	{
		System.out.println("这是Person的块");
	}
	static{
		Person.b();
		System.out.println("这是Person的静态块方法");
	}
	public static void b() {
		System.out.println("这是Person的静态普通方法");
	}
}
