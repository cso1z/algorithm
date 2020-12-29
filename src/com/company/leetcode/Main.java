package com.company.leetcode;

import com.company.leetcode.array.RemoveDuplicates;
import com.company.leetcode.array.Rotate;
import com.company.leetcode.list.AddTwoNumbers;

public class Main {

    static Main main = new Main();

    public static void main(String[] args) {
//        main.removeDuplicates();
        main.Rotate();
        main.addTwoNumbers();
    }

    private void addTwoNumbers() {
        main.print("两数相加");
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(2, new AddTwoNumbers.ListNode(4, new AddTwoNumbers.ListNode(3)));
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(5, new AddTwoNumbers.ListNode(6, new AddTwoNumbers.ListNode(4,new AddTwoNumbers.ListNode(1))));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    //删除排序数组中的重复项
    private void removeDuplicates() {
        main.print("删除排序数组中的重复项");
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] origin = new int[]{1, 1, 1, 2, 3, 3, 4, 5, 5, 5, 5};
        int endIndex = removeDuplicates.removeDuplicates(origin);
        main.printArray(origin, endIndex);
    }

    //旋转数组
    private void Rotate() {
        main.print("旋转数组");
        int[] origin1 = new int[]{1, 2, 3, 4,};
        int[] origin2 = new int[]{1, 2, 3, 4};
        Rotate rotate = new Rotate();
        rotate.rotate1(origin1, 2);
        main.printArray(origin1, origin1.length);
        rotate.rotate2(origin2, 2);
        main.printArray(origin2, origin2.length);
    }


    private void printArray(int[] array, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
            main.print(array[i]);
        }
        main.print("");
    }

    private void print(Object object) {
        System.out.println(object.toString());
    }
}
