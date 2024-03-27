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

    public CustomerAsPerson(String name, String surname, String personCode, Address address, String phone){
        super(name, surname, personCode, address, phone);


        //
        this.name = name;
        this.surname = surname;
        this.personCode = personCode;
        setCustomerCode(getcID(), name, personCode);
        //




    }

    //4. toString
    public String toString(){
        //return super.toString() + ": " + name + " " + surname + " " + personCode+ ": " + customerCode;
        return super.toString() + ": " + customerCode;
    }


    @Override
    public void setCustomerCode(long cID, String name, String personCode) {
        this.customerCode = String.valueOf(cID) + "_" + name + "_" + personCode;
    }
}
