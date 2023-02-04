import com.github.javafaker.Faker;

public class DataGenerator {

    public static final String NUMBER = "[1-9]{10}";
    public static String EMAIL = "wert@ert.com";

    /**
     * Экземпляр класса Faker
     */
    private static final Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomNumber() {
        return faker.regexify(NUMBER);
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomGender() {
        int i = (int) (Math.random() * (3 - 1 + 1) + 1);
        switch (i) {
            case 1 -> {
                return "Male";
            }
            case 2 -> {
                return "Female";
            }
            case 3 -> {
                return "Other";
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public static String getRandomSubjects() {
        return faker.educator().course();
    }
}