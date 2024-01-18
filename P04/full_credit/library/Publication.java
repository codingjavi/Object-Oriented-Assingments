package library;
import java.time.LocalDate;

/**
* This class is for creating a publication (books) it is a super class for Video
*
* @author Student           Javier Pacheco 
*/
public class Publication {
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;


/**
* Creates a publication instance.
*
* @param title title of the publication
* @param author author of the publication
* @param copyright copyright of the publication
* @since 1.0
*/
    public Publication(String title, String author, int copyright){
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        this.title = title;
        this.author = author;
        this.copyright = copyright;
        
        if (copyright < 1900 || copyright > currentYear) {
            throw new IllegalArgumentException("Copyright should be between 1900 and Present Year");
        }
    }

/**
* Check out the publication.
*
* @param patron the patron checking out the publication
* @since 1.0
*/
    public void checkOut(String patron){
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusDays(14);
        this.loanedTo = patron;
        this.dueDate = dueDate;
    }

/**
* Builds and displays the results of the out put of the video or book.
*
* @param pre defines if we're displaying a book or a video
* @param mid defined the number of minutes if pre equals "Video"
* @since 1.0
*/
    public void checkIn(){

    }



    protected String toStringBuilder(String pre, String mid){
        return  pre + "title" + " by " + author + ", copyright " + copyright + ((mid != "") ? " runtime " + mid +" minutes" : "")
            + ((loanedTo != null) ? "\n  : loaned to " + loanedTo + " until " + dueDate
                                  : ""); 
    }

/**
* Display the information of the publication along with if it is check out and by who.
*
* @since 1.0
*/
    @Override
    public String toString(){
        return toStringBuilder("Book", "");
         
    }

}
