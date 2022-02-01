package utils;

// Exception Class thrown if customers or employees birthdate input is in the future.
public class ImpossibleBirthdateException extends Exception{
    public ImpossibleBirthdateException(String errorMessage){
        super(errorMessage);
    }
}
