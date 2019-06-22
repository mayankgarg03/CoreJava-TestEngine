package com.xyz.testengine.user.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.xyz.testengine.user.dao.UserDao;
import com.xyz.testengine.user.dto.LoginDto;
import com.xyz.testengine.user.dto.RegisterDto;
import com.xyz.testengine.util.constants.PathConstants;

public class LoginView extends JFrame implements PathConstants {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void loadRegister(){
//		this.setVisible(false);
//		this.dispose();
		RegisterView registerview = new RegisterView();
		registerview.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
//	private void register() {
//		String username = textField.getText();
//		String password = new String(passwordField.getPassword());
//		RegisterDto registerdto = new RegisterDto();
//		registerdto.setUsername(username);
//		registerdto.setPassword(password);
//		
//		
//		UserDao userdao = new UserDao();
//		try{
//			
//		String message = userdao.doRegister(registerdto);
//		JOptionPane.showMessageDialog(this, message);
//		}	
//		catch(ClassNotFoundException e){
//            JOptionPane.showMessageDialog(this, "Contact to system admin some database problem occur");
//            e.printStackTrace();
//}
//           catch(SQLException e){
//                    JOptionPane.showMessageDialog(this, "might be some problem in database credentials contact database admin");
//                    e.printStackTrace();
//}
//            catch(Exception e){
//                    JOptionPane.showMessageDialog(this,"some serious problem occur contact to admin team");
//                     e.printStackTrace();
//}	
//	}
	private void checkLogin() {
		String username = textField.getText();
		String password = new String( passwordField.getPassword());
		System.out.println(username+" "+password);
		LoginDto logindto = new LoginDto();
		logindto.setUserName(username);
		logindto.setPassword(password);
		UserDao userdao = new UserDao();
		try{
		//String message = userdao.doLogin(logindto);
			RegisterDto registerdto = userdao.doLogin(logindto);
			if(registerdto==null){
			JOptionPane.showMessageDialog(this,"invalid username or password");
			return;
		}
		//call dashboard
		
		
		DashBoardView dashboard = new DashBoardView();
		dashboard.fillDashBoard( registerdto );
		dashboard.setVisible(true);
		dashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(false);
		this.dispose();
		}
		
		catch(ClassNotFoundException e){
			             JOptionPane.showMessageDialog(this, "Contact to system admin some database problem occur");
			             e.printStackTrace();
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(this, "might be some problem in database credentials contact database admin");
			e.printStackTrace();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this,"some serious problem occur contact to admin team");
			e.printStackTrace();
		}
	}
	private void reset(){
		  textField.setText(" ");
		  passwordField.setText(" ");
	}
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("my login");
		
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 80, 113, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(27, 133, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(176, 74, 181, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLoginregistration = new JLabel("Login");
		lblLoginregistration.setForeground(Color.BLUE);
		lblLoginregistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoginregistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginregistration.setBounds(112, 11, 214, 41);
		contentPane.add(lblLoginregistration);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 127, 181, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource(LOGIN_IMAGE)));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			checkLogin();			
			reset();
			}
		});
		btnNewButton.setBounds(125, 186, 129, 29);
		contentPane.add(btnNewButton);
		
//		JButton btnReset = new JButton("RESET");
//		btnReset.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				reset();
//			}
//		});
//		btnReset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
//		btnReset.setBounds(291, 186, 89, 29);
//		contentPane.add(btnReset);
//	

		
		JButton btnRegistration = new JButton("Register");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadRegister();
				reset();
			}
		});
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistration.setBounds(291, 186, 89, 29);
		contentPane.add(btnRegistration);
	}
}

