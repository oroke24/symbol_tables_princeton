/* 
 * Elist.java 
 * By: Jamie O'Roke
 *
 * Elist is essentially the data structue, it is responsible for
 * storing the employees from the given file into an array of type 
 * Employee.  Then it takes the desired symbol table and loads it, using
 * the array that initially stores the data.  This allows the timing to more
 * specifically measure just the time to load the table, without the time
 * it takes to access and read from the file.
 *    
*/
import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Stopwatch;

public class Elist{
	private Employee [] employee_list;
	private int number_of_employees;
	private SequentialSearchST<Integer, Employee> sst;
	private BinarySearchST<Integer, Employee> bs_st;
	private BST<Integer, Employee> bst;
	private RedBlackBST<Integer, Employee> rb_bst;
	private SeparateChainingHashST<Integer, Employee> sch_st;
	private LinearProbingHashST<Integer, Employee> lph_st;

	//constructor
	Elist(String file_name){
		number_of_employees = count_file(file_name);
		employee_list = new Employee[number_of_employees];
	}
	//method to fill the Employee array from a given file
	public void fill_array(String file_name) {
		try{
			//creating new scanner
			Scanner read = new Scanner(new File(file_name)); 
			read.useDelimiter(",");
			int i = 0;
			String id, dob, hire_date, first, last, gender;
			while(read.hasNext()){
				id = read.next();
				dob = read.next();
				first = read.next();
				last = read.next();
				gender = read.next();
				hire_date = read.nextLine();
				hire_date = hire_date.replaceAll(",","");
				employee_list[i] = new Employee(id, dob, hire_date, first, last, gender);
				i++;
			}
			read.close();
		}catch(FileNotFoundException e){
			System.out.println("an error ocurred.");
			e.printStackTrace();
		}
	}
	public double fill_symbol_table(String st_name)
	{
		double click = -1;
		if(st_name.equals("SequentialSearchST")){
			Stopwatch timer = new Stopwatch();
			sst = new SequentialSearchST<Integer, Employee>();
			for(int i=0; i < employee_list.length; i++){
				sst.put(employee_list[i].get_id(), employee_list[i]);	
			}
			click = timer.elapsedTime();
		}
		else if(st_name.equals("BinarySearchST")){
			Stopwatch timer = new Stopwatch();
			bs_st = new BinarySearchST<Integer, Employee>();
			for(int i=0; i < employee_list.length; i++){
				bs_st.put(employee_list[i].get_id(), employee_list[i]);	
			}
			click = timer.elapsedTime();
		}
		else if(st_name.equals("BST")){
			Stopwatch timer = new Stopwatch();
			bst = new BST<Integer, Employee>();
			for(int i=0; i < employee_list.length; i++){
				bst.put(employee_list[i].get_id(), employee_list[i]);	
			}
			click = timer.elapsedTime();
		}
		else if(st_name.equals("RedBlackBST")){
			Stopwatch timer = new Stopwatch();
			rb_bst = new RedBlackBST <Integer, Employee>();
			for(int i=0; i < employee_list.length; i++){
				rb_bst.put(employee_list[i].get_id(), employee_list[i]);	
			}
			click = timer.elapsedTime();
		}
		else if(st_name.equals("SeparateChainingHashST")){
			Stopwatch timer = new Stopwatch();
			sch_st = new SeparateChainingHashST <Integer, Employee>();
			for(int i=0; i < employee_list.length; i++){
				sch_st.put(employee_list[i].get_id(), employee_list[i]);	
			}
			click = timer.elapsedTime();
		}
		else if(st_name.equals("LinearProbingHashST")){
			Stopwatch timer = new Stopwatch();
			lph_st = new LinearProbingHashST <Integer, Employee>();
			for(int i=0; i < employee_list.length; i++){
				lph_st.put(employee_list[i].get_id(), employee_list[i]);	
			}
			click = timer.elapsedTime();
		}
		return click;
	}
	public double query(String st_name, int key){
		double click = -1;
		String employee_holder = "";
		if(st_name.equals("SequentialSearchST")){
			Stopwatch timer = new Stopwatch();
			employee_holder = ""+sst.get(key);
			click = timer.elapsedTime();
		}
		else if(st_name.equals("BinarySearchST")){
			Stopwatch timer = new Stopwatch();
			employee_holder = ""+bs_st.get(key);
			click = timer.elapsedTime();
		}
		else if(st_name.equals("BST")){
			Stopwatch timer = new Stopwatch();
			employee_holder = ""+bst.get(key);
			click = timer.elapsedTime();
		}
		else if(st_name.equals("RedBlackBST")){
			Stopwatch timer = new Stopwatch();
			employee_holder = ""+rb_bst.get(key);
			click = timer.elapsedTime();
		}
		else if(st_name.equals("SeparateChainingHashST")){
			Stopwatch timer = new Stopwatch();
			employee_holder = ""+sch_st.get(key);
			click = timer.elapsedTime();
		}
		else if(st_name.equals("LinearProbingHashST")){
			Stopwatch timer = new Stopwatch();
			employee_holder = ""+lph_st.get(key);
			click = timer.elapsedTime();
		}
		if(employee_holder.equals("null")) System.out.println("No employee record for id " + key);
		else System.out.println("{"+employee_holder+"}");
		return click;
	}
	public int lines(){
		return number_of_employees;
	}
	public int count_file(String file_name){
		int i = 0;
		try{
			Scanner read = new Scanner(new File(file_name));
			while(read.hasNext()){
				read.next();
				i++;
			}
			read.close();
		}catch(FileNotFoundException e){
			System.out.println("an error ocurred.");
			e.printStackTrace();
		}
		return i;
	}
	//Overriding the toString method
	@Override
	public String toString(){
		for(int i = 0; i < employee_list.length; i++){
			System.out.println(employee_list[i].toString());
		}
		return"";
	}
}
