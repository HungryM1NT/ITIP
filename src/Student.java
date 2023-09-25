public class Student extends Human{
    private int tuitionFees;
    private String university;
    private String group;

    public Student(String firstName, String secondName, int age, String startGender,
                   int startTuitionFees, String startUniversity, String startGroup) {
        super(firstName, secondName, age, startGender);
        tuitionFees = startTuitionFees;
        university = startUniversity;
        group = startGroup;
    }

    public Student() {
        this("Ivan", "Ivanov", 19, "attackHelicopter",
                0, "MTUCI", "BVT2301");
    }

    public int getTuitionFees() { return tuitionFees; }
    public String getUniversity() { return university; }
    public String getGroup() { return group; }
    @Override
    public String getInfo() {return firstName + " " + secondName + " " + this.getAge() + " " + this.getGender() + " " +
        tuitionFees + " " + university + " " + group;}

    public void setTuitionFees(int newTuitionFees) { tuitionFees = newTuitionFees; }
    public void setUniversity(String newUniversity) { university = newUniversity; }
    public void setGroup(String newGroup) { group = newGroup; }

    public boolean isBudget() { return tuitionFees == 0;}
    public String fullName() { return secondName + firstName + group; }
}
