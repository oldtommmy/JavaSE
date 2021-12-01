# JavaChapter5泛型

# 1.泛型

## （1）基本介绍

引出泛型（传统方法的缺陷）： 

- 不能对加入到集合ArrayList中的数据类型进行约束（不安全）<br />

- 遍历的时候，需要进行类型转换，如果集合中的数据量较大，对效率有影响

**泛型的优点：** 

- 编译时，检查添加元素的类型，提高了安全性<br />

- 减少了类型转换的次数，提高效率

- 不再提示编译警告

**理解：** 

- 泛型又称参数化类型，是Jdk5.0出现的新特性，解决数据类型的安性问题

- 在类声明或实例化时只要指定好需要的具体的类型即可。<br />

- Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮

- 泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型<br />


## （2）语法及应用

**泛型的声明** ：

`interface 接口<T>{}`和`class类<K,V>{}`  比如：List，ArrayList

说明：

1. 其中，T，K，V不代表值，而是表示类型。

2. 任意字母都可以。常用T表示，是Type的缩写

**泛型的实例化：** 

要在类名后面指定类型参数的值（类型）。如： 

`List <String> strList = new ArrayList<String>();`


**实例应用：** 

```Java
package com.tommychan.javalearing.generic_;

import java.util.*;
/**
        1．创建 3个学生对象
        2．放入到 HashSet中学生对象，使用
        3．放入到 HashMap中，要求 Key 是 String name，Value 就是 学生对象
        4．使用两种方式遍历
*/
public class Exercise01 {
    public static void main(String[] args) {

        //1.存入HashSet中
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("Tommy",19));
        students.add(new Student("Jack",17));
        students.add(new Student("Henry",24));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Student stu:students) {
            System.out.println(stu);
        }

        System.out.println("=========================");
        //2.存入HashMap
        HashMap<String, Student> students01 = new HashMap<>();
        students01.put("Tommy",new Student("Tommy",19));
        students01.put("Jack",new Student("Jack",17));
        students01.put("Henry",new Student("Henry",24));

        Set<Map.Entry<String,Student>> entrySet = students01.entrySet();
        for (Map.Entry entry:entrySet) {
            System.out.println(entry);
        }

    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```



## （3）注意事项及细节

- `interface List<``T``>{}`，` public class HashSet<``E``>{}`等等 说明：T，E只能是引用类型

- 在给泛型指定了具体类型后，可以传入该类型或其子类类型

- 泛型使用形式

&ensp;&ensp;&ensp;&ensp;- `List<Integer> list1 = new ArrayList<Integer>();`

&ensp;&ensp;&ensp;&ensp;- `List<Integer> list2 = new ArrayList<>();`** 推荐！！！** 

&ensp;&ensp;&ensp;&ensp;- 如果这样写 ： `List list3 = new ArrayList();`  则默认给它的泛型是Object


**练习：** 

定义Employee类<br />1）该类包含：private成员变量name，sal，birthday，其中 birthday为MyDate类的对 象；<br />2）为每一个属性定义 getter，setter方法； 3）重写 toString 方法输出 name，sal，birthday<br />4）MyDate类包含：private成员变量month，day，year；并为每一个属性定义 getter， setter 方法；<br />5）创建该类的3个对象，并把这些对象放入ArrayList集合中（ArrayList 需使用泛型来定义），对集合中的元素进行排序，并遍历输出：<br />排序方式：调用ArrayList的 sort方法，传入Comparator对象［使用泛型］，先按照 name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】

```Java
package com.tommychan.javalearing.generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercise02 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom",25000,new MyDate(2002,4,26)));
        employees.add(new Employee("henry",18000,new MyDate(2001,5,21)));
        employees.add(new Employee("ann",35000,new MyDate(1998,4,26)));
        employees.add(new Employee("ann",25000,new MyDate(1998,4,25)));

        System.out.println(employees);
        System.out.println("================================");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) {
                    return i;
                }

                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        System.out.println(employees);
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int compareTo(MyDate o1) {

        int yearMinus = this.getYear() - o1.getYear();
        if (yearMinus != 0) {
            return yearMinus;
        }

        int monthMinus = this.getMonth() - o1.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }

        int dayMinus = this.getDay() - o1.getDay();
        if (dayMinus != 0) {
            return dayMinus;
        }
        return 0;
    }
}

class Employee{
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}'+"\n";
    }
}



```



## （4）自定义泛型类

**基本语法：** 

```Java
class 类名<T,R...> {//...表示可有多个泛型
   成员
}
```


**注意细节：** 

- 普通成员可以使用泛型（属性、方法）<br />

- **使用泛型的数组，不能初始化**  （因为数组在new的时候不确定类型，无法开辟空间）

- 静态属性或方法中不能使用类的泛型 （因为类加载时，对象还未创建，静态方法不能确定类型，无法完成类加载）

- 泛型类的类型，是在创建对象时确定的（因为创建对象时，需要指定确定类型）<br />

- 如果在创建对象时，没有指定类型，默认为Object<br /><br /><br />

## （5）自定义泛型接口

**基本语法：** 

```Java
interface 接口名<T,R...>{
}
```


**注意细节：** 

- 接口中，静态成员也不能使用泛型（这个和泛型类规定一样）

- 泛型接口的类型，在继承接口或者实现接口时确定<br />

- 没有指定类型，默认为Object ，但**建议** 写上 `class A implements InterB<Object,Object> {}`


## （6）自定义泛型方法

**基本语法：** 

```Java
修饰符 <T,R...> 方法名(参数列表){}
```


**注意细节：** 

- 泛型方法，可以定义在普通类中，也可以定义在泛型类中<br />

- 当泛型方法被调用时，类型会确定<br />

- `public void eat(E e){}`，修饰符后没有＜T，R..＞eat 方法不是泛型方法，而是**使用了泛型** <br /><br /><br />

## （7）继承与通配符

- 泛型不具备继承性 `List<Object> list ＝ new ArrayList<String>(); //错误`

- `<?>`：支持任意泛型类型

- `<? extends A>`：支持A类以及A类的子类，规定了泛型的上限

- `<? super A>`：支持A类以及A类的父类，不限于直接父类，规定了泛型的下限<br /><br /><br />

# 2.JUnit

## （1）为什么需要JUnit—单元测试框架

- 一个类有很多功能代码需要测试，为了测试，就需要写入到main方法中<br />

- 如果有多个功能代码测试，就需要来回注销，切换很麻烦<br />

- 如果可以直接运行一个方法，就方便很多，并且可以给出相关信息，就会很方便


## （2）简单使用

1. 使用`@Test`写在需要测试的方法前，再alt+enter，选择JUnit5.4

2. 方法处就会出现run的箭头


```Java
package com.tommychan.javalearing.junit_;

import org.junit.jupiter.api.Test;

public class JUnit_ {
    public static void main(String[] args) {

        //传统方法来测试
        //m1();
        //m2();
    }

    @Test
    public void m1(){
        System.out.println("m1 is called");
    }

    @Test
    public void m2(){
        System.out.println("m2 is called");
    }
}
```


