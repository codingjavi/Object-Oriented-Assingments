package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

/**
* This class is for creating video that can be checked out of the library, it inherites form Publication.
*
* @author Student           Javier Pacheco 
*/
public class Video extends Publication {
    private Duration runtime;

/**
* Creates a Video instance.
*
* @param title the title of the video
* @param author the author of the video
* @param copyright the copyright of the video
* @param runtime the runtime of the video
* @since 1.0
*/
    public Video(String title, String author, int copyright, int runtime) {
        super(title, author, copyright);
        if (runtime <= 0){
            throw new InvalidRuntimeException(title, runtime);
        }
        else {
            this.runtime = Duration.ofMinutes(runtime);
        }
    }

    public Video(BufferedReader br) { 
        super(br);
        try {
            
            long minutes = Long.parseLong(br.readLine());

            this.runtime = Duration.ofMinutes(minutes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(BufferedWriter bw) {
        super.save(bw);
        long minutes = this.runtime.toMinutes();
        String durationString = Long.toString(minutes);
        try {
            bw.write("" + durationString + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
/**
* Creates a displays the content of the video object.
*
* @since 1.0
*/
    @Override
    public String toString() {
        return toStringBuilder("Video", Long.toString(this.runtime.toMinutes()));
    }
}