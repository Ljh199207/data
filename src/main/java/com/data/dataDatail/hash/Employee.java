package com.data.dataDatail.hash;

public class Employee {

    private String name;
    private Double salary;
    private int seniory;
    public  boolean equals(Object rhs)
    {
        return rhs instanceof Employee && name.equals(((Employee) rhs).name);
    }

    public int hashCode()
    {
        return  name.hashCode();
    }
}
