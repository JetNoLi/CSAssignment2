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

	public void printAllAreas(){
		LSAVLTree.inOrder();
		}



	public static void main(String[] args){
		//create instance of object to create AVLTree

		LSAVLTreeApp LSCAVLTree = new LSAVLTreeApp();

		try{
			Scanner scFile = new Scanner(new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
			while(scFile.hasNext()){
				LSCAVLTree.addToTree(new LSC(scFile.nextLine()));
				}
			}
	
		catch(FileNotFoundException e){
			System.out.println("File Not Found");
			}

		if (args.length == 3){
			LSCAVLTree.printAreas(args[0], args[1], args[2]);
			}

		else if (args.length == 0){
			LSCAVLTree.printAllAreas();
			}
		else{
			System.out.println("Error input entered in Incorrectly. Please Enter in the form:");
                        System.out.println(" stage day time, i.e. 1 1 10");
                        //System.out.println("Insert Counter: " + LSCTree.getInsCounter());
                        //System.out.println("Find Counter: " + LSCTree.getFinCounter());
                        }
		}
	}



		




