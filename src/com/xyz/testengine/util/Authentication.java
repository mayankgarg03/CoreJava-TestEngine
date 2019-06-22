package com.xyz.testengine.util;

import java.util.regex.Pattern;

public class Authentication {
	
	public String checksChar(String name){
		String result = " ";
		for(int i = 0;i<name.length();i++){
		if((name.charAt(i)>=65 && name.charAt(i)<=90) || (name.charAt(i)>=97 && name.charAt(i)<=122)){
			result = "correct";
		}
		else{
			result = "incorrect";
	        break;
		}
		}
		return result;
		
	}
	
	
	public String checksPhone(String number){
		String isCorrect = " ";
		for(int i = 0; i<number.length();i++){
			if((number.charAt(i)>=48 && number.charAt(i)<=57) || (number.trim().length() == 10)){
				isCorrect = "correct";
			}
			else{
				isCorrect = "Incorrect";
				break;
			}
		}
		return isCorrect;
	}
	
	public String checksEmail(String email){
		 String check="";
         String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$";
                  
           Pattern pat = Pattern.compile(emailRegex);

            if (pat.matcher(email).matches()) {
	                           check= "correct";
            	}
            else  if(email==null||pat.matcher(email).matches()==false){
                  check= "incorrect";		
            }
            			return check; 
		}
	
	
	
	
	
	
	public String checkPassword(String password){
		String passStatus = " ";
		boolean lowerCase = false;
		boolean upperCase=false;
		boolean number= false;
		boolean specialSymbol= false;
		
		for(int i =0; i<password.length();i++){
		       if(password.charAt(i)>=65 && password.charAt(i)<=90){
		    	   upperCase = true;
		       }
		       else if(password.charAt(i)>=97 && password.charAt(i)<=122){
		    	   lowerCase = true;
		       }
		       else if(password.charAt(i)>=48 && password.charAt(i)<=57){
		    	   number = true;
		       }
		       else if((password.charAt(i)>=33 && password.charAt(i)<=47) || (password.charAt(i)>=58 && password.charAt(i)<=64) ||
		    		   (password.charAt(i)>=91 && password.charAt(i)<=96)){
		    	   specialSymbol = true;
		       }       
		}
		if((upperCase && lowerCase)  && password.length()<6){
			passStatus = "Weak";
		}
		else if((upperCase && lowerCase && number)  && (password.length()>6 && password.length()<12) ){
			passStatus = "Medium";
		}
		else if((upperCase && lowerCase && number && specialSymbol) && (password.length()>12)){
			passStatus = "Strong";
		}
		return passStatus;
		
	}
	
	public String passwordMatch(String initial , String confirm){
		String match = " ";
		int i = 0 , j = 0;
		while(i<initial.length() || j<confirm.length()){
			if(initial.charAt(i) == confirm.charAt(i)){
				match = "true";
			}
			else{
				match = "false";
				break;
			}
			i++;
			j++;
		}
		return match;
		
		
	}
	

	}
