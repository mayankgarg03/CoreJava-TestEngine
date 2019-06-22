package com.xyz.testengine.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xyz.testengine.util.CommonDao;
import com.xyz.testengine.util.constants.QueryConstant;



public class TestNameDao {
	ArrayList<String> testlist = new ArrayList<>();
	
	
//	public void selectTest() throws ClassNotFoundException, SQLException{
//		Connection con = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs = null;
//		
//		
//		try{
//			
//			con=CommonDao.getConnection();
//			pstmt = con.prepareStatement(QueryConstant.FETCH_TESTNAME_SQL);
//			 rs = pstmt.executeQuery();
//			 while(rs.next()){
//				 testlist.add(rs.getString("testname"));
//			 }
//			 if(testlist.size()>0){
//				 System.out.println("Testnames present");
//			 }
//			 else{
//				 System.out.println("No test present");
//			 }
//			 
//		}
//		finally{
//			if(pstmt!=null){
//				pstmt.close();
//			}
//			if(con!=null){
//				con.close();
//			}
//		}
//	}

//	public void checkTestid(String test) throws ClassNotFoundException, SQLException{
//		Connection con = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs = null;
//		
//		con  = CommonDao.getConnection();
//		pstmt = con.prepareStatement(QueryConstant.CHECK_TESTID_SQL);
//		rs = pstmt.executeQuery();
//		
//	}
//	
//	public TestNameDto doFetchTestId(String test) throws ClassNotFoundException, SQLException{
//		Connection con = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs = null;
//		TestNameDto testnamedto= null;
//		try{
//			//System.out.println(test);
//			con=CommonDao.getConnection();
//			pstmt = con.prepareStatement(QueryConstant.FETCH_SQL);
//			//pstmt.setString(1, test); 
//			 rs = pstmt.executeQuery();
////			 if(rs.next()){
////				 return "welcome"+test;
////			 }
////			 else{
////				 return "nothing! wrong info";
////			 }
////		}
//			   while(rs.next()){
//		        	 if(testnamedto==null){
//		        		 testnamedto = new TestNameDto();
//		        		 testnamedto.setTestno(rs.getString("testno"));
//		        		// registerdto.setRolename(rs.getString("rolename"));
//		        		
//		        	 }
//			   }
//		}
//		         
//		finally{
//			if(pstmt!=null){
//				pstmt.close();
//			}
//			if(con!=null){
//				con.close();
//			}
//		}
//		 return testnamedto;
//	}
    //     return testnamedto;
	
}
