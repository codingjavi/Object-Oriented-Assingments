package library;

/**
* This class is for displaying an error incase there is an invalid runtime for the video
*
* @author Student           Javier Pacheco 
*/
public class InvalidRuntimeException extends ArithmeticException {
/**
* Creates an intances of an error referencended form the super class.
*
* @since 1.0
*/
    public InvalidRuntimeException() {super();}
/**
* Creates an intances of an error with a messagereferencended form the super class.

* @param message message for that error
* @since 1.0
*/
    public InvalidRuntimeException(String message) {super(message);}


/**
* Creates an intances of the error.
*
* @param title title of the video
* @param runtime the invalid runtime of the video
* @since 1.0
*/
    public InvalidRuntimeException(String title, int runtime) {
        super( title +" has invalid runtime " + runtime);
    }
}

