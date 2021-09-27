// 같은 문양의 숫자가 연속되게 3개 나오는 경우(예 9 8 7) > 서로 다른 문양의 같은 숫자
// 서로 다른 문양의 같은 숫자                         > 서로 다른 문양의 숫자가 연속되게 3개 나옴
// 서로 다른 문양의 숫자가 연속되게 3개 나옴            > 서로 같은 문양이 3개 나옴
// 무기간 상성이 존재한다고 가정한다(가위 바위 보처럼)
// 만약 서로 같은 문양의 숫자가 연속되게 나오는 케이스에서
// 창 987과 검 987 활 987 경우가 우연치않게 나왔다면 아래 상성을 따른다.
// 창 > 검
// 검 > 활
// 활 > 창
// 또한 창 987 vs 창 654는 큰 숫자로 구성된 쪽이 이겨야한다.

import java.util.HashMap;
import java.util.Map;
//가이드 코드 기반으로 2개의 매서드 작성 완료해보기
// 컴퓨터와 사용자가 있음
class ThreePoker {
    final int PATTERN_MAX = 3;
    final int CARD_MAX = 10;
    final int DISTRIBUTED_CARD_NUM = 4;

    final int USER = 1024;
    final int COMPUTER = 2048;

    private Map<String, Map<String, Integer>> map;
    private Map<String, Integer>[] preparedMap;
    private String[] pattern = {"spear", "sword", "arrow"};

    private int[][] dupNumArrCheck;  //[0][0]~[2][9]까지 배열을 나타냄(분배되는 카드를 나타내는 변수)

    private int[][] usrCard;
    private int[][] comCard;

    public ThreePoker () {
        map = new HashMap<String, Map<String, Integer>>();
        preparedMap = new HashMap[PATTERN_MAX];

        dupNumArrCheck = new int[PATTERN_MAX][CARD_MAX]; //[0][0]~[2][9]까지 배열을 나타냄(세가지 문양의 10가지 수가 적힌 카드의 배열)

        usrCard = new int[PATTERN_MAX][DISTRIBUTED_CARD_NUM];//[0][0]~[2][3]까지(분배되는 카드를 나타내는 배열)
        comCard = new int[PATTERN_MAX][DISTRIBUTED_CARD_NUM];

        for (int i = 0; i < PATTERN_MAX; i++) {
            preparedMap[i] = new HashMap<String, Integer>();

            for (int j = 0; j < CARD_MAX; j++) {
                preparedMap[i].put(pattern[i] + j, j);
            }

            for (int k = 0; k < DISTRIBUTED_CARD_NUM; k++) {
                usrCard[i][k] = -1;
                comCard[i][k] = -1;
            }
        }

        for (int i = 0; i < PATTERN_MAX; i++) {
            map.put(pattern[i], preparedMap[i]);
        }
    }

    public void printMap () {
        System.out.println(map);
    }

    public static Boolean checkDuplicate (
            int patternIdx, int randNum, int[][] randCheckArr) {

        if (randCheckArr[patternIdx][randNum] > 0) {
            return true;
        }

        return false;
    }

    public void distributeCard (int[][] arr, int identity) {  //컴퓨터와 사용자에게 카드를 나눠주는 메소드
        String sculpture;
        int sculptureIdx;
        int randNum;

        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            do {
                sculptureIdx = (int) (Math.random() * 3);
                randNum = (int) (Math.random() * 10);
            } while (checkDuplicate(sculptureIdx, randNum, dupNumArrCheck));

            sculpture = pattern[sculptureIdx];

            dupNumArrCheck[sculptureIdx][randNum]++;
            arr[sculptureIdx][cnt++] = randNum;

            if (identity == USER) {
                System.out.print("사용자");
            } else if (identity == COMPUTER) {
                System.out.print("컴퓨터");
            }

            System.out.println("에게 분배된 카드는 = " + sculpture +
                    " 문양의 " + randNum + " 카드입니다!");
        }
    }

    private Boolean checkTrippleWeapon (int[][] arr, int identity) {
        // 1. 문양도 일치해야하고
        // 2. 숫자가 연속되어야함
        if (!checkTripplePattern(arr, identity)) {
            return false;
        }

        // 1번이 검사 완료되었으므로 2번만 검사하면 된다.
        // 이 부분은 연속된 숫자를 검사하는 부분으로
        // checkTripplePattern() 부분을 작업하면 결과를 바로 얻을 수 있음
        if (!checkTrippleHarmonic(arr, identity)) {
            return false;
        }

        return true;
    }

    /* 아래 두 가지를 완성하면 자동으로 checkTrippleWeapon()은 완성이됩니다. */
    private Boolean checkTrippleNumber (int[][] arr, int identity) {
        //서로 다른 문양의 같은 숫자3개
        // 2. 처음 나오는 값의 숫자와 패턴을 파악한다.
        // 3. 문양이 다른지 확인 같은 숫자가 3개 있는지 확인 &&연산자를 사용해야하나?
        int[] savedRow = new int[DISTRIBUTED_CARD_NUM];
        int rowCnt = 0;

        int[] savedCol = new int[DISTRIBUTED_CARD_NUM];
        int colCnt = 0;

        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {
                // 주의해야할 것이 arr에 1, 0으로 값이 있다 없다가 아니라
                // 실제 셋팅된 값 자체가 배치되어 있다!
                // 그러므로 실제 사용하는 숫자 0이 들어간 경우 문제가 발생할 수 있음
                if (arr[i][j] != -1) {
                    savedRow[rowCnt++] = i;
                    savedCol[colCnt++] = j;
                }
            }
        }
        int patternCnt = 0;
        int secondaryPatternCnt = 0;

        // savedRow | 0 | 1 | 2 | 2 |
        for (int i = 0; i < DISTRIBUTED_CARD_NUM; i++) {
            if (savedCol[0] == savedCol[i]) {
                patternCnt++;
            }
            if (savedCol[1] == savedCol[i]) {
                secondaryPatternCnt++;
            }
        }

        if (patternCnt >= 3 || secondaryPatternCnt >= 3) {
            System.out.println("동일한 숫자 3개 이상 검출되었습니다!");
            return true;
        }

        return false;
    }
    private Boolean checkTrippleHarmonic (int[][] arr, int identity) {
        return false;
    }
    private Boolean checkTripplePattern (int[][] arr, int identity) {
        // 1. 전체를 순회하며 처음 나오는 값을 찾는다.
        // 2. 처음 나오는 값의 숫자와 패턴을 파악한다.
        // 3. 같은 패턴이 3개 존재하는지 검사한다.

        // 4. 만약 조건이 달성되지 않는다면 다시 2번째 값으로 위 작업을 반복한다.
        // 5. 2번째 값에서 판정이 되지 않았다면 다음을 검사할 필요가 없다!

        // ex) 창, 검, 활, 검
        // ex) 창, 검, 검, 검
        // ex) 활, 창, 활, 활
        // ex) 활, 창, 검, 활
        // ex) 창, 활, 창, 창
        int[] savedRow = new int[DISTRIBUTED_CARD_NUM];
        int rowCnt = 0;

        int[] savedCol = new int[DISTRIBUTED_CARD_NUM];
        int colCnt = 0;

        if (identity == USER) {
            System.out.println("사용자 데이터입니다.");
        } else if (identity == COMPUTER) {
            System.out.println("컴퓨터 데이터입니다.");
        }

        // 가만 보니 숫자 0이 들어가서 0 과 0이 같아서 구별이 안되는 문제도 있고
        // 조건이 0 보다 큰 것으로 잡아놨는데 0이니까 식별 자체를 안하는 문제가 겹쳤었음

        //  [0]  [1]  [2]  [3]
        // --------------------
        // | 0 | -1 | -1 | -1 |   [0] spear
        // --------------------
        // | -1 | 5 | -1 | -1 |   [1] sword
        // --------------------
        // | 2 | -1 | -1 | 1  |   [2] arrow
        // --------------------

        // savedRow | 0 | 1 | 2 | 2 |
        // savedCol | 7 | 7 | 0 | 3 |

        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {
                // 주의해야할 것이 arr에 1, 0으로 값이 있다 없다가 아니라
                // 실제 셋팅된 값 자체가 배치되어 있다!
                // 그러므로 실제 사용하는 숫자 0이 들어간 경우 문제가 발생할 수 있음
                if (arr[i][j] != -1) {
                    savedRow[rowCnt++] = i;
                    savedCol[colCnt++] = j;
                }
            }
        }

        int patternCnt = 0;
        int secondaryPatternCnt = 0;

        // savedRow | 0 | 1 | 2 | 2 |
        for (int i = 0; i < DISTRIBUTED_CARD_NUM; i++) {
            if (savedRow[0] == savedRow[i]) {
                patternCnt++;
            }
            if (savedRow[1] == savedRow[i]) {
                secondaryPatternCnt++;
            }
        }

        System.out.println(pattern[savedRow[0]]);
        System.out.println("첫 번째 패턴과 일치하는 개수 = " + patternCnt);
        System.out.println(pattern[savedRow[1]]);
        System.out.println("두 번째 패턴과 일치하는 개수 = " + secondaryPatternCnt);

        if (patternCnt >= 3 || secondaryPatternCnt >= 3) {
            System.out.println("동일한 패턴 3개 이상 검출되었습니다!");
            return true;
        }

        return false;
    }

    private String checkPattern (int[][] arr, int identity) {
        // 현재 케이스에서 바로 일반화를 적용하기는 어려움
        // 그러므로 각각의 패턴들에 대한 검사를 항목별로 만들어준다.
        if (checkTrippleWeapon(arr, identity)) {
            return "TrippleWeapon";
        } else if (checkTrippleNumber(arr, identity)) {
            return "TrippleNumber";
        } else if (checkTrippleHarmonic(arr, identity)) {
            return "TrippleHarmonic";
        } else if (checkTripplePattern(arr, identity)) {
            return "TripplePattern";
        } else {
            return "Bang";
        }
    }

    // 먼저 승리 패턴에 대한 분석이 필요함
    // 1. 같은 문양의 연속된 숫자 3개       - 트리플 웨폰(TrippleWeapon)
    // 2. 서로 다른 문양의 같은 숫자        - 트리플 넘버(TrippleNumber)
    // 3. 서로 다른 문양 + 연속된 숫자 3개  - 트리플 하모닉(TrippleHarmonic)
    // 4. 서로 같은 문양                  - 트리플 패턴(TripplePattern)
    // 5. 아무것도 아님                   - 꽝(Bang)
    public void checkWinner () {  //승패 확인
        // 1. String 값으로 각각의 패를 가져오도록 한다.
        String usr = checkPattern(usrCard, USER);
        String com = checkPattern(comCard, COMPUTER);

        System.out.println("사용자 패 검사: " + usr);
        System.out.println("컴퓨터 패 검사: " + com);
    }

    public void playGame () {
        Boolean wantContinue = false;

        do {
            distributeCard(usrCard, USER); //사용자에게 분배된 카드들 출력
            System.out.println("------------------절취선------------------");
            distributeCard(comCard, COMPUTER); //컴퓨터에게 분배된 카드들 출력
            printArr(usrCard, USER); //밑에있는 printArr메소드를 출력
            System.out.println("------------------절취선------------------");
            printArr(comCard, COMPUTER);//밑에있는 printArr메소드를 출력
            checkWinner();
        } while (wantContinue);
    }

    public void printArr (int[][] distArr, int identity) { //사용자와 컴퓨터에게 카드가 올바르게 나눠졌는지 확인하는 코드
        if (identity == USER) {
            System.out.println("사용자");
        } else if (identity == COMPUTER) {
            System.out.println("컴퓨터");
        }

        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {
                System.out.printf("distArr[%d][%d] = %3d ", i, j, distArr[i][j]);
            }
            System.out.println();
        }
    }
}

public class Prob57 {
    public static void main(String[] args) {
        ThreePoker tp = new ThreePoker();

        tp.playGame();
    }
}