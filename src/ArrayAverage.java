public class ArrayAverage {
    public static void arrayAverage(Object[] arr) {
        int sum = 0;
        int i = 0;
        try {
            while (true) {
                sum += (Integer) arr[i];
                i += 1;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(sum / i);
        }
        catch (ClassCastException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
