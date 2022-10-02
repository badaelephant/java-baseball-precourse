package baseball;

import baseball.controller.GameController;

/**
 * @info 최상위 어플리케이션 클래스 - 컨트롤러를 통해 게임을 시작함
 * @action Game Start!!
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();
    }
}
