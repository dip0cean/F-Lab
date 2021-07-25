package Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {5, 9, 3, 30, 34};
//        int[]           numbers = {100, 20, 4, 1, 44, 45, 46, 99, 34, 4, 4, 4, 4, 1, 1, 11, 111, 101, 121, 43};
//        int[] numbers = {6, 10, 2};
        List<Integer[]> tmp     = 가장큰수.sorted(numbers);

        for (int i = 0; i < tmp.size(); i++) {
            int next = i + 1;
            while (next < tmp.size() && tmp.get(i)[1] == tmp.get(next)[1]) {
                next++;
            }

            if ((i + 1) < next) {
                System.out.println("겹치는 값 첫 인덱스 : " + i);
                System.out.println("겹치는 값 마지막 인덱스: " + (next - 1));
                List<Integer> consArr  = new ArrayList<>();
                boolean       checkMin = false;
                for (int k = i; k < next; k++) {
                    consArr.add(numbers[tmp.get(k)[0]]);
                    if (numbers[tmp.get(k)[0]] < 10) {
                        checkMin = true;
                    }
                }

                // 정렬
                consArr.sort(Comparator.reverseOrder());
                System.out.println(consArr);
                // 1. 숫자의 첫 번째 수가 연속되는 배열의 내림차순에서 일의 자리가 처음 나오는 인덱스 찾기
                if (checkMin) {
                    int findIndex    = 0;
                    int lastBigIndex = 0;
                    for (int t = 0; t < consArr.size(); t++) {
                        // 최소값이 1의 자리수 일 때의 인덱스 찾기
                        if (consArr.get(t) < 10) {
                            findIndex = t;
                            break;
                        }
                    }
                    for (int t = 0; t < consArr.size(); t++) {
                        // 각 자리수가 첫 째 자리수의 값보다 작을 때 (ex. 첫 째 자리수 : 1 일 때, 101)
                        System.out.println("2_consArr.get(t) : " + consArr.get(t));
                        String thisVal = String.valueOf(consArr.get(t));
                        for (int s = 1; s < thisVal.length(); s++) {
                            int thisNum = Integer.parseInt(String.valueOf(thisVal.charAt(s)));
                            // 연속된 기준값보다 작거나, 각 자리 수에서 0이 존재하는 경우
                            if ((thisNum > 0 && thisNum < tmp.get(i)[1]) || thisNum == 0) {
                                lastBigIndex = t;
                                break;
                            }
                        }
                        if (lastBigIndex != 0) {
                            break;
                        }
                    }
                    if (findIndex != 0) {
                        for (int t = findIndex - 1; t > lastBigIndex; t--) {
                            // 각 자리수가 첫 째 자리수의 값보다 작을 때 (ex. 첫 째 자리수 : 1 일 때, 101)
                            System.out.println("1_consArr.get(t) : " + consArr.get(t));
                            String thisVal = String.valueOf(consArr.get(t));
                            int    check   = 0;
                            for (int s = 1; s < thisVal.length(); s++) {
                                int thisNum = Integer.parseInt(String.valueOf(thisVal.charAt(s)));
                                System.out.println("thisNum : " + thisNum);
                                // 각 자리수의 값이 같은 경우
                                if (thisNum == tmp.get(i)[1]) {
                                    check++;
                                }
                            }
                            if (check == thisVal.length() - 1) {
                                findIndex = t;
                                break;
                            }
                        }
                    }

                    // 2. 1의 자리수가 중간 위치에 있을 경우
                    System.out.println("일의 자리수 등장 인덱스 : " + findIndex);
                    System.out.println("각 자리수가 첫 째 자리수의 값보다 작을 때 인덱스 : " + lastBigIndex);
                    List<Integer> newTmp = new ArrayList<>();
                    for (int n = 0; n < lastBigIndex; n++) {
                        newTmp.add(consArr.get(n));
                    }
                    for (int n = findIndex; n < consArr.size(); n++) {
                        newTmp.add(consArr.get(n));
                    }
                    for (int n = lastBigIndex; n < findIndex; n++) {
                        newTmp.add(consArr.get(n));
                    }
                    System.out.println(newTmp);
                    consArr = newTmp;
                }

                System.out.println(consArr);

                int tmpIndex = 0;
                for (int n = i; n < next; n++, tmpIndex++) {
//                    System.out.println("현재의 값 : " + tmp.get(n)[0] + " / " + tmp.get(n)[1]);
                    numbers[tmp.get(n)[0]] = consArr.get(tmpIndex);
//                    System.out.println("numbers[tmp.get(n)[0]] : " + numbers[tmp.get(n)[0]]);
                }

                i = (next - 1);
            }
        }

        // 문자열 출력
        System.out.println();
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(tmp.get(i)[0] + " / " + tmp.get(i)[1]);
            int next = i + 1;
            result += numbers[tmp.get(i)[0]] + ",";
        }
        System.out.println(result);
    }

    public static List<Integer[]> sorted(int[] numbers) {
        List<Integer[]> tmp = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            String    thisVal = String.valueOf(numbers[i]);
            Integer[] arr     = {i, Integer.parseInt(String.valueOf(thisVal.charAt(0)))};
            tmp.add(arr);
        }
        for (int i = 0; i < tmp.size() - 1; i++) {
            System.out.println("i : " + tmp.get(i)[0] + " / " + tmp.get(i)[1]);
            int tmpVal   = tmp.get(i)[1];
            int tmpIndex = i;
            for (int k = i + 1; k < tmp.size(); k++) {
                System.out.println("i + n : " + tmp.get(k)[0] + " / " + tmp.get(k)[1]);
                int nextVal = tmp.get(k)[1];
                if (tmpVal < nextVal) {
                    tmpVal = nextVal;
                    tmpIndex = k;
                }
            }

            // 내림차순으로 정렬
            Integer[] tmpArr = tmp.get(i);
            tmp.set(i, tmp.get(tmpIndex));
            tmp.set(tmpIndex, tmpArr);
            System.out.println("------------------------");
        }
        System.out.print("Index : [ ");
        for (Integer[] arr : tmp) {
            System.out.print(arr[0] + " ");
        }
        System.out.println("]");
        System.out.print("Value : [ ");
        for (Integer[] arr : tmp) {
            System.out.print(arr[1] + " ");
        }
        System.out.println("]");
        System.out.println("------------------------");
        return tmp;
    }
}
