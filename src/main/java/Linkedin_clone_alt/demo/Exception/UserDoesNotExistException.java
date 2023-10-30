package Linkedin_clone_alt.demo.Exception;


public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
