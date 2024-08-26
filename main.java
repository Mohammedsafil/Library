
package Library;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){
        Library library = new Library();

        Fiction book1 = new Fiction("The Great Gatsby", "F. Scott Fitzgerald", 12345, "Classic");
        Fiction book2 = new Fiction("Harry Potter", "J.K. Rowling", 67890, "Fantasy");
        NonFiction book3 = new NonFiction("Sapiens", "Yuval Noah Harari", 11223, "History");
        NonFiction book4 = new NonFiction("Educated", "Tara Westover", 44556, "Memoir");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        
        System.out.println("All books in the library:");
        library.displayAllBooksDetails();

        
        System.out.println("Searching for book by title 'Harry Potter':");
        library.searchByTitle("Harry Potter");

        
        System.out.println("Searching for books by author 'Yuval Noah Harari':");
        library.searchByAuthor("Yuval Noah Harari");
    }
}
class Book{
    private String title;
    private String author;
    private int id;

    public Book(String title,String author, int id){
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public void displayBookDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: "+author);
        System.out.println("ID: "+id);
    }

    public String getTitle(){return title;}
    public String getAuthor(){return author;}
}

class Fiction extends Book{
    private String genre;

    public Fiction(String title, String author, int id, String genre){
        super(title, author, id);
        this.genre = genre;
    }

    public void displayBookDetails(){
        super.displayBookDetails();
        System.out.println("Genre: "+ genre);
    }

    public String getTitle(){
        return super.getTitle();
    }
    public String getAuthor(){
        return super.getAuthor();
    }

}

class NonFiction extends Book{
    private String genreN;

    public NonFiction(String title, String author, int id, String Genre){
        super(title, author, id);
        this.genreN = genreN;
    }

    public void displayBookDetails(){
        super.displayBookDetails();
        System.out.println("Genre: "+genreN);
    }

    
    public String getTitle(){
        return super.getTitle();
    }
    public String getAuthor(){
        return super.getAuthor();
    }
}


class Library{
    private List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void searchByTitle(String title){
        boolean found = false;

        for(Book book : books){
            if(book.getTitle().equals(title)){
                System.out.println("Book found");
                book.displayBookDetails();
                found = true;
            }
        }
        if(!found){
            System.out.println("No book found");
        }
    }

    public void searchByAuthor(String author){
        boolean found = false;
        for(Book book : books){
            if(book.getAuthor().equals(author)){
                System.out.println("Book Found");
                book.displayBookDetails();
                found = true;
            }
        }
        if(!found){
            System.out.println("Book not found");
        }
    }

    public void displayAllBooksDetails(){
        if(books.isEmpty()){
            System.out.println("No books in the library");
        }
        else{
            for(Book book : books){
                book.displayBookDetails();
                System.out.println();
            }
        }
    }
}