public class Main {
    public static void main(String[] args) {

        Book book = new Book("Война и мир", 1869, "Лев Толстой", 1225);

        System.out.println("Большая книга? " + book.isBig());
        System.out.println("Совпадение с 'Толстой'? " + book.matches("Толстой"));
        System.out.println("Цена книги" + book.estimatePrice());

    }
}
