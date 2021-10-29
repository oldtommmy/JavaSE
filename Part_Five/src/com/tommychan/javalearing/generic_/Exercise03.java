package com.tommychan.javalearing.generic_;

import java.util.*;

public class Exercise03 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001",new User("tom",18,"001"));
        userDAO.save("002",new User("jack",20,"002"));
        userDAO.save("003",new User("mary",25,"003"));

        System.out.println("001:"+userDAO.getT("001"));

        userDAO.update("001",new User("tom",19,"001"));
        System.out.println("001:"+userDAO.getT("001"));
        System.out.println("=======================");

        Collection<User> collection = userDAO.list();
        for (User user:collection) {
            System.out.println(user.toString());
        }
        System.out.println("=======================");

        userDAO.delete("001");
        for (User user:collection) {
            System.out.println(user.toString());
        }

    }
}

class User{
    private String name;
    private int age;
    private String id;

    public User(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}

class DAO<T>{

    private Map<String,T> hashMap = new HashMap<>();

    public void save(String id,T entity){
        hashMap.put(id,entity);
    }

    public T getT(String id){
        return hashMap.get(id);
    }

    public void update(String id,T entity){
        hashMap.replace(id,entity);
    }

    public List<T> list(){
        List<T> users = new ArrayList<>();
        users.addAll(hashMap.values());
        return  users;
    }

    public void delete(String id){
        hashMap.remove(id);
    }

}
