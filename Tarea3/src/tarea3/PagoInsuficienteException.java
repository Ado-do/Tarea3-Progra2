package tarea3;

public class PagoInsuficienteException extends Exception{
    public static final long SerialVersionUID = 22020;

    public PagoInsuficienteException(String mensaje){
        super("PagoInsuficienteException: " + mensaje);
    }
}