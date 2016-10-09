package org.darebeat.demo.sorts;

/**
 * Created by darebeat on 10/8/16.
 */
public class Test {
    public static void main(String[] args) {
        String[] arrs = {"we","are","the","world"};
        Sorts sorts = new Sorts<>();


        for (String a : arrs){
            System.out.print(a+" ");
        }
        System.out.println();

//        sorts.insertSort(arrs);
//        sorts.insertSort(arrs);
//        sorts.shellSort(arrs);

        sorts.changeSort(arrs);

        for (String a : arrs){
            System.out.print(a+" ");
        }
        System.out.println();
    }

}
