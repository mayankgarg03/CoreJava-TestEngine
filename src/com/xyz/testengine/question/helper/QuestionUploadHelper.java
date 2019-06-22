package com.xyz.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.xyz.testengine.question.dao.QuestionDao;
import com.xyz.testengine.question.dao.TestNameDao;
import com.xyz.testengine.question.dto.QuestionDto;
import com.xyz.testengine.util.CommonUtils;
import com.xyz.testengine.util.constants.PathConstants;

public class QuestionUploadHelper {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		 QuestionUploadHelper help = new  QuestionUploadHelper();
//		 help.write();
	}
	//TestNameDao testnamedao = new TestNameDao();
	             public boolean read(String path , int time) throws IOException, ClassNotFoundException, SQLException{
	            	  
	        
	            	 //String path = "C:\\Users\\mayank\\Documents\\testengine\\src\\com\\xyz\\testengine\\user\\view\\LoginView.java";
	            	 
	            	 boolean isUploaded = false;
	            	 File file = new File(path);
	            	 String fileName = CommonUtils.getFileName(path);
	            	 System.out.println("filename is "+fileName);
	            	
	            	 FileOutputStream fo = new FileOutputStream(PathConstants.UPLOAD_PATH+fileName);
	            	 BufferedOutputStream bo = new BufferedOutputStream(fo);
	            	      
	            	 final int EOF = -1;
	            	      if(file.exists()){
	            	    	  System.out.println("file exist.......");
	            	    	  FileInputStream fs = new FileInputStream(path);
	            	    	  
	            	    	BufferedInputStream bs = new BufferedInputStream(fs);
	            	    	long start = System.currentTimeMillis();
	            	    	 int singleByte = bs.read();
	            	    	  while(singleByte!=EOF){
	            	    		//System.out.print((char)singleByte);
	            	    		 bo.write(singleByte);
	            	    		 
	            	    		singleByte =  bs.read();
	            	    		
	            	    		 //System.out.print((char)singleByte);

	            	    	  }
	            	    	  isUploaded = true;
	            	    	  long end = System.currentTimeMillis();
	            	    	 // System.out.println("time take is:" +(end - start));
	            	      bo.close();
	            	      fo.close();
	            	      bs.close();
	            	      fs.close();
	            	      writeToDb(PathConstants.UPLOAD_PATH+fileName , fileName.substring(1) , time);
	            	      //testnamedao.uploadTestId();
	            	      
	            	      }
	            	      
	            	      else{
	            	    	  System.out.println("file not exist");
	            	      }
	            	      return isUploaded;
	             }
	             

            	  
              
              public void writeToDb(String path , String filename , int time) throws IOException{
            	  ArrayList<QuestionDto> questionlist = new ArrayList<>();
            	  boolean isFirstRowPass = false;
            	  int cellCounter = 0;
            	  FileInputStream fs = new FileInputStream(path);
            	  HSSFWorkbook workbook = new HSSFWorkbook(fs);
            	  HSSFSheet sheet = workbook.getSheetAt(0);
            	  Iterator<Row> rows = sheet.rowIterator();
            	  while(rows.hasNext()){
            		  Row currentRow = rows.next();
            		  if(!isFirstRowPass){
            			  isFirstRowPass = true;
            			  continue;
            		  }
            		  cellCounter=0;
            		  QuestionDto questiondto = new QuestionDto();
            		  Iterator<Cell> cells = currentRow.cellIterator();
            		  while(cells.hasNext()){
            			  Cell currentCell = cells.next();
            			  cellCounter++;
            			  if(cellCounter == 1){
            				  questiondto.setQuestion_No((int)currentCell.getNumericCellValue());
            			  }
            			  else
            				  if(cellCounter == 2){
            					  questiondto.setQuestion(currentCell.getStringCellValue());
            				  }
            				  else
                				  if(cellCounter == 3){
                					  questiondto.setAns1(currentCell.getStringCellValue());
                				  }
                			
                					  else
                        				  if(cellCounter == 4){
                        					  questiondto.setAns2(currentCell.getStringCellValue());
                        				  }
                        				  else
                            				  if(cellCounter == 5){
                            					  questiondto.setAns3(currentCell.getStringCellValue());
                            				  }
                            				  else
                                				  if(cellCounter == 6){
                                					  questiondto.setAns4(currentCell.getStringCellValue());
                                				  }
                                				  else
                                    				  if(cellCounter == 7){
                                    					  questiondto.setRans(currentCell.getStringCellValue());
                                    				  }
                                    				  else
                                        				  if(cellCounter == 8){
                                        					  questiondto.setScore((int)currentCell.getNumericCellValue());
                                        				  }
                                        				 
            			  
            		  }
            		  questionlist.add(questiondto);
            	  }
            	  QuestionDao questiondao = new QuestionDao();
            	  System.out.println("questions are::" +questionlist);
            	  try {
					questiondao.bulkUpload(questionlist , filename , time);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("some problem occur contact to admin team");
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("might be problem in db contact to db team");
					e.printStackTrace();
				}
            	  
            	  
              }
}
