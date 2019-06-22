package com.xyz.testengine.user.dto;

import java.util.ArrayList;

public class RegisterDto {
             private String rolename;
             public int uid;
             public String rightname;
             public String getRightname() {
				return rightname;
			}
			public void setRightname(String rightname) {
				this.rightname = rightname;
			}
			public int getUid() {
				return uid;
			}
			public void setUid(int uid) {
				this.uid = uid;
			}
			private ArrayList<RightDto> rights = new ArrayList<>();

			public String getRolename() {
				return rolename;
			}
			public void setRolename(String rolename) {
				this.rolename = rolename;
			}
			public ArrayList<RightDto> getRights() {
				return rights;
			}
			public void setRights(ArrayList<RightDto> rights) {
				this.rights = rights;
			}
	public String rollno;
	public String authentication;
	public String roleid;
	public int rightid;
	
	public int getRightid() {
		return rightid;
	}
	public void setRightid(int rightid) {
		this.rightid = rightid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getAuthentication() {
		return authentication;
	}
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String userName;
	public String password;
	public String confirmPassword;
	public String emailid;
	public String phoneNo;
	public String selectCity;
	public String selectCollege;
	public String selectStream;
	public String gender;
	public String dateofbirth;
	public String selectUserType;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSelectCity() {
		return selectCity;
	}
	public void setSelectCity(String selectCity) {
		this.selectCity = selectCity;
	}
	public String getSelectCollege() {
		return selectCollege;
	}
	public void setSelectCollege(String selectCollege) {
		this.selectCollege = selectCollege;
	}
	public String getSelectStream() {
		return selectStream;
	}
	public void setSelectStream(String selectStream) {
		this.selectStream = selectStream;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getSelectUserType() {
		return selectUserType;
	}
	public void setSelectUserType(String selectUserType) {
		this.selectUserType = selectUserType;
	}
	
	

}
      
