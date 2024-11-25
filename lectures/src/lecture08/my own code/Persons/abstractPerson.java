package Persons;

public abstract class abstractPerson {

    private String name;

    public abstractPerson(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public abstract String getAddress();
}
