package library;
import java.util.ArrayList;

/**
* This class is for creating a library instance where you can add publications and checkout books/videos.
*
* @author Student           Javier Pacheco 
*/
public class Library {
    private String name;
    private ArrayList<Publication> publications = new ArrayList<Publication>();

/**
* Creates a Library instance.
*
* @param name the name of the library
* @since 1.0
*/
    public Library (String name) {
        this.name = name;
    }

/**
*Adds a book/video to the library.
*
* @param publication the book/video object
* @since 1.0
*/
    public void addPublication(Publication publication) {
        this.publications.add(publication);
    }

/**
* Checks out a book from the Library.
*
* @param publicationIndex which book to check out
* @param patron the patron that wants to check out the book
* @since 1.0
*/
    public void checkOut(int publicationIndex, String patron) {
        Publication currentPublication = this.publications.get(publicationIndex);
        currentPublication.checkOut(patron);
    }

/**
* Displays which books are currently in the library and if anyone has checked them out.
*
* @since 1.0
*/
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i){
            buffer.append("" + i + ") " + publications.get(i).toString() + "\n");
        }
        return buffer.toString();
        

    }
}
