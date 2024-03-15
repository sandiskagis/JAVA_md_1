package model;

public class Person {
    //1. variables
    private String name;
    private String surname;
    private String personCode;

    //2. get and set
    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        if(name != null && name.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+"))
            this.name = name;
        else
            this.name = "Undefined";

    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        if(surname != null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+"))
            this.surname = surname;
        else
            this.surname = "Undefined";
    }
    public String getPersonCode()
    {
        return personCode;
    }

    public void setPersonCode(String personCode)
    {
        if(personCode != null && personCode.matches("[0-9]{6}-[0-9]{5}"))
            this.personCode = personCode;
        else
            this.personCode = "Undefined";
    }

    //3. constructors
    public Person()
    {
        setName("Jānis");
        setSurname("Bērziņš");
        setPersonCode("123456-76543");
    }

    public Person(String name, String surname, String personCode)
    {
        setName(name);
        setSurname(surname);
        setPersonCode(personCode);
    }

    //4. toString
    public String toString()
    {
        return name + " " + surname + "(" + personCode + ")";
    }
    //5. others functions

}