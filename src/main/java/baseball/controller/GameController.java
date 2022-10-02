package baseball.controller;

import baseball.domain.game.play.Computer;
import baseball.domain.game.play.Game;
import baseball.domain.game.play.GameRule;
import baseball.domain.game.play.Player;
import baseball.view.Input;

import java.util.List;

/**
 * 게임 컨트롤러 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class GameController {

    private final Game game;
    private final Player player;
    private final Computer computer;

    public GameController() {
        this.player = new Player();
        this.computer = new Computer();
        this.game = new Game();
    }

    public void startGame() {
        game.resetGame();
        List<Integer> computerNumbers = computer.generateNumbers();
        while (game.isPlaying()) {
            String inputNumbers = Input.getNumberInputFromPlayer();
            List<Integer> playerNumbers = player.pickNumbers(inputNumbers);
            game.updateGameResult(computerNumbers, playerNumbers);
        }
        askReplay();
    }

    private void askReplay() {
        String answer = Input.getReplayInputFromPlayer();
        if (answer.equals(GameRule.RESTART)) {
            startGame();
        }
    }
}
