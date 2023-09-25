public class Teacher extends Human{
    private String subject;
    private String university;
    private String qualification;

    public Teacher(String startFirstName, String startSecondName, int startAge, String startGender,
                   String startSubject, String startUniversity, String startQualification) {
        super(startFirstName, startSecondName, startAge, startGender);
        subject = startSubject;
        university = startUniversity;
        qualification = startQualification;
    }

    public Teacher() {
        this("Peter", "Petrov", 30, "male",
                "VVIT", "MTUCI", "docent");
    }

    public String getSubject() { return subject; }
    public String getUniversity() { return university; }
    public String getQualification() { return qualification; }
    @Override
    public String getInfo() {return firstName + " " + secondName + " " + this.getAge() + " " + this.getGender() + " " +
            subject + " " + university + " " + qualification;}

    public void setSubject(String newSubject) { subject = newSubject; }
    public void setUniversity(String newUniversity) { university = newUniversity; }
    public void setQualification(String newQualification) { qualification = newQualification; }

    public String answer(int number) {
        if (number == 42) return "Yes"; else return "No";
    }
    public int answer(String question) {
        if (question.equals("I need main answer")) return 42; else return -1;
    }
}