package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;

import components.*;

public class Main {
    static ArrayList<Client> clientList = new ArrayList<>();
    static ArrayList<Account> accountList = new ArrayList<>();
    static Hashtable<String,Account> accountHashtable = new Hashtable<>();
    
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
    
    
    
    public static void loadAccountList(ArrayList<Client> clients) {
    	for (Client client : clients) {
			Account savingsAccount = new SavingsAccount("saving", client);
			Account currentAcount = new CurrentAccount("current", client);			
			accountList.add(savingsAccount);
			accountList.add(currentAcount);			
		}
    }
    
    public static void displayAccountTable(ArrayList<Account> accounts) {
    	accounts.stream().map(Account::toString).forEach(System.out::println);
	}

    
    public static void loadAccountHashtable(ArrayList<Account> accounts) {
		for (Account account : accounts) {
			accountHashtable.put(account.getAccountID(), account);
		}
	}
    
    public static void displayAccountHashtable(Hashtable<String,Account> accounts) {
    	Comparator<Account>  comparator = Comparator.comparing(Account::getBalance);
    	
    	accounts.entrySet().stream().map(Map.Entry::getValue).
    	sorted(comparator).forEach(System.out::println);
	}
    
    
    
	public static void main(String[] args) {
		clientList = loadClientList(3);
		displayClientTable(clientList);
		loadAccountList(clientList);
		displayAccountTable(accountList);
		System.out.println("Je suis la");
		loadAccountHashtable(accountList);
		displayAccountHashtable(accountHashtable);
	}
}