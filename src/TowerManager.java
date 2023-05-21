import java.util.Stack;

public class TowerManager {
    private Disco principal;
    private int ContadorDiscos = 0;

    public int getContadorDiscos() {
        return ContadorDiscos;
    }

    public Disco getPrincipal() {
        return principal;
    }

    public TowerManager() {
        Stack<Disco> Towers = new Stack<>();
    }

    public void push(Disco disco) {
        ContadorDiscos++;
        if(principal == null){
            principal = disco;
        }else{
            disco.setAbajo(principal);
            principal.setArriba(disco);
            principal = disco;
        }
    }
    public void pop() {
        if(ContadorDiscos > 0){
            ContadorDiscos--;
            principal = principal.getAbajo();
        }
    }
    public String peek() {
        return principal.getDisco();
    }
}
