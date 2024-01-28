import javax.swing.SwingUtilities;

import user.LoginPage;

public class Main {
    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> {
            new LoginPage();
            
        });
    }
}