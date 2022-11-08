package tarea3;

public abstract class Bebida {
    private int serie;

    public Bebida(int serie) {
        this.serie = serie;
    }
    public int getSerie() {
        return serie;
    }
    public abstract String beber();
}

class CocaCola extends Bebida {

    public CocaCola(int serie) {
        super(serie);
    }
    @Override
    public String beber() {
        return "Coca-cola";
    }
}
class Fanta extends Bebida{
      
    public Fanta(int serie){
        super(serie);
    }
    public String beber(){
        return "Fanta";
    }
    
}
class Sprite extends Bebida{

    public Sprite(int serie){
        super(serie);
    }
    public String beber(){
        return "Sprite";
    }



}