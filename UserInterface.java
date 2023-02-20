/* 
 * UserInterface.java
 * By: Jamie O'Roke
 *
 * This file contains all of the User Interface Implementation
 * It has the menu for the user to select from
 * It also has most Error and Exception handling and 
 * a usage statement as well as an input check
 *
*/
//import java.nio.file.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
//import java.util.Scanner;

public class UserInterface{
/////////// FIRST CHECK THE USAGE AND INPUT ////////////////////
//
	private static int user_input;
	public static boolean usage(String[] args){
		if(args.length != 2){
			System.out.println("Usage: java -cp .:algs4.jar GRHEmployees filename STName");
			return true;
		}
		System.out.println("my args are: " + args[0] + ", " + args[1]);
		return false;
	}
	public static boolean bad_input(String[] args){
		//checking if the file was input correctly
		File file_name = new File(args[0]);
		String symbol_table_name = args[1];
		//file_name.exists checks the local directory for the input file name
		if(!file_name.exists()){
			System.out.println(args[0] + ": file not found in current directiory.");
			return true;
		}
		//checking if the symbol table name was input correctly 
		if(!symbol_table_name.equals("SequentialSearchST") 
		&& !symbol_table_name.equals("BinarySearchST") 
		&& !symbol_table_name.equals("BST") 
		&& !symbol_table_name.equals("RedBlackBST") 
		&& !symbol_table_name.equals("SeparateChainingHashST") 
		&& !symbol_table_name.equals("LinearProbingHashST")){ 

			System.out.println("Bad symbol table name: " + args[1]); 
			return true;
		}	
		return false;	
	}
//
/////////// END USAGE AND INPUT CHECK /////////////////////////// 

////////////////////// MENU INTERFACE /////////////////////////// 
//
	public static int repeat(){
		Scanner in = new Scanner(System.in);
	 	System.out.print("Enter an employee id to retrieve (-1 to quit): ");	
		user_input = in.nextInt();
		return user_input;
	}
	public static int show_input(){
		return user_input;
	}
//
////////////////// END MENU INTERFACE /////////////////////////// 

}

