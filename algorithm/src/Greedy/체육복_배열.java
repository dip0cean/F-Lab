package Greedy;

public class 체육복_배열 {
    public static void main(String[] args) {
        int   n       = 4; // 전체 인원수
        int[] lost    = {4, 2}; // 잃어버린 사람
        int[] reserve = {3, 1}; // 빌려줄 수 있는 사람

        int[] arr = new int[n]; // 전체 인원수 만큼의 배열방을 만든다.

        for (int idx : lost) {
            arr[idx - 1]--; // 잃어버린 사람 배열방의 값을 -1
        }

        for (int idx : reserve) {
            arr[idx - 1]++; // 대여 가능한 사람 배열방의 값을 1
        }

        for (int i = 0; i < arr.length; i++) {
            // 체육복 여분이 있는 학생
            int prev = i - 1; // 해당 학생의 앞 번호
            int next = i + 1; // 해당 학생의 뒷 번호

            // 앞 번호 학생부터
            if (prev > -1) {
                if (arr[prev] == -1 && arr[i] == 1) {
                    arr[prev] = 0;
                    arr[i] = 0;
                }
            }

            if (next < arr.length) {
                if (arr[next] == -1 && arr[i] == 1) {
                    arr[next] = 0;
                    arr[i] = 0;
                }
            }
        }

        int answer = 0;
        for (int result : arr) {
            if (result > -1) {
                answer++;
            }
            System.out.println(result);
        }

        System.out.println("answer : " + answer);
    }
}
