package lesson1Library;

import java.security.*;
import java.util.Arrays;

/**
 * Created by Rodichka on 23.02.2016.
 */
public class LauncerLibrary {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Library library = new Library(18);
        library.sortGanre();

        Book myFavoriteAuthor = library.searchAuthor("Эдгар По 2");
        myFavoriteAuthor.printBook();
        System.out.println();
        Book myFavoriteBook = library.searchName("Очень интересная книга 15");
        myFavoriteBook.printBook();
        System.out.println();
        myFavoriteBook = library.searchName("Очень интересная книга вапр");
        myFavoriteBook.printBook();

        Book [] myFavoriteGanreBooks = library.searchGanre(Ganre.COMPUTERS);
        for(int i=0;i < myFavoriteGanreBooks.length;i++) {
            myFavoriteGanreBooks[i].printBook();
        }



    }
}
