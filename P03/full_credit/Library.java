import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Publication> publications = new ArrayList<Publication>();

    public Library (String name) {
        this.name = name;
    }

    //add book to library
    public void addPublication(Publication publication) {
        this.publications.add(publication);
    }

    public void checkOut(int publicationIndex, String patron) {
        if (publicationIndex >= publications.size() ||  publicationIndex < 0 ) {
            throw new IllegalArgumentException("Invalid index, make sure to choose one of the books in the menu");
        }
        else {
            Publication currentPublication = this.publications.get(publicationIndex);
            currentPublication.checkOut(patron);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < publications.size(); ++i) {
            result.append(i + ") " + publications.get(i) + " \n");
        }

        return name + "\n\n" + result.toString();
    }
}
