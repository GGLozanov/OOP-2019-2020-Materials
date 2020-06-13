package users;

public class LoggedUser extends User {

    public LoggedUser() {
        this("", "", new DeliveryAddress());
    }

    public LoggedUser(String firstName, String lastName, DeliveryAddress deliveryAddress) {
        super(firstName, lastName, deliveryAddress);
    }
}
