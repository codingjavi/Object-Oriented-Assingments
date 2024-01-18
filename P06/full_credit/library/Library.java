package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    //constructor recreates an object from a file
    public Library(BufferedReader br) { 
        //BufferedReader br = new BufferedReader(new FileReader((args[0])));
        try {
            this.name = br.readLine();

            int size = Integer.parseInt(br.readLine());

            for(int i=0; i < size; i++){
                String check = br.readLine();
                if(check.equals("video")){
                    Video object = new Video(br);
                    this.publications.add(object);
                }
                else{
                    Publication object = new Publication(br);
                    this.publications.add(object);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //save method adds the objects fiels to a file
    public void save(BufferedWriter bw) {
        try {
            bw.write(this.name + "\n");
            int size = publications.size();
            bw.write(Integer.toString(size) + "\n");

            for (int i = 0; i < size; ++i) {
                
                if (publications.get(i) instanceof Video) {
                    bw.write("video\n");
                    publications.get(i).save(bw);
                } else {
                    bw.write("publication\n");
                    publications.get(i).save(bw);
                }
            }


            bw.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
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
        try {
            Publication currentPublication = this.publications.get(publicationIndex);
            currentPublication.checkOut(patron);
        } catch(Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex 
                + ": " + e.getMessage() + "\n");
        }
    }

    public void checkIn(int publicationIndex) {
        Publication currentPublication = this.publications.get(publicationIndex);
        currentPublication.checkIn();
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
