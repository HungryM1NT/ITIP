public class Mover extends Thread {
    Storage storage1;
    Storage storage2;
    Car car;
    int index;
    boolean waiting = false;
    String waitPlace;
    public Mover(Storage storage1, Storage storage2, Car car, int index) {
        this.storage1 = storage1;
        this.storage2 = storage2;
        this.car = car;
        this.index = index;
        this.waitPlace = "storage1";
    }
    public void run() {
        while (!(storage1.isEmpty() && car.isEmpty())) {
            if (!waiting) {
                Good hand;
                if (car.place.equals("storage1")) {
                    if (!storage1.isEmpty()) {
                        hand = storage1.getProduct();
                        if (hand.weight != -1) {
                            if (hand.weight + car.amount <= 150) {
                                car.giveProduct(hand);
//                                System.out.println("Грузчик " + index + " положил в машину предмет весом " + hand.weight);
                            } else {
                                waiting = true;
                                storage1.giveProduct(hand);
                                car.waitMembers += 1;
                                if (car.waitMembers >= 3) {
                                    car.waitMembers = 0;
                                    car.place = "storage2";
                                }

                            }
                        }
                    } else {
                        waiting = true;
                        car.waitMembers += 1;
                        if (car.waitMembers >= 3) {
                            car.waitMembers = 0;
                            car.place = "storage2";
                        }
                    }
                } else {
                    if (!car.isEmpty()) {
                        hand = car.getProduct();
                        if (hand.weight != -1) {
//                            System.out.println("Грузчик " + index + " достал из машины предмет весом " + hand.weight);
                            storage2.giveProduct(hand);
                        }
                    } else {
                        waiting = true;
                        if (car.waitMembers + 1 >= 3) {
                            car.waitMembers = 0;
                            car.place = "storage1";
                        } else {
                            car.waitMembers += 1;
                        }
                    }
                }
            } else {
                if (!waitPlace.equals(car.place)) {
                    waiting = false;
                    waitPlace = car.place;
                }
            }
        }
    }
}
