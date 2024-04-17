package edu.itstep;


import edu.itstep.annotation.AnnotationName;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * main class
 */
public class Main implements Serializable {
    /**
     * main
     *
     * @param args params
     */
    @AnnotationName(value = "asdasd", name = "Sasha")
    @SuppressWarnings("Unhandled exception: java.io.FileNotFoundException")
    public static void main(@AnnotationName("args") String[] args) {
//        Animal animal = new Animal();
//        System.out.println(animal);
//        Integer i = new Integer(5);
//
//        System.out.println(i);
//
//        @SuppressWarnings("'getYear()' is deprecated")
//        int year = new Date().getYear();
//
//        Calendar instance = Calendar.getInstance();
//        System.out.println(instance.get(Calendar.YEAR));
//        FileInputStream fileInputStream = new FileInputStream("");
//        Group pinkFloyd = new Group() {
//            int a = 4;
//
//            private void test(){}
//            @Override
//            public String bestAlbum() {
//                return "Album";
//            }
//        };
//
//
//        class Test implements Group{
//
//            @Override
//            public String bestAlbum() {
//                return null;
//            }
//        }
//        System.out.println(pinkFloyd.bestAlbum());
        Group group = new Group() {
            @Override
            public String bestAlbum() {
                element();
                return "Wish you were here";
            }

            static void element() {

            }
        };
//        group.
//        showGroup();
    }

    private static void showGroup(Group group) {
        System.out.println(group.bestAlbum());
    }

    interface Group {
        String bestAlbum();
    }
}