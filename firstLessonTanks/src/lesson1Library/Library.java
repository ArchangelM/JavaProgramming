package lesson1Library;

import static lesson1Library.Ganre.getSpecGanre;

/**
 * Created by Rodichka on 27.02.2016.
 */
public class Library {
    private final int MAX_BOOKS = 10;
    private final int PACKET_NUM_BOOK = 2;

    private int maxBooks;
    private Book[] library;
    private Ganre lastGanre; //последний жанр, который искали
    private int lastBookGanreSearch;

    private int [] ganreIndex;


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

        ganreIndex = new int[2*Ganre.getNum()];
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

        ganreIndex = new int[2*max];

        for(int i=0;i<2*max;i++) {
            ganreIndex[i] = -1;
        }
    }

    public void sortGanre() {
        Ganre ganre = Ganre.getFirstGanre();
        Book tmpBook = new Book();
        //int counter = 0;
        int forInsert =0;
        int tmp = forInsert;

        for(int i=0;i<Ganre.getNum();i++) {
            for(int j=forInsert;j<maxBooks;j++) {
                if (library[j].getGanre() == ganre) {
                    library[forInsert].copyBook(tmpBook);
                    library[j].copyBook(library[forInsert]);
                    tmpBook.copyBook(library[j]);

                    if (forInsert == tmp) {
                        ganreIndex[2*i] = tmp;
                    }

                    forInsert++;
                }

            }
            ganreIndex[2*i+1] = forInsert - 1;
            tmp = forInsert;
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
        int isGanre = 2*ganre.ordinal();

        if (ganreIndex[isGanre] != -1) {
            int i = 0;
            int j = 0;

             if (lastGanre != ganre) {
                 lastBookGanreSearch = ganreIndex[isGanre];
                 lastGanre = ganre;
             }
                //i =  lastBookGanreSearch;
                /*for (i = lastBookGanreSearch;i < ganreIndex[isGanre+1] && j < books.length;i++)
                //while(i < ganreIndex[isGanre+1])
                {
                    books[j] = new Book();
                    library[i].copyBook(books[j++]);

                }*/
            while((lastBookGanreSearch <= ganreIndex[isGanre+1]) && (j < books.length))
            {
                books[j] = new Book();
                library[lastBookGanreSearch++].copyBook(books[j++]);

            }
                if (lastBookGanreSearch > ganreIndex[isGanre+1]) {
                    lastBookGanreSearch = -1;
                    lastGanre = null;
                }

                return books;

        }

        for(int i = 0;i < books.length;i++) {
            books[i] = new Book("В библиотеки нет книг", "необходимого Вам жанра", ganre);
        }

        return books;
    }
}
