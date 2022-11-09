package tarea3;

public class test {
    public static void main(String[] args) {
        // 1: CocaCola, 2: Fanta, 3: Sprite.

        // Caso 1: Toma bebida y dice que tomó.
        System.out.println("* Adodo:");
        Moneda milpesos = new Moneda1000();
        Expendedor Maquina1 = new Expendedor(4,1000);
        Comprador Adodo = new Comprador(milpesos, 2, Maquina1);
        System.out.println(Adodo.queBebiste());
        System.out.println(Adodo.cuantoVuelto());
        System.out.print("\n");

        // Caso 2: Intenta comprar la bebida con menos plata.
        System.out.println("* Krozz:");
        Moneda gamba = new Moneda100();
        Expendedor Maquina2 = new Expendedor(7,1000);
        Comprador Krozz = new Comprador(gamba,1, Maquina2);
        System.out.println(Krozz.queBebiste());
        System.out.println(Krozz.cuantoVuelto());
        System.out.print("\n");
        
        // Caso 3: Intenta comprar, pero la maquina no tiene bebidas.
        System.out.println("* Masok:");
        Moneda lukita = new Moneda1000();
        Expendedor Maquina3 = new Expendedor(0,1000);
        Comprador Masok = new Comprador(lukita, 2, Maquina3);
        System.out.println(Masok.queBebiste());
        System.out.println(Masok.cuantoVuelto());
        System.out.print("\n");
        
        // Caso 4: Intenta comprar, pero la maquina no tiene bebidas.
        System.out.println("* Kevin:");
        Moneda nullito = null;
        Expendedor Maquina4 = new Expendedor(0,1000);
        Comprador Kevin = new Comprador(nullito, 2, Maquina4);
        System.out.println(Kevin.queBebiste());
        System.out.println(Kevin.cuantoVuelto());
        System.out.print("\n");

        // Caso 5: Intenta comprar, pero la maquina no tiene bebidas.
        System.out.println("* Mati:");
        Moneda money = new Moneda1000();
        Expendedor Maquina5 = new Expendedor(5,1000);
        Comprador Mati = new Comprador(money, 0, Maquina5);
        System.out.println(Mati.queBebiste());
        System.out.println(Mati.cuantoVuelto());
        System.out.print("\n");
    }
}
