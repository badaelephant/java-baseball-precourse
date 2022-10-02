package baseball.controller;

import baseball.domain.game.play.Computer;
import baseball.domain.game.play.Game;
import baseball.domain.game.play.GameRule;
import baseball.domain.game.play.Player;
import baseball.view.Input;

import java.util.List;

/**
 * @info 게임의 사용자와 컴퓨터, 게임이 상호작용하는 컨트롤러 클래스 - 게임방 혹은 게임매니저 역할
 * @action startPlay에서 값의 초기화를 위해 restartGame을 해주고,
 *         컴퓨터와 사용자의 값을 받고, 결과 확인하는 프로세스를 반복해서 돌림
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class GameController {
    private final Game game;
    private final Player player;
    private final Computer computer;

    public GameController(){
        this.player = new Player();
        this.computer = new Computer();
        this.game = new Game();
    }
    public void startGame(){
        game.resetGame();
        List<Integer> computerNumbers = computer.generateNumbers();
        while (game.isPlaying()){
            List<Integer> playerNumbers = player.pickNumbers();
            game.updateGameResult(computerNumbers, playerNumbers);
        }
        askReplay();
    }

    private void askReplay(){
        String answer = Input.getReplayInputFromPlayer();
        if(answer.equals(GameRule.RESTART)){
            startGame();
        }
    }
}
