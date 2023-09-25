public class SecondLab {
    public static void main(String[] args) {
        Student firstStudent = new Student();
        System.out.println(firstStudent.getInfo());
        System.out.println(firstStudent.isStandartGender());
        System.out.println();

        firstStudent.setGender("male");
        System.out.println(firstStudent.getInfo());
        System.out.println(firstStudent.isStandartGender());
        firstStudent.printCount();
        System.out.println();

        Teacher firstTeacher = new Teacher();
        System.out.println(firstTeacher.getInfo());
        firstStudent.printCount();
        firstTeacher.printCount();
        System.out.println();

        System.out.println(firstTeacher.answer(42));
        System.out.println(firstTeacher.answer("I need main answer"));
        System.out.println(firstTeacher.answer("Annoy"));
        System.out.println();

        TeachingAssistant firstTA = new TeachingAssistant(firstTeacher);
        System.out.println(firstTA.getTeacher());
        System.out.println(firstTA.getTeacher().getInfo());
        firstStudent.printCount();

    }
}
