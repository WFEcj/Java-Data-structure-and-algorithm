package examStudent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ExamMachine {
	public StringBuilder[] s = new StringBuilder[5];
	private HashSet<Question> questionBank = new HashSet<Question>();
	{
		questionBank.add(new Question("���a��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���b��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���c��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���d��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���e��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���f��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���g��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���h��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���i��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
		questionBank.add(new Question("���j��ʲô?\n\tA.��\n\tB.��\n\tC.��\n\tD.��","A"));
	}
	private HashMap<String,String> admin = new HashMap<String,String>();
	{
		admin.put("��","123");
		admin.put("��", "666");
		admin.put("��", "321");
	}
	public ArrayList<Question> getPaper(){
		int n = 0;
		HashSet<Question> questionPaper = new HashSet<Question>();
		ArrayList<Question> questionBank = new ArrayList<Question>(this.questionBank);
		while(questionPaper.size()!=5) {
			int i = new Random().nextInt(questionBank.size());
			Question q = questionBank.get(i);
			questionPaper.add(q);
			s[n] = new StringBuilder(q.getAnswer());
			n++;
		}
		return new ArrayList<Question>(questionPaper);
	}
	public boolean login(Student s) {
		if(s.getPassword().equals(admin.get(s.getName()))) {
			return true;
		}
		return false;
	}
	public String[] work() {
		Scanner in = new Scanner(System.in);
		ArrayList<Question> paper = this.getPaper();
		String[] s = new String[paper.size()];
		for(int i = 0; i<paper.size();i++) {
			System.out.println((i+1)+"."+paper.get(i).getTitle());
			System.out.println("���������Ĵ�:");
			s[i]=in.nextLine();
		}
		return s;
	}
	public String[] getAnswer() {
		String[] p = new String[5];
		for(int i =0;i<5;i++) {
			p[i]=s[i].toString();
		}
		return p;
	}
}
