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
        Driver dr2 = new Driver("Otrais", "Šoferis", "222222-22222", "22222222", 2.5F);
        Driver dr3 = new Driver("Trešais", "Šoferis", "333333-33333", "33333333", 3.5F);
        System.out.println(dr1);
        System.out.println(dr2);
        System.out.println(dr3);

        Parcel pa1 = new Parcel();
        Parcel pa2 = new Parcel(false, ParcelSize.L, dr2, LocalDateTime.of(2024, 10, 15, 0, 0));
        Parcel pa3 = new Parcel(false, ParcelSize.M, dr2, LocalDateTime.of(2024, 2, 15, 0, 0));
        System.out.println(pa1);
        System.out.println(pa2);
        System.out.println(pa3);





    }

}
