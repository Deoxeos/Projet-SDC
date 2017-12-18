package Exception;

@SuppressWarnings("serial")
public class IncompatibleTypeException extends ProcessingException {

    public IncompatibleTypeException() {
	super();
    }

    public IncompatibleTypeException(String s) {
	super(s);
    }

};