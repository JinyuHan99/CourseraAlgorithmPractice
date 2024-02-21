import java.util.Arrays;
import java.util.Scanner;

public class SortDemo {
    public static void main(String[] args) {

        int[] arr = {9, 5, 7, 465, 54, 8, 4, 1, 7, 545, 45, 1238, 48, 469, 91, 3, 60, 52, 3, 0, 8, 20, 6, 5864, 58, 4, 854, 30, 530, 54, 635};
        System.out.println("bubble_sort: " + Arrays.toString(bubble_sort(arr)));
        System.out.println("select_sort: " + Arrays.toString(select_sort(arr)));
        System.out.println("insert_sort: " + Arrays.toString(insert_sort(arr)));

    }
//    1. 冒泡排序
//    冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
//    算法描述
//    比较相邻的元素。如果第一个比第二个大，就交换它们两个；
//    对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
//    针对所有的元素重复以上的步骤，除了最后一个；
//    重复步骤1~3，直到排序完成。每循环一次，需要遍历的元素少一个，直至需要遍历的元素个数为0.循环停止。
//
//    代码优化
//    在数据完全有序的时候展现出最优时间复杂度，为O(n)。其他情况下，几乎总是O( n2 )。因此，算法在数据基本有序的情况下，性能最好。
//    要使算法在最佳情况下有O(n)复杂度，需要做一些改进，增加一个swap的标志，当前一轮没有进行交换时，说明数组已经有序，没有必要再进行下一轮的循环了，直接退出。

    //    稳定性
//    在相邻元素相等时，它们并不会交换位置，所以，冒泡排序是稳定排序。
//
//    适用场景
//    冒泡排序思路简单，代码也简单，特别适合小数据的排序。但是，由于算法复杂度较高，在数据量大的时候不适合使用。
    public static int[] bubble_sort(int[] arr) {

        for (int j = arr.length - 1; j >= 0; j--) {
            boolean swap = false;
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            if (swap == false) {
                return arr;
            }
        }
        return arr;
    }
//    2. 选择排序
//    选择排序是一种简单直观的排序算法，它也是一种交换排序算法，和冒泡排序有一定的相似度，可以认为选择排序是冒泡排序的一种改进。
//
//    算法描述
//    在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
//    从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
//    重复第二步，直到所有元素均排序完毕。

    //    稳定性
//    用数组实现的选择排序是不稳定的，用链表实现的选择排序是稳定的。
//    不过，一般提到排序算法时，大家往往会默认是数组实现，所以选择排序是不稳定的。
//
//    适用场景
//    选择排序实现也比较简单，并且由于在各种情况下复杂度波动小，因此一般是优于冒泡排序的。在所有的完全交换排序中，选择排序也是比较不错的一种算法。但是，由于固有的O(n2)复杂度，选择排序在海量数据面前显得力不从心。因此，它适用于简单数据排序。
    public static int[] select_sort(int[] arr) {

        for (int j = 0; j < arr.length; j++) {
            int min = j;
            for (int i = j; i < arr.length; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            if (min != j) {
                int temp = arr[j];
                arr[j] = arr[min];
                arr[min] = temp;
            }
        }

        return arr;
    }

    //    3. 插入排序
//    插入排序是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
//
//    算法描述
//    把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
//    从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
//    重复上述过程直到最后一个元素被插入有序子数组中。
//
//    稳定性
//    由于只需要找到不大于当前数的位置而并不需要交换，因此，直接插入排序是稳定的排序方法。
//
//    适用场景
//    插入排序由于O( n2 )的复杂度，在数组较大的时候不适用。但是，在数据比较少的时候，是一个不错的选择，一般做为快速排序的扩充。例如，在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，用于少量元素的排序。又如，在JDK 7 java.util.Arrays所用的sort方法的实现中，当待排数组长度小于47时，会使用插入排序。
    public static int[] insert_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;
            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = value;
        }
        return arr;
    }

    public static int[] quick_sort(int[] arr){

        return arr;
    }
}
