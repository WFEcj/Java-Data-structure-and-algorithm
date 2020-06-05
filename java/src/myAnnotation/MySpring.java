package myAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MySpring {
	public Object getBean(String className) {
		Object obj = null;
		try {
			Class clazz = Class.forName(className);
			Field[] fields = clazz.getDeclaredFields();
			Constructor con = clazz.getConstructor();
			obj = con.newInstance();
			Annotation a=con.getAnnotation(MyAnnotation.class);
			Class aclazz = a.getClass();
			Method amethod = aclazz.getMethod("value");
			String[] values = (String[])amethod.invoke(a);
			for(int i =0;i<fields.length;i++) {
				String name = fields[i].getName();
				String first = name.substring(0,1);
				String others = name.substring(1);
				StringBuilder str = new StringBuilder("set");
				str.append(first.toUpperCase());
				str.append(others);
				Method method = clazz.getMethod(str.toString(),fields[i].getType());
				method.invoke(obj,fields[i].getType().getConstructor(String.class).newInstance(values[i]));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
