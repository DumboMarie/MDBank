package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.Predicate;

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
    
    
    public static void updateAccounts(ArrayList<? super Flow> flowTable, Hashtable<String,Account> accountHashtable) {
    	for(Object flow: flowTable) {
    		String id = ((Flow) flow).getAccountID();
    		Account account = accountHashtable.get(id);
    		account.setBalance((Flow) flow);
    		accountHashtable.put(id,account);
    	}
    	Predicate<Double> negativeBalance = a -> a < 0;
    	accountHashtable.entrySet().stream().filter(a -> negativeBalance.test(a.getValue().getBalance())).
    	forEach(a -> System.out.println("Warning: Account n°"+ a.getKey()+" is negative "));
    	
    	displayAccountHashtable(accountHashtable);
	}
    
    public static void loadFlowsFile(ArrayList<Flow> flowTable) {
    	Path path = Paths.get("src/flows.json");
    	String jsonTxt = "{ \"Flows\" : [ ";
    	for (Flow flow : flowTable) {
			jsonTxt += "{ \"comment\": \"" + flow.getComment()+"\",";
			jsonTxt += "\"flowID\": \"" + flow.getFlowID()+"\",";
			jsonTxt += "\"amount\":" + flow.getAmount()+",";
			jsonTxt += "\"accountID\": \"" + flow.getAccountID()+"\",";
			jsonTxt += "\"effect\":  " + flow.isEffect()+",";
			jsonTxt += "\"date\":  \"" + flow.getDate()+ "\"";
			jsonTxt += "},";
		}
    	jsonTxt = jsonTxt.substring(0, jsonTxt.length() - 1);
    	jsonTxt += "]}";

    	try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
    		writer.write(jsonTxt);
    	}catch(IOException ex){
    		ex.printStackTrace();
    	}
    			
    }
    
    public static void loadAccountFile(Hashtable<String,Account> accountHashtable) {
    	Path path = Paths.get("src/accounts.xml");
    	String xmlTxt = "<?xml version=\"1.0\"?><Account>";
    	for (Map.Entry<String, Account> account : accountHashtable.entrySet()) {
    	    xmlTxt += "<id-"+ account.getKey() + ">";
    	    xmlTxt += "<label>"+ account.getValue().getLabel()+ "</label>"; 
    	    xmlTxt += "<balance>"+ account.getValue().getBalance()+ "</balance>";
    	    xmlTxt += "<accountID>"+ account.getValue().getAccountID()+ "</accountID>";
    	    xmlTxt += "<client>";
    	    xmlTxt += "<name>"+ account.getValue().getClient().getName()+ "</name>";
    	    xmlTxt += "<firstName>"+ account.getValue().getClient().getFirstName()+ "</firstName>";
    	    xmlTxt += "<clientID>"+ account.getValue().getClient().getClientID()+ "</clientID>";
    	    xmlTxt += "</client>";
    	    xmlTxt += "</id-"+ account.getKey() + ">";
    	}
    	xmlTxt += "</Account>";

    	try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
    		writer.write(xmlTxt);
    	}catch(IOException ex){
    		ex.printStackTrace();
    	}
    			
    }
     
    
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		clientList = loadClientList(3);
//		displayClientTable(clientList);
		loadAccountList(clientList);
//		displayAccountTable(accountList);
		loadAccountHashtable(accountList);
//		displayAccountHashtable(accountHashtable);
		
		
		ArrayList<? super Flow> flowTable = new ArrayList<>();
		flowTable.add(new Debit(50, "1", LocalDate.now().plusDays(2)));
		accountList.stream().filter(a -> a.getLabel() == "current").map(Account::getAccountID).
		forEach(id -> flowTable.add(new Credit(100.50, id, LocalDate.now().plusDays(2))));
		accountList.stream().filter(a -> a.getLabel() == "saving").map(Account::getAccountID).
		forEach(id -> flowTable.add(new Credit(1500, id, LocalDate.now().plusDays(2))));
		flowTable.add(new Transfert(50, "2","1", LocalDate.now().plusDays(2)));
				
		
		updateAccounts(flowTable, accountHashtable);
		
		loadFlowsFile((ArrayList<Flow>) flowTable);
		
		loadAccountFile(accountHashtable);
		
	}
}