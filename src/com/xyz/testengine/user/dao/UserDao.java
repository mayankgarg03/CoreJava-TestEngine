package com.xyz.testengine.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xyz.testengine.user.dto.LoginDto;
import com.xyz.testengine.user.dto.RegisterDto;
import com.xyz.testengine.user.dto.RightDto;
import com.xyz.testengine.util.CommonDao;
import com.xyz.testengine.util.constants.QueryConstant;

// class A{
//	 
//       static{
//    	   System.out.println("A class loaded ");
//       }
//
//	
// }


public class UserDao {
	
	
	
	public boolean submitAuthDB(ArrayList<RegisterDto> registerlist) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try{
	          con = CommonDao.getConnection();
	          
	          pstmt  = con.prepareStatement(QueryConstant.UPDATE_AUTHENTICATION_SQL);
	          for(int i = 0; i<registerlist.size();i++){
	          pstmt.setString(1, registerlist.get(i).getAuthentication());
	          System.out.println("inusderda"+" "+ registerlist.get(i).getAuthentication());
	          pstmt.setString(2,registerlist.get(i).getEmailid());
	          System.out.println(registerlist.get(i).getEmailid());
	          pstmt.addBatch();
	          }
	          int records[] = pstmt.executeBatch();
	          if(records.length>0){
	        	  result = true;
	          }
	          else{
	        	  result = false;
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
		return result;
	}
	
	public ArrayList<RegisterDto> fetchUserData() throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<RegisterDto> registerlist = new ArrayList<>();
try{
	con = CommonDao.getConnection();

		
		pstmt = con.prepareStatement(QueryConstant.FETCH_SQL);
		rs = pstmt.executeQuery();
		while(rs.next()){
			RegisterDto registerdto = new RegisterDto();
			registerdto.setUid(rs.getInt("uid"));
			registerdto.setUserName(rs.getString("username"));
			registerdto.setPassword(rs.getString("password"));
			registerdto.setEmailid(rs.getString("emailid"));
			registerdto.setConfirmPassword(rs.getString("confirmpassword"));
			registerdto.setSelectCity(rs.getString("selectcity"));
			registerdto.setDateofbirth(rs.getString("dateofbirth"));
			registerdto.setGender(rs.getString("gender"));
			registerdto.setSelectCollege(rs.getString("selectcollege"));
			registerdto.setSelectStream(rs.getString("selectstream"));
			registerdto.setPhoneNo(rs.getString("phoneno"));
			registerdto.setRollno(rs.getString("rollno"));
			registerdto.setSelectUserType(rs.getString("selectusertype"));
			//registerdto.setAuthentication(rs.getString("authentication"));
			registerlist.add(registerdto);
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
         return registerlist;
	

	}
		
public ArrayList<RegisterDto> fetchUserData1() throws ClassNotFoundException, SQLException{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<RegisterDto> registerlist = new ArrayList<>();
try{
con = CommonDao.getConnection();

	
	pstmt = con.prepareStatement(QueryConstant.FETCH_ROLE_SQL);
	rs = pstmt.executeQuery();
	while(rs.next()){
		RegisterDto registerdto = new RegisterDto();
		registerdto.setUid(rs.getInt("uid"));
		registerdto.setUserName(rs.getString("username"));
		registerdto.setPassword(rs.getString("password"));
		registerdto.setEmailid(rs.getString("emailid"));
		registerdto.setConfirmPassword(rs.getString("confirmpassword"));
		registerdto.setSelectCity(rs.getString("selectcity"));
		registerdto.setDateofbirth(rs.getString("dateofbirth"));
		registerdto.setGender(rs.getString("gender"));
		registerdto.setSelectCollege(rs.getString("selectcollege"));
		registerdto.setSelectStream(rs.getString("selectstream"));
		registerdto.setPhoneNo(rs.getString("phoneno"));
		registerdto.setRollno(rs.getString("rollno"));
		registerdto.setSelectUserType(rs.getString("selectusertype"));
		//registerdto.setAuthentication(rs.getString("authentication"));
		registerlist.add(registerdto);
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
             return registerlist;
		
	}

public void updateRoleAndRights(ArrayList<RegisterDto> registerlist , RegisterDto register) throws SQLException, ClassNotFoundException {
		
   Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		System.out.println("Updating started");
		int i;
		con=CommonDao.getConnection();
		
		pstmt=con.prepareStatement(QueryConstant.SET_USER_ROLE_SQL);
	for( i=0;i<registerlist.size();i++) {
		System.out.println("i" +registerlist.size());
		System.out.println("enetetr lop");
		pstmt.setInt(1,registerlist.get(i).getUid());
		//System.out.println(Integer.valueOf("@@"+registerlist.get(i).getRoleid()));
		if(registerlist.get(i).getRoleid().equals("Student")){
			System.out.println("enterss if");
			pstmt.setInt(2,3);
		}
		if(registerlist.get(i).getRoleid().equals("Teacher")){
			pstmt.setInt(2,2);
		}
		if(registerlist.get(i).getRoleid().equals("Admin")){
			pstmt.setInt(2,1);
		}
		pstmt.addBatch();
	}
		
		 int records[]=pstmt.executeBatch();
	
	pstmt = con.prepareStatement(QueryConstant.SET_USER_RIGHT_SQL);
	for(i=0 ; i<registerlist.size();i++){
		if(registerlist.get(i).getRoleid().equals("Student")){
			//System.out.println("enterss if");
			pstmt.setInt(1,3);
			pstmt.setInt(2,4);
		}
		if(registerlist.get(i).getRoleid().equals("Teacher")){
			pstmt.setInt(1,2);
			pstmt.setInt(2,5);
		}
		if(registerlist.get(i).getRoleid().equals("Admin")){
			pstmt.setInt(1,1);
			pstmt.setInt(1, 6);
			pstmt.addBatch();
			pstmt.setInt(1, 9);
			pstmt.setInt(1, 8);
		}
		
		pstmt.addBatch();
	}
	
	int records2[] = pstmt.executeBatch(); 
		
	
		 
		 
	pstmt = con.prepareStatement(QueryConstant.STATUS_ROLE_UPDATE_SQL);
	for( i=0;i<registerlist.size();i++) {
		//System.out.println("enetetr lop");
		pstmt.setInt(1,registerlist.get(i).getUid());
		pstmt.addBatch();
	}
		
		
	     
	      int records1[] = pstmt.executeBatch();

	     
	      if(records.length>0 && records1.length>0 && records2.length>0) {
	    	  //con.commit();
	    	  System.out.println("Data entered in DB");
	      }else {
	    	  //con.rollback();
	    	  System.out.println("Data entry cancelled");
	      }
	}
	
	
	finally {
		if(con !=null) {
			con.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
	}
		
	}
		
//		public void updateRight(RegisterDto resgisterdto) throws ClassNotFoundException, SQLException{
//			 Connection con=null;
//				PreparedStatement pstmt=null;
//				ResultSet rs=null;
//				
//				con = CommonDao.getConnection();
//				pstmt = con.prepareStatement(QueryConstant.SET_USER_RIGHT_SQL);
//				pstmt.setInt(1,resgisterdto.getRightid());
//				if()
//				
//				
//		}
	
	
	public String checkIfPresent(RegisterDto registerdto) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result;
		try{
			con = CommonDao.getConnection();
			pstmt = con.prepareStatement(QueryConstant.SEARCH_SQL);
			pstmt.setString(1, registerdto.getEmailid());
			pstmt.setString(2, registerdto.phoneNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = "Either Phoneno or emailid is already registered";
			}
			else{
				result = doRegister(registerdto);
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
	
	
	
	public String doRegister(RegisterDto registerdto) throws ClassNotFoundException, SQLException{
				 Connection con = null;
		 PreparedStatement pstmt = null;
		 try{
			 
		 
		 con = CommonDao.getConnection();
		 pstmt = con.prepareStatement(QueryConstant.REGISTER_SQL);
		 pstmt.setString(1,registerdto.getUserName());
		 pstmt.setString(2,registerdto.getPassword());
		 pstmt.setString(3,registerdto.getEmailid() );
		 pstmt.setString(4,registerdto.getConfirmPassword());
		 pstmt.setString(5,registerdto.getSelectCity());
		 pstmt.setString(6,registerdto.getDateofbirth());
		 pstmt.setString(7,registerdto.getGender());
		 pstmt.setString(8,registerdto.getSelectCollege());
		 pstmt.setString(9,registerdto.getSelectStream());
		 pstmt.setString(10,registerdto.getSelectUserType());
   		 pstmt.setString(11,registerdto.getPhoneNo());
   		 pstmt.setString(12,registerdto.getRollno());
		 int insertedCount = pstmt.executeUpdate();
		 return insertedCount>0 ?"register successfullly ":"can't register";
		 
	
	}         
		 finally{
			 if(pstmt!=null){
				 pstmt.close();	 
			 }
			 if(con!=null){
				 con.close();
			 }
		 
			
		 }
	}
	
	//ArrayList<RegisterDto> rightlist = new ArrayList<>();
	ArrayList<RightDto> rights;
	RegisterDto registerdto = new RegisterDto();
public RegisterDto fetchRight() throws ClassNotFoundException, SQLException{
	
	 Connection con = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 try{
	 con = CommonDao.getConnection();
	 pstmt = con.prepareStatement(QueryConstant.FETCH_RIGHT_SQL);
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		 rights = new ArrayList<>();
		 //System.out.println("amamma "+rs.getInt("rightid"));
		 registerdto.setRightid(rs.getInt("rightid"));
		 registerdto.setRights(rights);	
		 RightDto right = new RightDto(rs.getString("name") , rs.getString("screenname"));
		 rights.add(right);
		
		 System.out.println("a "+registerdto.getRights().get(0).getName() );
		 System.out.println("aaa "+registerdto.getRightid());
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
	return registerdto;
}
	
	public  RegisterDto doLogin(LoginDto logindto) throws ClassNotFoundException, SQLException{
		RegisterDto registerdto = null;
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 ArrayList<RightDto> rights = null;
		 try{
		 con = CommonDao.getConnection();
         pstmt = con.prepareStatement(QueryConstant.LOGIN_SQL);		 
         pstmt.setString(1, logindto.getUserName());
         pstmt.setString(2, logindto.getPassword());
        // System.out.println(username);
         rs = pstmt.executeQuery();
//         if(rs.next()){
//        	 return "WELCOME " + username;
//         }
//         else
//        	 return "invalid userid or password";
//	
         while(rs.next()){
        	 if(registerdto==null){
        		 registerdto = new RegisterDto();
        		 registerdto.setUserName(rs.getString("username"));
        		 registerdto.setRolename(rs.getString("rolename"));
        		 rights = new ArrayList<>();
        		 registerdto.setRights(rights);
        	 }
         
        	  
        	 RightDto rightdto = new RightDto(rs.getString("rightname"),rs.getString("screenname"));
        	    rights.add(rightdto);
         }
         return registerdto;
        		 
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
	
	//public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//         A obj = new A();            //object is required for class loading.
//        Class.forName("A"); 
////        System.out.println("A class loaded ");
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("enter the name ");
//		String name = scanner.next();
//		System.out.println("enter the password");
//		String passwrd = scanner.next();
//		
//		Class.forName("org.postgresql.Driver");
//		System.out.println("Driver Loaded..");
//		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exam","postgres","mayank1@");
//		if(con!=null){
//			System.out.println("connection estbalish ");
//		}
//		else
//		{
//			System.out.println("connection not establish");
//		}
//		final String SQL="select userid, password from users where userid=? and password=?";
//		PreparedStatement pstmt = con.prepareStatement(SQL);
//		pstmt.setString(1, name);
//	    pstmt.setString(2, passwrd);
//	     ResultSet rs = pstmt.executeQuery();
//	     if(rs.next()){
//	    	 System.out.println("WELCOME "+name);
//	     }
//	     else
//	     {
//	    	 System.out.println("invalid name and rollno");
//	     }
//	     rs.close();
//	     pstmt.close();
//	     con.close();
//	     scanner.close();
//	}

		
//}
	

