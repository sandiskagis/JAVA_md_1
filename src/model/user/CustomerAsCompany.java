package model.user;

import model.Address;

public class CustomerAsCompany extends AbstractCustomer {

    //1. variables
    private String title;
    private String companyRegNo;
    private String customerCode;

    //2. get and set

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if(title != null && title.matches("[A-Za-z0-9 ]{2,60}"))
            this.title = title;
        else
            this.title = "----";
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }
    public void setCompanyRegNo(String companyRegNo) {
        if(companyRegNo != null && companyRegNo.matches("\\d{8}"))
            this.companyRegNo = companyRegNo;
        else
            this.companyRegNo = "Undefined";
    }

    //3. constructors


    public CustomerAsCompany(){
        super();
        setTitle("Uzņēmums");
        setCompanyRegNo("11223344");
        setCustomerCode();
    }
    public CustomerAsCompany(Address address, String phoneNo, String title, String companyRegNo){
        super(address, phoneNo);
        setTitle(title);
        setCompanyRegNo(companyRegNo);
        setCustomerCode();
    }

    //4. toString

    public String toString(){
        return super.toString() + ": " + super.getCustomerCode();
    }

    //5. others

    @Override
    public void setCustomerCode() {
        super.customerCode = super.getcID() + "_company_" + this.companyRegNo;
    }



}
