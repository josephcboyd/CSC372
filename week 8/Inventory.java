import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Inventory {
    
    HashMap<Integer, String[]> bookList;
    String header = "";
    
    public Inventory()  {
        HashMap<Integer, String[]> inventory = new HashMap<>();
        String path = "books.csv";
        String line = "";
        String[] tempBook;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            this.header = br.readLine(); 
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                tempBook = line.split(","); 
                // Process the values (e.g., print them)
                inventory.put(Integer.parseInt(tempBook[0]), tempBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.bookList = inventory;
        System.out.println("Inventory Loaded successfully...");
    }

    public void saveInventory(HashMap<Integer, Book> bookList) {
        HashMap<Integer, ArrayList<String>> data = new HashMap<>();
        for (Map.Entry<Integer, Book> bookEntry : bookList.entrySet()) {
            Book book = bookEntry.getValue();
            ArrayList<String> tempBook = new ArrayList<>();
            tempBook.add(Integer.toString(book.bookID));
            tempBook.add(book.title);
            tempBook.add(book.author);
            tempBook.add(Boolean.toString(book.borrowed));
            tempBook.add(book.isbn);
            tempBook.add(Integer.toString(book.pages));
            data.put(book.bookID, tempBook);
        }
        String path = "books.csv";
        String line = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            // write CSV Header
            writer.write(this.header);
            writer.newLine();
            // Iterate and write data rows
            for (Map.Entry<Integer, ArrayList<String>> entry : data.entrySet()) {
                // Escape commas if your data contains them
                String nextLine = String.join(",", entry.getValue());
                writer.write(nextLine);
                writer.newLine();
            }
            System.out.println("Inventory Saved...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}