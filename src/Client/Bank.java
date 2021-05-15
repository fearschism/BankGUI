package Client;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.nio.file.*;
import java.util.logging.*;

public class Bank {
	 private FileReader fr;
	    private BufferedReader br;
	    private FileWriter fw;
	    private BufferedWriter bw;
	    private StringTokenizer strtok;
	    private String s;
	    
	public LinkedList<Client> C = new LinkedList<Client>();
	//private Client arrc[];
	int nbC;
	int Limit;
	public Bank() {
		nbC =0;
		//arrc = new Client[10];
		Limit = 10; //change this default 10
	}
	
	
	public int searchList(int ID) { //will search the id of the Client and returns -1 if not found and the index if found;
		if(C.size() == 0) return -2;
		for (int i = 0; i < C.size(); i++) {
			if(C.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}
	public boolean AddC(Client cc) {
		if(C.size() >= Limit) return false;
		C.add(cc);
		return true;
}

	public int RemoveC(int ID) {
		if(C.size() ==0) return 0;
		int find = searchList(ID);
		if(find == -1) return -1;
		else
		  C.remove(find);
		return 1;
	}
	
	public boolean WriteF(File f) {
		boolean ok;
		if(C.size() ==0) return false;
		try {
			PrintStream writer = new PrintStream(f);
			for(int i =0;i<C.size();i++) {
				writer.println(C.get(i).toString());
			}
			writer.close();
			ok = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
	
	public int RemoveV2(File f,int ID) throws IOException {
		int ok;
		int I = searchList(ID);
		if(C.size() ==0) return 0;
		if(I == -1) return -1;
		LinkedList<Client> temp = new LinkedList<Client>();
			//Scanner s = new Scanner(f);
			PrintStream writer = new PrintStream(f);
		    for(int i =0;i<C.size();i++) {
		    	if(C.get(i).getID() != ID)
		    	temp.add(C.get(i));	    
		    }
		    C.remove(I);
		    for(int i=0;i<temp.size();i++) {
		    	writer.println(temp.get(i).toString());
		    }
		    writer.close();
		return 1;
	}
	
	public boolean ReadF(File f) {
		if(C.size() >= Limit) return false;
		boolean ok = true;
		String x;
		int bal;
		int id;
		try {
			Scanner s = new Scanner(f);
			//s.nextLine();
			while(s.hasNext()) {
				String num = s.nextLine(); 
	            String[] personData = num.split(",");
	            x = personData[0];
	            bal = Integer.parseInt(personData[1]);
	            id = Integer.parseInt(personData[2]);
	            AddC(new Client(x, bal, id));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
	
	public String[] getCNames() {
		String[] names = new String[C.size()];
		if(C.size() == 0) return names;
		for(int i=0;i<names.length;i++) {
			names[i] = i+1 + "- " +C.get(i).getCname();
		}
		return names;
	}
	
	
	/*
	public boolean SavetoC() {
		
	}
	*/

}
