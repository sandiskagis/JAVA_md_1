package service;

import model.*;
import model.user.AbstractCustomer;
import model.user.AbstractCustomerAsPerson;
import model.user.CustomerAsCompany;
import model.user.CustomerAsPerson;

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



        System.out.println("\n-----Driver CRUD-----");

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


        System.out.println("-----Driver CRUD-----\n");







        System.out.println("-----Customer CRUD-----");

        CustomerAsCompany c1 = new CustomerAsCompany();

        Address address_c2 = new Address("Riga", "Brīvības iela", 5);
        CustomerAsCompany c2 = new CustomerAsCompany(address_c2, "23336666", "Nosaukums", "81112222");

        Address address_c3 = new Address("Liepaja", "Vēja iela", 77);
        CustomerAsPerson c3 = new CustomerAsPerson("Jānis", "Liepiņš", "161299-21435", address_c3, "25252343");

        Address address_c4 = new Address("Jelgava", "Liepu iela", 88);
        CustomerAsPerson c4 = new CustomerAsPerson("Toms", "Krūmiņš", "210988-65543", address_c4, "21169308");

        Address address_c5 = new Address("Ogre", "Priežu iela", 99);
        Address address_c6 = new Address("Daugavpils", "Meža iela", 13);




        allCustomers.add(c1);
        allCustomers.add(c2);
        allCustomers.add(c3);
        allCustomers.add(c4);
        //System.out.println(allCustomers);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);




        System.out.println("\nAll company customers:\n");


        try{
            retrieveAllCustomersAsCompany(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAll person customers:\n");

        try{
            retrieveAllCustomersAsPerson(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            CustomerAsPerson c5 = createNewCustomerAsPerson("Kārlis", "Bērziņš", "110199-71320", address_c5, "25508433");
            allCustomers.add(c5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            CustomerAsCompany c6 = createNewCustomerAsCompany(address_c6, "25100965", "SIA Ogles", "90134809");
            allCustomers.add(c6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAll company customers:\n");


        try{
            retrieveAllCustomersAsCompany(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAll person customers:\n");

        try{
            retrieveAllCustomersAsPerson(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }





        System.out.println("-----Customer CRUD-----\n");



        System.out.println("-----Parcel CRUD-----");



        System.out.println("-----Parcel CRUD-----\n");







    }










    //RETRIEVE
    public static Driver retrieveDriverByPersonCode(String personCode) throws Exception{
        //TODO
        //1. pārbaudīt personCode ir null
        if(personCode == null) {
            throw new Exception("Problems with input parameters");
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
            throw new Exception("Problems with input parameters");
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
            throw new Exception("Problems with input parameters");
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
            throw new Exception("Problems with input parameters");
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


    public static ArrayList<CustomerAsCompany> retrieveAllCustomersAsCompany(ArrayList<AbstractCustomer> customers) throws Exception {
        if(customers == null) {
            throw new Exception("Problems with input parameters");
        }

        ArrayList<CustomerAsCompany> companyCustomers = new ArrayList<>();

        for (AbstractCustomer customer : customers) {
            if (customer instanceof CustomerAsCompany) {
                System.out.println(customer);
                companyCustomers.add((CustomerAsCompany) customer);
            }
        }

        if (companyCustomers.isEmpty()) {
            throw new Exception("No company customers found");
        }

        return companyCustomers;
    }

    public static ArrayList<CustomerAsPerson> retrieveAllCustomersAsPerson(ArrayList<AbstractCustomer> customers) throws Exception {
        if(customers == null) {
            throw new Exception("Problems with input parameters");
        }

        ArrayList<CustomerAsPerson> personCustomers = new ArrayList<>();

        for (AbstractCustomer customer : customers) {
            if (customer instanceof CustomerAsPerson) {
                System.out.println(customer);
                personCustomers.add((CustomerAsPerson) customer);
            }
        }

        if (personCustomers.isEmpty()) {
            throw new Exception("No company customers found");
        }

        return personCustomers;
    }

    public static CustomerAsPerson createNewCustomerAsPerson(String name, String surname, String personCode, Address address, String phone) throws Exception {
        if (name == null || surname == null || personCode == null || address == null || phone == null) {
            throw new Exception("Problems with input parameters");
        }

        return new CustomerAsPerson(name, surname, personCode, address, phone);
    }

    public static CustomerAsCompany createNewCustomerAsCompany(Address address, String phoneNo, String title, String companyRegNo) throws Exception {
        if (address == null || phoneNo == null || title == null || companyRegNo == null) {
            throw new Exception("Problems with input parameters");
        }

        return new CustomerAsCompany(address, phoneNo, title, companyRegNo);
    }








}
