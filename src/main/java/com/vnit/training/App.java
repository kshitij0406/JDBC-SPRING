package com.vnit.training;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        JdbcDao ds = context.getBean("jdbcDao", JdbcDao.class);

//        User user = new User();
        String name, city;
        Scanner scan = new Scanner(System.in);
////        System.out.println("Enter Name and city");
////        user = ds.getUserDetails(scan.nextLine(),scan.nextLine());
////
////        System.out.println("Name: " + user.getName() + " City: " + user.getCity());

//
//        for(User user :ds.getALlUserDetails() ){
//            System.out.println("Name: " + user.getName() + " City: " + user.getCity());
//        }
        System.out.println("Enter Name");
        name = scan.nextLine();
        System.out.println("Enter City");
        city = scan.nextLine();
        ds.addNewData(new User(name, city));
    }


}
