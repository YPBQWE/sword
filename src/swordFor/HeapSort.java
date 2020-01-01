package swordFor;

public class HeapSort {
    public static void heapSort(int[] arr) {

        if(arr == null ||arr.length == 0)
            return ;
        for(int i = arr.length/2-1;i>=0;i--){
            heapAdjust(arr,i,arr.length-1);
        }
        for(int i = arr.length-1;i>=0;i--){
            swap(arr,0,i);
            heapAdjust(arr,0,i-1);
        }
    }
    /**
     * 堆筛选，除了start之外，start~end均满足大顶堆的定义。
     * 调整之后start~end称为一个大顶堆。
     * @param arr 待调整数组
     * @param start 起始指针
     * @param end 结束指针
     */
    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for(int i = 2*start+1;i<=end;i*=2){
            if(i<end && arr[i]<arr[i+1])
                i++;
            if(temp>=arr[i])
                break;
            arr[start]=arr[i];
            arr[i]=temp;
            start=i;
        }

        // arr[start] = temp; //插入正确的位置
    }



    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {


    }

}

