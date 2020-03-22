public class Util{

	public static boolean getT(String[] dataT){
		boolean T = false;
		if (dataT.length == 0){
			return false;
			}
		if (dataT[dataT.length-1].equals("T")){
			T = true;
                        }
		return T;
		}

	public static String[] getDataNoT(String[] dataT, boolean T){
		if(!T || dataT.length == 0){
			return dataT;
			}

                String[] dataNoT = new String[dataT.length-1];

		for (int i = 0; i<= dataNoT.length-1; i++){
                        dataNoT[i] = dataT[i];
                	}

		return dataNoT;
		
		}
	}

