package model;

public class People {
    private String idPeople;
    private String namePeople;
    private String numberPhone;
    private String address;

    public People(String idPeople, String namePeople, String numberPhone, String address) {
        this.idPeople = idPeople;
        this.namePeople = namePeople;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    public String getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(String idPeople) {
        this.idPeople = idPeople;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "idPeople='" + idPeople + '\'' +
                ", namePeople='" + namePeople + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
