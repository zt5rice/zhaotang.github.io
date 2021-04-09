/*
1151. Minimum Swaps to Group All 1's Together

Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.

Example 1:

Input: data = [1,0,1,0,1]
Output: 1
Explanation:
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
Example 2:

Input: data = [0,0,0,1,0]
Output: 0
Explanation:
Since there is only one 1 in the array, no swaps needed.
Example 3:
               0 1 2 3 4 5 6
Input: data = [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation:
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
Example 4:

Input: data = [1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1]
Output: 8


Constraints:

1 <= data.length <= 105
data[i] is 0 or 1.
 */

public class MinimumSwap {

    public int minSwaps(int[] data)
    {
        // sanity check
        if(data == null || data.length==0) return 0;

        int numOnes = 0;
        for (int ele: data)
        {
            numOnes+=ele;
        }

        // sliding window [start, end]
        int start = 0;
        int end = numOnes-1;
        int initial = 0;

        for (int i =0; i <=end;i++)
        {
            initial+=data[i];
        }

        int min = numOnes- initial;  // 多少个1 - 初始有多少

        // slide
        while (end+1<data.length) // end <=data.length-1
        {
            // 1 shift at the time
            int curAtStart = data[start];
            int curValue = initial-curAtStart + data[end+1];
            int zeroRemains = numOnes - curValue;



            min = Math.min(min,zeroRemains);
            start++;
            end++;
            initial=curValue;

        }

        return min;
    }

    public static void main(String[] args) {
        MinimumSwap sol = new MinimumSwap();
        int[] data1= {1,0,1,0,1};
        int[] data2= {0,0,0,1,0};
        int[] data3= {1,0,1,0,1,0,0,1,1,0,1};
        int[] data4= {1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1};

        System.out.println(sol.minSwaps(data1));
        System.out.println(sol.minSwaps(data2));
        System.out.println(sol.minSwaps(data3));
        System.out.println(sol.minSwaps(data4));

    }
}
