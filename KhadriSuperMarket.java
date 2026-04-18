import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class KhadriSuperMarket{

	private StockData stock;

   {
	
	// preparing stock data

	Cosmotics cosmotics = new Cosmotics();
	Soaps soaps = new Soaps();
	soaps.setSoap(Soap.LUX);
	Pastes pastes = new Pastes();
	pastes.setPaste(Paste.COLGATE);
	
	cosmotics.setSoaps(soaps);
	cosmotics.setPastes(pastes);


	
   	stock = new StockData(cosmotics);

   }

	
  public static void main(String[] args) throws IOException{
  	
	  KhadriSuperMarket instance = 	new KhadriSuperMarket();
	  instance.availableStocks();
	  instance.purchaseItems();

  }


  private void availableStocks(){
  	System.out.println(String.format("###### AVAILABLE STOCKS IN KHADRI SUPER MARKET ######"));
  	System.out.println(stock);
  }


  private void captureCustomer(Scanner sc,Customer customer){
  	System.out.println("Enter your name : ");
  	String name = sc.next(); //jhon
  	customer.setName(name);

  	System.out.println("Enter your gender (M/F) : ");
  	String gender = sc.next();//M
  	customer.setGender(gender);

  	System.out.println("Enter your age : ");
  	int age = sc.nextInt();//24
  	customer.setAge(age);
  }


  private void purchaseItems() throws IOException{
  	System.out.println(String.format("###### PURCHASE ITEMS ######"));
  	Scanner sc = new Scanner(System.in);
  	Customer customer = new Customer();

  	System.out.println("Enter your identity (mobile number) : ");
  	Long identity = sc.nextLong(); // 9440877300
  	customer.setIdentity(identity);
  	// Need to implement the logic to verify exist or new customer
    captureCustomer(sc,customer);

    List<Item> listOfItems = new ArrayList<>();
	 boolean decision = false;
	  do{
	  	 	System.out.println("Enter purchase item name");
	  		String itemName = sc.next(); // MYSORESANDLE


	  		Soap[] soapEnumValues = stock.getCosmotics().getSoaps().getSoap().values();

	  		boolean notAvailable = true;
	   		 for(Soap soap: soapEnumValues){
	    		if(soap.name().equals(itemName)){
					notAvailable = false;
	    			System.out.println("Enter purchase item quantity : ");
	  				int noOfQuantity = sc.nextInt(); // 2
	  				if(soap.getQuantity() <= 0){
	  					System.out.println("just out of stock !!!!");
	  				}else{
	  					soap.setQuantity(soap.getQuantity() - noOfQuantity);
	  					Item item = new Item(itemName,noOfQuantity);
	  					listOfItems.add(item);
	  				}  				
	    		 } 
	 		 }
       Paste[] pasteEnumValues = stock.getCosmotics().getPastes().getPaste().values();

        for(Paste paste : pasteEnumValues){
            if(paste.name().equals(itemName)){
                notAvailable = false;
        
                System.out.println("Enter purchase item quantity : ");
                int noOfQuantity = sc.nextInt();
        
                if(paste.getQuantity() <= 0){
                    System.out.println("just out of stock !!!!");
                } else {
                    paste.setQuantity(paste.getQuantity() - noOfQuantity);
                    Item item = new Item(itemName, noOfQuantity);
                    listOfItems.add(item);
                }
            }
        }
        	 		 if(notAvailable){
        	 		 		System.out.println("Entered Item in out of stock !!!!");
        	 		 }
        
        	 		 availableStocks();
        
        	 		 decision = KhadriSuperUtil.isDecision(sc,decision);
        
        	    }while(decision);
        
        	    customer.setItems(listOfItems);
        
        	    saveCustomerHistory(customer);
        
          }


  private void saveCustomerHistory(Customer customer) throws IOException{
  	System.out.println("customer name "+customer.getName());
  	System.out.println("customer identity "+customer.getIdentity());
  	System.out.println("customer age   "+customer.getAge());
  	System.out.println("customer gender   "+customer.getGender());
  	System.out.println("customer purchase Items    ");

  

  	Path path = Paths.get("customers");

  	Path resolvedPath = path.resolve(customer.getIdentity()+".txt");

  	StringBuilder builder = new StringBuilder();

   	String HEADER = String.format("%-20s %-20s %-20s %-20s %-20s %-10s \n","IDENTITY","NAME","AGE","GENDER","ITEM NAME","ITEM QUANTITY");
   	builder.append(HEADER);
   	builder.append("-".repeat(125) + System.lineSeparator());

	for(Item item : customer.getItems()) {
  		 String ROW = String.format("%-20d %-20s %-20d %-20s %-20s %-10d  \n",customer.getIdentity(), customer.getName(),customer.getAge(),customer.getGender(),item.getItemName(),item.getQuantity());
  		 builder.append(ROW);
  	}

  	Files.writeString(resolvedPath,builder.toString(),StandardCharsets.UTF_8);

 	System.out.println("Saved Customer "+resolvedPath.toAbsolutePath());
  }

}