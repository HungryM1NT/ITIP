import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FirthLab {
    public static void main(String[] args) {
        ArrayAverage.arrayAverage(new Object[]{1, 2, 3, 4, 5});
        ArrayAverage.arrayAverage(new Object[]{1, 2, 3, 4, "asd"});
        System.out.println();

        TextExceptions.textExceptions("textInput1.txt", "textOutput.txt");
        TextExceptions.textExceptions("wrongInput.txt", "newTextOutput.txt");
        System.out.println();

        File newfile = new File("textInput1.txt");

        try {
            if (newfile.exists()) {
                FileReader reader = new FileReader(newfile);
            }
            else {
                throw new CustomFileNotFoundException("Файл " + newfile + " не существует");
            }
        }
        catch (CustomFileNotFoundException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        newfile = new File("textInput11.txt");

        try {
            FileReader reader = new FileReader(newfile);
        }
        catch (Exception e) {
            try {
                if (!newfile.exists()) throw new CustomFileNotFoundException("Файл " + newfile + " не существует");
                System.out.println(e.getMessage());
            } catch (CustomFileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
