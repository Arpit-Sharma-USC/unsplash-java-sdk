package exceptions;

public class RequiredParameterException extends Exception {
    public RequiredParameterException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
