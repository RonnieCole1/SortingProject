/**
 * This is the starter code for the sorting project in CSCI 220. Note that there
 * are multiple files.
 *
 * This class is your driver class. It will control the flow of your program.
 * It will also contain your actual sorts.
 */
package sortingprojectsimplified;

import java.util.ArrayList;

/**
 * @version Starter Code
 * @author Katie Timmerman
 */
public class SortingProjectSimplified {

    //You should change this size as you are testing your program
    final static int LIST_SIZE = 15;

    /**
     * This is the method where your program begins running. Once this method is
     * done your program is done.
     */
    public static void main(String[] args) {
        testingMyCircularLL();
        testingAllSortingAlgorithms();

    }

    /**
     * This method tests the functionality of MyCircularLL
     */
    private static void testingMyCircularLL() {
        MyCircularLL list = new MyCircularLL();

        list.add(12);
        list.add(10);
        list.append(14);

        System.out.println("The list should be [10 12 14]: " + list);

        list.remove();
        System.out.println("The list should be [12 14]: " + list);

        list.add(8);
        System.out.println("The list should be [8 12 14]: " + list);

        System.out.println("The index of 8 should be 0: " + list.indexOf(8));
        System.out.println("The index of 14 should be 2: " + list.indexOf(14));
        System.out.println("The index of 9 should be -1: " + list.indexOf(9));

        list.remove(12);
        System.out.println("The list should be [8 14]: " + list);
        System.out.println("The index of 12 should be -1: " + list.indexOf(12));

        list.empty();
        System.out.println("The list should be []: " + list);
        System.out.println("The index of 8 should be -1: " + list.indexOf(8));

        list.add(6);
        list.append(9);
        list.add(4);
        list.add(3);
        list.add(2);
        list.append(10);

        System.out.println("The list should be [2 3 4 6 9 10]: " + list);
        list.remove(2);
        System.out.println("The list should be [3 4 6 9 10]: " + list);
        list.remove(10);
        System.out.println("The list should be [3 4 6 9]: " + list);

        System.out.println("The index of 2 should be -1: " + list.indexOf(2));
        System.out.println("The index of 10 should be -1: " + list.indexOf(10));
        System.out.println("The index of 3 should be 0: " + list.indexOf(3));
        System.out.println("The index of 9 should be 3: " + list.indexOf(9));

    }

    /**
     * Method tests all the sorting algorithms You can comment out sections to
     * only test sorts in certain categories
     */
    private static void testingAllSortingAlgorithms() {
        System.out.println("Testing Sorting Group 1");
        testSort(1);
        System.out.println("\n\n\nTesting Sorting Group 2");
        testSort(2);

    }

    /**
     * This runs a sorting algorithm on an array, MyLinkedList, and a dynamic
     * array. It creates lists using createUnsorted<List>(). It then prints
     * lists. It will sort the lists using the specified group & re-print lists.
     *
     * @param group a number between 1 and 3 inclusive that represents the
     * sorting algorithm
     */
    private static void testSort(int group) {
        //create lists
        int[] listArray = createUnsortedListArray();
        ArrayList<Integer> listDynamicArray = createUnsortedListDynamicArray();

        //print lists
        System.out.println("Prior to Sorting:");
        System.out.print("Array: ");
        printArray(listArray);
        System.out.println("DA: " + listDynamicArray);

        //sort lists using group
        if (group == 1) {
            listArray = sortArrayInsertion(listArray);
            listDynamicArray = sortDAInsertion(listDynamicArray);
        } else if (group == 2) {
            listArray = sortArrayMerge(listArray);
            listDynamicArray = sortDAMerge(listDynamicArray);
        } else {
            System.err.println("Error: no group " + group + " exists.");
        }

        //re-print Lists
        System.out.println("\nAfter Sorting:");
        System.out.print("Array: ");
        printArray(listArray);
        System.out.println("DA: " + listDynamicArray);

    }

    /**
     * prints out the contents of the array using System.out
     *
     * @param ary
     */
    private static void printArray(int[] ary) {
        System.out.print("[ ");
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * Creates an array of LIST_SIZE that is filled with random integers between
     * 0 and 999.
     *
     * @return
     */
    private static int[] createUnsortedListArray() {
        int[] ary = new int[LIST_SIZE];
        for (int i = 0; i < LIST_SIZE; i++) {
            ary[i] = (int) (Math.random() * 1000);
        }
        return ary;
    }

    /**
     * Creates a MyCircularLL of LIST_SIZE that is filled with random integers
     * between 0 and 999.
     *
     * @return
     */
    private static MyCircularLL createUnsortedListLL() {
        MyCircularLL linkedList = new MyCircularLL();
        for (int i = 0; i < LIST_SIZE; i++) {
            int value = (int) (Math.random() * 1000);
            linkedList.add(value);
        }
        return linkedList;
    }

    /**
     * Creates an ArrayList of LIST_SIZE that is filled with random integers
     * between 0 and 999.
     *
     * @return
     */
    private static ArrayList<Integer> createUnsortedListDynamicArray() {
        ArrayList<Integer> dyAry = new ArrayList<Integer>();
        for (int i = 0; i < LIST_SIZE; i++) {
            int value = (int) (Math.random() * 1000);
            dyAry.add(value);
        }
        return dyAry;
    }

    /**
     * @param listArray
     */
    private static int[] sortArrayInsertion(int[] listArray) {
        int rightIndex = 1;
        //Increments the right element
        while (rightIndex < listArray.length) {
            int leftIndex = rightIndex - 1;
            //compares every element before the right element with
            //the left element, until we reach the beginning of the list
            int rightValue = listArray[rightIndex];
            while (leftIndex >= 0 && listArray[leftIndex] > rightValue) {
                //We swap the left element's value with the right element's value 
                listArray[leftIndex + 1] = listArray[leftIndex];
                leftIndex--;
            }
            listArray[leftIndex + 1] = rightValue;
            rightIndex++;
            leftIndex = rightIndex - 1;
        }
        return listArray;
    }

    /**
     * @param listDynamicArray
     */
    private static ArrayList<Integer> sortDAInsertion(ArrayList<Integer> listDynamicArray) {
        int rightIndex = 1;
        //Increments the right element
        while (rightIndex < listDynamicArray.size()) {
            int leftIndex = rightIndex - 1;
            int rightValue = listDynamicArray.get(rightIndex);
            //compares every element before the right element with
            //the left element, until we reach the beginning of the list
            while (leftIndex >= 0 && listDynamicArray.get(leftIndex) > rightValue) {
                //We swap the left element's value with the right element's valu
                int rightVal = listDynamicArray.get(leftIndex + 1);
                listDynamicArray.set(leftIndex + 1, listDynamicArray.get(leftIndex));
                listDynamicArray.set(leftIndex, rightVal);
                leftIndex--;
            }
            rightValue = listDynamicArray.get(leftIndex + 1);
            rightIndex++;
            leftIndex = rightIndex - 1;
        }
        return listDynamicArray;
    }

    /**
     * @param listArray
     */
    private static int[] sortArrayMerge(int[] listArray) {
        return mergeHelper(listArray, listArray.length - 1, 0);
    }

    private static int[] mergeHelper(int[] list, int upper, int lower) {
        if (upper - lower < 1) {
            return list;
        }
        int middle = (upper + lower) / 2;
        //recursive call on this method on the upper half
        list = mergeHelper(list, upper, middle + 1);

        //recursive call on this method on the bottom half
        list = mergeHelper(list, middle, lower);
        int[] sorted = new int[upper - lower + 1];
        int lowIndex = lower;
        int upperIndex = middle + 1;
        int count = 0;
        while (lowIndex < middle + 1 && upperIndex < upper + 1) {
            if (list[upperIndex] < list[lowIndex]) {
                sorted[count] = list[upperIndex];
                upperIndex++;
            } else {
                sorted[count] = list[lowIndex];
                lowIndex++;
            }
            count++;
        }
        while ( lowIndex < middle + 1 ) {
            sorted[count] = list[lowIndex];
            lowIndex++;
            count++;
        }
        while ( upperIndex < upper + 1) {
            sorted[count] = list[upperIndex];
            upperIndex++;
            count++;
        }
        //merge the two sorted parts back together
        for ( int i = 0; i < sorted.length; i++ ) {
            list[lower] = sorted[i];
            lower++;
        }
        return list;
    }

    /**
     * @param listDynamicArray
     */
    private static ArrayList<Integer> sortDAMerge(ArrayList<Integer> listDynamicArray) {
        return mergeHelperDynamic(listDynamicArray, listDynamicArray.size() - 1, 0);
    }

    private static ArrayList mergeHelperDynamic(ArrayList<Integer> list, int upper, int lower) {
        if (upper - lower < 1) {
            return list;
        }
        int middle = (upper + lower) / 2;
        //recursive call on this method on the upper half
        list = mergeHelperDynamic(list, upper, middle + 1);

        //recursive call on this method on the bottom half
        list = mergeHelperDynamic(list, middle, lower);
        int[] sorted = new int[upper - lower + 1];
        int lowIndex = lower;
        int upperIndex = middle + 1;
        int count = 0;
        while (lowIndex < middle + 1 && upperIndex < upper + 1) {
            if (list.get(upperIndex) < list.get(lowIndex)) {
                sorted[count] = list.get(upperIndex);
                upperIndex++;
            } else {
                sorted[count] = list.get(lowIndex);
                lowIndex++;
            }
            count++;
        }
        while ( lowIndex < middle + 1 ) {
            sorted[count] = list.get(lowIndex);
            lowIndex++;
            count++;
        }
        while ( upperIndex < upper + 1) {
            sorted[count] = list.get(upperIndex);
            upperIndex++;
            count++;
        }
        //merge the two sorted parts back together
        for ( int i = 0; i < sorted.length; i++ ) {
            list.set(lower, sorted[i]);
            lower++;
        }
        return list;
    }
}
