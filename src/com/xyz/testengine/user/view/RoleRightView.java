package com.xyz.testengine.user.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.xyz.testengine.user.dto.RightDto;

public class RoleRightView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static RoleRightView frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new RoleRightView();
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
	JLabel lblRoleRrght = new JLabel("Role Right");
	JLabel lblEmail = new JLabel("email");
	JLabel emailLabel = new JLabel("");
	JLabel lblUsertype = new JLabel("usertype");
	JLabel usertypelabel = new JLabel("");
	JButton btnBack = new JButton("back");
	JButton btnSubmit = new JButton("Submit");
	JButton btnNext = new JButton("next");
	JButton btnPrevious = new JButton("previous");
	JRadioButton radioButton = new JRadioButton("Admin");
	JRadioButton radioButton_1 = new JRadioButton("Teacher");
	JRadioButton radioButton_2 = new JRadioButton("Student");
	JLabel lblName = new JLabel("name");
	JLabel userlabel = new JLabel("");
	ButtonGroup bg = new ButtonGroup();
	
	public int index;
	public String roleid;
	
	ArrayList<RegisterDto> registerlist = new ArrayList<>();
	RegisterDto registerlist1 = new RegisterDto();
	//ArrayList<RegisterDto> registerlist2 = new ArrayList<>();
	
	RegisterDto register = new RegisterDto();
	public void loadUserData(){
		
		UserDao userdao = new UserDao();
		try {
			registerlist = userdao.fetchUserData1();
			registerlist1 = userdao.fetchRight();
			//registerlist2 = userdao.fetchRight();

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
	
	 public void enabledisableButton(){
		 //System.out.println("shs"+registerlist.size());
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
				JOptionPane.showMessageDialog(this, "No role right updation pending");
				//return;
				frame.setVisible(false);
				 //throw new Exception("IndexOutOfBoundException");
			}
			if(index<registerlist.size()){
				//System.out.println("enters printdata iff");
				//selectYourOption();
				selectUserRole();
			
			RegisterDto registerdto ;
			registerdto = registerlist.get(index);
//			System.out.println(index);
//			System.out.println(registerdto.getUserName());
			userlabel.setText(registerdto.getUserName());
			emailLabel.setText(registerdto.getEmailid());
			usertypelabel.setText(registerdto.getSelectUserType());
			enabledisableButton();
			}
			
		}
	 
//	 ArrayList<RightDto> rights = new ArrayList<>();
//	 public void fetchRight(int index){
////		UserDao userdao = new UserDao();
////		
////			 //registerlist1 = userdao.fetchRight();
////		    String a =  registerlist.get(index).getSelectUserType();
////		    System.out.println("inside fetchright "+a);
////			ArrayList<Object> rightidlist  ;
////			 rightidlist = this.registerlist1.get(index).getRightid();
////			 for(int i=0;i<rightidlist.size();i++){
////			 System.out.println("inside fetchright "+rightidlist.get(i));
////			 }
////	
//		 
//		                int id[] =  registerlist1.getRightid();
//		                
//	 }
	 
	 public void fetchRole(int index) {
		 
		if(radioButton.isSelected()) {
			roleid = "Admin";
		}else if(radioButton_1.isSelected()) {
			roleid="Teacher";
		}else if(radioButton_1.isSelected()) {
			roleid="Student";
		}
		System.out.println( " role id " + roleid);
	    this.registerlist.get(index).setRoleid(roleid);
	    System.out.println( "he role id sent " + this.registerlist.get(index).getRoleid());
	    roleid=" " ;
	 }
	 
	 
	 public void selectUserRole() {
			if(this.registerlist.get(index).getSelectUserType()!=null) {
				roleid = this.registerlist.get(index).getSelectUserType();
				System.out.println(roleid);
				if(roleid.equals("Admin")) {
					radioButton.setSelected(true);
				}else if(roleid.equals("Teacher")) {
					radioButton_1.setSelected(true);
				}else if(roleid.equals("Student")) {
					radioButton_2.setSelected(true);
				}
			}else {
					bg.clearSelection();
				}
			}
	 
	 public void fetchNextScreen() throws Exception {
			UserDao userdao=new UserDao();
			 fetchRole(index);
			 
			   
			try {
				userdao.updateRoleAndRights(registerlist , registerlist1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	
	public RoleRightView() throws Exception  {
		loadUserData();
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		printData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblRoleRrght.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoleRrght.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRoleRrght.setBounds(180, 22, 131, 24);
		contentPane.add(lblRoleRrght);
		
		
		lblEmail.setBounds(47, 98, 46, 14);
		contentPane.add(lblEmail);
		
		
		emailLabel.setBounds(213, 98, 158, 14);
		contentPane.add(emailLabel);
		
		
		usertypelabel.setBounds(241, 150, 118, 14);
		contentPane.add(usertypelabel);
		
		
		lblUsertype.setBounds(35, 150, 46, 14);
		contentPane.add(lblUsertype);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index == registerlist.size()-1) {
					try {
						fetchNextScreen();
						JOptionPane.showMessageDialog(btnSubmit, "successful");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						JOptionPane.showMessageDialog(btnSubmit, "please fill in the details for all the users");
					}
				}
			});
			
		
		
		
		btnSubmit.setBounds(41, 364, 89, 23);
		contentPane.add(btnSubmit);
		
		
		btnBack.setBounds(345, 364, 89, 23);
		contentPane.add(btnBack);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(index==0) {
					   fetchRole(0);
					 //  fetchRight(0);
					   index=index+1;
				   }else {
					fetchRole(index);System.out.println("Role index next "+ index);
				
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
		
		
		btnNext.setBounds(35, 298, 89, 23);
		contentPane.add(btnNext);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchRole(index);
				System.out.println("Role index previous " + index);
			
				System.out.println("Rigt index previous " + index);
				index=index+-1;
				try {
					printData();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		btnPrevious.setBounds(331, 298, 89, 23);
		contentPane.add(btnPrevious);
		
		
		radioButton.setBounds(35, 207, 73, 23);
		contentPane.add(radioButton);
		
		
		radioButton_1.setBounds(172, 207, 73, 23);
		contentPane.add(radioButton_1);
		
		
		radioButton_2.setBounds(328, 207, 73, 23);
		contentPane.add(radioButton_2);
		
		
		lblName.setBounds(35, 62, 46, 14);
		contentPane.add(lblName);
		
		
		userlabel.setBounds(241, 62, 130, 14);
		contentPane.add(userlabel);
	}
}
