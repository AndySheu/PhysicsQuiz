import java.util.ArrayList;

public class Problem {
    private String question, a, b, c, d, e, correctAnswer, explanation;
    
    public Problem(String q, String a, String b, String c, String d, String e, String correctAnswer, String explanation) {
	this.question = q;
	this.a = a;
	this.b = b;
	this.c = c;
	this.d = d;
	this.e = e;
	this.correctAnswer = correctAnswer;
	this.explanation = explanation;
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
    
    public void setExplanation(String explanation) {
	this.explanation = explanation;
    }
    
    public Problem randomize() {
	ArrayList<String> temp = new ArrayList<String>(5);
	temp.add(a);
	temp.add(b);
	temp.add(c);
	temp.add(d);
	temp.add(e);
	
	a = temp.get((int)(Math.random() * 5));
	temp.remove(a);
	b = temp.get((int)(Math.random() * 4));
	temp.remove(b);
	c = temp.get((int)(Math.random() * 3));
	temp.remove(c);
	d = temp.get((int)(Math.random() * 2));
	temp.remove(d);
	e = temp.get(0);
	return new Problem(question, a, b, c, d, e, correctAnswer, explanation);
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
    
    public String getExplanation() {
	return explanation;
    }
}
