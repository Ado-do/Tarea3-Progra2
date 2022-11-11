package tarea3;
import java.util.ArrayList;
public class DepositoVuelto {   //* Modificado en gran medida (el nuestro no era tan compatible con el enuncidado de la tarea 3)
    // private ArrayList<Moneda100> vuelto;
    // private Moneda devolucion;
    private ArrayList<Moneda> dep;

    public DepositoVuelto() {
        // vuelto = new ArrayList<Moneda100>();
        // devolucion = null;
        dep = new ArrayList<Moneda>();
    }

    public Moneda getVuelto() {
        // // Si hay que devolver moneda
        // if (devolucion != null) {
            //     Moneda aux = devolucion;
            //     devolucion = null;
            //     return aux;
            
            // // Si no, se devuelve vuelto en monedas de 100
            // } else {
                //     if (!vuelto.isEmpty()) {
                    //         return vuelto.remove(0);
                    //     } else {
                        //         return null;
                        //     }
                        // }
        return dep.remove(0);
    }
    public void generarVuelto(int cuantoVuelto) {
        int cantMonedas = cuantoVuelto/100;
        for (int i = 0; i < cantMonedas; i++) {
            dep.add(new Moneda100());
        }
    }
    public void guardarDevolucion(Moneda m) {
        // devolucion = m;
        dep.add(m);
    }
}