/*Programmer: Alex Curreri, Alex Lemaire and Sravan Reddy
Date: 03/19/2014
Filename: AddressBook.java
Purpose: address book GUI, has buttons to view, add and remove contacts
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class AddressBook extends JFrame{
	private ArrayList<String> fnames = new ArrayList<String>(); //array list of first names (used to label buttons)
	private	ArrayList<String> lnames = new ArrayList<String>(); //array list of last names (used to label buttons)
	private JTextField tsearch; //search function text field
	private JLabel lcontacts;
	private JButton bdone;
	private JButton badd; //button to add contacts
	public String save = "";
	public String current = ""; //used to view the state of the GUI
	

	private JPanel j1 = new JPanel();	//JPanels to organize the gui
	private JPanel j2= new JPanel();
	private JPanel j3= new JPanel();

	thehandler handler = new thehandler(); //event handler for the buttons
	dashandler dhandler = new dashandler();


	public AddressBook(){ //GUI constructor
		super("Address Book");
		setLayout(new FlowLayout(FlowLayout.CENTER));

		badd = new JButton("        New Contact        ");
		j1.add(badd);
		bdone = new JButton("        Finished        ");
		j1.add(bdone);
		add(j1);

		tsearch = new JTextField("Search", 30);
		tsearch.setHorizontalAlignment(JTextField.CENTER);
		j2.add(tsearch);
		add(j2);

		lcontacts = new JLabel("                                            Contacts                                            ");
		j3.add(lcontacts);
		add(j3);
		

		bdone.addActionListener(handler);
		tsearch.addActionListener(dhandler);
		badd.addActionListener(handler);
	}

	public void setfnames(int q, String s){ //adding to the array list of first names
		fnames.add(q, s);
	}

	public void setlnames(int q, String s){ //adding to the array list of last names
		lnames.add(q, s);
	}

	public void anotherbutton2(String r, String t){
		JButton dcontact = new JButton(r + " " + t);
		add(dcontact);
		dcontact.addActionListener(handler);
		
	}

	public void anotherbutton(int q, String r, String t){ //creates buttons while the program is running
		JButton[] ccontact = new JButton[q];              //labels the buttons with first and last names
		ccontact[q-1] = new JButton(r + " " + t);
		add(ccontact[q-1]);
		ccontact[q-1].addActionListener(handler);
		
	}

	public void setbuttons(int w){ //creates buttons when the program is first opened
		JButton[] bcontact = new JButton[w];//labels the buttons with first and last names
		for (int q = 0; q<w;q++ ) {
			bcontact[q] = new JButton(fnames.get(q) + " " + lnames.get(q));
			add(bcontact[q]);
			bcontact[q].addActionListener(handler);
			
		}
	}

	private class dashandler implements ActionListener{ //handles when a button is clicked

		public void actionPerformed(ActionEvent event){
			current = event.getActionCommand();
		}
	}

	private class thehandler implements ActionListener{ //handles when a button is clicked

		public void actionPerformed(ActionEvent event){
			current = event.getActionCommand();
			save = event.getActionCommand();
		}
	}
}
