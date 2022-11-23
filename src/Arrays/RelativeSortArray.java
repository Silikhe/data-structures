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

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((first) -> IntStream.range(0, arr2.length).filter(i -> first.getKey() == arr2[i]).findFirst().orElse(first.getKey() + 1000)))
                .flatMapToInt(item -> Stream.iterate(item.getKey(), i -> i).limit(item.getValue()).mapToInt(i -> i))
                .toArray();
    }
}
