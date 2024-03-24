package model.user;

public abstract class CustomerAsCompany extends AbstractCustomer {

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
        setCustomerCode(getcID(), "Uzņēmums", "11223344");
    }
    public CustomerAsCompany(String title, String companyRegNo){
        super();
        setTitle(title);
        setCompanyRegNo(companyRegNo);
        setCustomerCode(getcID(), title, companyRegNo);
    }

    //4. toString

    public String toString(){
        return super.toString() + ": " + customerCode;
    }

    //5. others

    @Override
    public void setCustomerCode(long cID, String title, String companyRegNo) {
        this.customerCode =  "<" + String.valueOf(cID) + ">_" + title + "_<" + companyRegNo;
    }


}
