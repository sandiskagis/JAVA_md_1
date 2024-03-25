package service;

import model.*;
import model.user.AbstractCustomer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class MainService {

    public static ArrayList<Driver> allDrivers = new ArrayList<Driver>();
    public static ArrayList<AbstractCustomer> allCustomers = new ArrayList<AbstractCustomer>();


    public static void main(String[] args){

        System.out.println("-");
        Person pe1 = new Person();
        Person pe2 = new Person("Kārlis", "Ulmanis", "132499-34456");
        System.out.println(pe1);
        System.out.println(pe2);

        //Driver dr1 = new Driver();
        //Driver dr2 = new Driver("Otrais", "Šoferis", "222222-22222", "22222222", 2.5F);
        //Driver dr3 = new Driver("Trešais", "Šoferis", "333333-33333", "33333333", 3.5F);
        //System.out.println(dr1);
        //System.out.println(dr2);
        //System.out.println(dr3);

        //Parcel pa1 = new Parcel();
        //Parcel pa2 = new Parcel(false, ParcelSize.L, dr2, LocalDateTime.of(2024, 10, 15, 0, 0));
        //Parcel pa3 = new Parcel(false, ParcelSize.M, dr2, LocalDateTime.of(2024, 2, 15, 0, 0));
        //System.out.println(pa1);
        //System.out.println(pa2);
        //System.out.println(pa3);
        //System.out.println("-");



        System.out.println("-----Driver CRUD-----");

        Driver dr1 = new Driver();
        Driver dr2 = new Driver("Otrais", "Šoferis", "170799-22222", "22222222", 2.5F);
        allDrivers.addAll(Arrays.asList(dr1, dr2));


        try
        {
            Driver temptSt = retrieveDriverByPersonCode("170799-22222");
            System.out.println("Atrastais šoferis " + temptSt);

            Driver temptSt2 = retrieveDriverByPersonCode("101010-22222");
            System.out.println("Atrastais šoferis " + temptSt2);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        try
        {
            updateDriverLicenceNoByPersonCode("170799-22222", "33333333");//Pastars uz Kalniņš
            System.out.println(dr2);
        }
        catch (Exception e) {
            System.out.println(e);
        }


        try
        {
            updateDriverExperienceByPersonCode("170799-22222", 5.5f);//Pastars uz Kalniņš
            System.out.println(dr2);
        }
        catch (Exception e) {
            System.out.println(e);
        }


        try {
            deleteDriverByPersonCode("170799-22222");
            System.out.println("All drivers: ");
            System.out.println(allDrivers);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("-----Driver CRUD-----");

        

    }










    //RETRIEVE
    public static Driver retrieveDriverByPersonCode(String personCode) throws Exception{
        //TODO
        //1. pārbaudīt personCode ir null
        if(personCode == null) {
            throw new Exception("Problems with input arguments");
        }

        //2. ejot cauri foreach cikla visiem drivers, atrast konkrēto pēc personas koda
        for(Driver tempSt: allDrivers) {
            if(tempSt instanceof Driver){
                if(tempSt.getPersonCode().equals(personCode)) {
                    //3. atgriezt pašu atrasto driver
                    return (Driver) tempSt;
                }
            }
        }
        //4. pēc foreach cikla beigām izmest izņemu, ka tāds driver neeksistē sistemā
        throw new Exception("Driver with personcode " + personCode
                + " is not registered in the system");
    }

    public static void updateDriverLicenceNoByPersonCode(String personCode, String newLicenceNo) throws Exception {
        if(personCode == null || newLicenceNo == null) {
            throw new Exception("Problems with input arguments");
        }
        for(Driver tempSt: allDrivers) {
            if(tempSt instanceof Driver){
                if(tempSt.getPersonCode().equals(personCode))
                {
                    if (!tempSt.getLicenceNo().equals(newLicenceNo))
                    {
                        tempSt.setLicenceNo(newLicenceNo);
                    }
                    return;
                }

            }
        }
        throw new Exception("Driver with personcode " + personCode
                + " is not registered in the system");
    }
    public static void updateDriverExperienceByPersonCode(String personCode, float newExperience) throws Exception {
        if(personCode == null || newExperience <= 0 || newExperience >= 100) {
            throw new Exception("Problems with input arguments");
        }
        for(Driver tempSt: allDrivers) {
            if(tempSt instanceof Driver){
                if(tempSt.getPersonCode().equals(personCode))
                {
                    if (Float.compare(tempSt.getExperienceInYears(), newExperience) != 0)
                    {
                        tempSt.setExperienceInYears(newExperience);
                    }
                    return;
                }

            }
        }
        throw new Exception("Driver with personcode " + personCode
                + " is not registered in the system");
    }
    public static void deleteDriverByPersonCode(String personCode) throws Exception{
        //1. pārbaudam ievades argumentu
        if(personCode == null) {
            throw new Exception("Problems with input arguments");
        }
        //2. atrodam šoferi, ko gribam dzest
        for(Driver tempSt: allDrivers) {
            if(tempSt instanceof Driver) {
                if (tempSt.getPersonCode().equals(personCode)) {
                    //3. remove funkciju izdzēšam un return
                    allDrivers.remove(tempSt);
                    return;
                }
            }
        }
        //4. izmetam izņēmumu, ja tāds students neeksistē
        throw new Exception("Student with personcode " + personCode
                + " is not registered in the system");
    }




}
