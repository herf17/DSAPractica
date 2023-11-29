package rivas.hiram.ds.heaps;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int count=0;
        HeapMinImpl heap = new HeapMinImpl();
        A.forEach(heap::add);
        while(heap.peek() <= k){
            int firstmin = heap.poll();
            int secondtmin = heap.poll();
            heap.add(firstmin+(2*secondtmin));
            count++;
        }
        if(heap.isEmpty())
            return -1;
        /*System.out.println(Arrays.toString(heap.valores));
        System.out.println(count);*/

        return count;
    }

}

public class JessyAndCookies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/vyper/IdeaProjects/DSAPracticas/resources/heap/jesseandcookies/input/input01.txt"));
        FileWriter file = new FileWriter("ABC.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(file);

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
