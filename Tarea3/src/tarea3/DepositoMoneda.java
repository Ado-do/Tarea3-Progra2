package tarea3;
import java.util.ArrayList;

public class DepositoMoneda {   //* (DepositoVuelto -> DepositoMoneda) Modificado en gran medida (el nuestro no era tan compatible con el enuncidado de la tarea 3)
    private ArrayList<Moneda> dep;

    public DepositoMoneda() {
        dep = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda m) {
        if (m != null) dep.add(m);
    }

    public Moneda getMoneda() {
        return (dep.isEmpty()) ? null : dep.remove(0);
    }
    
    public boolean isEmpty() {
        return dep.isEmpty();
    }
}