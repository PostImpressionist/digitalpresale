package digital.presale.model;

import digital.presale.model.hardware.Hardware;
import digital.presale.util.EntityUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * created by E.K.
 * 2021 November 18
 **/

public class Calculation extends AbstractBaseEntity {

    private String description;

    private LocalDateTime dateTime;

    private List<Hardware> hardwareList;

    private Double totalPrice;

    private User user;

    public Calculation(Integer id, String description, LocalDateTime dateTime, List<Hardware> hardwareList, User user) {
        super(id);
        this.description = description;
        this.dateTime = dateTime;
        this.hardwareList = hardwareList;
        this.totalPrice = EntityUtil.getTotalPrice(hardwareList);
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Hardware> getHardwareList() {
        return hardwareList;
    }

    public void setHardwareList(List<Hardware> hardwareList) {
        this.hardwareList = hardwareList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", hardwareList=" + hardwareList +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Calculation that = (Calculation) o;
        return Objects.equals(description, that.description) && Objects.equals(dateTime, that.dateTime) && Objects.equals(hardwareList, that.hardwareList) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, dateTime, hardwareList, totalPrice, user);
    }
}
