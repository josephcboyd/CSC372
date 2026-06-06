import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library {
    HashMap<Integer, Book> bookList = new HashMap<>(); //book ids as the keys, book objectss as the values
    Inventory inventory = new Inventory();

    public Library() { //constructor to build book list and borrow list each load

        HashMap<Integer, String[]> tempBookList = inventory.bookList;
        for (Map.Entry<Integer, String[]> entry : tempBookList.entrySet()) {
            String[]tempBook = entry.getValue();
            int tempID = Integer.parseInt(tempBook[0]);
            String tempTitle = tempBook[1];
            String tempAuthor = tempBook[2];
            boolean borrowed = Boolean.parseBoolean(tempBook[3]);
            String tempISBN = tempBook[4];
            int tempPages = Integer.parseInt(tempBook[5]);
            Book book = new Book(tempID, tempTitle, tempAuthor, borrowed, tempISBN, tempPages);
            bookList.put(book.bookID, book);

        }
    }
    
    public boolean verifyBook(int id){
        if (bookList.containsKey(id)) {
            return true;
        }
        else return false;
    }

    public boolean isBorrowed(int id) {
        Book tempBook = bookList.get(id);
        if (tempBook.borrowed) {
            return true;
        }
        else return false;
    }

    public boolean verifyText(String text) { //used to verify that all but isbn are not empty
        try {
            if (text == null || text.isEmpty()) return false;
            else return true;        
        }
        catch (Exception e) {
            System.out.print("there was an error");
            return false;
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.print("there was an error");
            return false;
        }
    }

    public static boolean verifyISBN(String input) {
        // Compile regular expression
        String regex = "^(\\d-?){10,13}$";

        Pattern pattern = Pattern.compile(regex);
        // Match regex against input
        Matcher matcher = pattern.matcher(input);
        // Use results...
        return matcher.matches();
    }

    public void addBook() {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter the Book ID: ");
        String tempID = scnr.nextLine();

        if (!isInteger(tempID)) {
            System.out.println("Invalid entry: Book ID must be a number.");
            return;
        }

        int bookID = Integer.parseInt(tempID);

        if (verifyBook(bookID)) {
            System.out.println("Book is already in inventory.");
            return;
        }

        System.out.print("Enter the Book ISBN: ");
        String tempISBN = scnr.nextLine();

        if (!verifyISBN(tempISBN)) {
            System.out.println("Invalid entry: ISBN format is invalid.");
            return;
        }

        System.out.print("Enter the Book Title: ");
        String tempTitle = scnr.nextLine();
        if (!verifyText(tempTitle)) {
            System.out.println("Invalid entry: Title cannot be empty.");
            return;
        }

        System.out.print("Enter the Book Author: ");
        String tempAuth = scnr.nextLine();
        if (!verifyText(tempAuth)) {
            System.out.println("Invalid entry: Author cannot be empty.");
            return;
        }

        System.out.print("Enter the Page count: ");
        String tempPages = scnr.nextLine();

        if (!isInteger(tempPages)) {
            System.out.println("Invalid entry: Page count must be a number.");
            return;
        }

        int pages = Integer.parseInt(tempPages);

        Book tempBook = new Book(bookID, tempTitle, tempAuth, false, tempISBN, pages);
        bookList.put(bookID, tempBook);

        System.out.printf("%s, by %s.%n%s - %d pages%n", tempTitle, tempAuth, tempISBN, pages);
        System.out.println("Book has been added.");
    }

    public void borrowBook(int id) { //checks isbn is right format, that book exists, and that book is not borrowed
        boolean validEntry = true;
        while (validEntry) {
            if (verifyBook(id)) {} else { validEntry = false; System.out.println("Book does not exist"); break;}
            if (!isBorrowed(id)) {} else { validEntry = false; System.out.println("Book is already borrowed"); break;}
            Book tempBook = bookList.get(id);
            tempBook.borrowed = true;
            validEntry = false;
        }
    }

    public void returnBook(int id){ //checks isbn is right format, that book exists, and that book is borrowed
        boolean validEntry = true;
        while (validEntry) {
            if (verifyBook(id)) {} else { validEntry = false; System.out.println("Book does not exist");}
            if (isBorrowed(id)) {} else { validEntry = false; System.out.println("Book is already borrowed");}
            Book tempBook = bookList.get(id);
            tempBook.borrowed = false;
            validEntry = false;
        }
    }

    public void printbookList(){
        bookList.values().forEach(value -> value.printBookInfo());
    }

    public void bookSearch() {
    Scanner scnr = new Scanner(System.in);
    boolean searchMenu = true;

    while (searchMenu) {
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by ID");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        String tempEntry = scnr.nextLine();

        if (!isInteger(tempEntry)) {
            System.out.println("Invalid entry, please enter a number 1-4.");
            continue;
        }

        int entry = Integer.parseInt(tempEntry);

        if (entry == 4) {
            searchMenu = false;
            continue;
        }

        if (entry < 1 || entry > 3) {
            System.out.println("Invalid entry, please enter a number 1-4.");
            continue;
        }

        System.out.print("Enter your search term: ");
        String searchTerm = scnr.nextLine();

        if (!verifyText(searchTerm)) {
            System.out.println("Invalid entry, please enter a valid search term.");
            continue;
        }

        boolean noResults = true;

        switch (entry) {
            case 1:
                for (Map.Entry<Integer, Book> bookEntry : bookList.entrySet()) {
                    Book tempBook = bookEntry.getValue();
                    if (tempBook.title.contains(searchTerm)) {
                        tempBook.printBookInfo();
                        noResults = false;
                    }
                }
                break;
            case 2:
                for (Map.Entry<Integer, Book> bookEntry : bookList.entrySet()) {
                    Book tempBook = bookEntry.getValue();
                    if (tempBook.author.contains(searchTerm)) {
                        tempBook.printBookInfo();
                        noResults = false;
                    }
                }
                break;
            case 3:
                if (!isInteger(searchTerm)) {
                    System.out.println("Invalid entry: ID must be a number.");
                    continue;
                }
                int searchID = Integer.parseInt(searchTerm);
                if (bookList.containsKey(searchID)) {
                    bookList.get(searchID).printBookInfo();
                    noResults = false;
                }
                break;
        }

        if (noResults) {
            System.out.println("No results found. Please try another term or check your spelling.");
        }
    }
}

    public static void main(String[] args){
        try {
            Library schooLibrary = new Library();
            boolean mainMenu = true;
            while (mainMenu) {
                System.out.println("1. Add Book \t3. Return Book \t5. Print All Books");
                System.out.println("2. Borrow Book \t4. Search \t6. Exit");
                Scanner scnr = new Scanner(System.in);
                String tempEntry = scnr.next();
                String tempID = "";
                int tempIDINT = 0;
                int entry = 0;
                if (isInteger(tempEntry)) {
                    entry = Integer.parseInt(tempEntry);
                    switch (entry) {
                        case 1:
                            schooLibrary.addBook();
                            schooLibrary.inventory.saveInventory(schooLibrary.bookList);
                            break;
                        case 2:
                            System.out.println("Please enter the ID");
                            scnr.nextLine();
                            tempID = scnr.nextLine();
                            mainMenu = isInteger(tempID);
                            tempIDINT = Integer.parseInt(tempID);
                            schooLibrary.borrowBook(tempIDINT);
                            schooLibrary.inventory.saveInventory(schooLibrary.bookList);
                            break;
                        case 3:
                            System.out.println("Please enter the ID");
                            scnr.nextLine();
                            tempID = scnr.nextLine();
                            mainMenu = isInteger(tempID);
                            tempIDINT = Integer.parseInt(tempID);
                            schooLibrary.returnBook(tempIDINT);
                            schooLibrary.inventory.saveInventory(schooLibrary.bookList);
                            break;
                        case 4:
                            schooLibrary.bookSearch();
                            break;
                        case 5:
                            schooLibrary.printbookList();
                            break;
                        default:
                            System.out.println("Invalid entry.");
                    }
                } else {
                    System.out.println("Invalid Entry, try again.");
                }
            }
                
        } catch (Exception e) {
            System.out.println("Details: " + e.getMessage());
        }
    }
}
