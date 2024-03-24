package service;

import model.*;
import java.time.LocalDateTime;

public class MainService {

    public static void main(String[] args){

        Person pe1 = new Person();
        Person pe2 = new Person("Kārlis", "Ulmanis", "132499-34456");
        System.out.println(pe1);
        System.out.println(pe2);

        Driver dr1 = new Driver();
        Driver dr2 = new Driver("Pēteris", "Kalniņš", "123456-21212", "11223344", 4.5F);
        System.out.println(dr1);
        System.out.println(dr2);

        Parcel pa1 = new Parcel();
        Parcel pa2 = new Parcel(false, ParcelSize.L, dr2, LocalDateTime.of(2024, 10, 15, 0, 0)); //Nesaglabājas plannedDelivery, stock aiziet nedēļu pēc šīs dienas datuma
        System.out.println(pa1);
        System.out.println(pa2);





    }

}
