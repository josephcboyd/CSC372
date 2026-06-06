public class Book {
    int bookID;
    String title;
    String author;
    Boolean borrowed;
    String isbn;
    int pages;

    Book(int bookID, String title, String author, Boolean borrowed,String isbn, int pages) {
	    this.bookID = bookID;
      this.title = title;
	    this.author = author;
      this.borrowed = borrowed;
	    this.isbn = isbn;
	    this.pages = pages;
    }

    public int getID() {
      return this.bookID;
    }

    public String getTitle() {
      return this.title;
    }
    public void setTitle(String value) {
      this.title = value;
    }

    public String getAuthor() {
      return this.author;
    }
    public void setAuthor(String value) {
      this.author = value;
    }

    public String getIsbn() {
      return this.isbn;
    }
    public void setIsbn(String value) {
      this.isbn = value;
    }

    public int getPages() {
      return this.pages;
    }
    public void setPages(int value) {
      this.pages = value;
    }

    public void printBookInfo() {
      String isBorrowed = "";
      if (borrowed) {
      isBorrowed = "This book is unavailable.";
      } else {
      isBorrowed = "This book available.";
      }

      String string = String.format("#%d: %s, by %s.\n%s - %d pages. \n%s\n", this.bookID, this.title, this.author, this.isbn, this.pages, isBorrowed);
      System.out.println(string);
    }
}
