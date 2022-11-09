package tarea3.exceptions;

public class NoHayBebidaException extends Exception {
    public static final long SerialVersionUID = 2000;
    
    public NoHayBebidaException(String mensaje) {
        super("NoHayBebidaException: " + mensaje);
    }
}
