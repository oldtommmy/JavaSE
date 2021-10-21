package com.tommychan.enum_;

public class Enum_Exercise01 {
    public static void main(String[] args) {

        Week[] weeks = Week.values();
        for (Week week: weeks) {
            System.out.println(week);
        }
    }
}

enum Week{

    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Week{" +
                "name='" + name + '\'' +
                '}';
    }
}
