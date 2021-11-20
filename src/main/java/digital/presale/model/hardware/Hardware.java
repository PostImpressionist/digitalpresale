package digital.presale.model.hardware;

import java.util.Objects;

/**
 * created by E.K.
 * 2021 November 18
 **/

public class Hardware {
    private String reference;

    private String description;

    private double price;

    private Integer amount;

    public Hardware(String reference, String description, double price, Integer amount) {
        this.reference = reference;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Hardware{" +
                "reference='" + reference + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hardware hardware = (Hardware) o;
        return Double.compare(hardware.price, price) == 0 && Objects.equals(reference, hardware.reference) && Objects.equals(description, hardware.description) && Objects.equals(amount, hardware.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, description, price, amount);
    }
}
