package model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Parcel {

    //1. variables

    private boolean isFragile;
    private ParcelSize size;
    private LocalDateTime orderCreated = LocalDateTime.now();
    //private LocalDateTime plannedDelivery = LocalDateTime.now();
    private LocalDateTime plannedDelivery = orderCreated.plus(2, ChronoUnit.WEEKS);
    private float price;
    private Driver driver;


    //2. get and set

    public boolean isFragile()
    {
        return isFragile;
    }
    public void setFragile(boolean fragile)
    {
        if(fragile == true || fragile == false)
            isFragile = fragile;
        else
            isFragile = false;
    }

    public ParcelSize getSize()
    {
        return size;
    }
    public void setSize(ParcelSize size)
    {
        if(size != null)
            this.size = size;
        else
            this.size = ParcelSize.XL;
    }

    public LocalDateTime getOrderCreated()
    {
        return orderCreated;
    }

    public void setOrderCreated(LocalDateTime orderCreated) {
        this.orderCreated = orderCreated;
    }

    public LocalDateTime getPlannedDelivery()
    {
        return plannedDelivery;
    }
    public void setPlannedDelivery(LocalDateTime plannedDelivery){
        if (plannedDelivery.isAfter(orderCreated))
            this.plannedDelivery = plannedDelivery;
        else
            this.plannedDelivery = orderCreated.plus(1, ChronoUnit.WEEKS);
    }

    public float getPrice()
    {
        return price;
    }
    public void setPrice(ParcelSize size, boolean isFragile)
    {
        if(isFragile == true)
        {
            this.price = 2.99F;
        } else
        {
            this.price = 0; // Set price to 0 if not fragile
        }

        switch (size)
        {
            case X:
                this.price += 1 * 1.99F;
                break;
            case S:
                this.price += 2 * 1.99F;
                break;
            case M:
                this.price += 3 * 1.99F;
                break;
            case L:
                this.price += 4 * 1.99F;
                break;
            case XL:
                this.price += 5 * 1.99F;
                break;
            default:
                this.price += 5 * 1.99F;
                break;
        }
    }

    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver)
    {
        if(driver != null)
            this.driver = driver;
        else
            this.driver = new Driver();
    }


    //3. constructors

    public Parcel(){
        setOrderCreated(LocalDateTime.now());
        setFragile(true);
        setSize(ParcelSize.L);
        setPrice(ParcelSize.L, true);
        setDriver(new Driver());
        setPlannedDelivery(plannedDelivery);
    }
    public Parcel(boolean isFragile, ParcelSize size, Driver driver, LocalDateTime plannedDelivery){
        this.orderCreated = LocalDateTime.now();
        setFragile(isFragile);
        setSize(size);
        setPrice(size, isFragile);
        setDriver(driver);
        setPlannedDelivery(plannedDelivery);
    }
    //4. toString

    public String toString()
    {
        return "Order: ordered: " + orderCreated + "; Status: " + isFragile + "; Size: " + size + "; Price: " + price + "; Driver" + driver + "; Planned delivery: " + plannedDelivery;
    }

    //5. others

}
