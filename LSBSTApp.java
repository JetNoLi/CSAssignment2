import java.util.*;
import java.io.*;

public class LSBSTApp{
	//instance variable - Binary Search Tree of Type LSC
	private BinarySearchTree<LSC> LSTree;	
	
	//constructor
	/** Creates an empty Binary Search Tree of Type LSC and stores it as an instance variable which we can access through various accessor methods*/	
	public LSBSTApp(){
		LSTree = new BinarySearchTree<LSC>();
		}

	//methods 
	/** adds an item to the tree by invoking the insert method of the binary search tree */
	public void addToTree(LSC item){ // inserts item into the LSC BST 
		LSTree.insert(item);
		}

	/** by invoking the find method we are able to find the LSC which matches the input data which stores the zones affected, we then print these zones */
	public void printAreas(String stage, String day, String startTime){
		
		try{
			System.out.println("Areas Affected: " + Arrays.toString((LSTree.find(new LSC(stage,day,startTime)).data).getZones()));// check for not found
		
			}

		catch(NullPointerException e){
			System.out.println("Area Not Found");
			}
		}

	/** uses inOrder traversal to print the entire list of zones */
	public void printAllAreas(){ 
		LSTree.inOrder();
		}
		
	
	//instrumentation methods
	public int getInsCounter(){
		return LSTree.getInsCounter();
		}

	public int getFinCounter(){
		return LSTree.getFinCounter();
		}


	/** Instrumentation method which has same comparitive operations as printAreas but does not print anything */
	public void printAreasNull(String stage, String day, String startTime){
          	try{
                        LSC item = LSTree.find(new LSC(stage,day,startTime)).data;

                        }

                catch(NullPointerException e){
                        System.out.println("Area Not Found");
                        }
                }


	

	//main
	public static void main(String[] args){
		
		boolean T = Util.getT(args);

		LSBSTApp LSCTree = new LSBSTApp(); // create and instance of Object which store LSC BST
		try{
			Scanner scFile;

			if (args.length == 4 && !T){
				scFile = new Scanner(new File(args[3]));
				}
			else{
				scFile = new Scanner(new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
				}

			while(scFile.hasNextLine()){
				LSCTree.addToTree(new LSC(scFile.nextLine()));
				}
			}
			
		
		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			
			}

		//
		String[] data = Util.getDataNoT(args,T);

		//

		if (data.length == 3){
			LSCTree.printAreas(data[0],data[1],data[2]);
			if (T){
				System.out.println("Insert Counter: " + LSCTree.getInsCounter());
                        	System.out.println("Find Counter: " + LSCTree.getFinCounter());
				}
			}

		else if (data.length == 4 & !T){ // for Automated Python Script Part 5

			LSCTree.printAreasNull(data[0],data[1],data[2]);
	 		System.out.println("I: " + LSCTree.getInsCounter());
                        System.out.println("F: " + LSCTree.getFinCounter());
			}
			
		else if (data.length == 0){
			LSCTree.printAllAreas();
			if (T){
				System.out.println("Insert Counter: " + LSCTree.getInsCounter());
                        	System.out.println("Find Counter: " + LSCTree.getFinCounter());
				}
			}

		else{
			System.out.println("Error input entered in Incorrectly. Please Enter in the form:");
			System.out.println(" stage day time, i.e. 1 1 10");
			if (T){

				System.out.println("Insert Counter: " + LSCTree.getInsCounter());
                        	System.out.println("Find Counter: " + LSCTree.getFinCounter());
				}
			}


		}//end of main

	}// end of class

