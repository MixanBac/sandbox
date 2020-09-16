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

    Person(){
        firstName = "Mixan";
        lastName = "Bac";
        passportId = 734849;
    }

    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(int passportId){
        this.passportId = passportId;
    }

    Person(String firstName, String lastName, int passportId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
    }

    public static void main(String[] args){
        Person firstPerson = new Person();
        Person secondPerson = new Person("Elena", "Ivanova");
        Person thirdPerson = new Person("Vlada", "Petrova", 953023);
        Person fourthPerson = new Person(758304);

        System.out.println(firstPerson.getPassportId());
        System.out.println(secondPerson.getFirstName());
        System.out.println(thirdPerson.getPassportId());
        System.out.println(fourthPerson.getLastName());
    }

}


