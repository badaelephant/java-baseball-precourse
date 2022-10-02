package baseball.domain.game.play;


import baseball.domain.game.result.Result;
import baseball.domain.messages.PlayMessage;
import baseball.view.Output;

import java.util.List;

/**
 * info : 게임 전체의 서비스를 관장하는 Game 클래스
 * action : 메인 메서드인 play()에서는 사용자와 컴퓨터의 값을 받아 결과를 생성하고, 메시지를 보여주고, 종료여부를 업데이트함
 * comment : 게임의 기본은 게임준비, 게임, 결과 리셋, 리플레이 - 플레이어 입력받는 부분은 컨트롤러로 뺐음
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Game {
    private Result result;
    private GameStatus status;


    public Game(){
        this.result = new Result();
        this.status = GameStatus.PLAYING;
    }

    public void updateGameResult(List<Integer> computerNumbers, List<Integer> playerNumbers){
        result.checkResult(computerNumbers, playerNumbers);
        showMessage();
        checkFinish();
    }
    private void checkFinish() {
        if(result.isFinished()){
            Output.printGamePlayMessage(PlayMessage.GAME_FINISH);
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
