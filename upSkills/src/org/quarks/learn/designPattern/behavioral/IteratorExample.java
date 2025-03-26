package org.quarks.learn.designPattern.behavioral;

import java.util.ArrayList;
import java.util.List;

// Step 1: Create the Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }
}

// Step 2: Create the Iterator Interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Step 3: Create the Aggregate Interface
interface Aggregate {
    Iterator createIterator();
}

// Step 4: Create Concrete Iterator for BookCollection
class BookIterator implements Iterator {
    private List<Book> books;
    private int index;

    public BookIterator(List<Book> books) {
        this.books = books;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return books.get(index++);
        }
        return null;
    }
}

// Step 5: Create Concrete Aggregate for Book Collection
class BookCollection implements Aggregate {
    private List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}

// Step 6: Client Code
public class IteratorExample {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();

        // Adding books to the collection
        bookCollection.addBook(new Book("1984", "George Orwell"));
        bookCollection.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        bookCollection.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));

        // Creating iterator to traverse the collection
        Iterator iterator = bookCollection.createIterator();

        // Iterating through the collection
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book);
        }
    }
}

