package Arrays_.sortClass;


public class Car02 implements Comparable{

    private int speed;
    private String brand;

    public Car02(int speed, String brand) {
        this.speed = speed;
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object car02) {
        return Integer.compare(this.getSpeed(),((Car02)car02).getSpeed());
    }
    //当this.getSpeed()>car.getSpeed() return 1
    //当this.getSpeed()<car.getSpeed() return -1
    //当this.getSpeed()=car.getSpeed() return 0

}

