import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManager {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        Library myLibrary = new Library("Javier's Library");
        Publication inColdBlood = new Publication("In Cold Blood", "Truman Capote", 1966);
        Publication theThingsTheyCarried = new Publication("The Things They Carries", "Tim O'Brien", 1990);
        Publication intoTheWild = new Publication("Into the Wild", "Jon Krakauer", 1996);



        myLibrary.addPublication(inColdBlood);
        myLibrary.addPublication(theThingsTheyCarried);
        myLibrary.addPublication(intoTheWild);

        System.out.println(myLibrary);

        System.out.print("Which book to check out? ");
        int publicationIndex = 100;
        try {
            publicationIndex = in.nextInt();
        } 
        catch (InputMismatchException e) {
            System.err.println("Enter a real number");
        }
        

        in.nextLine();

        System.out.print("Who are you? ");
        String name = in.nextLine();

        try {
            //Integer.parseInt(String.valueOf(publicationIndex));
            myLibrary.checkOut(publicationIndex, name);
        } 
        catch(Exception e) {
            System.err.println(e.getMessage());
        } 

        System.out.println(myLibrary);

    }
}