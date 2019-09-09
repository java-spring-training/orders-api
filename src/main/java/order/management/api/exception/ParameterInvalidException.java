package order.management.api.exception;

public class ParameterInvalidException extends Exception {

    private static final long serialVersionUID = 61909828277801313L;

    public ParameterInvalidException(String message) {
        super(message);
    }
}
