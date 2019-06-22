package com.xyz.testengine.user.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.xyz.testengine.user.dao.UserDao;
import com.xyz.testengine.user.dto.RegisterDto;
import com.xyz.testengine.util.Authentication;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JPasswordField confirmpasswordField;
	private JTextField emailField;
	private JTextField phoneField;
	JDateChooser dateChooser;
	JComboBox cityCombo;
	JComboBox collegeCombo;
	JComboBox typeCombo ;
	JComboBox streamCombo ;
	JLabel passStrength;
	JLabel passMatch;
	JLabel emailForm;

	/**
	 * Launch the application.
	 */
	static RegisterView frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new RegisterView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Authentication auth = new Authentication();
	public String isChar;
	public String isPass;
	public String confirmPass;
	public String isEmail;
	public String isPhone;
	
	public String gender;
	private JTextField rollField;
	
	public   void  goBackLogin() {
		this.setVisible(false);
		this.dispose();
		LoginView loginWindow=new LoginView();
		loginWindow.setVisible(true);
		
	}
	
	
	
	private void register() {
		String username = userField.getText();
		String password = new String(passwordField.getPassword());
		String confpwd = new String(confirmpasswordField.getPassword());
		String email = emailField.getText();
		String phone  = phoneField.getText();
		Date date = dateChooser.getDate();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(date);
		String city = cityCombo.getSelectedItem().toString();
		String college = collegeCombo.getSelectedItem().toString();
		String stream = streamCombo.getSelectedItem().toString();
		String userType = typeCombo.getSelectedItem().toString();
		String rollno = rollField.getText();
		//System.out.println(username +" "+password+" "+confpwd+" "+ gender+" "+email+" "+phone+" "+strDate+" "+city+" "+college+" "+stream+" "+userType);
		RegisterDto registerdto = new RegisterDto();
		registerdto.setUserName(username);
		registerdto.setPassword(password);
		registerdto.setConfirmPassword(confpwd);
		registerdto.setEmailid(email);
		registerdto.setPhoneNo(phone);
		registerdto.setDateofbirth(strDate);
		registerdto.setGender(gender);
		registerdto.setSelectCity(city);
		registerdto.setSelectCollege(college);
		registerdto.setSelectStream(stream);
		registerdto.setSelectUserType(userType);
		registerdto.setRollno(rollno);
		
		UserDao userdao = new UserDao();
		try{
			String msg = userdao.checkIfPresent(registerdto);
			JOptionPane.showMessageDialog(this, msg);
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
//}	
		
//		RegisterDto registerdto = new RegisterDto();
//		registerdto.setUsername(username);
//		registerdto.setPassword(password);
		
		
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
	

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisteration = new JLabel("REGISTERATION");
		lblRegisteration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegisteration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisteration.setBounds(337, 11, 164, 26);
		contentPane.add(lblRegisteration);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 102, 94, 14);
		contentPane.add(lblUsername);
		
		
		userField = new JTextField();
		userField.setBounds(153, 99, 120, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		userField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				 isChar = auth.checksChar(userField.getText());
				if(isChar == "incorrect"){
					JOptionPane.showMessageDialog(frame, "please enter only characters");
//					userField.setToolTipText("Please enter only characters");
				}
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
		});
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(20, 146, 62, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 144, 120, 17);
		contentPane.add(passwordField);
		
		
//		passwordField.addMouseListener(new MouseListener(){
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				passStrength.setText(" ");
//				
//			}
//			
//		});
//		public void mouseExited(MouseEvent e){
//			
//		}
		passwordField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
			isPass = auth.checkPassword( String.valueOf(passwordField.getPassword()).trim());
			if(isPass == "Weak"){
				passStrength.setText(isPass);
				passStrength.setForeground(Color.RED);
			}
			else if(isPass == "Medium"){
				passStrength.setText(isPass);
				passStrength.setForeground(Color.GREEN);
			}
			else if(isPass == "Strong"){
				passStrength.setText(isPass);
				passStrength.setForeground(Color.BLUE);
			}
			else if(isPass == null){
				passStrength.setText(" ");
			}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
		});
		
		
		JLabel lblconfirmPassword = new JLabel("confirmPassword");
		lblconfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblconfirmPassword.setBounds(10, 224, 123, 14);
		contentPane.add(lblconfirmPassword);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(153, 222, 120, 17);
		contentPane.add(confirmpasswordField);
		confirmpasswordField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				String initial =  String.valueOf(passwordField.getPassword()).trim();
				String confirm =  String.valueOf(confirmpasswordField.getPassword()).trim();
				
				if((initial.length()<confirm.length()) || initial.length()>confirm.length()){
					 passMatch.setText("Password doesn't Match");
				}
				else if(initial.length() == confirm.length()){
					confirmPass = auth.passwordMatch(initial, confirm);
					
					if(confirmPass == "true"){
				            passMatch.setText("Password match");		
					}
					else if(confirmPass == "false"){
					              passMatch.setText("password doesn't match! please enter again");	
					}
					else if(confirm.length() == 0){
						passMatch.setText(" ");
						
					}
				}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblEmailid = new JLabel("EmailID");
		lblEmailid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailid.setBounds(36, 298, 46, 14);
		contentPane.add(lblEmailid);
		
		emailField = new JTextField();
		emailField.setBounds(153, 295, 120, 20);
		contentPane.add(emailField);
		emailField.setToolTipText("The format of email id has to be xyz123!@abcd.com ");
		emailField.setColumns(10);
		emailField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
			isEmail = auth.checksEmail(emailField.getText());
			if(isEmail == "correct"){
				emailForm.setText("Entered email is correct");
				emailForm.setForeground(Color.BLUE);
			}
			else if(isEmail == "incorrect"){
			emailForm.setText("Entered email is not correct");
			emailForm.setForeground(Color.RED);
			}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(36, 359, 46, 14);
		contentPane.add(lblPhoneNo);
		
		phoneField = new JTextField();
		phoneField.setBounds(153, 356, 120, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		phoneField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				isPhone = auth.checksPhone(phoneField.getText());
				if(isPhone == "correct"){
					
				}
				else if(isPhone == "Incorrect"){
					JOptionPane.showMessageDialog(frame,"please type correct phone no with 10 digits" );
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(36, 399, 46, 14);
		contentPane.add(lblGender);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(152, 395, 62, 23);
		contentPane.add(rdbtnMale);
		bg.add(rdbtnMale);
		rdbtnMale.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gender = rdbtnMale.getText();
			}
			
		});
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(216, 395, 94, 23);
		contentPane.add(rdbtnFemale);
		bg.add(rdbtnFemale);
		 rdbtnFemale .addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gender =  rdbtnFemale.getText();
				
			}
			 
		 });
		
		JLabel lblSelectCity = new JLabel("Select City");
		lblSelectCity.setBounds(405, 102, 62, 14);
		contentPane.add(lblSelectCity);
		
		JLabel lblSelectCollege = new JLabel("Select College");
		lblSelectCollege.setBounds(405, 162, 82, 14);
		contentPane.add(lblSelectCollege);
		
		JLabel lblSelectStream = new JLabel("Select Stream");
		lblSelectStream.setBounds(405, 211, 82, 14);
		contentPane.add(lblSelectStream);
		
		 cityCombo = new JComboBox();
		cityCombo.setModel(new DefaultComboBoxModel(new String[] {"Adilabad", "Agra", "Ahmedabad", "Ahmednagar", "Aizawl", "Ajitgarh (Mohali)", "Ajmer", "Akola", "Alappuzha", "Aligarh", "Alirajpur", "Allahabad", "Almora", "Alwar", "Ambala", "Ambedkar Nagar", "Amravati", "Amreli district", "Amritsar", "Anand", "Anantapur", "Anantnag", "Angul", "Anjaw", "Anuppur", "Araria", "Ariyalur", "Arwal", "Ashok Nagar", "Auraiya", "Aurangabad", "Aurangabad", "Azamgarh", "Badgam", "Bagalkot", "Bageshwar", "Bagpat", "Bahraich", "Baksa", "Balaghat", "Balangir", "Balasore", "Ballia", "Balrampur", "Banaskantha", "Banda", "Bandipora", "Bangalore Rural", "Bangalore Urban", "Banka", "Bankura", "Banswara", "Barabanki", "Baramulla", "Baran", "Bardhaman", "Bareilly", "Bargarh (Baragarh)", "Barmer", "Barnala", "Barpeta", "Barwani", "Bastar", "Basti", "Bathinda", "Beed", "Begusarai", "Belgaum", "Bellary", "Betul", "Bhadrak", "Bhagalpur", "Bhandara", "Bharatpur", "Bharuch", "Bhavnagar", "Bhilwara", "Bhind", "Bhiwani", "Bhojpur", "Bhopal", "Bidar", "Bijapur", "Bijapur", "Bijnor", "Bikaner", "Bilaspur", "Bilaspur", "Birbhum", "Bishnupur", "Bokaro", "Bongaigaon", "Boudh (Bauda)", "Budaun", "Bulandshahr", "Buldhana", "Bundi", "Burhanpur", "Buxar", "Cachar", "Central Delhi", "Chamarajnagar", "Chamba", "Chamoli", "Champawat", "Champhai", "Chandauli", "Chandel", "Chandigarh", "Chandrapur", "Changlang", "Chatra", "Chennai", "Chhatarpur", "Chhatrapati Shahuji Maharaj Nagar", "Chhindwara", "Chikkaballapur", "Chikkamagaluru", "Chirang", "Chitradurga", "Chitrakoot", "Chittoor", "Chittorgarh", "Churachandpur", "Churu", "Coimbatore", "Cooch Behar", "Cuddalore", "Cuttack", "Dadra and Nagar Haveli", "Dahod", "Dakshin Dinajpur", "Dakshina Kannada", "Daman", "Damoh", "Dantewada", "Darbhanga", "Darjeeling", "Darrang", "Datia", "Dausa", "Davanagere", "Debagarh (Deogarh)", "Dehradun", "Deoghar", "Deoria", "Dewas", "Dhalai", "Dhamtari", "Dhanbad", "Dhar", "Dharmapuri", "Dharwad", "Dhemaji", "Dhenkanal", "Dholpur", "Dhubri", "Dhule", "Dibang Valley", "Dibrugarh", "Dima Hasao", "Dimapur", "Dindigul", "Dindori", "Diu", "Doda", "Dumka", "Dungapur", "Durg", "East Champaran", "East Delhi", "East Garo Hills", "East Khasi Hills", "East Siang", "East Sikkim", "East Singhbhum", "Eluru", "Ernakulam", "Erode", "Etah", "Etawah", "Faizabad", "Faridabad", "Faridkot", "Farrukhabad", "Fatehabad", "Fatehgarh Sahib", "Fatehpur", "Fazilka", "Firozabad", "Firozpur", "Gadag", "Gadchiroli", "Gajapati", "Ganderbal", "Gandhinagar", "Ganganagar", "Ganjam", "Garhwa", "Gautam Buddh Nagar", "Gaya", "Ghaziabad", "Ghazipur", "Giridih", "Goalpara", "Godda", "Golaghat", "Gonda", "Gondia", "Gopalganj", "Gorakhpur", "Gulbarga", "Gumla", "Guna", "Guntur", "Gurdaspur", "Gurgaon", "Gwalior", "Hailakandi", "Hamirpur", "Hamirpur", "Hanumangarh", "Harda", "Hardoi", "Haridwar", "Hassan", "Haveri district", "Hazaribag", "Hingoli", "Hissar", "Hooghly", "Hoshangabad", "Hoshiarpur", "Howrah", "Hyderabad", "Hyderabad", "Idukki", "Imphal East", "Imphal West", "Indore", "Jabalpur", "Jagatsinghpur", "Jaintia Hills", "Jaipur", "Jaisalmer", "Jajpur", "Jalandhar", "Jalaun", "Jalgaon", "Jalna", "Jalore", "Jalpaiguri", "Jammu", "Jamnagar", "Jamtara", "Jamui", "Janjgir-Champa", "Jashpur", "Jaunpur district", "Jehanabad", "Jhabua", "Jhajjar", "Jhalawar", "Jhansi", "Jharsuguda", "Jhunjhunu", "Jind", "Jodhpur", "Jorhat", "Junagadh", "Jyotiba Phule Nagar", "Kabirdham (formerly Kawardha)", "Kadapa", "Kaimur", "Kaithal", "Kakinada", "Kalahandi", "Kamrup", "Kamrup Metropolitan", "Kanchipuram", "Kandhamal", "Kangra", "Kanker", "Kannauj", "Kannur", "Kanpur", "Kanshi Ram Nagar", "Kanyakumari", "Kapurthala", "Karaikal", "Karauli", "Karbi Anglong", "Kargil", "Karimganj", "Karimnagar", "Karnal", "Karur", "Kasaragod", "Kathua", "Katihar", "Katni", "Kaushambi", "Kendrapara", "Kendujhar (Keonjhar)", "Khagaria", "Khammam", "Khandwa (East Nimar)", "Khargone (West Nimar)", "Kheda", "Khordha", "Khowai", "Khunti", "Kinnaur", "Kishanganj", "Kishtwar", "Kodagu", "Koderma", "Kohima", "Kokrajhar", "Kolar", "Kolasib", "Kolhapur", "Kolkata", "Kollam", "Koppal", "Koraput", "Korba", "Koriya", "Kota", "Kottayam", "Kozhikode", "Krishna", "Kulgam", "Kullu", "Kupwara", "Kurnool", "Kurukshetra", "Kurung Kumey", "Kushinagar", "Kutch", "Lahaul and Spiti", "Lakhimpur", "Lakhimpur Kheri", "Lakhisarai", "Lalitpur", "Latehar", "Latur", "Lawngtlai", "Leh", "Lohardaga", "Lohit", "Lower Dibang Valley", "Lower Subansiri", "Lucknow", "Ludhiana", "Lunglei", "Madhepura", "Madhubani", "Madurai", "Mahamaya Nagar", "Maharajganj", "Mahasamund", "Mahbubnagar", "Mahe", "Mahendragarh", "Mahoba", "Mainpuri", "Malappuram", "Maldah", "Malkangiri", "Mamit", "Mandi", "Mandla", "Mandsaur", "Mandya", "Mansa", "Marigaon", "Mathura", "Mau", "Mayurbhanj", "Medak", "Meerut", "Mehsana", "Mewat", "Mirzapur", "Moga", "Mokokchung", "Mon", "Moradabad", "Morena", "Mumbai City", "Mumbai suburban", "Munger", "Murshidabad", "Muzaffarnagar", "Muzaffarpur", "Mysore", "Nabarangpur", "Nadia", "Nagaon", "Nagapattinam", "Nagaur", "Nagpur", "Nainital", "Nalanda", "Nalbari", "Nalgonda", "Namakkal", "Nanded", "Nandurbar", "Narayanpur", "Narmada", "Narsinghpur", "Nashik", "Navsari", "Nawada", "Nawanshahr", "Nayagarh", "Neemuch", "Nellore", "New Delhi", "Nilgiris", "Nizamabad", "North 24 Parganas", "North Delhi", "North East Delhi", "North Goa", "North Sikkim", "North Tripura", "North West Delhi", "Nuapada", "Ongole", "Osmanabad", "Pakur", "Palakkad", "Palamu", "Pali", "Palwal", "Panchkula", "Panchmahal", "Panchsheel Nagar district (Hapur)", "Panipat", "Panna", "Papum Pare", "Parbhani", "Paschim Medinipur", "Patan", "Pathanamthitta", "Pathankot", "Patiala", "Patna", "Pauri Garhwal", "Perambalur", "Phek", "Pilibhit", "Pithoragarh", "Pondicherry", "Poonch", "Porbandar", "Pratapgarh", "Pratapgarh", "Pudukkottai", "Pulwama", "Pune", "Purba Medinipur", "Puri", "Purnia", "Purulia", "Raebareli", "Raichur", "Raigad", "Raigarh", "Raipur", "Raisen", "Rajauri", "Rajgarh", "Rajkot", "Rajnandgaon", "Rajsamand", "Ramabai Nagar (Kanpur Dehat)", "Ramanagara", "Ramanathapuram", "Ramban", "Ramgarh", "Rampur", "Ranchi", "Ratlam", "Ratnagiri", "Rayagada", "Reasi", "Rewa", "Rewari", "Ri Bhoi", "Rohtak", "Rohtas", "Rudraprayag", "Rupnagar", "Sabarkantha", "Sagar", "Saharanpur", "Saharsa", "Sahibganj", "Saiha", "Salem", "Samastipur", "Samba", "Sambalpur", "Sangli", "Sangrur", "Sant Kabir Nagar", "Sant Ravidas Nagar", "Saran", "Satara", "Satna", "Sawai Madhopur", "Sehore", "Senapati", "Seoni", "Seraikela Kharsawan", "Serchhip", "Shahdol", "Shahjahanpur", "Shajapur", "Shamli", "Sheikhpura", "Sheohar", "Sheopur", "Shimla", "Shimoga", "Shivpuri", "Shopian", "Shravasti", "Sibsagar", "Siddharthnagar", "Sidhi", "Sikar", "Simdega", "Sindhudurg", "Singrauli", "Sirmaur", "Sirohi", "Sirsa", "Sitamarhi", "Sitapur", "Sivaganga", "Siwan", "Solan", "Solapur", "Sonbhadra", "Sonipat", "Sonitpur", "South 24 Parganas", "South Delhi", "South Garo Hills", "South Goa", "South Sikkim", "South Tripura", "South West Delhi", "Sri Muktsar Sahib", "Srikakulam", "Srinagar", "Subarnapur (Sonepur)", "Sultanpur", "Sundergarh", "Supaul", "Surat", "Surendranagar", "Surguja", "Tamenglong", "Tarn Taran", "Tawang", "Tehri Garhwal", "Thane", "Thanjavur", "The Dangs", "Theni", "Thiruvananthapuram", "Thoothukudi", "Thoubal", "Thrissur", "Tikamgarh", "Tinsukia", "Tirap", "Tiruchirappalli", "Tirunelveli", "Tirupur", "Tiruvallur", "Tiruvannamalai", "Tiruvarur", "Tonk", "Tuensang", "Tumkur", "Udaipur", "Udalguri", "Udham Singh Nagar", "Udhampur", "Udupi", "Ujjain", "Ukhrul", "Umaria", "Una", "Unnao", "Upper Siang", "Upper Subansiri", "Uttar Dinajpur", "Uttara Kannada", "Uttarkashi", "Vadodara", "Vaishali", "Valsad", "Varanasi", "Vellore", "Vidisha", "Viluppuram", "Virudhunagar", "Visakhapatnam", "Vizianagaram", "Vyara", "Warangal", "Wardha", "Washim", "Wayanad", "West Champaran", "West Delhi", "West Garo Hills", "West Kameng", "West Khasi Hills", "West Siang", "West Sikkim", "West Singhbhum", "West Tripura", "Wokha", "Yadgir", "Yamuna Nagar", "Yanam", "Yavatmal", "Zunheboto"}));
		cityCombo.setBounds(585, 99, 142, 20);
		contentPane.add(cityCombo);
		
		 collegeCombo = new JComboBox();
		collegeCombo.setModel(new DefaultComboBoxModel(new String[] {"Hindu College of Engineering sonipat", "Delhi Technology university(DTU)", "Netaji Subhas Institute of Technology(NSUT)", "IIT Delhi", "IIT Mumbai", "IIT Chennai", "bhagwan parshuram (BPIT)", "bharti vidyapeeth (BVCOE)"}));
		collegeCombo.setBounds(585, 159, 142, 20);
		contentPane.add(collegeCombo);
		
	    streamCombo = new JComboBox();
		streamCombo.setModel(new DefaultComboBoxModel(new String[] {"Computer Science Engineering(CSE)", "Electrical Engineering(EE)", "Electronics and Communication Engineering(ECE)", "Civil Engineering(CE)", "Mechanical Engineering(ME)"}));
		streamCombo.setBounds(585, 208, 142, 20);
		contentPane.add(streamCombo);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(405, 268, 82, 14);
		contentPane.add(lblDateOfBirth);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(585, 265, 142, 20);
		contentPane.add(dateChooser);
		
		JLabel lblUsertype = new JLabel("UserType");
		lblUsertype.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsertype.setBounds(405, 319, 46, 14);
		contentPane.add(lblUsertype);
		
		 typeCombo = new JComboBox();
		typeCombo.setModel(new DefaultComboBoxModel(new String[] {"Teacher", "Student", "Admin"}));
		typeCombo.setBounds(585, 316, 142, 20);
		contentPane.add(typeCombo);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			register();
			}
			
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(387, 421, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackLogin();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(635, 423, 89, 23);
		contentPane.add(btnBack);
		
		 passStrength = new JLabel("");
		passStrength.setBounds(62, 185, 152, 26);
		contentPane.add(passStrength);
		
		 passMatch = new JLabel("");
		passMatch.setBounds(50, 250, 164, 32);
		contentPane.add(passMatch);
		
	 emailForm = new JLabel("");
		emailForm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		emailForm.setBounds(62, 330, 152, 14);
		contentPane.add(emailForm);
		
		JLabel lblCollgerollno = new JLabel("collgeRollNo");
		lblCollgerollno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollgerollno.setBounds(369, 359, 120, 29);
		contentPane.add(lblCollgerollno);
		
		rollField = new JTextField();
		rollField.setBounds(585, 356, 142, 20);
		contentPane.add(rollField);
		rollField.setColumns(10);
	}
}
