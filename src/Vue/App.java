package Vue;

import Models.*;

public class App {

    public Parc evryParc;

    public App() {

        //region PERMIS SETUP

        PermisType permis_A = new PermisType("A");
        PermisType permis_A1 = new PermisType("A1");
        PermisType permis_A2 = new PermisType("A2");


        //endregion

        //region BRAND SETUP

        Brand yamaha = new Brand("YAMAHA");
        Brand suzuki = new Brand("SUZUKI");
        Brand ducati = new Brand("DUCATI");

        Model model1 = new Model("XI40", 400, 7, 150, permis_A, yamaha);
        Model model2 = new Model("XI42", 200, 5, 100, permis_A, yamaha);
        Model model3 = new Model("XI50", 550, 8, 200, permis_A, yamaha);
        Model model4 = new Model("XX40", 120, 3, 80, permis_A1, yamaha);
        Model model5 = new Model("XNA7", 50, 1, 20, permis_A2, yamaha);

        Model model6 = new Model("8HGZ", 50, 1, 30, permis_A2, suzuki);
        Model model7 = new Model("S4C4", 650, 10, 400, permis_A, suzuki);
        Model model8 = new Model("FGS56", 125, 2, 120, permis_A1, suzuki);
        Model model9 = new Model("1GR6", 350, 6, 150, permis_A, suzuki);

        Model model10 = new Model("8HGZ", 250, 5, 200, permis_A, ducati);
        Model model11 = new Model("S4C4", 200, 4, 120, permis_A1, ducati);
        Model model12 = new Model("FGS56", 40, 3, 30, permis_A2, ducati);
        Model model13 = new Model("1GR6", 900, 13, 650, permis_A, ducati);

        //endregion

        Scooter scooter1 = new Scooter(1, 259915, model1);
        Scooter scooter2 = new Scooter(2, 3290, model2);
        Scooter scooter3 = new Scooter(3, 0, model3);
        Scooter scooter4 = new Scooter(4, 9419, model4);
        Scooter scooter5 = new Scooter(5, 6436, model5);

        Scooter scooter6 = new Scooter(6, 615, model6);
        Scooter scooter7 = new Scooter(7, 147, model7);
        Scooter scooter8 = new Scooter(8, 86, model8);
        Scooter scooter9 = new Scooter(9, 486, model9);

        Scooter scooter10 = new Scooter(10, 764, model10);
        Scooter scooter11 = new Scooter(11, 50, model11);
        Scooter scooter12 = new Scooter(12, 0, model12);
        Scooter scooter13 = new Scooter(13, 0, model13);


        Parc.Address addressParc = new Parc.Address(23, "Boulevard Francois Mitterrand", 91000, "Évry-Courcouronnes");
        evryParc = new Parc("EVRYSCOOT", addressParc);


        evryParc.RegisterScooter(scooter1);
        evryParc.RegisterScooter(scooter2);
        evryParc.RegisterScooter(scooter3);
        evryParc.RegisterScooter(scooter4);
        evryParc.RegisterScooter(scooter5);
        evryParc.RegisterScooter(scooter6);
        evryParc.RegisterScooter(scooter7);
        evryParc.RegisterScooter(scooter8);
        evryParc.RegisterScooter(scooter9);
        evryParc.RegisterScooter(scooter10);
        evryParc.RegisterScooter(scooter11);
        evryParc.RegisterScooter(scooter12);
        evryParc.RegisterScooter(scooter13);


        System.out.println("Fin data");


    }

}

