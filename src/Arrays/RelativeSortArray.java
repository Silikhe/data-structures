package Arrays;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RelativeSortArray {
//    Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//
//    Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
//
//
//
//            Example 1:
//
//    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//    Output: [2,2,2,1,4,3,3,9,6,7,19]
//    Example 2:
//
//    Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//    Output: [22,28,8,6,17,44]
//
//
//    Constraints:
//
//            1 <= arr1.length, arr2.length <= 1000
//            0 <= arr1[i], arr2[i] <= 1000
//    All the elements of arr2 are distinct.
//    Each arr2[i] is in arr1.

//        public int[] relativeSortArray(int[] a, int[] b) {
//            int n=a.length;
//            int k=b.length;
//            int x=0,l=0,sum=0,w=0;
//            int count=0;
//            int c[]=new int[n];
//            for(int i=0;i<k;i++)
//            {
//                x=0;
//                for(int j=0;j<n;j++)
//                {
//                    if(b[i]==a[j])
//                    {
//                        x++;
//                    }
//                }
//                l=sum;
//                sum+=x;
//                for(int p=l;p<sum;p++)
//                {
//                    c[p]=b[i];
//                }
//            }
//            for(int i=0;i<n;i++)
//            {
//                count=0;
//                for(int j=0;j<k;j++)
//                {
//                    if(a[i]==b[j])
//                    {
//                        count++;
//                    }
//                }
//                if(count==0)
//                {
//                    w++;
//                }
//            }
//            int q[]=new int[w];
//            int y=0;
//            for(int i=0;i<n;i++)
//            {
//                count=0;
//                for(int j=0;j<k;j++)
//                {
//                    if(a[i]==b[j])
//                    {
//                        count++;
//                    }
//                }
//                if(count==0)
//                {
//                    q[y]=a[i];
//                    y++;
//                }
//            }
//            int r=0;
//            Arrays.sort(q);
//            for(int i=sum;i<n;i++)
//            {
//                c[i]=q[i-sum];
//                r++;
//            }
//            return c;
//        }

//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        return Arrays.stream(arr1)
//                .boxed()
//                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum))
//                .entrySet()
//                .stream()
//                .sorted(Comparator.comparing((first) -> IntStream.range(0, arr2.length).filter(i -> first.getKey() == arr2[i]).findFirst().orElse(first.getKey() + 1000)))
//                .flatMapToInt(item -> Stream.iterate(item.getKey(), i -> i).limit(item.getValue()).mapToInt(i -> i))
//                .toArray();
//    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int largest = 0;
        // get the largest element from arr1
        for(int i=0; i<arr1.length; i++)
            largest = Math.max(arr1[i], largest);

        // create an array of size (largest+1) to store frequencies of elements in arr1
        int[] frequencies = new int[largest+1];
        for(int i=0; i<arr1.length; i++)
            frequencies[arr1[i]]++;

        int index = 0;
        for(int i=0;  i<arr2.length;  i++){
            // insert the current element of arr2 till freqeuncy of this element in arr1 becomes 0
            while((frequencies[arr2[i]]--) > 0)
                arr1[index++] = arr2[i];
        }

        // insert the remaining elements of arr1 as per their frequencies  which were not present in arr2
        for(int i=1;  i<frequencies.length;  i++){
            while((frequencies[i]--) > 0)
                arr1[index++] = i;
        }
        return arr1;
    }
}
