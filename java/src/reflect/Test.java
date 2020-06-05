package reflect;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Class clazz = Person.class;
		Field fields = clazz.getDeclaredField("name");
		Class c = fields.getType();
		System.out.println(c);
	}
}
