import java.util.*;
import java.util.concurrent.*;

public class MaxNumber {
    public static int maxNumber(int[][] array) throws InterruptedException {
        int rows = array.length;
        ExecutorService service = Executors.newFixedThreadPool(rows);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            int index = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    int maxNum = array[index][0];
                    for (int j = 1; j < array[index].length; j++) {
                        maxNum = Math.max(maxNum, array[index][j]);
                    }
//                    System.out.println("Thread " + index);
                    list.add(maxNum);
                }
            });
        }
        service.shutdown();
        service.awaitTermination(4, TimeUnit.SECONDS);
//        System.out.println(Arrays.toString(list.toArray()));
        int answer = list.getFirst();
        for (int i = 1; i < list.size(); i++) {
            answer = Math.max(answer, list.get(i));
        }
        return answer;
    }
}
