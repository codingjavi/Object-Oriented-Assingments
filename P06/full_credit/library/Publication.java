package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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

    //constructor recreates an object from a file
    public Publication(BufferedReader br) { 
        String line;
        try {
            this.title = br.readLine();
            
            this.author = br.readLine();
            
            this.copyright = Integer.parseInt(br.readLine());
            line=br.readLine();
            if (line.equals("Checked In")) {
                this.loanedTo = null;
                this.dueDate = null;
            }
            else {
                this.loanedTo = br.readLine();
                int year = Integer.parseInt(br.readLine());
                int month = Integer.parseInt(br.readLine());
                int day = Integer.parseInt(br.readLine());
                this.dueDate = LocalDate.of(year, month, day);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(BufferedWriter bw) {
        try {
            bw.write(this.title + "\n");
            bw.write(this.author + "\n");
            bw.write("" + this.copyright + "\n");
            if (loanedTo == null) {
                bw.write("Checked In\n");
            }
            else {
                bw.write("Checked Out\n");
                bw.write(loanedTo + "\n");
                int year = this.dueDate.getYear();
                int month = this.dueDate.getMonthValue();
                int day = this.dueDate.getDayOfMonth();
                bw.write("" + year + "\n");
                bw.write("" + month + "\n");
                bw.write("" + day + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
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
    public void checkIn() {
        loanedTo = null;
        dueDate = null;
    }



    protected String toStringBuilder(String pre, String mid){
        return  pre + " " + title + " by " + author + ", copyright " + copyright + ((mid != "") ? " runtime " + mid +" minutes" : "")
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
