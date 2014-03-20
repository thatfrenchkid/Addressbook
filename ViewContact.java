/*Programmer: Alex Curreri, Alex Lemaire and Sravan Reddy
Date: 03/19/2014
Filename: ViewContact.java
Purpose: allows the user to view previously entered contacts
*/


import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;


class ViewContact extends JFrame{
	public String checker = ""; //way to check status of the GUI
	public String remove = "yes";
	public String edit = "";

	private JPanel j1 = new JPanel();	//JPanels to organize the gui
	private JPanel j2= new JPanel();
	private JPanel j3= new JPanel();
	private JPanel j4= new JPanel();
	private JPanel j5= new JPanel();
	private JPanel j6= new JPanel();
	private JPanel j7= new JPanel();
	private JPanel j8= new JPanel();
	private JPanel j9= new JPanel();

	private JTextField tfirstname; // first name text field
	private JTextField tlastname; // last name text field
	private JTextField taddress; // address text field
	private JTextField tcity; // city text field
	private JTextField tzip; // zip code text field
	private JTextField temail; // email text field
	private JTextField thome; // home phone text field
	private JTextField tmobile; // mobile phone text field

	private JLabel ltitle;
	private JLabel lfirstname; //labesl each of the text boxes with the corrisponding title
	private JLabel llastname;
	private JLabel laddress;
	private JLabel lstate;
	private JLabel lcity;
	private JLabel lzip;
	private JLabel lemail;
	private JLabel lhome;
	private JLabel lmobile;

	private JButton bedit;
	private JButton bremove;
	private JButton bdone; // done button that

	private JComboBox cstate;// allows the user to enter state with a drop down menu
	private JComboBox ctitle; 

	private static String[] title = new String[1];
	private static String[] state = new String[1];

	public ViewContact(){
		
	}

	public ViewContact(String fname, String lname, String add,  String cit, String tit, String mail, String stat, String zipcode, String home, String mobile){
		super("Contact");
		setLayout(new FlowLayout(FlowLayout.CENTER));

		bedit = new JButton("        Edit Contact        ");
		j1.add(bedit);

		bremove = new JButton("        Delete Contact        ");
		j1.add(bremove);
		add(j1);

		title[0] =  "   " + tit + "   ";
		state[0] = "   " + stat + "   ";

		ltitle = new JLabel("Title ");
		j2.add(ltitle);
		ctitle = new JComboBox(title); //drop down menu is populated
		j2.add(ctitle); //adds drop down menu to the GUI
		ctitle.setEditable(false); //makes editing drop down false

		lfirstname = new JLabel("First Name "); //sets label for text field
		j2.add(lfirstname); //adds the label to the GUI
		tfirstname = new JTextField("   " + fname+ "   "); //populates the text field
		j2.add(tfirstname); //adds text field to the GUI
		tfirstname.setEditable(false); //makes editing text field false
		add(j2);

		llastname = new JLabel("Last Name ");
		j3.add(llastname);
		tlastname = new JTextField("   " + lname + "   ");
		j3.add(tlastname);
		tlastname.setEditable(false);
		add(j3);

		laddress = new JLabel("Address ");
		j5.add(laddress);
		taddress = new JTextField("   " + add + "   ");
		j5.add(taddress);
		taddress.setEditable(false);
		add(j5);

		lcity = new JLabel("City ");
		j4.add(lcity);
		tcity = new JTextField("   " + cit + "   ");
		j4.add(tcity);
		tcity.setEditable(false);

		lstate = new JLabel("State ");
		j4.add(lstate);
		cstate = new JComboBox(state);
		j4.add(cstate);
		cstate.setEditable(false);

		lzip = new JLabel("Zip ");
		j4.add(lzip);
		tzip = new JTextField("   " + zipcode + "   ");
		j4.add(tzip);
		tzip.setEditable(false);
		add(j4);

		lemail = new JLabel("Email ");
		j6.add(lemail);
		temail = new JTextField("   " + mail + "   ");
		j6.add(temail);
		temail.setEditable(false);
		add(j6);

		lhome = new JLabel("Home ");
		j7.add(lhome);
		thome = new JTextField("   " + home + "   ");
		j7.add(thome);
		thome.setEditable(false);
		add(j7);

		lmobile = new JLabel("Cell ");
		j8.add(lmobile);
		tmobile = new JTextField("   " + mobile+ "   ");
		j8.add(tmobile);
		tmobile.setEditable(false);
		add(j8);

		bdone = new JButton("                         Done                         ");
		j9.add(bdone);
		add(j9);

		thehandler handler = new thehandler();
		bdone.addActionListener(handler);
		bremove.addActionListener(handler);
		bedit.addActionListener(handler);
	}


	private class thehandler implements ActionListener{ //action listener that is used to check when the person is done viewing the contact

		public void actionPerformed(ActionEvent event){
			checker = event.getActionCommand();
			remove = event.getActionCommand();
			edit = event.getActionCommand();
		}
	}
}