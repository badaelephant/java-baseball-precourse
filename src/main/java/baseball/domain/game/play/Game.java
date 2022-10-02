package baseball.domain.game.play;


import baseball.domain.game.result.Result;
import baseball.domain.messages.PlayMessage;
import baseball.view.Output;

import java.util.List;

/**
 * 게임 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Game {

    private Result result;
    private GameStatus status;


    public Game() {
        this.result = new Result();
        this.status = GameStatus.PLAYING;
    }

    public void updateGameResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        result.checkResult(computerNumbers, playerNumbers);
        showMessage();
        checkFinish();
    }

    private void checkFinish() {
        if (result.isFinished()) {
            Output.printGamePlayMessage(PlayMessage.GAME_FINISH_SUCCESS);
            this.status = GameStatus.FINISHED;
        }
    }

    public boolean isPlaying() {
        return this.status == GameStatus.PLAYING;
    }

    public void resetGame() {
        this.status = GameStatus.PLAYING;
        this.result = new Result();
    }

    private void showMessage() {
        Output.printGameResultMessage(result.getResultMessage());
    }
}
