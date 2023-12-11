class Sum {
    private int nowSum;
    public void addNumber(int number) {
        nowSum += number;
    }

    public int getSum() {
        return nowSum;
    }
}

class MyThread extends Thread {
    private Sum sum;
    private int start;
    private int finish;
    private int[] array;
    public MyThread(Sum sum, int start, int finish, int[] array) {
        this.sum = sum;
        this.start = start;
        this.finish = finish;
        this.array = array;
    }
    public void run() {
        while (start != finish) {
            sum.addNumber(array[start]);
            start++;
        }
    }
}

public class ArraySum {
    public static int arraySum(int[] numbers) {
        Sum sum = new Sum();
        int middle = numbers.length / 2;
        MyThread thread1 = new MyThread(sum, 0, middle, numbers);
        MyThread thread2 = new MyThread(sum, middle, numbers.length, numbers);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum.getSum();
    }
}
