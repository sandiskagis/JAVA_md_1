package model;

public class Address {

    //1. variables

    private City city;
    private String streetOrHouseTitle;
    private int houseNo = 0;

    //2. get and set

    public City getCity()
    {
        return city;
    }
    public void setCity(City city)
    {
        this.city = city;
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
        setCity(City.Riga);
        setStreetOrHouseTitle("Brīvības iela");
        setHouseNo(100);
    }

    public Address(City city, String streetOrHouseTitle, int houseNo)
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
