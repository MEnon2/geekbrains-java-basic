public class Person {

    private String name;
    private String post;
    private String email;
    private String phone;
    private int wage;
    private int age;

    public static void main(String[] args) {

    }

    public Person(String name, String post, String email, String phone, int wage, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.wage = wage;
        this.age = age;
    }

    public void getInfo() {
        System.out.printf("name: %s, post: %s, email: %s, phone: %s, wage: %s, age: %s%n", this.name, this.post, this.email, this.phone, this.wage, this.age);
    }

    public int getAge() {
        return this.age;
    }
}
