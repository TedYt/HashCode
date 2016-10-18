package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * set集合里不能存放相同的内容，其判断相同内容的依据是存进去的这个对象的hashcode与set集合
 * 里面的各个对象的hashcode是否相同，相同的话，就存不进去；如果不同，就用equals方法比较，equal
 * 的规则可以自己写
 *
 * 下面的例子中，如果Person不重写hashcode，则两次打印的count都是3
 *
 */
public class Main {

    public static void changeStringTest(){
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("a",25);
        Person p2 = new Person("b",26);
        Person p3 = new Person("c",27);
        Person p4 = new Person("d",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);//d的年龄和c相同，即hashcode一样，Person认为是同一个对象，p4就加不进去，下面的输出是3
        System.out.println("set count is " + set.size());
        for (Person person : set){
            System.out.println(person);
        }


        p3.setAge(30);
        //Person 重写hashCode方法的话，这里p3就不会被移除
        //因为上面改了年龄，set里没有与之相等的年龄值，就找不到对应的对象
        //如果，把p3的年龄改成26（b的年龄），那remove p3的结果是：b将会移除，同时set里还有两个c
        set.remove(p3);
        set.add(p3);
        //Person 重写hashCode方法后，下面的输出是4；否则就是3
        System.out.println("after change p3, set count is " + set.size());
        for (Person person : set){
            System.out.println(person);
        }
    }


    static class Person{
        String name;
        int age;

        public Person(String name,int age) {
            this.age = age;
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return age == person.age;

        }

        @Override
        public int hashCode() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
