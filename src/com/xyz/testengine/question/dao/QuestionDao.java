package com.xyz.testengine.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xyz.testengine.question.dto.QuestionDto;
import com.xyz.testengine.util.CommonDao;
import com.xyz.testengine.util.constants.QueryConstant;

public class QuestionDao {
	public boolean bulkUpload(ArrayList<QuestionDto> questionlist , String filename , int time) throws ClassNotFoundException, SQLException{
                       Connection con = null;
                       PreparedStatement pstmt = null;
                       int teststatus = 0;
                       String result = " ";
                       try{
                       con = CommonDao.getConnection();
                       if(findTest(filename).equals("File already present")){
                    	   return false;
                       }
                       else{
                       pstmt = con.prepareStatement(QueryConstant.UPDATE_TEST_SQL);
                       pstmt.setString(1, filename);
                       pstmt.setInt(2, time);
                      teststatus =  pstmt.executeUpdate();
                       }
                       pstmt = con.prepareStatement(QueryConstant.QUESTION_UPLOAD_SQL);
                       for(QuestionDto question : questionlist){
                    	   pstmt.setInt(1, question.getQuestion_No());
                    	   pstmt.setString(2,question.getQuestion() );
                    	   pstmt.setString(3,question.getAns1() );
                    	   pstmt.setString(4,question.getAns2() );
                    	   pstmt.setString(5,question.getAns3() );
                    	   pstmt.setString(6,question.getAns4() );
                    	   pstmt.setString(7,question.getRans() );
                    	   pstmt.setInt(8,question.getScore() );
                    	   pstmt.addBatch();
                       }
                       int records [] = pstmt.executeBatch();
                       if(records.length>0 && teststatus>0){
                    	   result = "question upload and testtime and name upload";
                       }
                       else{
                    	   result = "not upload";
                       }
                       System.out.println("RECORD UPLOADED......");
                       
                       if(testQuesMap(filename)) {
              			System.out.println("Inside test map if");
              		return true ;
              		}else {
             			System.out.println("Inside test map else");
              			return false;
              		}

	}
	finally{
		if(pstmt!=null){
			pstmt.close();
		}
		if(con!=null){
			con.close();
		}
		
		
	}
                       
                      // testQuesMap(filename);
//                       if(testQuesMap(filename)) {
//               			System.out.println("Inside test map if");
//               		return true ;
//               		}else {
////               			System.out.println("Inside test map else");
//               			return false;
//               		}
					//return false;
                       
                       
          
}
	
	
	public String findTest(String filename) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String result = " ";
		try{
		con = CommonDao.getConnection();
		pstmt = con.prepareStatement(QueryConstant.FIND_TEST_SQL);
		pstmt.setString(1, filename);
		rs = pstmt.executeQuery();
		if(rs.next()){
			result = "File already present";
			//System.out.println("File present");
		}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
			
		}
		return result;
		
		
	}
	
	
//	public void  doFetchTestId(String test) throws ClassNotFoundException, SQLException{
//		Connection con = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs = null;
//		
//		ArrayList <TestNameDto> testIdList =  new ArrayList<>(); 
//		try{
//			
//			con=CommonDao.getConnection();
//			pstmt = con.prepareStatement(QueryConstant.CHECK_TESTID_SQL);
//			
//			 rs = pstmt.executeQuery();
//			
//			   while(rs.next()){
//				   TestNameDto testnamedto = null;
//		        	 if(testnamedto==null){
//		        		 testnamedto = new TestNameDto();
//		        		 testnamedto.setTestno(rs.getString("testno"));
//		        		testIdList.add(testnamedto);
//		        		
//		        	 }
//			   }
//			   for( TestNameDto testnamedto : testIdList){
//				   
//				   System.out.println("testidlsi:"+testIdList);
//				   if(testIdList.equals(test)){
//					   JOptionPane.showMessageDialog(null, "Same value");
//					   getQuestions(test);
//					   TakeTestView ttv = new TakeTestView(test);
//						 ttv.setVisible(true);
//				   }
//				   else{
//					   JOptionPane.showMessageDialog(null,"enter right id please");
//				   }
//				
//				   
//		}
//		}
//		         
//		finally{
//			if(rs!=null){
//				rs.close();
//			}
//			if(pstmt!=null){
//				pstmt.close();
//			}
//			if(con!=null){
//				con.close();
//			}
//		}
//		 //return Testnamedto;
//	}
	
	
	public ArrayList<QuestionDto> getQuestions() throws ClassNotFoundException, SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;	 
		ResultSet rs = null;
		ArrayList<QuestionDto> questions = new ArrayList<>();
		try{

		
		
		con = CommonDao.getConnection();
		pstmt = con.prepareStatement(QueryConstant.FETCH_UNMAP_SQL);
		//pstmt.setString(1, test);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			QuestionDto questiondto = new QuestionDto();
			questiondto.setQid(rs.getInt("qid"));
			questiondto.setQuestion_No(rs.getInt("question_no"));
			questiondto.setQuestion(rs.getString("question"));
			questiondto.setAns1(rs.getString("ans1"));
			questiondto.setAns2(rs.getString("ans2"));
			questiondto.setAns3(rs.getString("ans3"));
			questiondto.setAns4(rs.getString("ans4"));
			questiondto.setRans(rs.getString("rans"));	
			questiondto.setScore(rs.getInt("score"));
			//questiondto.setTestid(rs.getString("testid"));
			questions.add(questiondto);
			
		}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return questions;
	}
	
	
	
	public ArrayList<QuestionDto> getQuestions1() throws ClassNotFoundException, SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;	 
		ResultSet rs = null;
		ArrayList<QuestionDto> questions = new ArrayList<>();
		try{

		
		
		con = CommonDao.getConnection();
		pstmt = con.prepareStatement(QueryConstant.FETCH_MAP_SQL);
		//pstmt.setString(1, test);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			QuestionDto questiondto = new QuestionDto();
			questiondto.setQid(rs.getInt("qid"));
			questiondto.setQuestion_No(rs.getInt("question_no"));
			questiondto.setQuestion(rs.getString("question"));
			questiondto.setAns1(rs.getString("ans1"));
			questiondto.setAns2(rs.getString("ans2"));
			questiondto.setAns3(rs.getString("ans3"));
			questiondto.setAns4(rs.getString("ans4"));
			questiondto.setRans(rs.getString("rans"));	
			questiondto.setScore(rs.getInt("score"));
			//questiondto.setTestid(rs.getString("testid"));
			questions.add(questiondto);
			
		}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return questions;
	}
	
		
	public boolean testQuesMap(String filename) throws ClassNotFoundException, SQLException{
		System.out.println("entersrsrsr testquesmap");
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		boolean status = false;
		int testid = 0;
		ArrayList<QuestionDto> questionlist = new ArrayList<>();
		try{
		con = CommonDao.getConnection();
		if(findTest(filename).equals("File already present")){
		pstmt = con.prepareStatement(QueryConstant.GET_TESTID_SQL);
		pstmt.setString(1, filename);
		//System.out.println("filenanns "+filename);
		rs = pstmt.executeQuery();
		rs.next();
		testid = rs.getInt("testid");
		System.out.println("testid at testquesmap" + testid);
		}
		if(getQuestions().size()==0){
			questionlist = getQuestions1();
		}
		else{
			questionlist = getQuestions();
		}
		
		pstmt = con.prepareStatement(QueryConstant.QUES_TEST_MAP_SQL);
		for(QuestionDto question : questionlist){
		pstmt.setInt(1, question.getQid());
		System.out.println(question.getQid());
		pstmt.setInt(2, testid);
		pstmt.addBatch();
		}
		int records[] = pstmt.executeBatch();
		
		pstmt = con.prepareStatement(QueryConstant.STATUS_UPDATE_SQL);
		for(QuestionDto question : questionlist){
		pstmt.setString(1, "y");
		pstmt.setInt(2, question.getQid());
		pstmt.addBatch();
		}
		int records1[] = pstmt.executeBatch();
		
		if(records.length>0 && records1.length>0){
			status = true;
		}
		else{
			status = false;
		}
		
		}
				finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
			
		}
		return status;
		
		
		
	}
	
	
	public int getTime(String filename) throws ClassNotFoundException, SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int time = 0;
		try{
		con = CommonDao.getConnection();
		pstmt = con.prepareStatement(QueryConstant.FETCH_TIME_SQL);
		pstmt.setString(1, filename);
		rs = pstmt.executeQuery();
		rs.next();
		time = rs.getInt("testtime");
	}
	finally{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(con!=null){
			con.close();
		}
	}
		return time;
	}
	
	
	public ArrayList<QuestionDto> getQuestions(String testname) throws ClassNotFoundException, SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
				 
		ResultSet rs = null;
		try{

		
		ArrayList<QuestionDto> questions = new ArrayList<>();
		con = CommonDao.getConnection();
		pstmt = con.prepareStatement(QueryConstant.QUESTION_INSERT_SQL);
		pstmt.setString(1, testname);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			QuestionDto questiondto = new QuestionDto();
			questiondto.setQid(rs.getInt("qid"));
			questiondto.setQuestion_No(rs.getInt("question_no"));
			questiondto.setQuestion(rs.getString("question"));
			questiondto.setAns1(rs.getString("ans1"));
			questiondto.setAns2(rs.getString("ans2"));
			questiondto.setAns3(rs.getString("ans3"));
			questiondto.setAns4(rs.getString("ans4"));
			questiondto.setRans(rs.getString("rans"));	
			questiondto.setScore(rs.getInt("score"));
			//questiondto.setTestid(rs.getString("testid"));
			questions.add(questiondto);
		}
		
		
		
		//		for(QuestionDto questiondto  : questions){
//			System.out.println(questions);
//		}
		return questions;
	}
	finally{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(con!=null){
			con.close();
		}
	}
	}
	
	
	
	
	
		}
	
	
