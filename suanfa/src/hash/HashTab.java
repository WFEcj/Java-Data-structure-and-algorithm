package hash;

import java.util.Scanner;

public class HashTab {
	private EmpLinkList[] EmpLinkListArray;
	int size;
	public HashTab(int size) {
		this.size=size;
		EmpLinkListArray = new EmpLinkList[size];
		for(int i=0;i<size;i++) {
			EmpLinkListArray[i] = new EmpLinkList();
		}
	}
	public void add(int id,String name) {
		EmpLinkListArray[this.findHash(id)].add(new Emp(id,name));
	}
	public void list() {
		for(int i=0;i<size;i++) {
			EmpLinkListArray[i].list(i);
		}
	}
	public Emp delete(int id) {
		return EmpLinkListArray[this.findHash(id)].delete(id);
	}
	private int findHash(int id) {
		return id%size;
	}
	public Emp find(int id) {
		return EmpLinkListArray[this.findHash(id)].find(id);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTab hashTab = new HashTab(5);
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("add: ��ӹ�Ա");
			System.out.println("list: �鿴��Ա");
			System.out.println("delete: ɾ����Ա");
			System.out.println("find: ���ҹ�Ա");
			System.out.println("exit: �˳�ϵͳ");
			String key = in.next();
			switch(key) {
			case "add":
				System.out.println("������id");
				int id = in.nextInt();
				System.out.println("����������");
				String name = in.next();
				hashTab.add(id, name);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("������id");
				id = in.nextInt();
				Emp value = hashTab.find(id);
				System.out.println("id:"+value.id+"\t"+"name:"+value.name);
				break;
			case "delete":
				System.out.println("������id");
				id = in.nextInt();
				value = hashTab.delete(id);
				System.out.println("id:"+value.id+"\t"+"name:"+value.name);
				break;
			case "exit":
				in.close();
				System.exit(0);
			default:
				break;
			}
		}
	}

}
class EmpLinkList{
	private Emp head;
	public void add(Emp emp) {
		if(head==null) {
			head=emp;
			return;
		}
		if(emp.id<head.id) {
			Emp temp = head;
			head=emp;
			emp.next=temp;
			return;
		}
		Emp cur = head;
		Emp curn = cur.next;
		while(true) {
			if(curn==null) {
				cur.next=emp;
				break;
			}
			if(emp.id<curn.id) {
				cur.next=emp;
				emp.next=curn;
				break;
			}
			cur=cur.next;
			curn = cur.next;
		}
	}
	public void list(int i) {
		if(head==null) {
			System.out.println("����Ϊ�գ��޷���ӡ");
			return;
		}
		Emp cur = head;
		System.out.printf("��%d������=>",i+1);
		while(cur!=null) {
			System.out.printf("id:%d name:%s\t",cur.id,cur.name);
			cur=cur.next;
		}
		System.out.println();
	}
	public Emp find(int id) {
		if(head==null) {
			System.out.println("����Ϊ�գ��޷�����");
			return null;
		}
		Emp cur =head;
		while(true) {
			if(cur==null) {
				return null;
			}
			if(cur.id==id) {
				return cur;
			}
			cur=cur.next;
		}
	}
	public Emp delete(int id) {
		if(head==null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
			return null;
		}
		Emp cur = head;
		Emp curn = cur.next;
		if(cur.id==id) {
			cur.next=null;
			head=curn;
			return cur;
		}
		while(true) {
			if(curn==null) {
				System.out.println("���޴���!");
				return null;
			}
			if(curn.id==id) {
				cur.next=curn.next;
				curn.next=null;
				return curn;
			}
		}
	}
}
class Emp{
	public int id;
	public String name;
	public Emp next;
	public Emp(int id,String name) {
		this.id=id;
		this.name=name;
	}
}