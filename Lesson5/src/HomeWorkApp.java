
public class HomeWorkApp {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer1", "ivivan@mailbox.com", "892312312", 30000, 31);
        persArray[1] = new Person("Petrov Ivan", "Engineer2", "mail2@mailbox.com", "892312312", 40000, 40);
        persArray[2] = new Person("Petrov Petr", "Engineer3", "mail3@mailbox.com", "892312312", 35000, 25);
        persArray[3] = new Person("John Smith", "farmer", "post1111@mailbox.com", "892312312", 10000, 50);
        persArray[4] = new Person("Harry Potter", "wizard", "hp@hogwarts.com", "892312312", 999999, 12);

         for (int i = 0; i< persArray.length; i++) {
            if (persArray[i].getAge() >= 40) {
                persArray[i].getInfo();
            }
        }
    }
}
