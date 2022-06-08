package quicksort;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {

    public static ArrayList<Integer> sort(ArrayList<Integer> arrayList) {
        if (arrayList.size() < 2) {
            return arrayList;
        }
        else {
            int pivot = arrayList.get(0);
            ArrayList<Integer> less = new ArrayList<>();
            ArrayList<Integer> greater = new ArrayList<>();
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) <= pivot) {
                    less.add(arrayList.get(i));
                } else {
                    greater.add(arrayList.get(i));
                }
            }
            ArrayList<Integer> list = sort(less);
            list.add(pivot);
            list.addAll(sort(greater));
            return list;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = new Random().nextInt(1000);
            list.add(random);
        }
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();
        ArrayList<Integer> arrayList = QuickSort.sort(list);
        for (int i : arrayList)
            System.out.print(i + " ");

    }
}
