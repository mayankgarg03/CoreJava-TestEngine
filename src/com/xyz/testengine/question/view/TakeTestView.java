package com.xyz.testengine.question.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.xyz.testengine.question.dao.QuestionDao;
import com.xyz.testengine.question.dto.QuestionDto;

public class TakeTestView extends JFrame {

	private JPanel contentPane;
	private int  index = 0;
	private ArrayList<QuestionDto> questions ;
	private String yourAns="";
	public String testName = " ";
	

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TakeTestView frame = new TakeTestView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	JRadioButton rbtnans1 = new JRadioButton("");
	JRadioButton rbtnans2 = new JRadioButton("");
	JRadioButton rbtnans3 = new JRadioButton("");
	JRadioButton rbtnans4 = new JRadioButton("");
	JLabel qno = new JLabel("");
	JLabel question = new JLabel("");
	ButtonGroup bg = new ButtonGroup();
	JButton btnPrevoius = new JButton("Previous");
	JButton btnNext = new JButton("Next");
	JLabel lblNewLabel = new JLabel("Time Left");
	JLabel lbltime = new JLabel("");
	
	public int time ;
	private Timer timer;
	final int DELAY = 1000;
	private final JButton btnFinish = new JButton("Finish");
	
	
	
//	public int getTime(){
//		QuestionDao qd = new QuestionDao();
//		try {
//			time = qd.getTime(testName);
//			System.out.println("Taketestviewww " + time);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return time;
//	}
//	
	 

	private void showTimeLeft(){
		timer = new Timer(DELAY , new ActionListener(){
			//QuestionDao qd = new QuestionDao();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("tiem" +String.valueOf(getTime()));
				lbltime.setText(String.valueOf(time));
				
				if(time==0){
					timer.stop();
					finishTest();
					
				}
				
				time--;
				
			}
			
		});
		timer.start();
	}
	
	private void loadNext(){
		this.setVisible(false);
		this.dispose();
		SelectTest selecttest = new SelectTest();
		selecttest.setVisible(true);
	}
	private void printQuestions(){
		//bg.clearSelection();
		if(index<questions.size()){
		selectAns();
			
		QuestionDto currentQuestion = questions.get(index);
		qno.setText(String.valueOf(currentQuestion.getQuestion_No()));
		question.setText(currentQuestion.getQuestion());
		rbtnans1.setText(currentQuestion.getAns1());
		rbtnans2.setText(currentQuestion.getAns2());
		rbtnans3.setText(currentQuestion.getAns3());
		rbtnans4.setText(currentQuestion.getAns4());
		setEnableDisable();
//		 if(questions.get(index).getYourAnswer()!=null && questions.get(index).getYourAnswer().trim().length()>0) {
//				if(questions.get(index).getYourAnswer().equals("a")) {
//					rbtnans1.setSelected(true);
//				}
//				else
//				if(questions.get(index).getYourAnswer().equals("b")) {
//					rbtnans2.setSelected(true);
//				}
//				if(questions.get(index).getYourAnswer().equals("c")) {
//					rbtnans3.setSelected(true);
//				}
//				else
//				if(questions.get(index).getYourAnswer().equals("d")) {
//					rbtnans4.setSelected(true);
//				}
//		
		// }
		 }
	}
//	String test1;
//	public String getTest(String test){
//		 test1 = test;
//         System.out.println("value tets in gettest"+test1);
//		 return test1;
//		 
//	}
	//TestNameDto testnamedto = new TestNameDto();
	
	
	
	//QuestionDto qd = new QuestionDto();
	
	
	
	public void loadQuestions(){
		//String test1 = testnamedto .getTestno();
		QuestionDao questiondao = new QuestionDao();
		
	//	System.out.println("test value in loadquestion"+test);
		try {
			
	//	System.out.println("test value in loadquestion"+qd.getTestid());
			questions = questiondao.getQuestions(testName);
			time = questiondao.getTime(testName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "can't load questions");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "can't load questions");
			e.printStackTrace();
		}
		
		
	}
	

	public void setEnableDisable(){
		if(index==0){
			btnPrevoius.setEnabled(false);
			btnNext.setEnabled(true);
		}
		else
			if(questions.size()==1){
				btnPrevoius.setEnabled(false);
				btnNext.setEnabled(false);
			}
			else if(index == questions.size()-1){
				btnPrevoius.setEnabled(true);
				btnNext.setEnabled(false);
			}
			else if(index>0 && index < questions.size()-1 ){
				btnPrevoius.setEnabled(true);
				btnNext.setEnabled(true);
			}
	}
	
	
	
	private void selectAns(){
		if(this.questions.get(index).getYourAnswer()!=null ){
			
			yourAns = this.questions.get(index).getYourAnswer();
			if(yourAns.equals("a")){
				rbtnans1.setSelected(true);
			}
			else if(yourAns.equals("b")){
				rbtnans2.setSelected(true);
			}
			else if(yourAns.equals("c")){
				rbtnans3.setSelected(true);
			}
			else if(yourAns.equals("d")){
				rbtnans4.setSelected(true);
			}
//			
		}
		else {
			bg.clearSelection();
		}
//			
}
	
	

//	private void fetchAns(int index){
//		if(rbtnans1.isSelected()){
//			yourAns = "a";
//		}
//		else
//		if(rbtnans2.isSelected()){
//			yourAns = "b";
//		}
//		else
//		if(rbtnans3.isSelected()){
//			yourAns = "c";
//		}
//		else
//		if(rbtnans4.isSelected()){
//			yourAns = "d";
//		}
//		
//		this.questions.get(index).setYourAnswer(yourAns);
//		System.out.println("questions are " + this.questions.get(index));
//		yourAns = "";
//	}
	
	 private void storeAnswer(String answer) {
			this.questions.get(index).setYourAnswer(answer);
		    }
	
	private void finishTest(){
	//fetchAns(index);
    ResultView vr = new ResultView(questions , checkTest());
	vr.setVisible(true);
	this.setVisible(false);
	this.dispose();
	}
	
	private int checkTest(){
		int score = 0;
		for(QuestionDto questiondto : questions){
//			
			if(!questiondto.getRans().equals(questiondto.getYourAnswer())){
				 questiondto.setScore(0);
			}
			else
				 score = score + questiondto.getScore();
		}
		return score;
	}


	
	
	public TakeTestView(String Test) {
		testName = Test;
		loadQuestions();
		
		
		bg.add(rbtnans1);
		bg.add(rbtnans2);
		bg.add(rbtnans3);
		bg.add(rbtnans4);
		printQuestions();
	   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		question.setBounds(70, 47, 307, 64);
		contentPane.add(question);
		
		
		qno.setBounds(10, 47, 40, 64);
		contentPane.add(qno);
		
		
		rbtnans1.setBounds(70, 166, 295, 30);
		contentPane.add(rbtnans1);
		
		
		rbtnans2.setBounds(70, 199, 295, 30);
		contentPane.add(rbtnans2);
		
		
		rbtnans3.setBounds(70, 232, 295, 30);
		contentPane.add(rbtnans3);
		rbtnans4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		rbtnans4.setBounds(70, 267, 295, 30);
		contentPane.add(rbtnans4);
		btnPrevoius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				index = index - 1;
				printQuestions();
			}
		});
		
		
		btnPrevoius.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrevoius.setBounds(70, 343, 104, 23);
		contentPane.add(btnPrevoius);
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(index==0){
//					fetchAns(0);
//					index = index + 1;
//					}
//					else{
//					index = index + 1;
//					fetchAns(index);
//					}
				index++;
				printQuestions();
			}
		});
		
		
		
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNext.setBounds(221, 343, 89, 23);
		contentPane.add(btnNext);
		
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(405, 22, 86, 17);
		contentPane.add(lblNewLabel);
		
		
		lbltime.setBounds(435, 59, 46, 23);
		contentPane.add(lbltime);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishTest();
				
			}
		});
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinish.setBounds(358, 343, 89, 23);
		
		contentPane.add(btnFinish);
		
		
		rbtnans1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeAnswer("a");
			}
			
		});
		rbtnans2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeAnswer("b");
			}
		});
		rbtnans3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeAnswer("c");
			}
		});
		rbtnans4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeAnswer("d");
			}
		});
		showTimeLeft();
	}
}
