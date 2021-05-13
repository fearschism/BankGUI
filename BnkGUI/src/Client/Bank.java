package Client;

import java.util.LinkedList;

public class Bank {
	
	public LinkedList<Client> C = new LinkedList<Client>();
	int nbC;
	int Limit1;
	public Bank() {
		Limit1 = 20;
		nbC =0;
	}
	
	
	public int searchList(int ID) { //will search the id of the Client and returns -1 if not found and the index if found;
		if(nbC == 0) return -1;
		for (int i = 0; i < C.size(); i++) {
			if(C.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}
	public boolean AddC(Client cc) {
		if(C.size() == Limit1) return false;
		C.add(cc);
		nbC++;
		return true;
}

	public boolean RemoveC(int ID) {
		if(C.isEmpty()) return false;
		int find = searchList(ID);
		if(find == -1) return false;
		C.remove(find);
		return true;
	}

}
