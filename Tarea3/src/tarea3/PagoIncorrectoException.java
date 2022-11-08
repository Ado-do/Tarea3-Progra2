package tarea3;

public class PagoIncorrectoException extends Exception {
    public static final long SerialVersionUID = 102120;

    public PagoIncorrectoException(String mensaje){
        super("PagoIncorrectoException: "  + mensaje);
    }
}
