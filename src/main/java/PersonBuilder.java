import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String currentCity;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным.");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null) {
            throw new IllegalStateException("Отсутствует обязательное поле name");
        }
        if (surname == null) {
            throw new IllegalStateException("Отсутствует обязательное поле surname");
        }
        return new Person(this);
    }

}
