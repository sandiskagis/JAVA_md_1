package model;

public class Address {

    //1. variables

    private String city;
    private String streetOrHouseTitle;
    private int houseNo = 0;

    //2. get and set

    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        if(city != null && city.matches("[A-Z]{1}[a-z]{3,9}"))
            this.city = city;
        else
            this.city = "Undefined";
    }

    public String getStreetOrHouseTitle()
    {
        return streetOrHouseTitle;
    }
    public void setStreetOrHouseTitle(String streetOrHouseTitle)
    {
        if(streetOrHouseTitle != null && streetOrHouseTitle.length() <= 100)
            this.streetOrHouseTitle = streetOrHouseTitle;
        else
            this.streetOrHouseTitle = "Undefined";
    }

    public int getHouseNo()
    {
        return houseNo;
    }
    public void setHouseNo(int houseNo)
    {
        if(houseNo > 0 && houseNo <= 1000)
            this.houseNo = houseNo;
        else
            this.houseNo = 0;
    }

    //3. constructors

    public Address()
    {
        setCity("Riga");
        setStreetOrHouseTitle("Brīvības iela");
        setHouseNo(100);
    }

    public Address(String city, String streetOrHouseTitle, int houseNo)
    {
        setCity(city);
        setStreetOrHouseTitle(streetOrHouseTitle);
        setHouseNo(houseNo);
    }

    //4. toString

    public String toString()
    {
        return "Address: " + city + ", " + streetOrHouseTitle + " " + houseNo;
    }

    //5. others

}
