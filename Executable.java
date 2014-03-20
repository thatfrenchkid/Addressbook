import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;
import java.io.*;

public class Executable{
	public static void main(String[] args) throws IOException{
		String FirstName, LastName, Address, City, State, Title, Email, HomePhone, MobilePhone, ZipCode;
		long iZipCode = 0l, iHomePhone = 0l, iMobilePhone = 0l;
		int InitialSize = 0;
		FileCreator f1 = new FileCreator();
		AddressBook book = new AddressBook();
		book.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		book.setSize(450, 450);
		book.setLocationRelativeTo(null);
		ArrayList<Contact> addressBook = new ArrayList<Contact>(); //Instantiate everything
		Scanner vReader = new Scanner(new File("contact.txt"));
		ViewContact[] view = new ViewContact[100];
		NewContact[] add = new NewContact[100];
		String str = "";

		while(vReader.hasNext()){
			InitialSize =  Integer.parseInt(vReader.nextLine());

			for(int j = 0; j < InitialSize; j++){
					addressBook.add(new Contact());
			}
				
			for(int i = 0; i < addressBook.size(); i++){
				addressBook.get(i).setFName(vReader.nextLine());
				addressBook.get(i).setLName(vReader.nextLine());
				addressBook.get(i).setAddress(vReader.nextLine());
				addressBook.get(i).setState(vReader.nextLine());
				addressBook.get(i).setCity(vReader.nextLine());
				addressBook.get(i).setEmail(vReader.nextLine());
				addressBook.get(i).setTitle(vReader.nextLine());
				addressBook.get(i).setHomePhone((Long.parseLong(vReader.nextLine())));
				addressBook.get(i).setMobilePhone((Long.parseLong(vReader.nextLine())));
				addressBook.get(i).setZipCode((Long.parseLong(vReader.nextLine())));
			}
		}

		while(vReader.hasNext() == false && InitialSize == 0){
			addressBook.add(new Contact());
			add[99] = new NewContact();
			add[99].setSize(450,400);
			add[99].setLocationRelativeTo(null);
			add[99].setVisible(true);	
			add[99].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			while(add[99].checker.equals ("")){

				if (add[99].checker.equals ("done")) {
					book.setLocationRelativeTo(null);
					book.setVisible(true);
					add[99].setVisible(false);
					addressBook.get(addressBook.size()-1).setFName(add[99].str1);
					addressBook.get(addressBook.size()-1).setLName(add[99].str2);
					addressBook.get(addressBook.size()-1).setAddress(add[99].str3);
					addressBook.get(addressBook.size()-1).setState(add[99].str6);
					addressBook.get(addressBook.size()-1).setCity(add[99].str4);
					addressBook.get(addressBook.size()-1).setEmail(add[99].str7);
					addressBook.get(addressBook.size()-1).setTitle(add[99].str0);
					addressBook.get(addressBook.size()-1).setHomePhone(Long.parseLong(add[99].str8));
					addressBook.get(addressBook.size()-1).setMobilePhone(Long.parseLong(add[99].str9));
					addressBook.get(addressBook.size()-1).setZipCode(Long.parseLong(add[99].str5));
				}
			}

			InitialSize++;
			f1.openFile("contact");
			f1.addRecords("" + addressBook.size() + "\n");
			f1.addRecords(addressBook.get(0).getFName() + "\n");
			f1.addRecords(addressBook.get(0).getLName() + "\n");
			f1.addRecords(addressBook.get(0).getAddress()+ "\n");
			f1.addRecords(addressBook.get(0).getState() + "\n" );
			f1.addRecords(addressBook.get(0).getCity() + "\n");
			f1.addRecords(addressBook.get(0).getEmail() + "\n");
			f1.addRecords(addressBook.get(0).getTitle() + "\n");
			f1.addRecords(addressBook.get(0).getHomePhone() + "\n");
			f1.addRecords(addressBook.get(0).getMobilePhone() + "\n");
			f1.addRecords(addressBook.get(0).getZipCode() + "\n");
			f1.closeFile();
		}

		for (int m = 0; m<addressBook.size(); m++) {
			book.setfnames(m, addressBook.get(m).getFName());
		}

		for (int n = 0; n<addressBook.size(); n++) {
			book.setlnames(n, addressBook.get(n).getLName());
		}

		book.setbuttons(addressBook.size());
		book.setLocationRelativeTo(null);
		book.setVisible(true);

		while (true){

			for (int z = 0; z<addressBook.size(); z++) {
				view[z] = new ViewContact();
				add[z] = new NewContact();

				if (book.current.equals (addressBook.get(z).getFName() + " " + addressBook.get(z).getLName())) {
					view[z] =  new ViewContact(addressBook.get(z).getFName(), addressBook.get(z).getLName(), addressBook.get(z).getAddress(), addressBook.get(z).getCity(), addressBook.get(z).getTitle(), addressBook.get(z).getEmail(), addressBook.get(z).getState(), ""+addressBook.get(z).getZipCode(), (""+addressBook.get(z).getHomePhone()), ""+ addressBook.get(z).getMobilePhone());
					view[z].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					view[z].setSize(400, 400);
					view[z].setLocationRelativeTo(null);					
					view[z].setVisible(true);
					book.setVisible(false);
					book.current = "yes";

					while(book.current.equals ("yes")){
						
						if (view[z].remove.equals ("        Delete Contact        ")) {
							System.out.println(addressBook.size());
							addressBook.remove(addressBook.get(z));
							for (int m = 0; m<addressBook.size(); m++) {
								book.setfnames(m, addressBook.get(m).getFName());
							}
							for (int n = 0; n<addressBook.size(); n++) {
								book.setlnames(n, addressBook.get(n).getLName());
							}
							view[z].remove = "";
							view[z].checker = "                         Done                         ";							
						}

						if (view[z].remove.equals ("        Edit Contact        ")) {
							view[z].remove = "";
							add[z] = new NewContact(addressBook.get(z).getTitle(), addressBook.get(z).getFName(), addressBook.get(z).getLName(), addressBook.get(z).getAddress(), addressBook.get(z).getCity(),  addressBook.get(z).getState(), ""+addressBook.get(z).getZipCode(), addressBook.get(z).getEmail(),   (""+addressBook.get(z).getHomePhone()), ""+ addressBook.get(z).getMobilePhone());
							view[z].setVisible(false);
							add[z].setSize(450,400);
							add[z].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							add[z].setLocationRelativeTo(null);
							add[z].setVisible(true);

		
							while(add[z].checker.equals ("")){
								System.out.println(book.current);

								if (add[z].checker.equals ("done")) {
								addressBook.get(z).setFName(add[z].str1);
								addressBook.get(z).setLName(add[z].str2);
								addressBook.get(z).setAddress(add[z].str3);
								addressBook.get(z).setState(add[z].str6);
								addressBook.get(z).setCity(add[z].str4);
								addressBook.get(z).setEmail(add[z].str7);
								addressBook.get(z).setTitle(add[z].str0);
								
									try{
										addressBook.get(addressBook.size()-1).setHomePhone(Long.parseLong(add[z].str8));
									}
									
									catch (NumberFormatException e){
										JOptionPane.showMessageDialog(null, "Please enter numbers for 'Home Phone'");
										break;
									}
									
									try{
										addressBook.get(addressBook.size()-1).setMobilePhone(Long.parseLong(add[z].str9));
									}
									
									catch (NumberFormatException e){
										JOptionPane.showMessageDialog(null, "Please enter numbers for 'Cell Phone'");
										break;
									}							
									
									try{
										addressBook.get(addressBook.size()-1).setZipCode(Long.parseLong(add[z].str5));
									}
									
									catch (NumberFormatException e){
										JOptionPane.showMessageDialog(null, "Please enter numbers for 'ZipCode'");
										break;
									}	
								}	
							}					
						}

						if (view[z].checker.equals ("                         Done                         ")|| add[z].checker.equals ("done")) {
							System.out.println(addressBook.size());	
							add[z].setVisible(false);
							view[z].setVisible(false);
							book = new AddressBook();
							
							for (Contact c: addressBook ) {
								book.anotherbutton2(c.getFName(),c.getLName());					
							}							
							
							book.setSize(450,450);
							book.setLocationRelativeTo(null);
							book.setVisible(true);							
							view[z].checker = "thecode";
							book.current = "";
							view[z].remove = "";
						}
					}
				}

				if (book.current.equals ("        New Contact        ")) {
					add[z] = new NewContact();
					add[z].setSize(450,400);
					add[z].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					add[z].setLocationRelativeTo(null);
					add[z].setVisible(true);
					book.setVisible(false);
					book.current = "";

					while(add[z].checker.equals ("")){
						System.out.println(book.current);

						if (add[z].checker.equals ("done")) {
							book.setLocationRelativeTo(null);
							book.setVisible(true);				
							add[z].setVisible(false);
							addressBook.add(new Contact());
							addressBook.get(addressBook.size()-1).setFName(add[z].str1);
							addressBook.get(addressBook.size()-1).setLName(add[z].str2);
							addressBook.get(addressBook.size()-1).setAddress(add[z].str3);
							addressBook.get(addressBook.size()-1).setState(add[z].str6);
							addressBook.get(addressBook.size()-1).setCity(add[z].str4);
							addressBook.get(addressBook.size()-1).setEmail(add[z].str7);
							addressBook.get(addressBook.size()-1).setTitle(add[z].str0);
							
							try{
								addressBook.get(addressBook.size()-1).setHomePhone(Long.parseLong(add[z].str8));
							}
							
							catch (NumberFormatException e){
								JOptionPane.showMessageDialog(null, "Please enter numbers for 'Home Phone'");
								addressBook.remove(addressBook.get(z));	
								break;
							}
							
							try{
								addressBook.get(addressBook.size()-1).setMobilePhone(Long.parseLong(add[z].str9));
							}
							
							catch (NumberFormatException e){
								JOptionPane.showMessageDialog(null, "Please enter numbers for 'Cell Phone'");
								addressBook.remove(addressBook.get(z));	
								break;
							}							
							
							try{
								addressBook.get(addressBook.size()-1).setZipCode(Long.parseLong(add[z].str5));
							}
							
							catch (NumberFormatException e){
								JOptionPane.showMessageDialog(null, "Please enter numbers for 'ZipCode'");
								addressBook.remove(addressBook.get(z));	
								break;
							}							
							
							System.out.println(addressBook.size());		
							book.anotherbutton(addressBook.size(), addressBook.get(addressBook.size()-1).getFName(), addressBook.get(addressBook.size()-1).getLName());		
							f1.openFile("contact");
							InitialSize = addressBook.size();
							f1.addRecords(addressBook.size() +"\n");						

							for (int m = 0; m<addressBook.size(); m++) {
								book.setfnames(m, addressBook.get(m).getFName());
							}

							for (int n = 0; n<addressBook.size(); n++) {
								book.setlnames(n, addressBook.get(n).getLName());
							}
							
							book.setLocationRelativeTo(null);
							book.setVisible(true);							
						}
					}
				}

				if (addressBook.size() ==0 && book.save.equals ("        Finished        ")) {
					break;
				}
			}

			if (addressBook.size() ==0 && book.current.equals ("        New Contact        ")) {
				int z = 0;
				JOptionPane.showMessageDialog(null, addressBook.size());
				add[z] = new NewContact();
				add[z].setSize(450,400);
				add[z].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				add[z].setLocationRelativeTo(null);
				add[z].setVisible(true);
				book.setVisible(false);
				book.current = "";

				while(add[z].checker.equals ("")){
					System.out.println(book.current);

					if (add[z].checker.equals ("done")) {
						book.setLocationRelativeTo(null);
						book.setVisible(true);
						add[z].setVisible(false);
						addressBook.add(new Contact());
						addressBook.get(addressBook.size()-1).setFName(add[z].str1);
						addressBook.get(addressBook.size()-1).setLName(add[z].str2);
						addressBook.get(addressBook.size()-1).setAddress(add[z].str3);
						addressBook.get(addressBook.size()-1).setState(add[z].str6);
						addressBook.get(addressBook.size()-1).setCity(add[z].str4);
						addressBook.get(addressBook.size()-1).setEmail(add[z].str7);
						addressBook.get(addressBook.size()-1).setTitle(add[z].str0);
						
						try{
							addressBook.get(addressBook.size()-1).setHomePhone(Long.parseLong(add[z].str8));
						}

						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Please enter numbers for 'Home Phone'");
							addressBook.remove(addressBook.get(z));
							break;
						}

						try{
							addressBook.get(addressBook.size()-1).setMobilePhone(Long.parseLong(add[z].str9));
						}

						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Please enter numbers for 'Cell Phone'");
							addressBook.remove(addressBook.get(z));						
							break;
						}	

						try{
							addressBook.get(addressBook.size()-1).setZipCode(Long.parseLong(add[z].str5));
						}

						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Please enter numbers for 'ZipCode'");
							addressBook.remove(addressBook.get(z));	
							break;
						}	

						System.out.println(addressBook.size());		
						book.anotherbutton(addressBook.size(), addressBook.get(addressBook.size()-1).getFName(), addressBook.get(addressBook.size()-1).getLName());		
						f1.openFile("contact");
						InitialSize = addressBook.size();
						f1.addRecords(addressBook.size() +"\n");

						for (int m = 0; m<addressBook.size(); m++) {
							book.setfnames(m, addressBook.get(m).getFName());
						}

						for (int n = 0; n<addressBook.size(); n++) {
							book.setlnames(n, addressBook.get(n).getLName());
						}
						
						book.setLocationRelativeTo(null);	
						book.setVisible(true);	
					}
				}
			}

			if (book.current.equals ("        Finished        ")) {
				break;	
			}
		}

		f1.openFile("contact");
			
		if (addressBook.size() !=0) {
			f1.addRecords("" + addressBook.size() + "\n");	
		}

		for(int i = 0; i < addressBook.size(); i++){
			f1.addRecords(addressBook.get(i).getFName() + "\n");
			f1.addRecords(addressBook.get(i).getLName() + "\n");
			f1.addRecords(addressBook.get(i).getAddress()+ "\n");
			f1.addRecords(addressBook.get(i).getState() + "\n" );
			f1.addRecords(addressBook.get(i).getCity() + "\n");
			f1.addRecords(addressBook.get(i).getEmail() + "\n");
			f1.addRecords(addressBook.get(i).getTitle() + "\n");
			f1.addRecords(addressBook.get(i).getHomePhone() + "\n");
			f1.addRecords(addressBook.get(i).getMobilePhone() + "\n");
			f1.addRecords(addressBook.get(i).getZipCode() + "\n");
		}	

		f1.closeFile();
		book.save = "";
		System.exit(0);
	}	
}