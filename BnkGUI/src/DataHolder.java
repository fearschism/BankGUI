import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import Client.Bank;
import Client.Client;

public class DataHolder {
	public  Bank bnk = new Bank();
	public  Client cl;
	 File f = new File("Saves/Client.txt"); {
	 if(!f.exists()) {
		 try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
}
