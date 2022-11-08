package tarea3;

public abstract class Moneda {

    public Moneda getSerie() {
        return this;
    }
    public abstract int getValor();
}

class Moneda100 extends Moneda {

    @Override
    public int getValor() {
        return 100;
    }
}
class Moneda500 extends Moneda{

    @Override
    public int getValor() {
        return 500;
  }
}
class Moneda1000 extends Moneda{

    @Override
    public int getValor() {
        return 1000;
    }
}