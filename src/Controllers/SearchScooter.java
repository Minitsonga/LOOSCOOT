package Controllers;


import Models.Client;
import Models.Parc;
import Models.Scooter;
import Vue.DetailsScooterCancel;
import Vue.DetailsScooterLocation;
import Vue.DetailsScooterRetour;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;


public class SearchScooter implements ActionListener {

    JTextField textField;
    LocalDate startDate, endDate;
    JFrame mainFrame;
    Client client;
    Parc parc;
    Vector<Scooter> listScooter;
    Parc.ChoiceClient choice;

    public SearchScooter(Parc p, Vector<Scooter> listS, JTextField txtModel, LocalDate d1, LocalDate d2, JFrame frame, Client c, Parc.ChoiceClient choice) {
        parc = p;
        listScooter = listS;
        startDate = d1;
        endDate = d2;
        textField = txtModel;
        mainFrame = frame;
        client = c;
        this.choice = choice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        listScooter.forEach(scooter -> {
            if (scooter.model.label.equalsIgnoreCase(textField.getText())) {

                if (choice == Parc.ChoiceClient.location) {
                    mainFrame.setContentPane(new DetailsScooterLocation(parc, scooter, startDate, endDate, client, mainFrame));
                } else if (choice == Parc.ChoiceClient.retour) {
                    mainFrame.setContentPane(new DetailsScooterRetour(parc, scooter, startDate, endDate, client, mainFrame));
                } else if (choice == Parc.ChoiceClient.cancel) {
                    mainFrame.setContentPane(new DetailsScooterCancel(parc, scooter, startDate, endDate, client, mainFrame));
                }
                mainFrame.repaint();
                mainFrame.revalidate();

            }
        });


    }
}
