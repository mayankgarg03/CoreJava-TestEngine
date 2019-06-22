package com.xyz.testengine.question.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.border.EmptyBorder;

import com.xyz.testengine.question.dto.TestNameDto;
import com.xyz.testengine.util.CommonDao;
import com.xyz.testengine.util.constants.QueryConstant;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class SelectTest extends JFrame {

	private JPanel contentPane;
	//TestNameDto testnamedto = new TestNameDto();
	ArrayList<JRadioButton> btnlist;
	ButtonGroup bg = new ButtonGroup();
	JPanel panel_1 = new JPanel(); 
	JLabel label;
	JRadioButton btn;
	
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectTest frame = new SelectTest();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void selectTest() throws ClassNotFoundException, SQLException{
		ArrayList<String> testlist = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		try{
			
			con=CommonDao.getConnection();
			pstmt = con.prepareStatement(QueryConstant.FETCH_TESTNAME_SQL);
			 rs = pstmt.executeQuery();
			 while(rs.next()){
				 testlist.add(rs.getString("testname"));
			 }
			 if(testlist.size()>0){
				 System.out.println("Testnames present");
			 }
			 else{
				 System.out.println("No test present");
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
		
		
		
		
		
		for(int i=0;i<testlist.size();i++) {
			System.out.println("The list elements  " + testlist.get(i));
		} 
		int x=50 , y = 50;
		String str="";
		System.out.println("The size of the test list "  + testlist.size());
	    btnlist=new ArrayList<>();
	    //int j=0;
	   // GridBagConstraints c=new GridBagConstraints();
		for(int i=0;i<testlist.size();i++) {
			//j=i;
			btn= new JRadioButton(testlist.get(i));
		//	    c.gridx=1;
		  //      c.gridy=i;
	        
		    //    c.insets=new Insets(10,10,10,10);
		      //  panel_1.add(btn,c);
			str=(i+1) +". " ;
			label=new JLabel(str);
			label.setBounds(x, y, 50 , 20);
			 //c.gridx=0;
		       // c.gridy=i;
		        //c.insets=new Insets(10,10,10,10);
		      //  c.anchor=GridBagConstraints.PAGE_START;
		        panel_1.add(label);
		        //label.setBounds(50,50, 100, 40);
			System.out.println("lable text " + label.getText());
	       
			System.out.println(testlist.get(i));
		    btnlist.add(btn);
			btn.setFont(new Font("Times New Roman", Font.BOLD, 15));
			panel_1.add(btn);
			System.out.println("button loop");
			btn.setBounds(x+20,y-10,200, 47);
			bg.add(btn);
			
			
			y =y+80;
			
			
			
			
		  }
		 
//		for( int i=0;i<btnlist.size();i++) {
//			System.out.println("The test buttons " +btnlist.get(i).getText());
//		}
		
		
	}

	
	
	
	
public  boolean  fetchTest() {
		
		for(int i=0;i<btnlist.size();i++) {
			
			if(btnlist.get(i).isSelected()) {
				
				String testName=btnlist.get(i).getText().trim();
				System.out.println("The test name selected is " + testName);
				TakeTestView frame1= new TakeTestView(testName);
				frame1.setVisible(true);
				
			//	frame.dispose();
				return true;
			}
			
			
			
		}
		
		return false;
			
		
	}
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	//public String test;
	 //QuestionDao qd = new QuestionDao();
	 
	//public String fetchTestid(){
//		String test = textField.getText();
//		  testnamedto.setTestno(test);
//            		 
////		  try {
////			//  qd.doFetchTestId(test);    
////			 // System.out.println("test value in selecttest"+test);
////			 qd.getQuestions(test);
////			// ttv.getTest(test);
////			 JOptionPane.showMessageDialog(this, testnamedto.getTestno());
////			 } catch (ClassNotFoundException e) {
////			// TODO Auto-generated catch block
////				 JOptionPane.showMessageDialog(this, "contact to admin");
////			e.printStackTrace();
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			 JOptionPane.showMessageDialog(this, "some error occur! contact syatem admin");
////			e.printStackTrace();
////		}
//		  TakeTestView ttv = new TakeTestView(test);
//		 ttv.setVisible(true);
//		  return test;
//	}
	
	public SelectTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel lblPleaseSelectA = new JLabel("Please Select a Test");
//		lblPleaseSelectA.setFont(new Font("Algerian", Font.BOLD, 16));
//		lblPleaseSelectA.setHorizontalAlignment(SwingConstants.CENTER);
//		lblPleaseSelectA.setBounds(34, 11, 366, 14);
//		contentPane.add(lblPleaseSelectA);
		
//		JLabel lblNewLabel = new JLabel("Enter The Test Name");
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
//		lblNewLabel.setBounds(28, 109, 372, 35);
//		contentPane.add(lblNewLabel);
//		
//		textField = new JTextField();
//		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
//		textField.setBounds(28, 176, 174, 20);
//		contentPane.add(textField);
//		textField.setColumns(10);
		
//		JButton btnNewButton = new JButton("submit");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		             	 // fetchTestid();
//			
//					//TakeTestView taketestview = new TakeTestView();
//					//taketestview.setVisible(true);
//					
//					//.loadQuestions();
//				
//				
//			}
//		});
//		
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnNewButton.setBounds(163, 227, 89, 23);
//		contentPane.add(btnNewButton);
//		
		
		panel_1.setBounds(0, 0, 434, 261);
		//contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 5, 434, 391);
		scrollPane.setViewportView(panel_1);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a test");
		lblPleaseSelectA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPleaseSelectA.setBounds(36, 11, 361, 22);
		panel_1.add(lblPleaseSelectA);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fetchTest()){
					
				}
				else{
					JOptionPane.showMessageDialog(null, "please select one option");
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(169, 339, 89, 23);
		panel_1.add(btnSubmit);
		contentPane.add(scrollPane);
		//scrollPane.setViewportView(panel_1);
		
		
//		JButton btnNewButton = new JButton("JAVA");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			
//					TakeTestView taketestview = new TakeTestView();
//					taketestview.setVisible(true);
//			
//				
//				
//			}
//		});
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
//		
//		btnNewButton.setBounds(26, 67, 89, 23);
//		contentPane.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("C++");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				TestNameDto testnamedto = new TestNameDto();
//				  testnamedto.setTestid("C++");
//				  
//	          			
//			}
//		});
//		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnNewButton_1.setBounds(26, 112, 89, 23);
//		contentPane.add(btnNewButton_1);
//		
//		JButton btnNewButton_2 = new JButton("C");
//		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnNewButton_2.setBounds(26, 159, 89, 23);
//		contentPane.add(btnNewButton_2);
		try {
			selectTest();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
