package users;

public class User {
    static Integer lastID;
    Integer ID;
    String firstName;
    String lastName;
    DeliveryAddress deliveryAddress;

    public User(String firstName, String lastName, DeliveryAddress deliveryAddress) {
        this.ID = ++lastID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
    }

    public User(User user) {
        this.ID = ++lastID;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.deliveryAddress = user.deliveryAddress;
    }

    public String getFullName() {
        return firstName + lastName;
    }

    public Integer getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean validateFields() {
        return ID != null && firstName != null && lastName != null && deliveryAddress.validateFields();
    }

}
