package orders;

import users.DeliveryAddress;

import java.util.Set;

public class OrderInformation {
    Integer ID;
    Integer userID;
    DeliveryAddress deliveryAddressCopy;


    public OrderInformation(Integer ID, Integer userID, DeliveryAddress originalAddress) {
        this.ID = ID;
        this.userID = userID;
        this.deliveryAddressCopy = new DeliveryAddress(originalAddress);
    }

    public Integer getID() {
        return ID;
    }

    public Integer getUserID() {
        return userID;
    }

    public DeliveryAddress getDeliveryAddressCopy() {
        return deliveryAddressCopy;
    }
}
