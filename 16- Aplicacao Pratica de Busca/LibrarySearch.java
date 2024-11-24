import java.util.Arrays;

class Book {
    String title;
    String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}

public class LibrarySearch {

    public static void main(String[] args) {
        Book[] books = {
            new Book("Book A", "978-1-234-56789-0"),
            new Book("Book B", "978-1-234-56789-1"),
            new Book("Book C", "978-1-234-56789-2"),
            new Book("Book D", "978-1-234-56789-3")
        };

        Arrays.sort(books, (b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn()));

        String isbnToFind = "978-1-234-56789-2";
        int index = binarySearch(books, isbnToFind);

        if (index != -1) {
            System.out.println("Livro encontrado: " + books[index].title);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static int binarySearch(Book[] books, String isbn) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = books[mid].getIsbn().compareTo(isbn);
            if (result == 0) return mid;
            if (result < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
