package impacta.exceptions;

public class EmailInexistenteException extends RuntimeException {
    public EmailInexistenteException(String message) {
        super(message);
    }
}
