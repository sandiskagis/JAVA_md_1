package model.user;

import model.Address;
import model.Person;

public abstract class AbstractCustomerAsPerson extends AbstractCustomer {

    //1. variables

    protected Person person;
    //private String name;
    //private String surname;
    //private String personcode;


    //2. get and set

    //3. constructors
    //public AbstractCustomerAsPerson(Address address, String phone, String name, String surname, String personCode) {
   // public AbstractCustomerAsPerson() {
    //    super();
    //}
    //public AbstractCustomerAsPerson(Person person, String name, String surname, String personCode, Address address, String phone){
    //public AbstractCustomerAsPerson(Person person, Address address, String phone){
        //super(address, phone);
        //.person = person;
        //this.person = new Person(name, surname, personCode);
        //person.setName(name);
        //person.setSurname(surname);
       // person.setPersonCode(personCode);
    //}



    public AbstractCustomerAsPerson(){
        super();
        this.person = new Person("Jānis", "Kalniņš", "101099-31141");
    }
    public AbstractCustomerAsPerson(String name, String surname, String personCode, Address address, String phone){
        super(address, phone);
        this.person = new Person(name, surname, personCode);
    }

    //4. toString
    public String toString(){
        return super.toString() + ": " + person.getName() + " " + person.getSurname() + " " + person.getPersonCode();
    }
    //5. others

}

