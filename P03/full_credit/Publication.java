import java.time.LocalDate;

public class Publication {
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

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

    public void checkOut(String patron){
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusDays(14);
        this.loanedTo = patron;
        this.dueDate = dueDate;
    }
    
    public void checkIn(){

    }
    @Override
    public String toString(){
        if (loanedTo != null){
            return loanedTo + " checked out " + title + " by " + author + ", copyright " + copyright + " and will be due on " + dueDate;
        }
        else {
            return title + " by " + author + ", copyright " + copyright + " has not been loaned to anyone yet";
        }
         
    }

}
