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
import java.util.regex.Pattern;

public class SignClient implements ActionListener {

    Parc parc;
    Vector<Client> listClient;
    JTextField firstName, lastName;
    JTextField year, month, day;

    JLabel errorTxt;
    Client curClient;
    JFrame frame;


    JCheckBox hasPermisA, hasPermisA1, hasPermisA2;

    LocalDate date;


    public SignClient(Parc p, JTextField name, JTextField lastName, JLabel errorText, JTextField yearB, JTextField monthB, JTextField dayB, JFrame f, JCheckBox permisA, JCheckBox permisA1, JCheckBox permisA2, LocalDate d) {
        parc = p;
        listClient = parc.getListClient();
        firstName = name;
        this.lastName = lastName;

        errorTxt = errorText;

        year = yearB;
        month = monthB;
        day = dayB;

        frame = f;

        hasPermisA = permisA;
        hasPermisA1 = permisA1;
        hasPermisA2 = permisA2;

        date = d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        LocalDate birthDate = null;

        if(firstName.getText().trim().isEmpty() || lastName.getText().trim().isEmpty() )
        {
            errorTxt.setText("Nom et prénom obligatoire");
            return;
        }

        if (isNumeric(year.getText().trim()) && isNumeric(month.getText().trim()) && isNumeric(day.getText().trim())) {
            if (Integer.parseInt(year.getText().trim()) > 2006 || Integer.parseInt(year.getText().trim()) <= 1900)
            {
                errorTxt.setText("Votre année de naissance doit être comprise entre 1901 et 2006");
                return;
            }
            birthDate = LocalDate.of(Integer.parseInt(year.getText().trim()), Integer.parseInt(month.getText().trim()), Integer.parseInt(day.getText().trim()));
        }
        else {
            errorTxt.setText("Erreur dans votre date");
            return;
        }


        //ADDING NEW USER
        curClient = new Client(lastName.getText().trim(), firstName.getText().trim(), birthDate, hasPermisA.isSelected(), hasPermisA1.isSelected(), hasPermisA2.isSelected());

        var count = 0;
        for (var client : listClient) {
            if (client.firstName.equals(curClient.firstName) && client.lastName.equals(curClient.lastName) && client.birthDate.equals(curClient.birthDate)) {
                errorTxt.setText("Utilisateur deja inscrit");
                break;
            } else {
                count++;
            }

        }
        if (count >= listClient.size()) {
            System.out.println("Ajout nouveau client");
            parc.RegisterClient(curClient);
            frame.setJMenuBar(new MenuBar(parc, curClient, frame));
            frame.setContentPane(new Home(parc, curClient, frame, date));
            frame.repaint();
            frame.revalidate();
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
