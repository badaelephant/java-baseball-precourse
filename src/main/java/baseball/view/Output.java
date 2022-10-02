package baseball.view;

import baseball.domain.messages.PlayMessage;

/**
 * 콘솔 Output 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Output {

    public static void askPlayerInputNumber() {
        System.out.println(PlayMessage.ASK_INPUT);
    }

    public static void askPlayerInputReplay() {
        System.out.println(PlayMessage.ASK_REPLAY);
    }

    public static void printGameResultMessage(String gameResult) {
        System.out.println(gameResult);
    }

    public static void printGamePlayMessage(String playMessage) {
        System.out.println(playMessage);
    }
}
