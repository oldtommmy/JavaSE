package com.tommychan.learning.exercise;
/**有关成员内部类的实例**/
//有一个Car类，有属性temperature（温度），车内有Air（空调）类，有吹风的功能flow，Air会监视车内的温度，
//如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，如果在这之间则关掉空调
//实例化具有不同温度的Car对象，调用空调的flow方法，测试空调吹的风是否正确
public class Exercise02 {
    public static void main(String[] args) {
        Car car = new Car(-2);
        Car car1 = new Car(23);

        car.getAir().flow(); //外部其他类的访问方法（1）在外部类写一个方法来返回内部类
        car1.getAir().flow();

        Car car2 = new Car(45);
        Car.Air air2 = car2.new Air(); //外部其他类的访问方法（2）
        air2.flow();
    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if (temperature>40){
                System.out.println("Cool wind is on");
            }else if (temperature<0){
                System.out.println("Warm wind is on");
            }else{
                System.out.println("0-40℃ Wind is off");
            }
        }
    }

    public Air getAir(){ //成员内部类 外部其他类的访问方法（1）
        return new Air();//在外部类写一个方法来返回内部类
    }
}
