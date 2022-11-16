package tarea3;
import java.util.ArrayList;

class DepositoBebida {
    private ArrayList<Bebida> dep;

    public DepositoBebida() {
        this.dep = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida b) {
        this.dep.add(b);
    }
    public Bebida getBebida() {
        if (!dep.isEmpty()) {
            return this.dep.remove(0);
        } else {
            return null;
        }
    }

    public boolean quedanBebidas() {
        return dep.isEmpty();
    }
}