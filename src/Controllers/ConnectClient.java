package Controllers;

import Models.Client;
import Models.Parc;
import Vue.Home;
import Vue.MenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

public class ConnectClient implements ActionListener {

    Parc parc;
    Vector<Client> listClient;
    JTextField firstName;
    JTextField lastName;
    JLabel errorTxt;
    Client curClient;
    JFrame frame;
    LocalDate date;

    public ConnectClient(Parc p, JTextField name, JTextField lastName, JLabel errorText, JFrame f) {
        parc = p;
        listClient = p.getListClient();
        firstName = name;
        this.lastName = lastName;
        frame = f;
        errorTxt = errorText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        var count = 0;
        for (var client : listClient) {
            if (client.firstName.equalsIgnoreCase(firstName.getText()) && client.lastName.equalsIgnoreCase(lastName.getText())) {
                //CONNECTING WITH THIS USER
                curClient = client;
                frame.setJMenuBar(new MenuBar(parc, curClient, frame));
                frame.setContentPane(new Home(parc, curClient, frame, date));
                frame.repaint();
                frame.revalidate();
            } else {

                count++;
            }
        }
        if (count >= listClient.size()) {
            errorTxt.setText("Aucun utilisateur trouvé");
        }

    }
}
