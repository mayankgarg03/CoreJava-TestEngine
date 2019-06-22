package com.xyz.testengine.user.dto;



public class RightDto {
	public int rightid;

	public int getRightid() {
		return rightid;
	}

	public void setRightid(int rightid) {
		this.rightid = rightid;
	}

	private String screenname;
	public String name;
       
       public RightDto(String name , String screenname){
    	   this.name = name;
    	   this.screenname = screenname;
       }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
       
}
