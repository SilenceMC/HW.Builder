import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String currentCity;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.currentCity = personBuilder.currentCity;
    }

    public boolean hasAddress() {
        return currentCity != null;
    }

    public boolean hasAge() {
        return age != null;
    }


    public void happyBirthday() {
        if (hasAge()) {
            int currentAge = age.getAsInt();
            age = OptionalInt.of(currentAge + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setCurrentCity(currentCity);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", currentCity='" + currentCity + '\'' +
                '}';
    }
}



