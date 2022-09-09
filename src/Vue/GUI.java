package Vue;


import Models.DataScooter;
import Models.Parc;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {

    public static boolean windowOpen = false;

    public static void main(String[] args) {

        App app = new App();

        DataScooter dataParc = new DataScooter();
        Parc parc = dataParc.LoadData();

        if (parc == null) {
            parc = app.evryParc;
            System.out.println("No save found");
        }



        JFrame frame = new JFrame("LOUSCOOT");
        frame.setContentPane(new Login(parc, frame));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 600);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Parc finalParc = parc;
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dataParc.SaveData(finalParc);

            }
        });


    }


}

