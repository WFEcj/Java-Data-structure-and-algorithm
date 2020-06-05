package examStudent;

public class Teacher {
	public int score(String[] s,String[] a) {
		int grade = 0;
		for(int i = 0;i<s.length;i++) {
			if(s[i].equalsIgnoreCase(a[i])) {
				grade+=100/s.length;
			}
		}
		return grade;
	}
}
