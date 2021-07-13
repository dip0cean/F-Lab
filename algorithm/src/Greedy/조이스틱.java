package Greedy;

public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱   joystick = new 조이스틱();
        String name     = "ABAAABB";

        // case_1
        System.out.println("case 1 : " + joystick.case_1(name));
        // case_2
        System.out.println("case 2 : " + joystick.case_2(name));
        // case_3
        System.out.println("case 3 : " + joystick.case_3(name));
    }

    public int case_1(String name) {
        /*
            # 접근 방법 : 영문 대문자를 아스키코드의 값으로 치환한 후, 변경되어야 할 값과 기존의 값 ('A') 을 상황에 맞게 연산한다.
                        'N' 을 기준으로 name 변수의 n 번째 문자의 아스키코드 값이
                            1. 'N' 보다 크면 ▼
                            2. 'N' 보다 작으면 ▲
                        각 자리가 이동한 수 만큼 더한 후 해당 값에 name 변수의 문자열 길이를(좌우로 이동한 값) 더한다.

            # 문제점 :
                첫 번째에서 왼쪽으로 이동하는 경우의 수를 고려하지 못했다.
                무조건 오른쪽으로만 이동하기 때문에 테스트케이스 절반 이상에서 실패를 했다.
         */
        int answer = name.length() - 1;
        int N      = 'N';
        for (int num : name.toCharArray()) {
            if (N < num) {
                answer += 'Z' - num + 1;
            } else {
                answer += num - 'A';
            }
        }

        return answer;
    }

    public int case_2(String name) {
        /*
            # 접근 방법 : case_1 과 같은 방식이지만 'N' 을 기준으로 나뉘어진 연산 값 중 최소값만 알고 있으면 되기 때문에 'N' 을 기준으로 한 if 문을 제거.

            # 문제점 : case_1 과 동일
         */
        int answer = name.length() - 1;
        for (int num : name.toCharArray()) {
            answer += Math.min('Z' - num + 1, num - 'A');
        }
        return answer;
    }

    public int case_3(String name) {
        /*
            # 접근방법 : case_1 과 case_2 의 상하 조이스틱 이동수는 그대로 사용하되, 좌우 조이콘 이동에 대한 로직을 추가한다.
         */
        int    answer  = 0;
        int    length  = name.length();
        int    move    = length - 1;
        char[] charArr = name.toCharArray();

        for (int i = 0; i < length; i++) {
            // 상하 움직이는 값 계산
            answer += Math.min('Z' - charArr[i] + 1, charArr[i] - 'A');

            // 좌우 움직이는 값 계산
            int next = i + 1;
            while (next < length && charArr[next] == 'A') {
                next++;
            }
            // i + i > 현재 위차까지 갔다가 다시 처음으로 돌아간 만큼의 좌우 이동 횟수
            // length - next >
            //      현재의 next 는 연속적으로 A 가 나왔을 때, 마지막에 위치한 A의 인덱스 값
            //      배열의 길이에서 연속된 마지막 A 의 인덱스를 빼면 해당 인덱스 뒤에 남은 알파벳의 개수가 도출된다.
            //      이 때, 남은 알파벳의 개수는 현재 위치에서 뒤로 돌아갔을 때 바꿔야 할 수도 있는 알파벳의 개수이다. (BAB 혹은 BBA 혹은 BBB 일 수도 있다.)
            // * 이렇게 주어진 문자열의 길이만큼 순회하고 연속된 A 가 있다면 뒤로 돌아가는 것이 최소한의 움직임으로 바꿔야 하는 모든 알파벳으로 바꿀 수 있는 경우의 수도 존재하기 때문에
            //   이전 순회의 최소 좌우 이동 값과 현재 순회의 최소 좌우 이동 값을 최소 비교를 한다.
            move = Math.min(move, i + length - next + i);
        }
        answer += move;
        return answer;
    }
}
