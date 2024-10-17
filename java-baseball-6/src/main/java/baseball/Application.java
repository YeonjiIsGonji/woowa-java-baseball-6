package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        /**
         * 사용자가 입력한 3자리 숫자와 computer 숫자가 같은지를 체크하는 게임
         * 같은 숫자를 입력하면 게임을 새로 시작할지, 종료할 지 체크
         */

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // computer 랜덤 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // 게임 시작
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String number = Console.readLine();

                if (number.length() > 3) {
                    throw new IllegalArgumentException();
                }

                int ball = 0;
                int strike = 0;

                for (int i = 0; i < 3; i++) {
                    int num = Integer.parseInt(String.valueOf(number.charAt(i)));
                    if (num == computer.get(i)) {
                        strike++;
                    } else if (computer.contains(num)) {
                        ball++;
                    }
                }

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String select = Console.readLine();
                    if (select.equals("1")) {
                        break;
                    } else if (select.equals("2")) {
                        return;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (ball == 0 & strike == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
        }
    }
}
