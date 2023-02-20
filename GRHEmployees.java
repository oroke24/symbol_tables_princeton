/*
 * GHREmployees.java
 * By: Jamie O'Roke
 *
 * GHR stands for "Grande Ronde Hospital"
 * This file is where main exists
 * A program to utilize a provided symbol table implementation to store data
 *
*/ 
import java.io.*;
import edu.princeton.cs.algs4.SequentialSearchST;

public class GRHEmployees{

	public static void main(String[] args) {
		String file_name = args[0];

		Elist employee_list = new Elist(file_name);
		employee_list.fill_array(file_name);

		if(UserInterface.usage(args)) return; 
		if(UserInterface.bad_input(args)) return;

		System.out.println("Welcome to the GRH employee data program!");
		System.out.println("	filename: " + args[0]);
		System.out.println("	symbol table name: " + args[1]);

		//employee_list.fill symbol contains and returns the value
		//of a stopwatch object that times the for loop to fill the symbol table
		double fill_time = employee_list.fill_symbol_table(args[1]);

		//DEVELOPMENT TESTING, REMOVE THIS CODE ONCE TESTING IS COMPLETE//
		//
		//System.out.println(employee_list.toString());
		//
		////////////////////////END OF TEST CODE//////////////////////////

		System.out.println("Symbol table load time: " + fill_time + " seconds.");
		System.out.println("	  record count: " + employee_list.lines());

		while(UserInterface.repeat() != -1){
			double query_time = employee_list.query(args[1], UserInterface.show_input());
			System.out.println("	query time: " + query_time + " seconds.");
		}
	}
}
