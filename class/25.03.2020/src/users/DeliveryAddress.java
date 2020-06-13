package users;

import enums.Country;

public class DeliveryAddress {
    Country country;
    String city;
    String road;
    Integer apartmentNo;

    public DeliveryAddress() {
        this.country = Country.BULGARIA;
        this.city = "";
        this.road = "";
        this.apartmentNo = 12;
    }

    public DeliveryAddress(Country country, String city, String road, Integer apartmentNo) {
        this.country = country;
        this.city = city;
        this.road = road;
        this.apartmentNo = apartmentNo;
    }

    public DeliveryAddress(DeliveryAddress deliveryAddress) {
        this.country = deliveryAddress.country;
        this.city = deliveryAddress.city;
        this.road = deliveryAddress.road;
        this.apartmentNo = deliveryAddress.apartmentNo;
    }

    public Country getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getRoad() {
        return road;
    }

    public Integer getApartmentNo() {
        return apartmentNo;
    }

    public boolean validateFields() {
        return country != null && city != null && road != null && apartmentNo != null;
    }
}
