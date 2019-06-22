package com.xyz.testengine.question.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xyz.testengine.question.dao.TestNameDao;
import com.xyz.testengine.question.helper.QuestionUploadHelper;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class QuestionUploaderView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionUploaderView frame = new QuestionUploaderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	
	TestNameDao testnamedao = new TestNameDao();
	private JTextField timeField;
	public int time = 0;
	
	public void uploadIt() throws ClassNotFoundException, SQLException{
		JFileChooser jfilechooser = new JFileChooser("C:\\Users\\mayank\\Documents");
		jfilechooser.showOpenDialog(this);
		File file = jfilechooser.getSelectedFile();
		System.out.println("path is "+file.getAbsolutePath());
		QuestionUploadHelper help = new QuestionUploadHelper();
		time =Integer.parseInt(timeField.getText());
		System.out.println("test time is: "+time);
		try {
			boolean isUploaded = help.read(file.getAbsolutePath() , time);
			
			JOptionPane.showMessageDialog(this,isUploaded?"upload done":"upload failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,"can't upload the file contact the system team");
			e.printStackTrace();
		}
	}
           public QuestionUploaderView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnUpload = new JButton("UPLOAD");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					uploadIt();
					//testnamedao.uploadTestId();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpload.setBounds(34, 47, 265, 23);
		contentPane.add(btnUpload);
		
		JLabel lblEnterTestTime = new JLabel("Enter test time minutes");
		lblEnterTestTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterTestTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTestTime.setBounds(27, 149, 140, 23);
		contentPane.add(lblEnterTestTime);
		
		timeField = new JTextField();
		timeField.setBounds(204, 151, 122, 20);
		contentPane.add(timeField);
		timeField.setColumns(10);
	}
}
