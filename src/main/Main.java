// 1.1.2 Creation of the Main class
package main;

import java.util.ArrayList;


import components.*;

public class Main {
    static ArrayList<Client> clientList = new ArrayList<>();
    
    public static ArrayList<Client> loadClientList(int newClientNB) {
        ArrayList<Client> newClientList = new ArrayList<>();
    	for(int i = 1; i <= newClientNB; i++) {
    		newClientList.add(new Client("name"+i, "firstname"+i));
    	}
    	return newClientList;
    }
    
    public static void displayClientTable(ArrayList<Client> clients) {
    	clients.stream().map(Client::toString).forEach(System.out::println);
	}

	public static void main(String[] args) {
		clientList = loadClientList(3);
		displayClientTable(clientList);
	}

}
