package tarea3.exceptions;

public class CompraEnProcesoException extends Exception {
    public static final long SerialVersionUID = 1250;
    
    public CompraEnProcesoException(String mensaje) {
        super("CompraEnProcesoException: " + mensaje);
    }
}
