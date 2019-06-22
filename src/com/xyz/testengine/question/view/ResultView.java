package com.xyz.testengine.question.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.xyz.testengine.question.dto.MyResultTableModel;
import com.xyz.testengine.question.dto.QuestionDto;
import com.xyz.testengine.user.view.LoginView;

public class ResultView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ResultView frame = new ResultView( );
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	
//	}
	/**
	 * Create the frame.
	 */
	public ResultView(ArrayList<QuestionDto> questions, int finalScore) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Dialog", Font.BOLD, 16));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(198, 24, 121, 21);
		contentPane.add(lblResult);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 557, 350);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(12, 400, 413, 255);
		//contentPane.add(table);
		table.setModel(new MyResultTableModel(questions));
	//	table.setBounds(20, 66, 531, 328);
		scrollPane.setViewportView(table);
	
		
		JLabel lblScoreIs = new JLabel("Score is "+finalScore);
		lblScoreIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreIs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblScoreIs.setBounds(43, 428, 121, 14);
		contentPane.add(lblScoreIs);
		
		
		
		
	}
	
}
