package com.javaimplant.java17.features;

import com.javaimplant.java17.features.interfaces.Employee;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ImmutableCollectionSerializerMain {
    static void main() throws IOException, ClassNotFoundException {
        serialization();
        deSerialization();
    }

    private static void serialization() throws IOException {
        Employee emp = new Employee(1, "John Doe", "Engineering");
        Employee emp2 = new Employee(2, "Jane Smith", "Marketing");
        Employee emp3 = new Employee(3, "Alice Johnson", "Sales");
        List<Employee> ls = List.of(emp, emp2, emp3);
        String paths ="/tmp/emps.ser";
        FileOutputStream fos = new FileOutputStream(new File(paths));
        ObjectOutputStream oos =new ObjectOutputStream(fos);
        oos.writeObject(ls);
        oos.close();
        fos.close();
    }

    private static void deSerialization() throws IOException, ClassNotFoundException {
        String paths ="/tmp/emps.ser";
        FileInputStream fis = new FileInputStream(new File(paths));
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Employee> ls = (List<Employee>) ois.readObject();
        System.out.println(Arrays.deepToString(ls.toArray()));
    }

}
