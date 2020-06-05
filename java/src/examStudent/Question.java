package examStudent;

public class Question {
	private String title;
	private String answer;
	Question(String title,String answer){
		this.title=title;
		this.answer=answer;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAnswer() {
		return this.answer;
	}
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof Question) {
			Question anotherQuestion = (Question)obj;
			if(this.title.split("\\?")[0].equals(anotherQuestion.getTitle().split("\\?")[0])) {
				return true;
			}
		}
		return false;
	}
	public int hashCode() {
		return this.title.split("\\?")[0].hashCode();
	}
}
