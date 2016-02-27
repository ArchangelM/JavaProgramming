package lesson1Library;

import static lesson1Library.Ganre.getSpecGanre;

/**
 * Created by Rodichka on 27.02.2016.
 */
public class Library {
    private final int MAX_BOOKS = 10;
    private final int PACKET_NUM_BOOK = 2;

    int maxBooks;
    private Book[] library;
    private Ganre lastGanre; //последний жанр, который искали
    private int lastBookGanreSearch;


    public Library(){
        library = new Book[MAX_BOOKS];
        maxBooks = MAX_BOOKS;
        for(int i=0;i<maxBooks;i++) {
            String name = "Очень интересная книга " + Integer.toString(10+i);
            String author = "Эдгар По " + Integer.toString(i);
            Ganre ganre  = getSpecGanre(i);
            library[i] = new Book(name, author, ganre);
        }
        lastBookGanreSearch = -1;
    }

    public Library(int max){
        library = new Book[max];
        maxBooks = max;
        for(int i=0;i<maxBooks;i++) {
            String name = "Очень интересная книга " + Integer.toString(10+i);
            String author = "Эдгар По " + Integer.toString(i);
            Ganre ganre  = getSpecGanre(i);
            library[i] = new Book(name, author, ganre);
        }
        lastBookGanreSearch = -1;
    }

    public void sortGanre() {
        Ganre ganre = Ganre.getFirstGanre();
        Book tmpBook = new Book();
        //int counter = 0;
        int forInsert =0;

        for(int i=0;i<Ganre.getNum();i++) {
            for(int j=forInsert;j<maxBooks;j++) {
                if (library[j].getGanre() == ganre) {
                    library[forInsert].copyBook(tmpBook);
                    library[j].copyBook(library[forInsert]);
                    tmpBook.copyBook(library[j]);
                    forInsert++;
                }
            }

            ganre = Ganre.getNextGanre(ganre);
        }
    }

    public Book searchAuthor(String author) {
        int i = 0;

        while (i < maxBooks) {
            if(author.equals(library[i].getAuthor())) {
                return library[i];
            }
            i++;
        }
        return new Book("В библиотеки нет такого автора", author, null);
    }

    public Book searchName(String name) {
        int i = 0;

        while (i < maxBooks) {
            if(name.equals(library[i].getName())) {
                return library[i];
            }
            i++;
        }
        return new Book(name, "В библиотеки нет такой книги", null);
    }

    public Book[] searchGanre(Ganre ganre) {
        Book [] books = new Book[PACKET_NUM_BOOK];

        for(int i=0;i < PACKET_NUM_BOOK;i++) {
            books[i] = new Book("В библиотеки нет книг", "необходимого Вам жанра", ganre);
        }

        return books;
    }
}
