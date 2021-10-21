package Arrays_.sortClass;

public class Car01 implements Comparable<Car01>{

    private int speed;
    private String brand;

    public Car01(int speed, String brand) {
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
    public int compareTo(Car01 car01) { //此时在sort里面将以速度升序排序
        return Integer.compare(this.getSpeed(),car01.getSpeed());
    }
    //当this.getSpeed()>car.getSpeed() return 1
    //当this.getSpeed()<car.getSpeed() return -1
    //当this.getSpeed()=car.getSpeed() return 0

}
