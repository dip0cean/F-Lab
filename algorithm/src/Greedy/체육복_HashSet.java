package Greedy;

import java.util.HashSet;

public class 체육복_HashSet {
    public static void main(String[] args) {
        int   n       = 5;
        int[] lost    = {1, 3, 5};
        int[] reserve = {2, 4, 5};

        // 현재 대여 가능한 학생 수
        HashSet<Integer> set      = new HashSet<>();
        int[]            students = new int[n];

        for (int i = 0; i < reserve.length; i++) {
            set.add(reserve[i]);
            if (reserve[i] > -1) {
                students[reserve[i] - 1] = 1;
            }
        }
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] > -1) {
                if (set.contains(lost[i])) {
                    set.remove(lost[i]);
                    students[lost[i] - 1] = 0;
                } else {
                    students[lost[i] - 1] = -1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < students.length; i++) {
            int prev = i - 1;
            int next = i + 1;
            if (prev > -1) {
                if (students[prev] == -1 && students[i] == 1) {
                    students[prev] = 0;
                    students[i] = 0;
                }
            }
            if (next < students.length) {
                if (students[next] == -1 && students[i] == 1) {
                    students[next] = 0;
                    students[i] = 0;
                }
            }
            System.out.println(students[i] + " / " + next + " / " + prev);
        }
    }
}
