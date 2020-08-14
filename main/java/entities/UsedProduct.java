package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

    private Date manufactureDate;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct() {
    }

    public UsedProduct(Date manufactureDate, String name, Double price) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return super.priceTag() + " Manufacture Date: " + manufactureDate;
    }

}
