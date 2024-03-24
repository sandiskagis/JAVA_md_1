package model;

public class Driver extends Person{

    //1. variables

    private long dID;
    private String licenceNo;
    private float experienceInYears;
    private static long counter = 0;

    //2. get and set

    public long getdID()
    {
        return dID;
    }
    public void setdID()
    {
        dID = counter;
        counter++;
    }

    public String getLicenceNo()
    {
        return licenceNo;
    }
    public void setLicenceNo(String licenceNo)
    {
        if(licenceNo != null && licenceNo.matches("\\d{8}"))
            this.licenceNo = licenceNo;
        else
            this.licenceNo = "Undefined";
    }

    public float getExperienceInYears()
    {
        return experienceInYears;
    }
    public void setExperienceInYears(float experienceInYears)
    {
        if(experienceInYears >= 0 && experienceInYears <= 120)
            this.experienceInYears = experienceInYears;
        else
            this.experienceInYears = 0;
    }

    //3. constructors

    public Driver()
    {
        setdID();
        setName("Jānis");
        setSurname("Ozols");
        setPersonCode("121290-12311");
        setLicenceNo("12345678");
        setExperienceInYears(3);
    }

    public Driver(String name, String surname, String personCode, String licenceNo, float experienceInYears)
    {
        super(name, surname, personCode);
        setdID();
        setLicenceNo(licenceNo);
        setExperienceInYears(experienceInYears);
    }

    //4. toString

    public String toString()
    {
        return dID + ": " + super.toString() + "[" + licenceNo + "  " + experienceInYears + "]";
    }

    //5. other
}
