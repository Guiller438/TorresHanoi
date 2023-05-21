import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{

    int cantidadNummov = 0;
    boolean jugar = false;
    TowerManager TowerA = new TowerManager();
    TowerManager TowerB = new TowerManager();
    TowerManager TowerC = new TowerManager();
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton TorreA_B;
    private JButton TorreA_C;
    private JButton TorreB_A;
    private JButton TorreB_C;
    private JButton TorreC_A;
    private JButton TorreC_B;
    private JComboBox comboBox1;
    private JTextField txtminimomov;
    private JTextField txtnummovimientos;
    private JButton iniciarButton;
    private JButton reiniciarButton;
    private JButton resolverButton;



    public Ventana() {
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              IniciarJuego();
              Presentar(TowerA,textArea1);
            }
        });

        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cantidadNummov == 0){
                    JOptionPane.showMessageDialog(null,"No hay movimientos para reiniciar");
                }else{
                    comboBox1.setSelectedIndex(0);
                    IniciarJuego();
                }
            }
        });
        TorreA_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoverDisco(TowerA,TowerB);
                if(TowerB.getContadorDiscos() == Integer.parseInt(comboBox1.getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null,"Lo hiciste excelente y hiciste "+cantidadNummov+" movimientos");
                }
                Presentar(TowerA,textArea1);
                Presentar(TowerB,textArea2);
            }
        });
        TorreA_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoverDisco(TowerA,TowerC);
                if(TowerC.getContadorDiscos() == Integer.parseInt(comboBox1.getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null,"Lo hiciste excelente y hiciste "+cantidadNummov+" movimientos");
                }
                Presentar(TowerC,textArea3);
                Presentar(TowerA,textArea1);

            }
        });
        TorreB_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoverDisco(TowerB,TowerA);
                Presentar(TowerB,textArea2);
                Presentar(TowerA,textArea1);
            }
        });
        TorreB_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoverDisco(TowerB,TowerC);
                if(TowerC.getContadorDiscos() == Integer.parseInt(comboBox1.getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null,"Lo hiciste excelente y hiciste "+cantidadNummov+" movimientos");
                }
                Presentar(TowerC,textArea3);
                Presentar(TowerB,textArea2);
            }
        });
        TorreC_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoverDisco(TowerC,TowerA);
                Presentar(TowerC,textArea3);
                Presentar(TowerA,textArea1);
            }
        });
        TorreC_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoverDisco(TowerC,TowerB);
                if(TowerB.getContadorDiscos() == Integer.parseInt(comboBox1.getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null,"Lo hiciste excelente y hiciste "+cantidadNummov+" movimientos");
                }
                Presentar(TowerC,textArea3);
                Presentar(TowerB,textArea2);

            }
        });
        resolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TowerC.getContadorDiscos() == Integer.parseInt(comboBox1.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(null, "Ya esta resuelto");
                } else {
                    ResolverHanoi(Integer.parseInt(comboBox1.getSelectedItem().toString()), TowerA, TowerB, TowerC);
                }
                Presentar(TowerC, textArea3);
                Presentar(TowerB, textArea2);
                Presentar(TowerA, textArea1);
            }
        });
    }
    private void cantidadMovimientos(){
        cantidadNummov++;
        txtnummovimientos.setText(""+cantidadNummov);
    }

    private void Presentar(TowerManager Tower, JTextArea textArea){
        textArea.setText("");
        Disco d;
        if(Tower.getContadorDiscos() > 0){
            for(d = Tower.getPrincipal(); d.getAbajo() != null; d = d.getAbajo()){
                String[] disco = {d.getDisco()};
                textArea.append(disco[0]+"\n");
            }
            if(d.getAbajo() == null){
                String[] disco = {d.getDisco()};
                textArea.append(disco[0]+"\n");
            }
        }
    }

    private void IniciarJuego(){
        cantidadNummov = 0;
        TowerA = new TowerManager();
        TowerB = new TowerManager();
        TowerC = new TowerManager();
        int cantidadDiscos = Integer.parseInt(comboBox1.getSelectedItem().toString());
        txtminimomov.setText(""+((Math.pow(2,cantidadDiscos))-1));
        txtnummovimientos.setText(""+cantidadNummov);
        for (int i = cantidadDiscos; i > 0; i--){
            Disco nivel = new Disco();
            String disco = "";
            for (int j = i; j > 0; j--){
                disco += "#";
            }
            nivel.setDisco(disco);
            TowerA.push(nivel);
        }
        Presentar(TowerA,textArea1);
        Presentar(TowerB,textArea2);
        Presentar(TowerC,textArea3);
    }

    public void MoverDisco(TowerManager origen, TowerManager destino){
        if(origen.getContadorDiscos() == 0) {
            JOptionPane.showMessageDialog(null, "No hay discos para mover");
        }else{
            Disco disco = new Disco();
            disco.setDisco(origen.peek());
                if(destino.getContadorDiscos() > 0){
                       if(disco.getDisco().compareTo(destino.peek()) > 0){
                           return;
                       }
                }
            origen.pop();
            destino.push(disco);
            cantidadMovimientos();
        }
    }

    private void Resolver(TowerManager origen, TowerManager Destino){
        if(!jugar){
            Disco disco = new Disco();
            disco.setDisco(origen.peek());
            origen.pop();
            Destino.push(disco);
            cantidadMovimientos();
            Presentar(TowerA,textArea1);
            Presentar(TowerB,textArea2);
            Presentar(TowerC,textArea3);
            int opt = (int) JOptionPane.showConfirmDialog(null,"Paso #" +cantidadNummov +"¿Desea continuar?");
            if(opt == JOptionPane.NO_OPTION)
                jugar = true;
        }
    }
    private void ResolverHanoi(int n, TowerManager origen, TowerManager auxiliar, TowerManager destino){
        if(n == 1){
            Resolver(origen,destino);
        }else{
            ResolverHanoi(n-1,origen,destino,auxiliar);
            Resolver(origen,destino);
            ResolverHanoi(n-1,auxiliar,origen,destino);
        }
    }


    public JPanel getMainPanel(){
        return panel1;
    }

}
