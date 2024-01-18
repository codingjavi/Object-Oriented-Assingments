package library;
import java.time.Duration;

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