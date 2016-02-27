package lesson1Library;

import static lesson1Library.Ganre.getSpecGanre;

/**
 * Created by Rodichka on 27.02.2016.
 */
public class Library {
    final int MAX_BOOKS = 10;
    private Book[] library = new Book[MAX_BOOKS];

    public void Library() {
        for(int i=0;i<MAX_BOOKS;i++) {
            String name = "Очень интересная книга " + Integer.toString(10+i);
            String author = "Эдгар По " + Integer.toString(i);
            Ganre ganre  = getSpecGanre(i);
            library[i] = new Book(name, author, ganre);
        }
    }
}
