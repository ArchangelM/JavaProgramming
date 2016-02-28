package lesson1LibraryAlt;

import lesson1Library.Ganre;

/**
 * Created by Rodichka on 23.02.2016.
 */



public class Book {
    private int index;

    private String name;
    private String author;

    private Ganre ganre;



    public Book() {

    }

    public Book(String name, String author, Ganre ganre)  {
        setName(name);
        setAuthor(author);
        setGanre(ganre);
    }

    public void copyBook(Book receiverBook) {
        receiverBook.author = this.author;
        receiverBook.name = this.name;
        receiverBook.ganre = this.ganre;
    }

    public void  printBook() {
        System.out.println("Автор: " + author);
        System.out.println("Наименование: " + name);
        if(ganre != null) {
            System.out.println("Жанр: " + ganre);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Ganre getGanre() {
        return ganre;
    }

    public void setGanre(Ganre ganre) {
        this.ganre = ganre;
    }
}
