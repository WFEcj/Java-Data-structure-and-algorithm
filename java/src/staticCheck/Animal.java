package staticCheck;
/*����ģʽ
public class Animal {
	private Animal(){}
	private static Animal animal = new Animal();
	public static Animal getAnimal() {
		return animal;
	}
}
����ʽ
public class Animal {
	private Animal(){}
	private static Animal animal;
	public static Animal getAnimal() {
		if(animal==null) {
			animal=new Animal();
		}
		return animal;
	}
}*/
public class Animal {
	Animal(){
		System.out.println("����Animal�Ĺ��췽��");
	}
	public static void say() {
		System.out.println("����Animal�ľ�̬��ͨ����");
	}
	{
		System.out.println("����Animal�Ŀ�");
	}
	static{
		Animal.say();
		System.out.println("����Animal�ľ�̬��");
	}
}
