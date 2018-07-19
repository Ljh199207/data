package com.data.io;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomAccessTest {

    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1988, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1988, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1988, 3, 15);

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("employ.dat"));
            for (Employee e : staff)
                writeData(out, e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RandomAccessFile in = new RandomAccessFile("employee.dat", "r");
        int n = (int)(in.length() / Employee.RECORD_SIZE);
        Employee[] newStaff = new Employee[n];
        for (int i = n - 1; i >= 0; i--)
        {
            newStaff[i] = new Employee();
            in.seek(i * Employee.RECORD_SIZE);
            newStaff[i] = readData(in);
        }

        // print the newly read employee records
        for (Employee e : newStaff)
            System.out.println(e);
    
    }

    private static Employee readData(RandomAccessFile in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m - 1, d);
    }

    private static void writeData(DataOutputStream out, Employee e) throws IOException {

        DataIO.writeFixedStirng(e.getName(),Employee.NAME_SIZE,out);
        out.writeDouble(e.getSalary());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH)+1);
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
