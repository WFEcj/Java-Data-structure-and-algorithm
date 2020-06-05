package staticCheck;
/*饿汉模式
public class Animal {
	private Animal(){}
	private static Animal animal = new Animal();
	public static Animal getAnimal() {
		return animal;
	}
}
懒汉式
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
		System.out.println("这是Animal的构造方法");
	}
	public static void say() {
		System.out.println("这是Animal的静态普通方法");
	}
	{
		System.out.println("这是Animal的块");
	}
	static{
		Animal.say();
		System.out.println("这是Animal的静态块");
	}
}
