/*Programmer: Alex Curreri, Alex Lemaire and Sravan Reddy
Date: 03/19/2014
Filename: NewContact.java
Purpose: allows the user to create a new contact, adds the contact object to the array list
*/


import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;


class NewContact extends JFrame{

	private JPanel j1 = new JPanel();	//JPanels to organize the gui
	private JPanel j2= new JPanel();
	private JPanel j3= new JPanel();
	private JPanel j4= new JPanel();
	private JPanel j5= new JPanel();
	private JPanel j6= new JPanel();
	private JPanel j7= new JPanel();
	private JPanel j8= new JPanel();
	private JPanel j9= new JPanel();

	public String checker = ""; // way to check status of GUI

	private JTextField tfirstname; // first name text field
	private JTextField tlastname; // last name text field
	private JTextField taddress; // address text field
	private JTextField tcity; // city text field
	private JTextField tzip; // zip code text field
	private JTextField temail; // email text field
	private JTextField thome; // home phone number text field
	private JTextField tmobile; // mobile phone number text field

	private JLabel ltitle;
	private JLabel lfirstname; //labesl each of the text boxes with the corrisponding title
	private JLabel llastname;
	private JLabel laddress;
	private JLabel lcity;
	private JLabel lzip;
	private JLabel lstate;
	private JLabel lemail;
	private JLabel lhome;
	private JLabel lmobile;

	private JButton bdone; // done button that

	private JComboBox cstate; // allows the user to enter state with a drop down menu
	private JComboBox ctitle; 

	public String str0 = ""; //strings utilized to read and take in the infromation from the GUI
	public String str1 = "";
	public String str2 = "";
	public String str3 = "";
	public String str4 = "";
	public String str5 = "";
	public String str6 = "";
	public String str7 = "";
	public String str8 = "";
	public String str9 = "";

	private static String[] title = {"Mr.", "Mrs.", "Miss.", "Dr."}; //string arrays used to populate the drop down menu
	private static String[] state = {"AK","AL","AR","AZ","CA","CO","CT","DE","FL","GA","HI","IA","ID","IL","IN","KS","KY","LA","MA","MD","ME","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VA","VT","WA","WI","WV","WY"};

	public NewContact(){
		super("New Contact"); //construct that titles the GUI
		setLayout(new FlowLayout(FlowLayout.CENTER)); //sets the layout for the GUI and centers it

		ltitle = new JLabel("Title ");
		j1.add(ltitle);
		ctitle = new JComboBox(title); //adds drop down menu to the GUI
		j1.add(ctitle);
		add(j1);

		lfirstname = new JLabel("First Name "); //sets the the label equal to a string so that the correct labels will be printed next to the text field
		j2.add(lfirstname); //adds label to the GUI
		tfirstname = new JTextField(15); //limits the length of the string that can be entered into the text field
		j2.add(tfirstname); //adds text field to the GUI
		add(j2);

		llastname = new JLabel("Last Name ");
		j3.add(llastname);
		tlastname = new JTextField(15);
		j3.add(tlastname);
		add(j3);

		laddress = new JLabel("Address ");
		j4.add(laddress);
		taddress = new JTextField(20);
		j4.add(taddress);
		add(j4);

		lcity = new JLabel("City ");
		j5.add(lcity);
		tcity = new JTextField(12);
		j5.add(tcity);

		lstate = new JLabel("State ");
		j5.add(lstate);
		cstate = new JComboBox(state);
		j5.add(cstate);

		lzip = new JLabel("Zip ");
		j5.add(lzip);
		tzip = new JTextField(5);
		j5.add(tzip);
		add(j5);

		lemail = new JLabel("Email ");
		j6.add(lemail);
		temail = new JTextField(20);
		j6.add(temail);
		add(j6);

		lhome = new JLabel("Home ");
		j7.add(lhome);
		thome = new JTextField(17);
		j7.add(thome);
		add(j7);

		lmobile = new JLabel("Cell ");
		j8.add(lmobile);
		tmobile = new JTextField(17);
		j8.add(tmobile);
		add(j8);

		bdone = new JButton("                         Done                         ");
		j9.add(bdone);
		add(j9);

		thehandler handler = new thehandler();
		bdone.addActionListener(handler);
	}

	public NewContact( String tit, String fn, String ln, String ad, String cit, String st, String zc, String em, String hm, String cl){
		super("New Contact"); //construct that titles the GUI
		setLayout(new FlowLayout(FlowLayout.CENTER)); //sets the layout for the GUI and centers it
		int t = 0;
		int y = 0;
		for (int e = 0; e<title.length; e++) {
			if (title[e].equals (tit)) {
				t = e;
			}
		}
		for (int e = 0;e<state.length ;e++ ) {
			if (state[e].equals (st)) {
				y = e;
			}
		}


		ltitle = new JLabel("Title ");
		j1.add(ltitle);
		ctitle = new JComboBox(title);
		ctitle.setSelectedItem(tit); //adds drop down menu to the GUI
		j1.add(ctitle);
		add(j1);

		lfirstname = new JLabel("First Name "); //sets the the label equal to a string so that the correct labels will be printed next to the text field
		j2.add(lfirstname); //adds label to the GUI
		tfirstname = new JTextField(fn, 15); //limits the length of the string that can be entered into the text field
		j2.add(tfirstname); //adds text field to the GUI
		add(j2);

		llastname = new JLabel("Last Name ");
		j3.add(llastname);
		tlastname = new JTextField(ln,15);
		j3.add(tlastname);
		add(j3);

		laddress = new JLabel("Address ");
		j4.add(laddress);
		taddress = new JTextField(ad,20);
		j4.add(taddress);
		add(j4);

		lcity = new JLabel("City ");
		j5.add(lcity);
		tcity = new JTextField(cit, 12);
		j5.add(tcity);

		lstate = new JLabel("State ");
		j5.add(lstate);
		cstate = new JComboBox(state );
		cstate.setSelectedItem(st);
		j5.add(cstate);

		lzip = new JLabel("Zip ");
		j5.add(lzip);
		tzip = new JTextField(zc, 5);
		j5.add(tzip);
		add(j5);

		lemail = new JLabel("Email ");
		j6.add(lemail);
		temail = new JTextField(em, 20);
		j6.add(temail);
		add(j6);

		lhome = new JLabel("Home ");
		j7.add(lhome);
		thome = new JTextField(hm,17);
		j7.add(thome);
		add(j7);

		lmobile = new JLabel("Cell ");
		j8.add(lmobile);
		tmobile = new JTextField(cl,17);
		j8.add(tmobile);
		add(j8);

		bdone = new JButton("                         Done                         ");
		j9.add(bdone);
		add(j9);

		thehandler handler = new thehandler();
		bdone.addActionListener(handler);
	}

	private class thehandler implements ActionListener{ //returns new values from user input and stores them in strings

		public void actionPerformed(ActionEvent event){
			String tostring = "";
			str0 = (String)ctitle.getSelectedItem();
			str1 = (String)tfirstname.getText();
			str2 = (String)tlastname.getText();
			str3 = (String)taddress.getText();
			str4 = (String)tcity.getText();
			str5 = (String)tzip.getText();
			str6 = (String)cstate.getSelectedItem();
			str7 = (String)temail.getText();
			str8 = (String)thome.getText();
			str9 = (String)tmobile.getText();
			tostring = str0 +" "+ str1 +" "+ str2 +" "+ str3 +" "+ str4 +" "+ str5 +" "+ str6 +" "+str7 +" "+ str8 +" "+ str9;
			//JOptionPane.showMessageDialog(null, tostring);
			checker = "done";
		}
	}
}