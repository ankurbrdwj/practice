package gangoffour.classic.structural.creational.singleton;

public class HayStorage {
    private int quantity = 0;

    private HayStorage() {
    }

    private static volatile HayStorage instance = new HayStorage();

    public static HayStorage getInstance() {
        if (instance == null) {
            synchronized (HayStorage.class) {
                if (instance == null) {
                    instance = new HayStorage();
                }
            }
        }
        return instance;
    }

        public synchronized void addHay ( int amount){
            quantity += amount;
        }

        public synchronized boolean removeHay ( int amount){
            if (quantity < amount) return false;
            quantity -= amount;
            return true;
        }

        public synchronized int getHayQuantity () {
            return quantity;
        }
    }
