package model.user;

import model.Address;

public class CustomerAsPerson extends AbstractCustomerAsPerson {

    //1. variables

    private String name;
    private String surname;
    private String personCode;
    private String customerCode;

    //2. get and set



    //3. constructor
    public CustomerAsPerson(){
        super();
        //
//        this.name = "Jānis";
//        this.surname = "Kalniņš";
//        this.personCode = "101099-31141";
        setCustomerCode();
        //
    }
    public CustomerAsPerson(String name, String surname, String personCode, Address address, String phone){
        super(name, surname, personCode, address, phone);
        //
//        this.name = name;
//        this.surname = surname;
//        this.personCode = personCode;
        setCustomerCode();
        //
    }

    //4. toString
    public String toString(){
        //return super.toString() + ": " + name + " " + surname + " " + personCode+ ": " + customerCode;
        return super.toString() + ": " + super.getCustomerCode();
    }


    @Override
    public void setCustomerCode() {
        super.customerCode = super.getcID() + "_person_" + super.person.getPersonCode();
    }
}
