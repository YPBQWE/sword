package FastHand;

public class HeapSort {
    /**
     * 堆筛选，除了start之外，start~end均满足大顶堆的定义。
     * 调整之后start~end称为一个大顶堆。
     * @param arr 待调整数组
     * @param start 起始指针
     * @param end 结束指针
     */
    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];

        for(int i=2*start+1; i<=end; i*=2) {
            //左右孩子的节点分别为2*i+1,2*i+2

            //选择出左右孩子较大的下标
            if(i <end &&arr[i]<arr[i+1]) {
                i ++;
            }
            if(temp >= arr[i]) {
                break; //已经为大顶堆，=保持稳定性。
            }
            arr[start] = arr[i]; //将子节点上移
            arr[i]=temp;
            start = i; //下一轮筛选
        }

//        arr[start] = temp; //插入正确的位置
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0){
            return ;
        }

        //建立大顶堆
        for(int i=arr.length/2; i>=0; i--) {
            heapAdjust(arr, i, arr.length-1);
        }

        for(int i=arr.length-1; i>=0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i-1);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String [] args){
        int [] arr = new int []{11,2,0,5,7,111,4,5,1,2,3,19};
        int [] num = new int [5];
        int n = 0;
        for(int k=0;k<5;k++)
            num[k] = arr[k];
        heapSort(num);
        for(int i:num)
            System.out.print(" "+i);
        System.out.println();

        for(int j = num.length;j<arr.length;j++){
            if(arr[j]>num[0]) {
                num[0] = arr[j];
                 heapSort(num);
            }
        }

        for(int i:num)
            System.out.print(" "+i);

    }

}

