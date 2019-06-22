package com.xyz.testengine.question.dto;

public class QuestionDto {
	private int question_no;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String rans;
	private int score;
	private String yourAnswer;
	private int qid;
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getQuestion_No() {
		return question_no;
	}
	public void setQuestion_No(int questionNO) {
		this.question_no = questionNO;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public String getRans() {
		return rans;
	}
	public void setRans(String rans) {
		this.rans = rans;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	@Override
	public String toString() {
		return "QuestionDto [question_no=" + question_no + ", question=" + question + ", ans1=" + ans1 + ", ans2="
				+ ans2 + ", ans3=" + ans3 + ", ans4=" + ans4 + ", rans=" + rans + ", score=" + score + ", yourAnswer="
				+ yourAnswer + ", getQuestion_No()="
				+ getQuestion_No() + ", getQuestion()=" + getQuestion() + ", getAns1()=" + getAns1() + ", getAns2()="
				+ getAns2() + ", getAns3()=" + getAns3() + ", getAns4()=" + getAns4() + ", getRans()=" + getRans()
				+ ", getScore()=" + getScore() + ", getYourAnswer()=" + getYourAnswer() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	}
	


