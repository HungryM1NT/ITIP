import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextExceptions {
    public static void textExceptions(String file1, String file2) {
        FileReader reader = null;
        FileWriter writer = null;
        try  {
            reader = new FileReader(file1);
            writer = new FileWriter(file2, false);
            try {
                int c;
                while ((c = reader.read()) != -1) {
                    writer.write((char) c);
                }
                System.out.println("Файл успешно скопирован");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        catch (IOException e) {
            System.out.println("Неверное название первого файла (открытие)");
        }
        finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            }
            catch (IOException e) {
                System.out.println("Неверное название первого файла (закрытие)");
            }
        }
    }
}
