package ru.ssau.tk.mixanbac.sandbox;

public class Person {
    private String firstName;
    private String lastName;
    private int passportId;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPassportId() {
        return passportId;
    }
}

class Task1 {
    public static void main(String[] args) {
        Person elena = new Person();
        Person vlada = new Person();

        elena.setFirstName("Elena");
        elena.setLastName("Ivanova");
        elena.setPassportId(758304);

        vlada.setFirstName("Vlada");
        vlada.setLastName("Petrova");
        vlada.setPassportId(953023);
    }

}

