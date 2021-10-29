package com.tommychan.javaselearning.exercise;


import java.util.ArrayList;

public class Exercise01 {
    public static void main(String[] args) {

        ArrayList newsList = new ArrayList();
        newsList.add(new News("HengRiver COVID-19"));
        newsList.add(new News("FreeFish"));

        for (Object o:newsList) {
            News news = (News) o;
            if (news.getTitle().length()>10){
                System.out.println(news.getTitle().substring(0,10)+"...");
            }else {
                System.out.println(news.getTitle());
            }
        }
    }
}

class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }
}
