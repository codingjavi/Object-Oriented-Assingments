package mdi;
import library.Library;
import library.Publication;
import library.Video;

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

    


    public static void main(String [] args){
            Library myLibrary = new Library("Javier's Library");

            Publication inColdBlood = new Publication("In Cold Blood", "Truman Capote", 1966);
            Publication theThingsTheyCarried = new Publication("The Things They Carries", "Tim O'Brien", 1990);
            Publication intoTheWild = new Publication("Into the Wild", "Jon Krakauer", 1996);

            Video nope = new Video("Nope", "Jordan Peele", 2022, 250);
            Video hereditary = new Video("Hereditary", "Ari Aster", 2018, 180);
            Video whiplash = new Video("Whiplash", "Damien Chazelle", 2014, 100);

            myLibrary.addPublication(inColdBlood);
            myLibrary.addPublication(theThingsTheyCarried);
            myLibrary.addPublication(intoTheWild);
            myLibrary.addPublication(nope);
            myLibrary.addPublication(hereditary);
            myLibrary.addPublication(whiplash);

            LibraryManager myLibraryManager = new LibraryManager(myLibrary);

            Scanner in = new Scanner(System.in);

            while (true) {
                System.out.println("\nMain Menu \n");
                System.out.println("Javier's Library\n");
                System.out.println("0) Exit");
                System.out.println("1) List");
                System.out.println("2) Add");
                System.out.println("3) Check out");
                System.out.println("4) Check in\n");
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

            }
            
    }
}