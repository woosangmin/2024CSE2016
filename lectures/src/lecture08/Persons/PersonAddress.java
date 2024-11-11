package Persons;

public class PersonAddress extends abstractPerson{
    private String address;

    public PersonAddress(String n, String a) {
        super(n);
        address = a;
    }

    public String getAddress() {
        return address;
    }
}
