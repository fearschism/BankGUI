package Client;
import java.util.LinkedList;

public class Client {

	private String Cname;
	private int CBalance;
	private int ID;
	private LinkedList<Client> C = new LinkedList<Client>(); //storing Client details;
	int Limit1;
	int nbC = 0;
	public Client(String name,int B,int id,int size) {
		this.Cname = name;
		this.CBalance = B;
		this.ID = id;
		this.Limit1 = size;
		nbC = 0;
}
	
	public boolean AddC(Client cc) {
		if(C.size() == Limit1) return false;
		C.set(nbC++, cc);
		return true;
}

}