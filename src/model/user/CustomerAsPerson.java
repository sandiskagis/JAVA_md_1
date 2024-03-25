package model.user;

public class CustomerAsPerson extends AbstractCustomerAsPerson {

    private String name;
    private String personCode;
    private String customerCode;

    @Override
    public void setCustomerCode(long cID, String name, String personCode) {
        this.customerCode =  "<" + String.valueOf(cID) + ">_" + name + "_<" + personCode;
    }
}
