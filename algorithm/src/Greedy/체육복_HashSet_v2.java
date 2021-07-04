package Greedy;

import java.util.HashSet;
/*
    해당 코드는 정렬이 안된 테스트 케이스에서 실패한다.
    어떻게 하면 간결하게 해결 할 수 있을까?
 */
public class 체육복_HashSet_v2 {
    public static void main(String[] args) {
        int   n       = 4;
        int[] lost    = {4, 2};
        int[] reserve = {3, 1};

        // 현재 대여 가능한 학생 수
        HashSet<Integer> set      = new HashSet<>();
        int[]            students = new int[n];

        for (int l : lost) {
            set.add(l);
            int idx = l - 1;
            if (idx > -1) {
                students[idx] = -1;
            }
        }

        for (int r : reserve) {
            int idx = r - 1;
            if (idx > -1) {
                if (set.contains(r)) {
                    set.remove(r);
                    students[idx] = 0;
                } else {
                    students[idx] = 1;
                    int prev = idx - 1;
                    int next = idx + 1;
                    if (prev > -1 && students[prev] == -1) {
                        students[prev] = 0;
                        students[idx] = 0;
                    }

                    if (next < students.length && students[next] == -1 && students[idx] == 1) {
                        students[next] = 0;
                        students[idx] = 0;
                    }
                }
            }
        }

        for (int student : students) {
            System.out.println(student);
        }
    }
}
