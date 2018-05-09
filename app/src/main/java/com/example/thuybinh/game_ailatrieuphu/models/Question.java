package com.example.thuybinh.game_ailatrieuphu.models;

public class Question {
	private int id;
	private String content;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String answer;
	private int level;
	
	public Question() {
	}

	public Question(int id, String content, String answerA, String answerB, String answerC, String answerD, String answer, int level) {
		this.id = id;
		this.content = content;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.answer = answer;
		this.level = level;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}



	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + content + ", answerA=" + answerA + ", answerB=" + answerB
				+ ", answerC=" + answerC + ", answerD=" + answerD + ", answer=" + answer + ", level=" + level + "]";
	}
	
}