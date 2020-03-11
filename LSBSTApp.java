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
			//LSC item = LSTree.find(new LSC(stage,day,startTime)).getData()// finds the matching LSC in the
			System.out.println("Areas Affected: " + Arrays.toString((LSTree.find(new LSC(stage,day,startTime)).getData()).getZones()));// check for not found
		
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

	public void resetCounter(){
		LSTree.resetCounter();
		}

	/** Instrumentation method which has same comparitive operations as printAreas but does not print anything */
	public void printAreasNull(String stage, String day, String startTime){
          	try{
                        LSC item = LSTree.find(new LSC(stage,day,startTime)).getData();

                        }

                catch(NullPointerException e){
                        System.out.println("Area Not Found");
                        }
                }


	

	//main
	public static void main(String[] args){
		LSBSTApp LSCTree = new LSBSTApp(); // create and instance of Object which store LSC BST
		try{
			Scanner scFile = new Scanner(new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
		
			while(scFile.hasNextLine()){
				LSCTree.addToTree(new LSC(scFile.nextLine()));
				}
			}

		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			}

		if (args.length == 3){
			LSCTree.printAreas(args[0],args[1],args[2]);
			System.out.println("Insert Counter: " + LSCTree.getInsCounter());
			System.out.println("Find Counter: " + LSCTree.getFinCounter());
			}
		else if (args.length == 0){
			LSCTree.printAllAreas();
			System.out.println("Insert Counter: " + LSCTree.getInsCounter());
                        System.out.println("Find Counter: " + LSCTree.getFinCounter());
			}
		else{
			System.out.println("Error input entered in Incorrectly. Please Enter in the form:");
			System.out.println(" stage day time, i.e. 1 1 10");
			System.out.println("Insert Counter: " + LSCTree.getInsCounter());
                        System.out.println("Find Counter: " + LSCTree.getFinCounter());
			}


		}//end of main

	}// end of class

