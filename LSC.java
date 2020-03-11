import java.util.Arrays;
import java.lang.Comparable;
public class LSC implements Comparable<LSC>{
	
	//instance variables
	private String stage;
        private String day;
        private String time;
	private String[] zones;

	/** constructor which takes in 3 variables to create an LSC item with an empty zones list */
	public LSC(String stage, String day, String time){
		this.stage = stage;
		this.day = day;
		this.time = time;
		zones = null;
		}

	/**constructor which takes in a String in the format of each line in the Load Shedding data file, allowing us to read in each line as an object by passing each line as a string to a new instance of a LSC object which can then be added to either data structure */
	public LSC(String key){
		String[] info = key.split(" ",2);
                String[] varArray = info[0].split("_");
                String[] zoneArray = info[1].split(", ");
                
		stage = varArray[0];
		day = varArray[1];
		time = varArray[2];
		this.zones = zoneArray;
		}

	
	
	//methods
	/** Overwrite the toString method to make printmethods in App classes easier */
	public String toString(){
                return "Stage: "+ stage + " Day: " + day + " Time: " + time + "  Zones: " + Arrays.toString(zones);
                }

        public String getStage(){
                return stage;
                }

        public String getDay(){
                return day;
                }

        public String getTime(){
                return time;
                }

	/** returns instance variables as a single string in the same form of our App classes command line arguments */
	public String getInfo(){
		return stage + " " + day + " " + time;
		}

	public String[] getZones(){
		return zones;
		}

	/**had to override the compareTo method while implementing comparable so that the BinarySearchTree class will not give an error when using LSC as the data type, Note we are only comparing based on key not zones */	
	public int compareTo(LSC item){
		return this.getInfo().compareTo(item.getInfo());
		}




	}// end of class
	
						
					


							
				
			
