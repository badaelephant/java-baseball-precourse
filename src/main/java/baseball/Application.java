package baseball;

import baseball.controller.GameController;

/**
 * 최상위 어플리케이션 클래스(main)
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();
    }
}
