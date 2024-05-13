package org.example.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        Class<?> aClass = Class.forName("org.example.reflection.Car");
//        Car car = new Car(234, "asdas");
//        Class<? extends Car> carClass2 = car.getClass();
//        Class<Car> carClass = Car.class;
//        Field[] declaredFields = carClass.getDeclaredFields();
//        for (Field field : declaredFields)
//            System.out.println(field);
//
//        declaredField();
//        getFieldsExample();
//        getFieldExample();
//        getDeclaredMethodsExample();
//        getDeclaredMethodExample();
//        Car car = new Car(12, "sad", "asd") {
//            @Override
//            public void printSerialNumber() {
//
//            }
//        };
//
//        Method enclosingMethod = car.getClass().getEnclosingMethod();
//        System.out.println(enclosingMethod);
//        fieldExample();
//        fieldExamplePrivate();
//        fieldExampleChange();
        methodExample();
    }

    public static void declaredField() throws NoSuchFieldException {
        Class<Car> carClass = Car.class;
        Field horsepower = carClass.getDeclaredField("horsepower");
        System.out.println(horsepower);
        Field anotherField = carClass.getDeclaredField("dasd");
    }

    public static void getFieldsExample() {
        Class<Car> carClass = Car.class;
        Field[] fields = carClass.getFields();
        for (Field field : fields)
            System.out.println(field);
    }

    public static void getFieldExample() throws NoSuchFieldException {
        Class<Car> carClass = Car.class;
        Field field = carClass.getField("carName");
        System.out.println(field);
    }

    public static void getDeclaredMethodsExample() throws NoSuchFieldException {
        Class<Car> carClass = Car.class;
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method method : declaredMethods)
            System.out.println(method);
    }

    public static void getDeclaredMethodExample() throws NoSuchMethodException {
        Class<Car> carClass = Car.class;
        Method declaredMethod = carClass.getDeclaredMethod("setCarName", String.class);
        System.out.println(declaredMethod);
    }

    public static void fieldExample() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car(500, "123", "123");

        Class<? extends Car> carClass = car.getClass();

        Field serialNumber = carClass.getDeclaredField("serialNumber");

        String serialNumberValue = (String) serialNumber.get(car);
        System.out.println(serialNumberValue);
    }

    public static void fieldExamplePrivate() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car(500, "123", "123");

        Class<? extends Car> carClass = car.getClass();

        Field horserpowerField = carClass.getDeclaredField("horsepower");

        horserpowerField.setAccessible(true);

        int anInt = horserpowerField.getInt(car);
        System.out.println(anInt);

        System.out.println(horserpowerField.getName());
        System.out.println(horserpowerField.getType());
        System.out.println(horserpowerField.getModifiers());
        System.out.println(Modifier.isPrivate(horserpowerField.getModifiers()));
        System.out.println(Modifier.isFinal(horserpowerField.getModifiers()));

        System.out.println(Arrays.toString(horserpowerField.getAnnotations()));
        Annotation[] annotations = carClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    public static void fieldExampleChange() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car(500, "123", "123");

        Class<? extends Car> carClass = car.getClass();

        Field serialNumber = carClass.getDeclaredField("serialNumber");
        System.out.println(car);
        serialNumber.setAccessible(true);
        serialNumber.set(car, "new value");
        System.out.println(car);
    }

    public static void methodExample() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Car car = new Car(500, "123", "123");

        Class<? extends Car> carClass = car.getClass();

        Method getHorserpowerMethod = carClass.getMethod("getHorsepower");
        System.out.println(getHorserpowerMethod.getName());
        System.out.println(getHorserpowerMethod.getModifiers());
        System.out.println(Arrays.toString(getHorserpowerMethod.getAnnotations()));
        System.out.println(Arrays.toString(getHorserpowerMethod.getExceptionTypes()));
        System.out.println(getHorserpowerMethod.getParameterCount());
        System.out.println(Arrays.toString(getHorserpowerMethod.getParameterTypes()));
        System.out.println(getHorserpowerMethod.getReturnType());
        System.out.println(getHorserpowerMethod.getGenericReturnType()); // T
        System.out.println(getHorserpowerMethod.getDeclaringClass());
        System.out.println(getHorserpowerMethod.isSynthetic());
        System.out.println(getHorserpowerMethod.isBridge());
        System.out.println(getHorserpowerMethod.isDefault());
        System.out.println(getHorserpowerMethod.isVarArgs());

        getHorserpowerMethod.setAccessible(true);

        Object result = getHorserpowerMethod.invoke(car);
        System.out.println(result);
    }
}
