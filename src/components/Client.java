// 1.1.1 Creation of the client class
package components;


public class Client {
	private String name;
	private String firstName;
	private String clientID;
	static int clientNB = 0;
	
	public Client(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
		clientNB++;
		clientID = String.valueOf(clientNB);
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

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
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
	        return String.format("Name : %s %s %n ID : %s", name, firstName, clientID);
	    }

}
