package com.tommychan.javaselearning.map_;
/**
 * 使用HashMap添加3个员工对象，要求键：员工 id  值：员工对象
 * 并遍历显示工资 >9000的员工（遍历方式最少两种）员工类：姓名、工资、员工id
 */
import java.util.*;

public class MapExercise01 {
    public static void main(String[] args) {
        Map map = new HashMap();

        Employee tommy = new Employee("Tommy", 25000, "001");
        Employee jason = new Employee("Jason", 9000, "002");
        Employee charlie = new Employee("Charlie", 12000, "003");

        map.put(tommy.getId(),tommy);
        map.put(jason.getId(),jason);
        map.put(charlie.getId(),charlie);

        Collection collection = map.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Employee employee = (Employee) iterator.next();   //next方法的返回类型是Object 要向下转型
            if (employee.getSalary()>9000){
                System.out.println(employee);
            }
        }


        Set employee2 = map.entrySet();
        for (Object o:employee2) {
            Map.Entry employee = (Map.Entry) o; //getValue方法的返回类型是Object 要向下转型
            Employee employee1 = (Employee) employee.getValue();
            if (employee1.getSalary()>9000){
                System.out.println(employee1);
            }
        }
    }
}


class Employee{

    private String name;
    private double salary;
    private String id;

    public Employee(String name, double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}
