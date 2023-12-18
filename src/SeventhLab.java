public class SeventhLab {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ArraySum.arraySum(new int[]{1, 4, 6, 8, 34}));
        System.out.println(ArraySum.arraySum(new int[]{1, 2, 3, 4}));
        System.out.println();

        int[][] a = new int[][]{
                {3},
                {4, 112, 6},
                {4, 45},
                {43, 5, 12}
        };
        System.out.println(MaxNumber.maxNumber(a));
        System.out.println();

        Good firstItem = new Good(30);
        Good secondItem = new Good(50);
        Good thirdItem = new Good(40);
        Good fourthItem = new Good(30);
        Good fifthItem = new Good(50);
        Good sixthItem = new Good(70);
        Good seventhItem = new Good(110);

        Storage storage1 = new Storage();
        storage1.giveProduct(firstItem);
        storage1.giveProduct(secondItem);
        storage1.giveProduct(thirdItem);
        storage1.giveProduct(fourthItem);
        storage1.giveProduct(fifthItem);
        storage1.giveProduct(sixthItem);
        storage1.giveProduct(seventhItem);

        Storage storage2 = new Storage();

        Car car = new Car();

        Mover mover1 = new Mover(storage1, storage2, car, 1);
        Mover mover2 = new Mover(storage1, storage2, car, 2);
        Mover mover3 = new Mover(storage1, storage2, car, 3);

        System.out.println(storage1.goodsList);
        System.out.println(storage2.goodsList);

        mover1.start();
        mover2.start();
        mover3.start();

        try {
            mover1.join();
            mover2.join();
            mover3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(storage1.goodsList);
        System.out.println(storage2.goodsList);
    }
}