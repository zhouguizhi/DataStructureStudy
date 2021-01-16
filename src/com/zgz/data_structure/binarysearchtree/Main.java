package com.zgz.data_structure.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{7,4,9,2,5,8,11,3};
//        BinarySearchTree1<Integer> binarySearchTree1 = new BinarySearchTree1();
//        for(int i:arr){
//            binarySearchTree1.add(i);
//        }

        BinarySearchTree<Person> binarySearchTree12 = new BinarySearchTree(new Comparator() {
            @Override
            public int compareTo(Object e1, Object e2) {
                return 0;
            }
        });
    }

}
class Person implements Comparable<Person>{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.age-person.age;
    }
}
