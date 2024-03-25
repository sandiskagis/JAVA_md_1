package model.user;

import model.Address;
import model.Person;

public abstract class AbstractCustomerAsPerson extends AbstractCustomer {

    //1. variables

    private Person person;

    //2. get and set

    //3. constructors
    public AbstractCustomerAsPerson() {
        super();
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

