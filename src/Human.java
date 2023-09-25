public abstract class Human {
    public String firstName;
    public String secondName;
    private int age;
    private String gender;
    static int count;

    public Human(String startFirstName, String startSecondName, int startAge, String startGender) {
        firstName = startFirstName;
        secondName = startSecondName;
        age = startAge;
        gender = startGender;
        count++;
    }

//     public Human() {
//        this("Ivan", "Ivanov", 30, "attackHelicopter");
//    }

    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getInfo() {return firstName + " " + secondName + " " + age + " " + gender;}

    public void setFirstName(String newFirstName) { firstName = newFirstName; }
    public void setSecondName(String newSecondName) { secondName = newSecondName; }
    public void setAge(int newAge) { age = newAge; }
    public void setGender(String newGender) { gender = newGender; }


    public boolean isStandartGender() { return gender.equals("male") || gender.equals("female"); }
    public int howManyHumans() { return count;}
    public String sayHi() { return "Hi"; }
    public void printCount() { System.out.println(count); }
}
