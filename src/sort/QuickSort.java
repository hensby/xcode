package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quicksort1(int[] arr, int l, int r) {
        int i = l, j = r, stand = arr[i];
        if(l < r) {
            while(l < r) {
                while(l < r && arr[r] > stand) {
                    r--;
                }
                swap(arr, l, r);
                while(l < r && arr[l] < stand) {
                    l++;
                }
                swap(arr, l, r);
            }
            quicksort1(arr, i, l - 1);
            quicksort1(arr, l + 1, j);
        }
    }
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    public static void quickSort(int[] arr, int start, int end) {

        //当开始位置小于结束位置时（数组有数据）  进行排序  也就是递归入口
        if (start < end) {
            //首先找到基准数  作为比较的标准数  取数组开始位置   从哪里开始  用哪个数当标准数 这个就是标准数
            int stard = arr[start];
            //记录需要进行排序的下标
            int low = start;
            int high = end;

            //循环比对比标准数大和小的数字
            while (low < high) {
                //如果标准数小于右边的数字  把右边的游标卡尺向左移动
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                //如果标准数大于 右边的数字
                //用低位数字替换右边数字
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                //如果左边的数字比标准数大
                //用左边数字替换右边数字
                arr[high] = arr[low];
            }
            //把标准数赋给高或者低所在的元素
            arr[low] = stard;
            //处理所有比标准数小的数字
            quickSort(arr, start, low);
            //处理所有比标准数大的数字
            quickSort(arr, low + 1, end);
        }
    }

    public static void QuickSort2(int[] arr , int left , int right) {
        // 递归的出口必须仔细考虑清楚，否则就会陷入无穷循环从而使栈溢出
        if (left >= right) {
            return;
        }
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 这里如果pivot 选在左侧，就要先从右侧开始遍历，反之则先从左侧开始
            while (arr[j] > pivot && i < j) {
                j--;
            }
            // 找到比基准小的数换到左侧去
            arr[i] = arr[j];
            while (arr[i] < pivot && i < j) {
                i++;
            }
            // 找到比基准大的数换到右侧去
            arr[j] = arr[i];
        }
        // 最后将基准放到中间位置
        arr[i] = pivot;
        //  递归快排左侧数列
        QuickSort2(arr,left,i - 1);
        // 递归遍历右侧数列
        QuickSort2(arr, i + 1, right);
    }


    public static void main(String[] args) {
        int[] arr = {5,2,1,8,9,3,7,0,4,6};
        QuickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{5, 3, 4, 1, 6, 322, 66, 2, 78};
        //5, 3, 4, 1, 6, x, 66, 2 , 322
        // 5, 3, 4, 1, 6, 2, 66, x, 322
        // 5, 3, 4, 1, 6, 2, 66, 78, 322
        QuickSort2(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }
}
