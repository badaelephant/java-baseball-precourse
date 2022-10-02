package baseball.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * UI 입력 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Input {

    public static String getNumberInputFromPlayer() {
        Output.askPlayerInputNumber();
        return Console.readLine();
    }

    public static String getReplayInputFromPlayer() {
        Output.askPlayerInputReplay();
        return Console.readLine();
    }
}
