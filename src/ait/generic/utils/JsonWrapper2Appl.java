package ait.generic.utils;

public class JsonWrapper2Appl {
    public static void main(String[] args) {
        JsonWrapper2 <Integer   > wrapper2 = new JsonWrapper2<>(10);
        System.out.println(wrapper2 );
        Integer a =wrapper2.getValue();
        System.out.println(a);

    }
}
