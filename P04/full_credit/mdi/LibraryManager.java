package mdi;
import library.Library;
import library.Publication;
import library.Video;

import java.util.Scanner;

public class LibraryManager {
    public static void main(String [] args){
        try {
            Scanner in = new Scanner(System.in);

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

            System.out.println(myLibrary);

            System.out.print("Which book to check out? ");
            int publicationIndex = in.nextInt();

            in.nextLine();

            System.out.print("Who are you? ");
            String name = in.nextLine();
            myLibrary.checkOut(publicationIndex, name);
            System.out.println(myLibrary);
        } catch(Exception e) {
            System.err.println("There was an error \n" + e);
        } 
    }
}