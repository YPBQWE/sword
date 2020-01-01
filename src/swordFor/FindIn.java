/*
package swordFor;

import java.util.*;
//一袋子积木可以打多少层
*/
/*public static void main(String[] args) {  Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] ps = new Point[N];  //这里x是宽，y是长
        for (int i = 0; i  ps[i] = new Point(sc.nextInt(),sc.nextInt());  }
        Arrays.sort(ps, new Comparator() {
            @Override
            public int compare(Point p1, Point p2)
        {  //对x（宽）排序
         if( p1.x == p2.x )  return p1.y-p2.y;  return p1.x-p2.x;
        }
        });
        TreeSet dpSet = new TreeSet(new Comparator() {  //与上面不同，这里x是长，y是最大层数，该数据为特定长对应的最大长度  @Override  public int compare(Point o1, Point o2) {  return o1.x - o2.x;  }  }) ;
        for (Point p : ps) {  Point dp = new Point(p.y, 1);  Point dpTmp = dpSet.floor(dp);  //获取长小于等于p的数据  if( dpTmp == null ){  //数据不存在，此时的长最小，最大层数为1  dpSet.add(dp);  }else{  if( dpTmp.x == p.y ){  //若恰有该长的数据，数据对象最大层数+1  dp = dpTmp;  dp.y ++;  }else{  //若无对应数据，将新增点的层数设为小于其的点的层数+1  dp.y = dpTmp.y + 1;  dpSet.add(dp);  }  }  if( (dpTmp = dpSet.higher(dp)) != null && dpTmp.y == dp.y )  dpSet.remove(dpTmp);  //清理其后等于其层数的元素，因为若有后来的方块，只会叠加到此方块下，而不会选择长更大的方块  }
        System.out.println(dpSet.last().y);  }
     *//*

    class BinaryTree {

    TreeNode root;
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int paraValue)
        {
            this.value = paraValue;
        }
    }

    public BinaryTree(int[]array)
    {
        root = createBinaryTreeByArray(array, 0);
    }

    private TreeNode createBinaryTreeByArray(int []array,int index)
    {
        TreeNode tn = null;
        if (index<array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

public class FindIn {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean Find(int target, int[][] array) {
        if (array.length == 0)
            return false;
        int rows = array.length;
        int cols = array[0].length;
        int begin = array[0][cols - 1];
        int row = 0, col = cols - 1;
        while (row <= rows && col >= 0) {
            if (target > array[row][col])
                row++;
            else if (target < array[row][col])
                col--;
            else
                return true;
        }
        return false;
    }

    */
/**
     * 替换空格
     *
     * @param str
     * @return
     *//*

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0)
            return new String();
        int cnt = str.length() - 1;
        int length = str.length() - 1;
        for (int i = 0; i <= length; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
                cnt += 2;
            }
        }
        while (length >= 0) {
            if (str.charAt(length) != ' ') {
                str.setCharAt(cnt--, str.charAt(length));
            } else {
                str.setCharAt(cnt--, '0');
                str.setCharAt(cnt--, '2');
                str.setCharAt(cnt--, '%');
            }
            length--;
        }
        return str.toString();


    }

    public static ArrayList<Integer> ret = new ArrayList<Integer>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = next;
        }
        while (head.next != null) {

            ret.add(head.next.val);
            head = head.next;
        }
        return ret;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0 || array == null)
            return -1;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[left] == array[right] && array[left] == array[mid]) {
                int min = -1;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] < array[left])
                        min = array[i];
                }
                return min;
            }
            if (array[left] <= array[mid])
                left = mid;
            else if (array[right] > array[mid])
                right = mid - 1;
        }
        return array[mid];
    }

    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }


    public Stack<Integer> stack = new Stack<>();

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int cnt = 0;
        for (int i = 0; i < popA.length; i++) {
            if (popA[i] != pushA[cnt] && stack.search(popA[i]) == 0)
                stack.push(pushA[cnt++]);
            else {
                stack.pop();
            }
        }
        return stack.empty();

    }

    public static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        sort(input, k - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void sort(int[] input, int k) {
        int l = 0, h = input.length - 1;
        while (l < h) {
            int j = partition(input, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }

    }

    public static int prtation(int[] input, int l, int r) {
        int keyindex = l;
        int key = input[l];
        while (l < r) {
            while (l < r && input[r] >= key)
                r--;
            while (l < r && input[l] <= key)
                l++;
            swap(input, l, r);
        }
        swap(input, keyindex, l);
        return l;
    }

    private static int partition(int[] nums, int l, int h) {
        int p = nums[l];     */
/* 切分元素 *//*

        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }


    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public Queue<Integer> queue = new LinkedList<>();

    public static String PrintMinNumber(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (s1, s2) -> {
            return (s1 + s2).compareTo(s2 + s1);
        });
        String ret = "";
        for (String s : str) {
            ret += s;
        }
        return ret;
    }

    public   void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 0, 7, 3, 8}, 4));

    }
}
}
*/
