package all.person;

public class Person {
    private static String name;
    private static String lastName;

    public Person(String name, String lastName){
        this.name =name;
        this.lastName =lastName;
    }

    public String toString(){
        return lastName +" " +name;
    }
}
