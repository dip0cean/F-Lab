package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class K번째수 {
    public static void main(String[] args) {
        int[]     arr      = {1, 5, 2, 6, 3, 7, 4};
        int[][]   commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        K번째수      test     = new K번째수();
        Integer[] answer   = test.solution(arr, commands);

        for (Integer value : answer) {
            System.out.println(value);
        }
    }

    public Integer[] solution(int[] arr, int[][] commands) {
        Integer[] result = new Integer[commands.length];
        final int[] index = {0};
        Arrays.stream(commands)
                .forEach(command -> {
                    int value = IntStream
                            .range(0, arr.length)
                            .filter(i -> (command[0] - 1) <= i && (command[1] - 1) >= i)
                            .mapToObj(i -> arr[i])
                            .sorted()
                            .collect(Collectors.toList()).get(command[2] - 1);
                    result[index[0]] = value;
                    index[0]++;
                });
        return result;
    }
}
