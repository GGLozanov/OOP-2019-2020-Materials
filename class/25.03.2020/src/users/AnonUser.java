package users;

public class AnonUser extends User {
    public AnonUser(String firstName, String lastName, DeliveryAddress deliveryAddress) {
        super(firstName, lastName, deliveryAddress);
    }
}
