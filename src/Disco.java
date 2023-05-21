public class Disco {
    private String disco;
    private Disco arriba;
    private Disco abajo;

    public Disco() {

    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public String getDisco() {
        return disco;
    }

    public Disco getArriba() {
        return arriba;
    }

    public void setArriba(Disco arriba) {
        this.arriba = arriba;
    }

    public Disco getAbajo() {
        return abajo;
    }

    public void setAbajo(Disco abajo) {
        this.abajo = abajo;
    }
}
