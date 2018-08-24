package com.data.basejava.String;

public class TestClone implements Cloneable {

    private String name;
    private int age;

    public TestClone(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {

        return "姓名：" + this.name + ",年龄" + this.age;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestClone testClone1 = new TestClone("张三", 10);
        TestClone testClone2 = (TestClone) testClone1.clone();
        System.out.println(testClone1.toString());
        testClone2.setAge(20);
        System.out.println(testClone2.toString());
    }
}
