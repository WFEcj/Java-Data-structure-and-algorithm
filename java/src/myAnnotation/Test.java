package myAnnotation;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) {
		MySpring my = new MySpring();
		Person p = (Person)my.getBean("myAnnotation.Person");
		System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());
	}
}
