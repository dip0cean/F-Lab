package Greedy;

import java.util.ArrayList;
import java.util.List;

public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱 joystick = new 조이스틱();
//        String name     = "ABBAAAABBABB";
//        String name     = "AAABBAAAAAAAAAA";
//        String name = "JEROEN";
//        String name = "JAN";
        String name = "BBBBAAABA";

        // case_1 > 실패
        System.out.println("case 1 : " + joystick.case_1(name));
        // case_2 > 실패
        System.out.println("case 2 : " + joystick.case_2(name));
        // case_3 > 성공
        System.out.println("case 3 : " + joystick.case_3(name));
        // case_4
        System.out.println("case 4 : " + joystick.case_4(name));
        // case_5 > 성공 (현덕님)
        System.out.println("case 5 : " + joystick.case_5(name));
        // case_6
        System.out.println("case 6 : " + joystick.case_6(name));
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
            # 문제점 : AAABBAAAAAAAAAA 같이 중간에만 변경해야 할 알파벳이 존재한다면 정확한 값을 도출하지 못한다.
                     물론 언제나 최적의 해를 도출하는 것은 아니지만, 위의 경우에는 6번이 최소 이동값인데!
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
            move = Math.min(move, (i * 2) + length - next);
        }
        answer += move;
        return answer;
    }

    public int case_4(String name) {
        int    answer  = 0;
        int    length  = name.length();
        int    maxMove = length - 1; // 커서 최대 이동값은 문자열 길이 - 1
        int    minMove = 0;
        char[] charArr = name.toCharArray();

        for (int i = 0; i < length; i++) {
            // 알파벳 변경 시, 상하 최소 이동값
            answer += Math.min('Z' - charArr[i] + 1, charArr[i] - 'A');

            // 커서 변셩 시, 좌우 최소 이동값
            // 다음 인덱스
            int next = i + 1;
            // 조건 1. 다음 인덱스 값이 문자열의 길이를 초과 할 수 없다.
            // 조건 2. 다음 인덱스의 알파벳이 'A' 일 경우, 상하로 움직일 필요가 없다.
            while (next < length && charArr[next] == 'A') {
                next++;
            }

            int backCount = i + i + length - next;
            if (maxMove > next) {
                minMove = Math.max(minMove, next);
                if (minMove > backCount) {
                    minMove = backCount;
                    i = next;
                } else {
                    i = next - 1;
                }
            } else if (maxMove == next) {
                minMove = backCount;
                i = next - 1;
            } else if (next == length) {
                break;
            }
        }
//        System.out.println("minMove : " + minMove + " / maxMove : " + maxMove);
        answer += Math.min(maxMove, minMove);

        return answer;
    }

    // 현덕님 풀이
    public int case_5(String name) {
        char[]        nameToChar    = name.toCharArray(); //name을 char[]으로 변환
        int           strLength     = name.length();
        int[]         charCount     = new int[strLength]; //각 배열마다 A를 int로 변경하는 값을 기록하기 위함.
        int           wordCost      = 0; //A를 변경한 횟수
        List<Integer> wordCountList = new ArrayList<>(); //A가아닌 문자열들의 인덱스를 기록하는 리스트

        //단어변환시 드는 소모값 계산
        for (int i = 0; i < strLength; i++) {
            charCount[i] = nameToChar[i] - 65; //char형을 아스키코드로 전환, A일때 변환 필요가 없으므로 0이다.
            if (charCount[i] > 13) {// A에서 변환하는 횟수가 절반이상이면 반대로 접근하는것이 더빠르다.
                charCount[i] = 26 - charCount[i];
            }
            //A가 아닌 단어들의 갯수 계산
            if (charCount[i] > 0) {
                wordCountList.add(i);
            }
            //단어변환 시 드는 비용 계산
            wordCost = wordCost + charCount[i];
        }

        //커서움직일때 드는 값 변환
        int cur      = 0; //nameToChar배열의 현재 가리키는 위치 변수
        int moveCost = 0; //커서를 옮긴 횟수

        while (wordCountList.size() > 0) {
            Integer[] tmp             = new Integer[wordCountList.size()]; //A가아닌 글자로 옮길 소요값 저장하는 임시배열
            int       nearestDistance = strLength / 2; // 현재위치에서 가장 작은 소요값을 찾기위한 변수
            int       listIndex       = 0; //가장 작은 소요값의 위치를 확인할 인덱스 변수

            for (int word = 0; word < wordCountList.size(); word++) {
                tmp[word] = Math.abs(wordCountList.get(word) - cur) > strLength / 2 ?
                        strLength - Math.abs(wordCountList.get(word) - cur) :
                        Math.abs(wordCountList.get(word) - cur);

                if (nearestDistance > tmp[word]) {
                    nearestDistance = tmp[word];
                    listIndex = word;
                }
            }
            cur = wordCountList.get(listIndex);
            wordCountList.remove(listIndex);
            moveCost += nearestDistance;
        }

        return moveCost + wordCost;
    }

    public int case_6(String name) {
        int    answer  = 0;
        int    length  = name.length();
        int    move    = length - 1;
        char[] charArr = name.toCharArray();


        int maxCount   = 0;
        int startIndex = 0;
        int endIndex   = 0;

        for (int i = 0; i < length; i++) {
            // 상하 이동
            answer += Math.min('Z' - charArr[i] + 1, charArr[i] - 'A');

            // 좌우 이동
            if (charArr[i] == 'A') {
                int next      = i + 1; // 현재의 다음 인덱스
                int thisCount = 1; // next 인덱스를 기준으로 얼만큼 연속되었는지
                while (next < length && charArr[next] == 'A') {
                    next++;
                    thisCount++;
                }
                // 현재 가장 긴 연속된 길이
                maxCount = Math.max(maxCount, thisCount);
                // 만약 thisCount 가 현재 가장 긴 길이라면
                if (maxCount == thisCount) {
                    // 해당 연속된 길이의 시작점
                    startIndex = i;
                    endIndex = next - 1;
                }
            }
        }

        int half     = length / 2;
        int backStep = endIndex + 1 == length ? endIndex - maxCount : ((startIndex - 1) * 2) + length - (endIndex + 1);
        System.out.println("maxCount : " + maxCount + " / half : " + half + " / startIndex : " + startIndex + " / endIndex : " + endIndex + " / move : " + move + " / backStep : " + backStep + " / answer : " + answer);
        if (endIndex > 0) {
            if (startIndex <= half) {
                if (startIndex == 0) {
                    move = move - endIndex;
                } else {
                    move = Math.min(move, backStep);
                }
            } else {
                move = Math.min(backStep - (move - endIndex), move);
            }
        }
        if (backStep < 0) {
            answer = 0;
            move = 0;
        }

        return answer + move;
    }
}
