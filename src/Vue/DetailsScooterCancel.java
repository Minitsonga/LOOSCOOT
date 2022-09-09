package Vue;

import Controllers.ValidateLoc_Return;
import Models.Client;
import Models.Parc;
import Models.Scooter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class DetailsScooterCancel extends JPanel {


    public DetailsScooterCancel(Parc parc, Scooter scooter, LocalDate startDate, LocalDate endDate, Client client, JFrame frame) {

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        JLabel titleTxt = new JLabel("Voici le scooter choisi");
        titleTxt.setFont(new Font("Tahoma", Font.BOLD, 36));
        add(titleTxt, gbc);

        JPanel panel = new JPanel(new GridBagLayout());

        panel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        panel.setPreferredSize(new Dimension(300, 300));

        JLabel brandTxt = new JLabel(scooter.model.brand.name + " : " + scooter.model.label);
        brandTxt.setFont(new Font("Tahoma", Font.BOLD, 24));


        JLabel idScooter = new JLabel("ID : " + scooter.id);
        idScooter.setFont(new Font("Tahoma", Font.PLAIN, 14));


        JLabel permisTxt = new JLabel("Permis " + scooter.model.licenceType.type + " nécessaire");
        permisTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));


        JLabel nbKmTxt = new JLabel("Kilometrage : " + scooter.nbKm);
        nbKmTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel horseTxt = new JLabel("Chevaux : " + scooter.model.cv);
        horseTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel consumptionTxt = new JLabel("Consomation : " + scooter.model.consumption + "L/100Km");
        consumptionTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel capacityTxt = new JLabel("Centimètres cubes : " + scooter.model.capacity + " CC");
        capacityTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        String stateValue = scooter.isReserved(LocalDate.now(), LocalDate.now()) ? "En location" : "Disponible";
        JLabel stateTxt = new JLabel("Etat actuel : " + stateValue);
        stateTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));


        gbc.weighty = 1;

        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(brandTxt, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(idScooter, gbc);
        panel.add(permisTxt, gbc);
        panel.add(nbKmTxt, gbc);
        panel.add(horseTxt, gbc);
        panel.add(consumptionTxt, gbc);
        panel.add(capacityTxt, gbc);
        panel.add(stateTxt, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(panel, gbc);


        JPanel panel2 = new JPanel(new GridBagLayout());

        JLabel errorTxt = new JLabel();
        errorTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
        errorTxt.setForeground(Color.RED);


        JButton returnButton = new JButton("Annulation");
        returnButton.setBackground(new Color(59, 89, 182));
        returnButton.setOpaque(true);
        returnButton.setBorderPainted(false);
        returnButton.setForeground(Color.WHITE);
        returnButton.setFocusPainted(false);
        returnButton.setPreferredSize(new Dimension(150, 40));
        returnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

        ValidateLoc_Return locationWindow = new ValidateLoc_Return(parc, scooter, startDate, endDate, client, frame, Parc.ChoiceClient.cancel, null, errorTxt);
        //ReturnWindow returnWindow = new ReturnWindow()
        returnButton.addActionListener(locationWindow);
        //returnButton.addActionListener(returnWindow);

        panel2.add(returnButton);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(panel2, gbc);
        add(errorTxt, gbc);

    }


}
