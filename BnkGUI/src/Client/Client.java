package Client;
import java.util.LinkedList;

public class Client {

	private String Cname;
	private int CBalance;
	private int ID; //storing Client details;
	int Limit1;
	int nbC = 0;
	public Client(String name,int B,int id) {
		this.Cname = name;
		this.CBalance = B;
		this.ID = id;
}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public int getCBalance() {
		return CBalance;
	}
	public void setCBalance(int cBalance) {
		CBalance = cBalance;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String Display() { //used for the display functionality
		return "Name: " + Cname + " Balance: " + CBalance + " ID: " + ID;
	}
	@Override
	public String toString() { //used for file writing and reading.
		return  Cname +"," + CBalance + "," + ID ;
	}
	

	
}