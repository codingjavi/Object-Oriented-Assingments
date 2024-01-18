package mdi;
import library.Library;
import library.Publication;
import library.Video;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class LibraryManager {
    Scanner in = new Scanner(System.in);

    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void listPublications() {
        System.out.println(library);
    }

    public void addPublication() {
        System.out.print("Title: ");
        String title = in.nextLine();
        System.out.print("Author: ");
        String author = in.nextLine();
        System.out.print("Copyright: ");
        int copyright = in.nextInt();
        System.out.print("Runtime (-1 if book): ");
        int runtime = in.nextInt();

        if (runtime == -1){
            Publication newBook = new Publication(title, author, copyright);
            library.addPublication(newBook);
        }
        else {
            Video newVideo = new Video(title, author, copyright, runtime);
            library.addPublication(newVideo);
        }
    }

    public void chechOutPublication() {
        System.out.println(library);

        System.out.print("Which publication do you want to check out? ");
        int publicationIndex = in.nextInt();

        in.nextLine();

        System.out.print("Who are you? ");
        String name = in.nextLine();
        library.checkOut(publicationIndex, name);
    }

    public void checkInPublication() {
        System.out.println(library);

        System.out.print("Which publication are you checking in? ");
        int publicationIndex = in.nextInt();

        library.checkIn(publicationIndex);
    }

    public void saveLibrary() {

        System.out.print("File name: ");
        String trailingNewline = in.nextLine();
        String fileName = in.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            library.save(bw);
        } catch (Exception e) {
        System.err.println("Failed to write: " + e); System.exit(-1);
        }
    }

    public void openLibrary() {
        System.out.print("File name: ");
        String fileName = in.nextLine();
        //String trailingNewline = in.nextLine();
        Library library = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            library = new Library(br);
            this.library = library;
        } catch (Exception e) {
            System.err.println("Failed to read: " + e); System.exit(-2);
        }
    }


    public static void main(String [] args){
        
            Library myLibrary = new Library("Javier's Library");

            LibraryManager myLibraryManager = new LibraryManager(myLibrary);
      
            Scanner in = new Scanner(System.in);

            while (true) {
                try { 
                    System.out.println("\nMain Menu \n");
                    System.out.println("Javier's Library\n");
                    System.out.println("0) Exit");
                    System.out.println("1) List");
                    System.out.println("2) Add");
                    System.out.println("3) Check out");
                    System.out.println("4) Check in");
                    System.out.println("5) Save");
                    System.out.println("6) Open\n");
                    System.out.print("Selection: ");
                    int selection = in.nextInt();
                    in.nextLine();
                    
                    if (selection == 0) {
                        break;
                    }
                    else if(selection == 1) {
                        myLibraryManager.listPublications();
                    }
                    else if(selection == 2) {
                        myLibraryManager.addPublication();
                    }
                    else if(selection == 3) {
                        myLibraryManager.chechOutPublication();
                    }
                    else if(selection == 4) {
                        myLibraryManager.checkInPublication();
                    }
                    else if(selection == 5) {
                        myLibraryManager.saveLibrary();
                    }
                    else if(selection == 6) {
                        myLibraryManager.openLibrary();
                    }

                } catch (Exception e) {
                    System.err.println("Error - " + e.getMessage());
                }
            }
            
    }
}