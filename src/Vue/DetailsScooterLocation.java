package Vue;

import Controllers.ValidateLoc_Return;
import Models.Client;
import Models.Parc;
import Models.Scooter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class DetailsScooterLocation extends JPanel {


    public DetailsScooterLocation(Parc parc, Scooter curScooter, LocalDate startDate, LocalDate endDate, Client client, JFrame frame) {


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

        JLabel brandTxt = new JLabel(curScooter.model.brand.name + " : " + curScooter.model.label);
        brandTxt.setFont(new Font("Tahoma", Font.BOLD, 24));


        JLabel idScooter = new JLabel("ID : " + curScooter.id);
        idScooter.setFont(new Font("Tahoma", Font.PLAIN, 14));


        JLabel permisTxt = new JLabel("Permis " + curScooter.model.licenceType.type + " nécessaire");
        permisTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));


        JLabel nbKmTxt = new JLabel("Kilometrage : " + curScooter.nbKm);
        nbKmTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel horseTxt = new JLabel("Chevaux : " + curScooter.model.cv);
        horseTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel consumptionTxt = new JLabel("Consomation : " + curScooter.model.consumption + "L/100Km");
        consumptionTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel capacityTxt = new JLabel("Centimètres cubes : " + curScooter.model.capacity + " CC");
        capacityTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        String stateValue = curScooter.isReserved(LocalDate.now(), LocalDate.now()) ? "En location" : "Disponible";
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

        add(panel, gbc);

        JPanel panel2 = new JPanel(new GridBagLayout());

        JButton locateButton = new JButton("Louer");
        locateButton.setBackground(new Color(59, 89, 182));
        locateButton.setOpaque(true);
        locateButton.setBorderPainted(false);
        locateButton.setForeground(Color.WHITE);
        locateButton.setFocusPainted(false);
        locateButton.setMinimumSize(new Dimension(100, 20));
        locateButton.setPreferredSize(new Dimension(150, 40));
        locateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

        ValidateLoc_Return locationWindow = new ValidateLoc_Return(parc, curScooter, startDate, endDate, client, frame, Parc.ChoiceClient.location, null, null);
        locateButton.addActionListener(locationWindow);


        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel2.add(locateButton);
        add(panel2, gbc);

    }


}
