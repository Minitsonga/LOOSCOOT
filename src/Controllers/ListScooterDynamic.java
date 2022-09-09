package Controllers;

import Models.Client;
import Models.Parc;
import Vue.SelectScooter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class ListScooterDynamic implements ActionListener {
    Parc parc;
    JFrame frame;
    Client client;
    JRadioButton locationBox, returnBox, cancelBox;
    JLabel errorTxt;

    JTextField yearStart, monthStart, dayStart, yearEnd, monthEnd, dayEnd;

    LocalDate startDate, endDate;


    public ListScooterDynamic(Parc p, Client c, JFrame f, JTextField yearS, JTextField monthS, JTextField dayS, JTextField yearE, JTextField monthE, JTextField dayE, JRadioButton locationBox, JRadioButton returnBox, JRadioButton cancelBox, JLabel txt) {
        parc = p;
        client = c;
        frame = f;
        errorTxt = txt;

        yearStart = yearS;
        monthStart = monthS;
        dayStart = dayS;

        yearEnd = yearE;
        monthEnd = monthE;
        dayEnd = dayE;

        this.locationBox = locationBox;
        this.returnBox = returnBox;
        this.cancelBox = cancelBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (isNumeric(yearStart.getText()) && isNumeric(monthStart.getText()) && isNumeric(dayStart.getText())) {
            if (Integer.parseInt(yearStart.getText()) < 2022 || Integer.parseInt(yearStart.getText()) >= 2100) {
                errorTxt.setText("Erreur dans l'année de debut");
                return;
            }

            startDate = LocalDate.of(Integer.parseInt(yearStart.getText()), Integer.parseInt(monthStart.getText()), Integer.parseInt(dayStart.getText()));

        } else {
            errorTxt.setText("Erreur de date de debut");
            return;
        }

        if (isNumeric(yearEnd.getText()) && isNumeric(monthEnd.getText()) && isNumeric(dayEnd.getText())) {
            if (Integer.parseInt(yearEnd.getText()) < 2022 || Integer.parseInt(yearEnd.getText()) >= 2100) {
                errorTxt.setText("Erreur dans l'année de fin");
                return;
            }

            endDate = LocalDate.of(Integer.parseInt(yearEnd.getText()), Integer.parseInt(monthEnd.getText()), Integer.parseInt(dayEnd.getText()));

        } else {
            errorTxt.setText("Erreur de date de fin");
            return;
        }

        if (startDate.isAfter(endDate)) {
            errorTxt.setText("Erreur : votre date de fin est avant la date de debut");
            return;
        }


        if (locationBox.isSelected() && !returnBox.isSelected() && !cancelBox.isSelected()) {

            if (endDate.isBefore(LocalDate.now())) {
                errorTxt.setText("Erreur : Vous ne pouvez pas reserver un scooter dans le passé");
                return;
            }

            frame.setContentPane(new SelectScooter(parc, parc.getListDynamicScooter(Parc.ChoiceClient.location, startDate, endDate, client), startDate, endDate, frame, client, Parc.ChoiceClient.location));
            frame.repaint();
            frame.revalidate();
        } else if (returnBox.isSelected() && !locationBox.isSelected() && !cancelBox.isSelected()) {

            if (LocalDate.now().isBefore(startDate)) {
                errorTxt.setText("Votre reservation doit avoir commencé pour pouvoir rendre un scooter");
                return;
            }
            if (parc.getListDynamicScooter(Parc.ChoiceClient.retour, startDate, endDate, client).size() <= 0) {
                errorTxt.setText("Aucune donnée trouvée, Vérifiez votre date de fin");
                return;
            }
            frame.setContentPane(new SelectScooter(parc, parc.getListDynamicScooter(Parc.ChoiceClient.retour, startDate, endDate, client), startDate, endDate, frame, client, Parc.ChoiceClient.retour));
            frame.repaint();
            frame.revalidate();
        } else if (cancelBox.isSelected() && !locationBox.isSelected() && !returnBox.isSelected()) {
            if (parc.getListDynamicScooter(Parc.ChoiceClient.cancel, startDate, endDate, client).size() <= 0) {
                errorTxt.setText("Aucune donnée trouvée, Vérifiez votre date de fin");
                return;
            }
            frame.setContentPane(new SelectScooter(parc, parc.getListDynamicScooter(Parc.ChoiceClient.cancel, startDate, endDate, client), startDate, endDate, frame, client, Parc.ChoiceClient.cancel));
            frame.repaint();
            frame.revalidate();
        } else {
            errorTxt.setText("Vous devez cocher uniquement une case");
        }


    }

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }


}