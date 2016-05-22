package lesson1LibraryAlt;

import lesson1Library.Book;
import lesson1LibraryAlt.Ganre;
import lesson1Library.Library;

/**
 * Created by Rodichka on 23.02.2016.
 */
public class LauncerLibrary {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Library library = new Library(35);
        library.sortGanre();

        lesson1Library.Book myFavoriteAuthor = library.searchAuthor("Эдгар По 2");
        myFavoriteAuthor.printBook();
        System.out.println();
        lesson1Library.Book myFavoriteBook = library.searchName("Очень интересная книга 15");
        myFavoriteBook.printBook();
        System.out.println();

        myFavoriteBook = library.searchName("Очень интересная книга вапр");
        myFavoriteBook.printBook();
        System.out.println();

        myFavoriteBook = library.searchName("Очень интересная книга 11");
        myFavoriteBook.printBook();
        System.out.println();

        Book[] myFavoriteGanreBooks = library.searchGanre(Ganre.COMPUTERS);
        for(int i=0;i < myFavoriteGanreBooks.length;i++) {
            if(myFavoriteGanreBooks[i] != null) {
                myFavoriteGanreBooks[i].printBook();
            }else break;
        }
        myFavoriteGanreBooks = library.searchGanre(Ganre.COMPUTERS);
        for(int i=0;i < myFavoriteGanreBooks.length;i++) {
            if(myFavoriteGanreBooks[i] != null) {
                myFavoriteGanreBooks[i].printBook();
            } else break;
        }



    }
}
