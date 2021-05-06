// 1.1.1 Creation of the client class

package components;

public class Client {
	private String name;
	private String firstName;
	private int clientID;
	static int clientNB = 0;
	
	private void Client(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
		clientNB++;
		clientID = clientNB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public static int getClientNB() {
		return clientNB;
	}

	public static void setClientNB(int clientNB) {
		Client.clientNB = clientNB;
	}
	
	 @Override
	    public String toString() {
	        return String.format("Name : %s %s /n ID : %d", name, firstName, clientID);
	    }

}
