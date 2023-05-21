import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
    public class Main {
        public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Ventana MainForm = new Ventana();
                    MainForm.setContentPane(MainForm.getMainPanel());
                    MainForm.setBounds(100,100,800,500);
                    MainForm.setVisible(true);
                    MainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                }
            });
        }
    }