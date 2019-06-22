package com.xyz.testengine.question.dto;

public class TestNameDto {
@Override
	public String toString() {
		return "TestNameDto [testno=" + testno + "]";
	}

private String testno;

//TestNameDto(String testid){
//	this.testid = testid;
//}
public String getTestno() {
	return testno;
}

public void setTestno(String testno) {
	this.testno = testno;
}

//public static void main(String[] args) {
//	TestNameDto test = new TestNameDto();
//	 String msg = test.getTestid();
//     System.out.println("tetsid is"+msg);
//}
}
