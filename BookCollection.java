import java.util.ArrayList;
import java.util.Scanner;

public class BookCollection {

    // clears the screen, source:
    // https://stackoverflow.com/questions/2979383/how-to-clear-the-console
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // source: https://www.asciiart.eu/books/books
        System.out.printf(
                "\n        .--.                   .---." +
                        "\n    .---|__|           .-.     |~~~|" +
                        "\n .--|===|--|_          |_|     |~~~|--." +
                        "\n |  |===|  |'\\     .---!~|  .--|   |--|" +
                        "\n |%%%%|   |  |.'\\    |===| |--|%%%%|   |  |" +
                        "\n |%%%%|   |  |\\.'\\   |   | |__|  |   |  |" +
                        "\n |  |   |  | \\  \\  |===| |==|  |   |  |" +
                        "\n |  |   |__|  \\.'\\ |   |_|__|  |~~~|__|" +
                        "\n |  |===|--|   \\.'\\|===|~|--|%%%%|~~~|--|" +
                        "\n ^--^---'--^    `-'`---^-^--^--^---'--' \n");
        System.out.println("\t    " + "BOOK COLLECTION!\n");

        // default books
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("Animal Farm", "George Orwell", 1945));

        // main loop, runs until user enters 5
        while (true) {
            System.out.println("\nSELECT AN OPTION:");
            System.out.println("1 to add a book to your collection.");
            System.out.println("2 to remove a book from your collection.");
            System.out.println("3 to display all the books in your collection.");
            System.out.println("4 to search for a book in your collection.");
            System.out.println("5 to quit the program.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearScreen();

                    System.out.printf("Enter the name of the book you want to add: ");
                    String title = scanner.nextLine();

                    System.out.printf("Enter the author: ");
                    String author = scanner.nextLine();

                    System.out.printf("Enter the publication year: ");
                    int publicationYear = scanner.nextInt();

                    scanner.nextLine(); // consume the newline character

                    Book newBook = new Book(title, author, publicationYear);
                    books.add(newBook);

                    break;

                case 2:
                    clearScreen();

                    System.out.printf("Enter the name of the book you want to remove: ");
                    String titleToRemove = scanner.nextLine();

                    boolean bookFound = false;
                    for (int i = 0; i < books.size(); i++) {
                        Book currentBook = books.get(i);
                        if (currentBook.getTitle().equals(titleToRemove)) {
                            books.remove(currentBook);
                            bookFound = true;
                            System.out.println("Book removed successfully!");
                            break;
                        }
                    }

                    if (!bookFound) {
                        System.out.println("Book not found in your collection.");
                    }
                    break;

                case 3:
                    clearScreen();

                    if (books.isEmpty()) {
                        System.out.println("Your book collection is empty.");
                    } else {
                        System.out.println("Your book collection:");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i).getAuthor() + " - "
                                    + books.get(i).getTitle() + " (" + books.get(i).getYearPublished() + ")");
                        }
                    }
                    break;

                case 4:
                    clearScreen();

                    System.out.print("Enter the title of the book you want to search for: ");
                    String bookTitle = scanner.nextLine();

                    bookFound = false;
                    for (Book book : books) {
                        if (book.getTitle().equals(bookTitle)) {
                            System.out.println("\nBook found in collection!");
                            System.out.println(book.getAuthor() + " - " + book.getTitle() + " ("
                                    + book.getYearPublished() + ")");
                            bookFound = true;
                            break;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("Book not found in collection.");
                    }
                    break;

                case 5:
                    clearScreen();
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}
