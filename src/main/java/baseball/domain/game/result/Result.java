package baseball.domain.game.result;

import baseball.domain.game.play.GameRule;
import baseball.domain.messages.ResultMessage;

import java.util.List;

/**
 * @info 게임의 결과값인 게임결과 클래스
 * @action 컴퓨터의 값과 사용자의 값을 check하여 Strike, Ball의 갯수를 업데이트함.
 *         게임결과의 Strike, Ball의 구성에 따라 사전 정의해둔 결과 메시지를 생성함.
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Result {
    private final Strike strike;
    private final Ball ball;

    public Result() {
        this.strike = new Strike();
        this.ball = new Ball();
    }

    public void checkResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < GameRule.GAME_COUNT; i++) {
            int cumputerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            this.strike.check(cumputerNumber == playerNumber);
            this.ball.check(computerNumbers, playerNumber, i);
        }
    }

    public String getResultMessage(){
        if(this.strike.getCount() == 3 && this.ball.getCount()== 0){
            return ResultMessage.THREE_STRIKE;
        }
        if (this.strike.is() && this.ball.is()) {
            return String.format(ResultMessage.STRIKE_BALL_MIX, this.ball.getCount(), this.strike.getCount());
        }
        if (!this.strike.is() && this.ball.is()) {
            return String.format(ResultMessage.BALL, this.ball.getCount());
        }
        if (this.strike.is() && !this.ball.is()) {
            return String.format(ResultMessage.STRIKE, this.strike.getCount());
        }
        return ResultMessage.NOTHING;
    }

    public boolean isFinished() {
        return this.strike.getCount() == 3 && this.ball.getCount() == 0;
    }

    public void reset(){
        this.strike.reset();
        this.ball.reset();
    }
}
