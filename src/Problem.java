
public class Problem {
    private String question, a, b, c, d, e, correctAnswer;
    
    public Problem(String q, String a, String b, String c, String d, String e, String correctAnswer) {
	this.question = q;
	this.a = a;
	this.b = b;
	this.c = c;
	this.d = d;
	this.e = e;
	this.correctAnswer = correctAnswer;
    }
    
    public void setQuestion(String q) {
	this.question = q;
    }
    
    public void setA(String a) {
	this.a = a;
    }
    
    public void setB(String b) {
	this.b = b;
    }
    
    public void setC(String c) {
	this.c = c;
    }
    
    public void setD(String d) {
	this.d = d;
    }
    
    public void setE(String e) {
	this.e = e;
    }
    
    public void setCorrectAnswer(String ca) {
	this.correctAnswer = ca;
    }
    
    public String getQuestion() {
	return question;
    }
    
    public String getA() {
	return a;
    }
    
    public String getB() {
	return b;
    }
    
    public String getC() {
	return c;
    }
    
    public String getD() {
	return d;
    }
    
    public String getE() {
	return e;
    }
    
    public String getCorrectAnswer() {
	return correctAnswer;
    }
}
