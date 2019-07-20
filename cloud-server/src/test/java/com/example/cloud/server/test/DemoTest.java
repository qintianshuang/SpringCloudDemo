//package com.example.cloud.server.test;
//
//import com.example.cloud.server.controller.UserController;
//import org.junit.Test;
//
//public class DemoTest {
//
//    @Test
//    public void test(){
//        String a = "123";
//        String b = "123";
//        String c = new String("123");
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(c.hashCode());
//        System.out.println("---------------------");
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(a.equals(c));
//    }
//
//   /*
//   * 循环实现二分查找算法arr 已排好序的数组x 需要查找的数-1 无法查到数据
//   */
//    public static int binarySearch(int[] arr, int x) {
//        int low = 0;
//        int high = arr.length-1;
//        while(low <= high) {
//            int middle = (low + high)/2;
//            if(x == arr[middle]) {
//                return middle;
//            }else if(x <arr[middle]) {
//                high = middle - 1;
//            }else {
//                low = middle + 1;
//            }
//        }
//        return -1;
//    }
//
//    /***
//     *
//     * @param dataset 数据
//     * @param data  要查找的数据
//     * @param startIndex   开始下标
//     * @param endIndex  结束下标
//     * @return
//     */
//    //递归实现二分查找
//    public static int binarySearch(int[] dataset,int data,int startIndex,int endIndex){
//        int midIndex = (startIndex+endIndex)/2;
//        if(data < dataset[startIndex] || data > dataset[endIndex] || startIndex > endIndex){
//            return -1;
//        }
//        if(data <dataset[midIndex]){
//            return binarySearch(dataset,data,startIndex,midIndex-1);
//        }else if(data>dataset[midIndex]){
//            return binarySearch(dataset,data,midIndex+1,endIndex);
//        }else {
//            return midIndex;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int[] arr = { 6, 8, 12, 33, 58, 87, 90, 97, 108, 321, 465, 561 };
//        System.out.println("循环查找：" + (binarySearch(arr, 87)));
//        System.out.println("递归查找"+binarySearch(arr,561,0,arr.length-1));
//    }
//
//
//    @Test
//    public void test22(){
//        UserController userController = new UserController();
//        userController.addHelloPort();
//    }
//}
