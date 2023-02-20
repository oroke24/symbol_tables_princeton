# symbol_tables_princeton
Usage:      java   -cp .:algs4.jar GRHEmployees filename STName 

Storing and Retrieving Employee Data

Prompt:
  Grande Ronde Hospital (GRH) has hired you to write a simple program to store and retrieve their 
  employee data.  You are going to be paid lots of money to write this program, but it must be fast for 
  both loading and retrieving employee data, and must use a provided symbol table implementation to 
  store the data.
  Besides implementing the program, part of your job will be to provide a report supporting your 
  conclusions about which symbol table implementation to use.


The Task

Program reads a file containing employee data, stores the data in the various symbol tables provided by the book, then queries the symbol tables for various employee IDs.



If a symbol table doesn’t work for a particular input size, enter “fails” as the load time and include 
a footnote in your report explaining why it failed.
Other requirements
•The employee data is contained in the following input files for use for your testing: 
tinyEmployees.csv, employees.csv, bigEmployees.csv. 
•library functions used: java.lang, java.util, java.io, and algs4.jar
•main class is called GRHEmployees

Compile:     javac -cp .:algs4.jar *.java

◦Usage:      java   -cp .:algs4.jar GRHEmployees filename STName

▪where filename is the file containing employee data.  If the user enters a bad file name, 
you must display an appropriate error message in either in the output of an exception or 
in the Usage statement.
▪where STName is one of the following strings: SequentialSearchST, BinarySearchST, 
BST, RedBlackBST, SeparateChainingHashST, and LinearProbingHashST.  Note that 
these symbol table names must match exactly, and are case sensitive.  

•program makes use of the following symbol table implementations from the algs4.jar 
file:  SequentialSearchST, BinarySearchST, BST, RedBlackBST, SeparateChainingHashST, 
and LinearProbingHashST.
•You must have a class called Employee, which holds all of the data about a particular 
employee.  Employee class has a toString() method, and doesn't contain any 
System.out.println() statements or output of any kind.

•The output has the following elements:
•The name of the input file
•The name of the symbol table used
•The time the symbol table took to load with the employee data
•The number of employee records read from the file
•The time it took to query the symbol table for a given employee Id
•If an employee ID is found, the program must display the employee data for that 
employee ID.
•If an employee ID is not found, the program says “No Employee record for id” 
and id number.
