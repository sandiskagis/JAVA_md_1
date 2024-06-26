package model.user;
import model.Address;
import model.Driver;
import model.Parcel;
import model.ParcelSize;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class AbstractCustomer {

    //1. variables

    private long cID;
    private Address address;
    private String phoneNo;
    private ArrayList<Parcel> parcels = new ArrayList<Parcel>();
    protected String customerCode;
    private static long counter = 0;

    //2. get and set

    public long getcID()
    {
        return cID;
    }
    public void setcID()
    {
        cID = counter;
        counter++;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        if(phoneNo != null && phoneNo.matches("[2]{1}[0-9]{7}"))
            this.phoneNo = phoneNo;
        else
            this.phoneNo = "Undefined";
    }

    public ArrayList<Parcel> getParcels() {
        return parcels;
    }

    public void setPackages(ArrayList<Parcel> parcels){

    }

    public String getCustomerCode() {
        return customerCode;
    }


    //3.constructors

    public AbstractCustomer(){
        setcID();
        setAddress(new Address());
        setPhoneNo("21212121");
    }
    public AbstractCustomer(Address address, String phoneNo){
        setcID();
        //this.address = address;
        setAddress(address);
        setPhoneNo(phoneNo);
    }

    //4. toString

    public String toString()
    {
        return cID + " " + address + " " + parcels + "(" + phoneNo + ")";
    }

    //5. other

//    public void addNewParcel(Parcel parcel, boolean isFragile, ParcelSize size, Driver driver, LocalDateTime plannedDelivery){
//        // Check if a parcel with the same characteristics already exists
//        for (Parcel existingParcel : parcels) {
//            if (existingParcel.isFragile() == isFragile &&
//                    existingParcel.getSize() == size &&
//                    existingParcel.getDriver().equals(driver) &&
//                    existingParcel.getPlannedDelivery().equals(plannedDelivery)) {
//                // Parcel with the same characteristics already exists, so don't add a new one
//                System.out.println("Parcel with the same characteristics already exists.");
//                return;
//            }
//        }
//
//        // If no existing parcel found, create and add the new parcel
//        Parcel newParcel = new Parcel(isFragile, size, driver, plannedDelivery);
//        parcels.add(newParcel);
//    }

    public void addNewParcel(Parcel parcel) throws Exception {
        if (parcel != null && parcel instanceof Parcel) {
            for (Parcel e : parcels){
                if (e.equals(parcel)){
                    throw new Exception("Parcel already exists");
                }
            }
            parcels.add(parcel);
            return;
        }
        throw new Exception("Invalid input parameters");
    }




    //public abstract void setCustomerCode(long cID, String title, String companyRegNo);
    public abstract void setCustomerCode();
}
