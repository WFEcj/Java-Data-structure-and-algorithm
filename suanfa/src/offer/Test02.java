package offer;

public class Test02 {
	
	/**
	 * 单例模式	饿汉式	线程安全
	 * 缺点：直接实例化，资源会浪费；丢失了延迟实例化的性能好处。
	 */
	private static class Singleton{
		private final static Singleton INSTANCE = new Singleton();
		private Singleton() {
			
		}
		public static Singleton getInstance(){
			return INSTANCE;
		}
	}
	
	
	/**
	 * 单例模式	懒汉式	线程不安全
	 * 缺点：当多个线程同时进入if（instance==null）时，导致实例化多次对象，便不算单例模式了
	 * @param args
	 */
	private static class Singleton2{
		private static Singleton2 instance = null;
		private Singleton2() {
			
		}
		public static Singleton2 getInstance() {
			if(instance==null) {
				instance = new Singleton2();
			}
			return instance;
		}
	}
	
	/**
	 * 单例模式	懒汉式	线程安全
	 * 缺点：导致线程堵塞，性能不好，不推荐
	 * @param args
	 */
	private static class Singleton3{
		private static Singleton3 instance = null;
		private Singleton3() {
			
		}
		public static synchronized Singleton3 getInstance() {
			if(instance==null) {
				instance = new Singleton3();
			}
			return instance;
		}
	}
	
	/**
	 * 单例模式	懒汉式（变种）	线程安全
	 * @param args
	 */
	private static class Singleton4{
		private static Singleton4 instance = null;
		
		static {
			instance = new Singleton4();
		}
		private Singleton4(){
			
		}
		public static Singleton4 getInstance() {
			return instance;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
