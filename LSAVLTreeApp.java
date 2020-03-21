import java.util.*;
import java.io.*;

/**Class which acts as the app,the class stores the AVL Tree as an instance variable, an instance of the class as an object is created to store data read in from the text file in the AVL Tree.*/

public class LSAVLTreeApp{

	private AVLTree<LSC> LSAVLTree;

	public LSAVLTreeApp(){
	LSAVLTree = new AVLTree<LSC>();
	}

	//methods 

	public void addToTree(LSC item){
		LSAVLTree.insert(item);
		}

	public void printAreas(String stage, String day, String startTime){
		try {
			System.out.println("Areas Affected: " + Arrays.toString(LSAVLTree.find(new LSC(stage, day, startTime)).data.getZones()));
			}

		catch(NullPointerException e){
			System.out.println("Areas Not Found");
			}
		}

	public void printAreasNull(String stage, String day, String startTime){
		try{
			LSC item = LSAVLTree.find(new LSC(stage,day,startTime)).data;
			}

		catch(NullPointerException e){
			System.out.println("Area Not Found");
			}

		}

	public void printAllAreas(){
		LSAVLTree.inOrder();
		}

	//Instrumentation Method
	public int getInsCounter(){
		return LSAVLTree.getInsCounter();
		}

	public int getFinCounter(){
		return LSAVLTree.getFinCounter();
		}



	public static void main(String[] args){
		//create instance of object to create AVLTree
		boolean T = Util.getT(args);

		LSAVLTreeApp LSCAVLTree = new LSAVLTreeApp();

		try{
			Scanner scFile;
			if (args.length == 4 && !T){

				scFile = new Scanner(new File(args[3]));
				}

			else{
				scFile = new Scanner(new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
				}

			while(scFile.hasNext()){
				LSCAVLTree.addToTree(new LSC(scFile.nextLine()));
				}
			}

	
		catch(FileNotFoundException e){
			System.out.println("File Not Found");
			}

		
		String[] data = Util.getDataNoT(args,T);

		
		if (data.length == 3){
			
			LSCAVLTree.printAreas(data[0], data[1], data[2]);
			if (T){
				System.out.println("Insert Counter: " + LSCAVLTree.getInsCounter());
				System.out.println("Find Counter: " + LSCAVLTree.getFinCounter());
				}

			}

		else if(data.length == 4 & !T){
			LSCAVLTree.printAreasNull(data[0], data[1], data[2]);
			System.out.println("I: " + LSCAVLTree.getInsCounter());
                        System.out.println("F: " + LSCAVLTree.getFinCounter());
			}

		else if (data.length == 0){
			LSCAVLTree.printAllAreas();
			if (T){
				System.out.println("Insert Counter: " + LSCAVLTree.getInsCounter());
                                System.out.println("Find Counter: " + LSCAVLTree.getFinCounter());
				}

			}
		
		else{
			System.out.println("Error input entered in Incorrectly. Please Enter in the form:");
                        System.out.println(" stage day time, i.e. 1 1 10");
                        if (T){
				System.out.println("Insert Counter: " + LSCAVLTree.getInsCounter());
                                System.out.println("Find Counter: " + LSCAVLTree.getFinCounter());
				}

                        }
		}
	}



		




