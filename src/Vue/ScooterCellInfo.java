package Vue;

import Models.Scooter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ScooterCellInfo extends JPanel {


    public ScooterCellInfo(Scooter scooter, LocalDate d1, LocalDate d2) {


        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;


        JLabel titleTxt = new JLabel(scooter.model.brand.name + " : " + scooter.model.label + " (ID : " + scooter.id + ")");
        titleTxt.setForeground(new Color(227, 63, 63));

        JLabel permisTxt = new JLabel("Permis " + scooter.model.licenceType.type + " nécessaire");
        JLabel kmTxt = new JLabel("Km : " + scooter.nbKm);
        JLabel capacityTxt = new JLabel("Centimètres cubes : " + scooter.model.capacity);


        String stateValue = scooter.isReserved(d1, d2) ? "En location" : "Disponible";
        JLabel stateTxt = new JLabel("Etat actuel : " + stateValue);

        add(titleTxt, gbc);
        gbc.anchor = GridBagConstraints.WEST;

        add(permisTxt, gbc);
        add(kmTxt, gbc);
        add(capacityTxt, gbc);
        add(stateTxt, gbc);



        /* assign the card layout */

        /* add the different panels to the container panel and show the initial one */


    }


}
