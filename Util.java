public class Util{

	public static boolean getT(String[] dataT){
		boolean T = false;

		for (int i = 0; i < dataT.length; i++){
                        if (dataT[i].equals("T")){
                                T = true;
                                }
                        }
		return T;
		}

	public static String[] getDataNoT(String[] dataT, boolean T){
		int count = 0;
                String[] dataNoT;
                if (T){
                        dataNoT = new String[dataT.length-1];
                        }
                else{
                        dataNoT = new String[dataT.length];
                        }


                for (int i = 0; i< dataNoT.length; i++){
                        count++;
                        if ( dataT[i].equals("T")){
                                count++;
                                }
                        dataNoT[i] = dataT[count];
                	}
		
		return dataNoT;
		}
	}

