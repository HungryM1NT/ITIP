public class TeachingAssistant extends Student {
    private Teacher teacher;
    private String qualificationLevel ; // barchelors in science/masters in art etc
    private String mood;

    public TeachingAssistant(String startFirstName, String startSecondName, int startAge, String startGender,
                             int startTuitionFees, String startUniversity, String startGroup,
                             Teacher startTeacher, String startQualificationLevel, String startMood) {
        super(startFirstName, startSecondName, startAge, startGender, startTuitionFees, startUniversity,startGroup);
        teacher = startTeacher;
        qualificationLevel = startQualificationLevel;
        mood = startMood;
    }

    public TeachingAssistant(Teacher newTeacher) {
        this("Elena", "Popova", 24, "female",
                140000, "MTUCI", "MIT2201",
                newTeacher, "bachelor", "good");
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public String getQualificationLevel() { return qualificationLevel; }
    public String getMood() { return mood; }
    @Override
    public String getInfo() {return firstName + " " + secondName + " " + this.getAge() + " " + this.getGender() + " " +
            this.getTuitionFees() + " " + this.getUniversity() + " " + this.getGroup() + " " +
            teacher.getInfo() + " " + qualificationLevel + " " + mood;}

    public void setTeacher(Teacher newTeacher) { teacher = newTeacher; }
    public void setQualificationLevel(String newQualificationLevel) { qualificationLevel = newQualificationLevel; }
    public void setMood(String newMood) { mood = newMood; }

    @Override
    public String sayHi() { return "Good morning"; }
    public boolean isSameUni() {return this.getUniversity().equals(teacher.getUniversity()); }
}
