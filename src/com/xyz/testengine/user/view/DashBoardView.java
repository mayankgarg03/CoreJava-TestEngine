package com.xyz.testengine.user.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xyz.testengine.user.dto.RegisterDto;
import com.xyz.testengine.user.dto.RightDto;

public class DashBoardView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoardView frame = new DashBoardView();
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
	
	public void fillDashBoard(RegisterDto registerdto){
		if(registerdto!=null){
			lblNewLabel.setText("Welcome "+registerdto.getUserName()+" "+registerdto.getRolename());
         if(registerdto.getRights()!=null){
        	 for(RightDto rightdto : registerdto.getRights()){
        		 JMenuItem menuitem = new JMenuItem(rightdto.getName());
        		 menuitem.addActionListener(new ActionListener(){
        			
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("screenname "+rightdto.getScreenname());
						try{
						int lastindex = rightdto.getScreenname().lastIndexOf(".java");
						System.out.println("last index "+lastindex);
						String className = rightdto.getScreenname().substring(0,lastindex);
						System.out.println("class name "+className);                                    //REFLECTION.
						Object object = Class.forName(className).newInstance();
						Method method = object.getClass().getMethod("setVisible", boolean.class);
						method.invoke(object, true);
						}
						catch(Exception e1){
							System.out.println("reflection error "+e1);
							e1.printStackTrace();
						}
						}
        		 });
        		 file.add(menuitem);
        	 }
         }
		}
	}
	JLabel lblNewLabel = new JLabel("");
	JMenu file = new JMenu("File");
	public DashBoardView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		

		
        file.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(file);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setBounds(15, 44, 362, 56);
		contentPane.add(lblNewLabel);
	}
}
