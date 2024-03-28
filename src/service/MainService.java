package service;

import model.*;
import model.user.AbstractCustomer;
import model.user.AbstractCustomerAsPerson;
import model.user.CustomerAsCompany;
import model.user.CustomerAsPerson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import model.Parcel;
import model.Driver;

import java.time.temporal.ChronoUnit;


public class MainService {

    public static ArrayList<Driver> allDrivers = new ArrayList<Driver>();
    public static ArrayList<AbstractCustomer> allCustomers = new ArrayList<AbstractCustomer>();


    public static void main(String[] args){

        System.out.println("-");
        Person pe1 = new Person();
        Person pe2 = new Person("Kārlis", "Ulmanis", "132499-34456");
        System.out.println(pe1);
        System.out.println(pe2);

        System.out.println("\n-----Driver CRUD-----");

        Driver dr1 = new Driver();
        Driver dr2 = new Driver("Otrais", "Šoferis", "170799-22222", "22222222", 2.5F);
        Driver dr3 = new Driver("Trešais", "Braucējs", "101000-33333", "11111111", 5.5F);
        Driver dr4 = new Driver("Ceturtais", "Stūrmanis", "221080-44444", "24444444", 5.0F);
        allDrivers.addAll(Arrays.asList(dr1, dr2, dr3, dr4));


        try
        {
            Driver temptSt = retrieveDriverByPersonCode("170799-22222");
            System.out.println("Atrastais šoferis " + temptSt);

            Driver temptSt2 = retrieveDriverByPersonCode("101000-33333");
            System.out.println("Atrastais šoferis " + temptSt2);

            updateDriverLicenceNoByPersonCode("170799-22222", "33333333");//Pastars uz Kalniņš
            System.out.println(dr2);

            updateDriverExperienceByPersonCode("170799-22222", 5.5f);//Pastars uz Kalniņš
            System.out.println(dr2);

            deleteDriverByPersonCode("170799-22222");
            System.out.println("All drivers: ");
            System.out.println(allDrivers);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println("-----Driver CRUD-----\n");







        System.out.println("-----Customer CRUD-----");

        CustomerAsCompany c1 = new CustomerAsCompany();

        Address address_c2 = new Address(City.Riga, "Brīvības iela", 5);
        CustomerAsCompany c2 = new CustomerAsCompany(address_c2, "23336666", "Nosaukums", "81112222");

        Address address_c3 = new Address(City.Liepaja, "Vēja iela", 77);
        CustomerAsPerson c3 = new CustomerAsPerson("Jānis", "Liepiņš", "161299-21435", address_c3, "25252343");

        Address address_c4 = new Address(City.Jelgava, "Liepu iela", 88);
        CustomerAsPerson c4 = new CustomerAsPerson("Toms", "Krūmiņš", "210988-65543", address_c4, "21169308");

        Address address_c5 = new Address(City.Ventspils, "Priežu iela", 99);
        CustomerAsPerson c5 = new CustomerAsPerson("Andris", "Pakalns", "300679-34712", address_c5, "25997100");


        allCustomers.addAll(Arrays.asList(c1, c2, c3, c4, c5));


        try {

            System.out.println("\nAll company customers:\n");
            retrieveAllCustomersAsCompany(allCustomers);
            System.out.println("\nAll person customers:\n");
            retrieveAllCustomersAsPerson(allCustomers);
            Address address_c6 = new Address(City.Liepaja, "Smilšu iela", 205);
            CustomerAsPerson c6 = createNewCustomerAsPerson("Kārlis", "Bērziņš", "110199-71320", address_c6, "25508433");
            allCustomers.add(c6);
            Address address_c7 = new Address(City.Riga, "Ganību dambis", 7);
            CustomerAsCompany c7 = createNewCustomerAsCompany(address_c7, "25100965", "SIA Ogles", "90134809");
            allCustomers.add(c7);
            System.out.println("\nAll company customers:\n");
            retrieveAllCustomersAsCompany(allCustomers);
            System.out.println("\nAll person customers:\n");
            retrieveAllCustomersAsPerson(allCustomers);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try{
            createNewParcelForCustomer(LocalDateTime.now().plus(2, ChronoUnit.WEEKS), ParcelSize.X, true, retrieveDriverByPersonCode("101000-33333"), "3_person_210988-65543");
            createNewParcelForCustomer(LocalDateTime.now().plus(5, ChronoUnit.DAYS), ParcelSize.S, false, retrieveDriverByPersonCode("101000-33333"), "3_person_210988-65543");
            createNewParcelForCustomer(LocalDateTime.now().plus(3, ChronoUnit.DAYS), ParcelSize.M, true, retrieveDriverByPersonCode("101000-33333"), "3_person_210988-65543");

            createNewParcelForCustomer(LocalDateTime.now().plus(3, ChronoUnit.WEEKS), ParcelSize.M, true, retrieveDriverByPersonCode("221080-44444"), "4_person_300679-34712");
            createNewParcelForCustomer(LocalDateTime.now().plus(6, ChronoUnit.DAYS), ParcelSize.L, false, retrieveDriverByPersonCode("221080-44444"), "4_person_300679-34712");
            createNewParcelForCustomer(LocalDateTime.now().plus(4, ChronoUnit.DAYS), ParcelSize.XL, true, retrieveDriverByPersonCode("221080-44444"), "4_person_300679-34712");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-----Customer CRUD-----\n");



        System.out.println("-----Parcel CRUD-----");

        try {
            System.out.println("\nRetreive all parcels by customer code\n");
            System.out.println(retrieveAllParcelsByCustomerCode("3_person_210988-65543"));
            System.out.println(retrieveAllParcelsByCustomerCode("4_person_300679-34712"));

            System.out.println("\nRetreive all parcels by driver person code\n");
            System.out.println(retrieveAllParcelsByDriverPersonCode("101000-33333"));
            System.out.println(retrieveAllParcelsByDriverPersonCode("221080-44444"));

            System.out.println("\nRetreive all parcels by city\n");
            System.out.println("\nVentspils:");
            System.out.println(retrieveAllParcelsByCity(City.Ventspils));
            System.out.println("\nRiga:");
            System.out.println(retrieveAllParcelsByCity(City.Riga));
            System.out.println("\nLiepaja:");
            System.out.println(retrieveAllParcelsByCity(City.Liepaja));
            System.out.println("\nJelgava:");
            System.out.println(retrieveAllParcelsByCity(City.Jelgava));
            System.out.println("\nDaugavpils:");
            System.out.println(retrieveAllParcelsByCity(City.Daugavpils));

            System.out.println("\nRetreive all parcels by size\n");
            System.out.println("\nX:");
            System.out.println(retriveAllParcelsBySize(ParcelSize.X));
            System.out.println("\nS:");
            System.out.println(retriveAllParcelsBySize(ParcelSize.S));
            System.out.println("\nM:");
            System.out.println(retriveAllParcelsBySize(ParcelSize.M));
            System.out.println("\nL:");
            System.out.println(retriveAllParcelsBySize(ParcelSize.L));
            System.out.println("\nXL:");
            System.out.println(retriveAllParcelsBySize(ParcelSize.XL));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

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
                    return tempSt;
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

    public static void createNewParcelForCustomer(LocalDateTime plannedDelivery, ParcelSize size, boolean isFargile, Driver driver, String customerCode) throws Exception {
        for (AbstractCustomer tempSt : allCustomers){
            if ((tempSt.getCustomerCode().matches(customerCode))) {
                tempSt.addNewParcel(new Parcel(isFargile, size, driver, plannedDelivery));
                return;
            }
        }
        throw new Exception("Invalid customer code");
    }

    public static ArrayList<Parcel> retrieveAllParcelsByCustomerCode(String customerCode) throws Exception {
        for (AbstractCustomer tempSt : allCustomers){
            if ((tempSt.getCustomerCode().matches(customerCode))) {
                return tempSt.getParcels();
            }
        }
        throw new Exception("Invalid customer code");
    }

    public static ArrayList<Parcel> retrieveAllParcelsByDriverPersonCode(String personCode) throws Exception{
        if(personCode == null || !(personCode.matches("[0-9]{6}-[0-9]{5}"))) {
            throw new Exception("Invalid person code");
        }
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer tempSt : allCustomers){
            for (Parcel tempVar : tempSt.getParcels()) {
                if (tempVar.getDriver().getPersonCode().matches(personCode)) {
                    parcels.add(tempVar);
                }
            }
        }
        return parcels;
    }

    public static ArrayList<Parcel> retrieveAllParcelsByCity(City city) throws Exception{
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer tempSt : allCustomers){
            if (tempSt.getAddress().getCity() == city) {
                for (Parcel tempVar : tempSt.getParcels()) {
                    parcels.add(tempVar);
                }
            }
        }
        return parcels;
    }

    public static ArrayList<Parcel> retriveAllParcelsBySize(ParcelSize size) throws Exception {
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer tempSt : allCustomers){
            for (Parcel tempVar : tempSt.getParcels()) {
                if (tempVar.getSize() == size) {
                    parcels.add(tempVar);
                }
            }
        }
        return parcels;
    }

}
