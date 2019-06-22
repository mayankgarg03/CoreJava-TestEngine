package com.xyz.testengine.question.dto;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyResultTableModel extends AbstractTableModel {
	
	
	private String columns[] = {"qno","question","your answer", "right answer","score"};
	private ArrayList<QuestionDto> questionList;
	
	public MyResultTableModel(ArrayList<QuestionDto> questionList){
	this.questionList = questionList;	
	}
	
	@Override
	public String getColumnName(int column){
		return columns[column];
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return questionList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		QuestionDto questiondto = questionList.get(rowIndex);
		
		switch(columnIndex){	
			case 0:
				return questiondto.getQuestion_No();
			case 1:
				return questiondto.getQuestion();
			case 2:
				return questiondto.getYourAnswer();
			case 3:
				return questiondto.getRans();			
			case 4:	
				return questiondto.getScore();
		}
	
	return null;
}
}
