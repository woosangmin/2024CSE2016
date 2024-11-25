package Persons;

public class PersonAddrInt extends abstractPerson{
    private int address;

    public PersonAddrInt(String n, int a) {
        super(n);
        address = a;
    }
    public String getAddress() {
        return "" + address;
    }
}
