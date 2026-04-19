import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class KhadriSuperMarket {
private static final String DIR = "customers/";
private StockData stock;

{
    Cosmotics cosmotics = new Cosmotics();
    Soaps soaps = new Soaps();
    soaps.setSoap(Soap.LUX);
    Pastes pastes = new Pastes();
    pastes.setPaste(Paste.COLGATE);
    cosmotics.setSoaps(soaps);
    cosmotics.setPastes(pastes);

    Groceries groceries = new Groceries();
    Sugars sugars = new Sugars();
    sugars.setSugar(Sugar.REFINED);
    Rices rices = new Rices();
    rices.setRice(Rice.BASMATI);
    Wheats wheats = new Wheats();
    wheats.setWheat(Wheat.SHARBATI);
    groceries.setSugars(sugars);
    groceries.setRices(rices);
    groceries.setWheats(wheats);

    stock = new StockData(cosmotics, groceries);
}

public static void main(String[] args) throws IOException {
    KhadriSuperMarket instance = new KhadriSuperMarket();
    instance.availableStocks();
    instance.purchaseItems();
}

private void availableStocks() {
    System.out.println("###### AVAILABLE STOCKS IN KHADRI SUPER MARKET ######");
    System.out.println(stock);
}

private void checkAndGreetCustomer(Scanner sc, Customer customer) throws IOException {
    Path path = Paths.get(DIR + customer.getIdentity() + ".txt");
    boolean isExists = Files.exists(path);

    if (isExists) {
        List<String> lines = Files.readAllLines(path);
        String[] headers = {"IDENTITY", "NAME", "AGE", "GENDER", "ITEM NAME", "ITEM QUANTITY"};
        Map<String, String> customerMap = new LinkedHashMap<>();

        for (String line : lines) {
            if (line.trim().isEmpty() || line.contains("IDENTITY") || line.startsWith("---")) {
                continue;
            }
            String[] values = line.trim().split("\\s+");
            for (int i = 0; i < headers.length; i++) {
                customerMap.put(headers[i], values[i]);
            }
            break;
        }

        String name = customerMap.get("NAME");
        customer.setName(name);
        System.out.println("Welcome back, " + name + " : Happy Shopping!");

    } else {
        captureNewCustomer(sc, customer);
    }
}

private void captureNewCustomer(Scanner sc, Customer customer) {
    System.out.println("Enter your name : ");
    customer.setName(sc.next());
    System.out.println("Enter your gender (M/F) : ");
    customer.setGender(sc.next());
    System.out.println("Enter your age : ");
    customer.setAge(sc.nextInt());
}

private void purchaseItems() throws IOException {
    System.out.println("###### PURCHASE ITEMS ######");
    Scanner sc = new Scanner(System.in);
    Customer customer = new Customer();

    System.out.println("Enter your identity (mobile number) : ");
    Long identity = sc.nextLong();
    customer.setIdentity(identity);

    checkAndGreetCustomer(sc, customer);

    List<Item> listOfItems = new ArrayList<>();
    boolean decision = false;

    do {
        System.out.println("Enter purchase item name");
        String itemName = sc.next();
        boolean notAvailable = true;

        for (Soap soap : stock.getCosmotics().getSoaps().getSoap().values()) {
            if (soap.name().equals(itemName)) {
                notAvailable = false;
                System.out.println("Enter purchase item quantity : ");
                int qty = sc.nextInt();
                if (soap.getQuantity() <= 0) {
                    System.out.println("just out of stock !!!!");
                } else {
                    soap.setQuantity(soap.getQuantity() - qty);
                    listOfItems.add(new Item(itemName, qty));
                }
            }
        }

        for (Paste paste : stock.getCosmotics().getPastes().getPaste().values()) {
            if (paste.name().equals(itemName)) {
                notAvailable = false;
                System.out.println("Enter purchase item quantity : ");
                int qty = sc.nextInt();
                if (paste.getQuantity() <= 0) {
                    System.out.println("just out of stock !!!!");
                } else {
                    paste.setQuantity(paste.getQuantity() - qty);
                    listOfItems.add(new Item(itemName, qty));
                }
            }
        }

        for (Sugar sugar : stock.getGroceries().getSugars().getSugar().values()) {
            if (sugar.name().equals(itemName)) {
                notAvailable = false;
                System.out.println("Enter purchase item quantity : ");
                int qty = sc.nextInt();
                if (sugar.getQuantity() <= 0) {
                    System.out.println("just out of stock !!!!");
                } else {
                    sugar.setQuantity(sugar.getQuantity() - qty);
                    listOfItems.add(new Item(itemName, qty));
                }
            }
        }

        for (Rice rice : stock.getGroceries().getRices().getRice().values()) {
            if (rice.name().equals(itemName)) {
                notAvailable = false;
                System.out.println("Enter purchase item quantity : ");
                int qty = sc.nextInt();
                if (rice.getQuantity() <= 0) {
                    System.out.println("just out of stock !!!!");
                } else {
                    rice.setQuantity(rice.getQuantity() - qty);
                    listOfItems.add(new Item(itemName, qty));
                }
            }
        }

        for (Wheat wheat : stock.getGroceries().getWheats().getWheat().values()) {
            if (wheat.name().equals(itemName)) {
                notAvailable = false;
                System.out.println("Enter purchase item quantity : ");
                int qty = sc.nextInt();
                if (wheat.getQuantity() <= 0) {
                    System.out.println("just out of stock !!!!");
                } else {
                    wheat.setQuantity(wheat.getQuantity() - qty);
                    listOfItems.add(new Item(itemName, qty));
                }
            }
        }

        if (notAvailable) {
            System.out.println("Entered Item is out of stock !!!!");
        }

        availableStocks();
        decision = KhadriSuperUtil.isDecision(sc, decision);

    } while (decision);

    customer.setItems(listOfItems);
    saveCustomerHistory(customer);
}

private void saveCustomerHistory(Customer customer) throws IOException {
    System.out.println("############# Saving Customer Starts ##############");

    Path resolvedPath = Paths.get(DIR + customer.getIdentity() + ".txt");
    StringBuilder builder = new StringBuilder();

    String HEADER = String.format("%-20s %-20s %-20s %-20s %-20s %-10s \n", "IDENTITY", "NAME", "AGE", "GENDER", "ITEM NAME", "ITEM QUANTITY");
    builder.append(HEADER);
    builder.append("-".repeat(125) + System.lineSeparator());

    for (Item item : customer.getItems()) {
        String ROW = String.format("%-20d %-20s %-20d %-20s %-20s %-10d  \n", customer.getIdentity(), customer.getName(), customer.getAge(), customer.getGender(), item.getItemName(), item.getQuantity());
        builder.append(ROW);
    }

    Files.writeString(resolvedPath, builder.toString(), StandardCharsets.UTF_8);
    System.out.println("Customer Saved Location : " + resolvedPath.toAbsolutePath());
    System.out.println("############# Saving Customer Ends ##############");
}

}                