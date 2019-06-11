package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    static void printAll(String job, List<String> list){
        System.out.printf("[%16s]  \n", job);
        for(String s : list){
            System.out.println(s);
        }
        System.out.println();
    }
    public static void main(String[] a){
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("JDBC");
        list.add("Servlet");
        list.add(2, "Database");
        list.add("iBATIS");
        printAll("addAll", list);

        int size = list.size();
        System.out.println("객체 수 : " + size);

        String skill = list.get(2);
        System.out.println("2: " + skill);

        list.remove(2);
        printAll("remove(2)",list);

        list.remove(2);
        printAll("remove(2)",list);

        list.remove("iBATIS");
        printAll("remove(\"iBATIS\")", list);
    }
}
