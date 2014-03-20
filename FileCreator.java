/*Programmer: Alex Curreri, Alex Lemaire and Sravan Reddy
Date: 03/19/2014
Filename: FileCreator.java
Purpose: create a txt file where contact information will be stored for later use
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class FileCreator{
	private Formatter x;

	public void openFile(String s1){ //open txt file
		try{
			x = new Formatter(s1 + ".txt");
		}
		catch(Exception e){
			System.out.println("Already Exists");
		}
	}
	public void addRecords(String s){ //writes to the text file using string
		x.format("%s", s);
	}
	public void closeFile(){ //closes and saves txt file
		x.close();
	}
}
