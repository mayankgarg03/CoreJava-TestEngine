package com.xyz.testengine.user.view;

import java.awt.EventQueue;
import java.awt.Font;
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

import com.xyz.testengine.user.dao.UserDao;
import com.xyz.testengine.user.dto.RegisterDto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthenticationView extends JFrame {

	private JPanel contentPane;
	public String authentication;
	public int index;

	/**
	 * Launch the application.
	 */
 static AuthenticationView frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AuthenticationView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JLabel namelbl = new JLabel("");
//	JRadioButton rdbtnYes;
//	JRadioButton rdbtnNo;
	JLabel emaillabel = new JLabel("");
	JLabel phonelabel = new JLabel("");
	JLabel usertypelabel=new JLabel("");
	JLabel rolllabel=new JLabel("");
	JButton btnPrevious = new JButton("Previous");
	JButton btnSubmit = new JButton("Submit");
	JButton btnNext = new JButton("Next");
	ButtonGroup bg = new ButtonGroup();
	JRadioButton rdbtnYes = new JRadioButton("Yes");
	JRadioButton rdbtnNo = new JRadioButton("No");
	ArrayList<RegisterDto> registerlist = new ArrayList<>();
	
	
	public boolean submitAuthentication(){
		getDataAuthentication(index);
		UserDao userdao = new UserDao();
		boolean result = false;
	try {
		result = userdao.submitAuthDB(registerlist);
		//System.out.println("print result in submitauthentication "+result);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(this, "conatact to system administration as some problem occured");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, "conatact to system administration as some problem occured");
	}
	return result;
	}
	
	
	
	public void loadUserData(){
		UserDao userdao = new UserDao();
		try {
			registerlist = userdao.fetchUserData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "some problem occured");
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "some problem occured contact DB admin");
			e.printStackTrace();
		}
		//System.out.println("data Load");
		
	}
	
	
//	 public void selectYourOption() {
//		 System.out.println("enters selectyouroptoon");
//		 //System.out.println(this.registerlist.get(index).getAuthentication());
//		 //System.out.println(index);
// 		if(this.registerlist.get(index).getAuthentication()!=null) {
// 			//System.out.println("enter if in select");
// 	  authentication=this.registerlist.get(index).getAuthentication();
// 	//System.out.println("selectyourans"+" "+ authentication);
//      if(authentication.equals("yes")) {
//    	  rdbtnYes.setSelected(true);
// 	  }else if(authentication.equals("no")) {
// 		 rdbtnNo.setSelected(true);
// 	  }
// 	}
//      else {
// 		  bg.clearSelection();
// 	  }		
// }
//	
	 
	public void selectYourOption(){
		rdbtnNo.setSelected(true);
	}
	 public void enabledisableButton(){
		 if(registerlist.size()==1){
			 btnPrevious.setEnabled(false);
 			btnNext.setEnabled(false);
 		}
 		else
 		if(index==0){
 		btnPrevious.setEnabled(false);
 		btnNext.setEnabled(true);
 		}
 		else
 			if(index == registerlist.size()-1){
 				btnNext.setEnabled(false);
 				btnPrevious.setEnabled(true);
 				
 			}
 		else
 		if(index>0 && index<registerlist.size()){
 			btnPrevious.setEnabled(true);
 			btnNext.setEnabled(true);
 		}	 
	 }
	 
	 
	public void printData() throws Exception{
		if(registerlist.size()==0){
			JOptionPane.showMessageDialog(this, "No Authentication updation pending");
			frame.setVisible(false);
			// throw new Exception("IndexOutOfBoundException");
		}
		if(index<registerlist.size()){
			//System.out.println("enters printdata iff");
			selectYourOption();
		
		RegisterDto registerdto ;
		registerdto = registerlist.get(index);
//		System.out.println(index);
//		System.out.println(registerdto.getUserName());
		namelbl.setText(registerdto.getUserName());
		emaillabel.setText(registerdto.getEmailid());
		phonelabel.setText(registerdto.getPhoneNo());
		rolllabel.setText(registerdto.getRollno());
		usertypelabel.setText(registerdto.getSelectUserType());
		enabledisableButton();
		}
		
	}
	
	
	 public void getDataAuthentication(int index) {
    	 
    	 if(rdbtnYes.isSelected()) {
    		 authentication="yes";
    	 }else if(rdbtnNo.isSelected()) {
    		 authentication="no";
    	 }
    	 this.registerlist.get(index).setAuthentication(authentication);
    	 authentication=" ";
     }
	
	public AuthenticationView() throws Exception {
		loadUserData();
		//bg = new ButtonGroup();
		bg.add(rdbtnYes);
		bg.add(rdbtnNo);
		printData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAuthentication = new JLabel("Authentication");
		lblAuthentication.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuthentication.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthentication.setBounds(230, 22, 143, 24);
		contentPane.add(lblAuthentication);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(28, 90, 83, 14);
		contentPane.add(lblUsername);
		
		 
		namelbl.setBounds(230, 90, 197, 14);
		contentPane.add(namelbl);
		
		JLabel lblPhoneno = new JLabel("phoneNo");
		lblPhoneno.setBounds(28, 147, 83, 14);
		contentPane.add(lblPhoneno);
		
		
		phonelabel.setBounds(230, 147, 197, 14);
		contentPane.add(phonelabel);
		
				emaillabel.setBounds(230, 211, 277, 14);
		contentPane.add(emaillabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(28, 211, 83, 14);
		contentPane.add(lblEmail);
		
		JLabel lblUsertype = new JLabel("Usertype");
		lblUsertype.setBounds(28, 274, 83, 14);
		contentPane.add(lblUsertype);
		
		JLabel lblRollno = new JLabel("RollNo");
		lblRollno.setBounds(28, 339, 83, 14);
		contentPane.add(lblRollno);
		
		 
		usertypelabel.setBounds(230, 274, 261, 14);
		contentPane.add(usertypelabel);
		
		
		rolllabel.setBounds(230, 339, 207, 14);
		contentPane.add(rolllabel);

		
		
		 btnPrevious.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		 getDataAuthentication(index);
					index=index+-1;
					try {
						printData() ;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		 	
		 });
		btnPrevious.setBounds(37, 503, 89, 23);
		contentPane.add(btnPrevious);
		
		 
		 btnNext.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		if(index==0) {
					getDataAuthentication(0);
					index=index+1;
				}else {
					getDataAuthentication(index);
					index=index+1;
				}
				try {
					printData();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		btnNext.setBounds(230, 503, 89, 23);
		contentPane.add(btnNext);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status=false;
				status = submitAuthentication();
				String result = status?"upload successfully" : "cann't Upload";
				JOptionPane.showMessageDialog(btnSubmit, result);
			}
		});
		btnSubmit.setBounds(453, 503, 89, 23);
		contentPane.add(btnSubmit);
		
		
		rdbtnYes.setBounds(28, 405, 109, 23);
		contentPane.add(rdbtnYes);
		
		 
		rdbtnNo.setBounds(230, 405, 109, 23);
		contentPane.add(rdbtnNo);
				
		
		
		
	}
}
