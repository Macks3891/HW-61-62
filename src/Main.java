import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Главный класс для тестирования библиотеки.
 */
public class Main {
    public static void main(String[] args) {

        Library library = new Library();


        Book book1 = new Book(1, "Мёртвые души", "Николай Гоголь", true);
        Book book2 = new Book(2, "Преступление и наказание", "Фёдор Достоевский", false);
        Book book3 = new Book(3, "Война и мир", "Лев Толстой", true);
        Book book4 = new Book(4, "Мастер и Маргарита", "Михаил Булгаков", false);
        Book book5 = new Book(5, "Евгений Онегин", "Александр Пушкин", true);
        Book book6 = new Book(6, "Братья Карамазовы", "Фёдор Достоевский", false); // Вторая книга автора Фёдор Достоевский


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);


        System.out.println("Все книги в библиотеке:");
        library.getBooks().forEach(System.out::println);


        System.out.println("\nДоступные книги:");
        library.getBooks(true).forEach(System.out::println);


        System.out.println("\nНедоступные книги:");
        library.getBooks(false).forEach(System.out::println);


        System.out.println("\nОбщее количество книг: " + library.getTotalBooksCount());


        System.out.println("Количество доступных книг: " + library.getBooksCount(true));


        System.out.println("Количество недоступных книг: " + library.getBooksCount(false));


        System.out.println("\nАвторы:");
        library.getAuthors().forEach(System.out::println);


        System.out.println("\nКниги, отсортированные по автору:");
        library.getBooks(Comparator.comparing(Book::getAuthor)).forEach(System.out::println);


        System.out.println("\nКниги, разделенные по доступности:");
        Map<Boolean, List<Book>> partitionedBooks = library.partitionBooksByAvailability();
        System.out.println("Доступные книги: " + partitionedBooks.get(true));
        System.out.println("Недоступные книги: " + partitionedBooks.get(false));


        System.out.println("\nКниги, сгруппированные по авторам:");
        Map<String, List<Book>> groupedBooks = library.groupBooksByAuthor();
        groupedBooks.forEach((author, booksList) -> {
            System.out.println("Автор: " + author);
            booksList.forEach(System.out::println);
        });
    }
}