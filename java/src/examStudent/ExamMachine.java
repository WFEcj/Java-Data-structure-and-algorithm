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
		questionBank.add(new Question("你的a是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的b是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的c是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的d是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的e是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的f是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的g是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的h是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的i是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
		questionBank.add(new Question("你的j是什么?\n\tA.曹\n\tB.王\n\tC.熊\n\tD.杨","A"));
	}
	private HashMap<String,String> admin = new HashMap<String,String>();
	{
		admin.put("曹","123");
		admin.put("熊", "666");
		admin.put("王", "321");
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
			System.out.println("请输入您的答案:");
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
