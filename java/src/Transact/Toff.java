package Transact;

public class Toff extends Person{
	public Toff() {}
	public Toff(String name) {
		this.name=name;
	}
	public void CallNumber() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"½ÐºÅ");
	}
	public void transact() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"È¡Ç®");
	}
	public void leave() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"Àë¿ª");
	}
}
