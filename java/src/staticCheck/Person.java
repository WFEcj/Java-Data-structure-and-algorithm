package staticCheck;

public class Person extends Animal{
	public Person(){
		System.out.println("����Person�Ĺ��췽��");
	}
	{
		System.out.println("����Person�Ŀ�");
	}
	static{
		Person.b();
		System.out.println("����Person�ľ�̬�鷽��");
	}
	public static void b() {
		System.out.println("����Person�ľ�̬��ͨ����");
	}
}
