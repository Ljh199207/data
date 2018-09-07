package com.data.basejava.arrays;

/**
 * @Auther: ljh
 * @Date: 2018/9/5 15:45
 * @Description:
 */
public class Penson implements java.lang.Comparable<Penson> {


        private  String name;
        private int age ;

    public Penson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
        public String toString() {
            return "penson{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
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
    public int compareTo(Penson o) {
        if(this.age>o.age)
            return 1;
        else if(this.age<o.age)
            return  -1;
        else
        return 0;
    }
}
