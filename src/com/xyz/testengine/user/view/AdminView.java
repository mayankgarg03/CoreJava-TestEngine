package com.xyz.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	 private static AdminView frame ;
		private static RoleRightView frame1;
		private static AuthenticationView frame2;
		
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void roleRights()  {
	
		
		
			try {
				frame1=new RoleRightView();
				frame1.setVisible(true);
		
		}catch(IndexOutOfBoundsException e) {
			AdminView.generateMsg(false);
		}
			catch(NullPointerException e){
				AdminView.generateMsg(false);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		


	}
	public static void authenticationOpen() {
		
		
		try {
			frame2=new AuthenticationView();
			frame2.setVisible(true);
		}
		catch(NullPointerException e){
			AdminView.generateMsg(false);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	this.dispose();
		
	}
	
	
	public static void generateMsg(boolean status) {
		if(status==false) {
			JOptionPane.showMessageDialog(frame,"No new Records for assigning role and rights  or authentication");
		}
	}
	public AdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdmin.setBounds(245, 11, 210, 37);
		contentPane.add(lblAdmin);
		
		JButton btnUserRoleRight = new JButton("User Role Right");
		btnUserRoleRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					roleRights();
			}
		});
		btnUserRoleRight.setBounds(81, 182, 230, 23);
		contentPane.add(btnUserRoleRight);
		
		JButton btnAuthentication = new JButton("Authentication");
		btnAuthentication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					authenticationOpen();
			}	
		});
		btnAuthentication.setBounds(368, 182, 210, 23);
		contentPane.add(btnAuthentication);
	}
}
