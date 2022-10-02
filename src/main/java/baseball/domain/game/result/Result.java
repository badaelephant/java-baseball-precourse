package baseball.domain.game.result;

import baseball.domain.game.play.GameRule;
import baseball.domain.messages.ExceptionMessage;
import baseball.domain.messages.ResultMessage;

import java.util.*;

/**
 * 게임 결과 클래스
 *
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
        reset();
        for (int i = 0; i < GameRule.GAME_COUNT; i++) {
            int cumputerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            this.strike.check(cumputerNumber == playerNumber);
            this.ball.check(computerNumbers, playerNumber, i);
        }
        checkResultValidation();
    }

    private void checkResultValidation() {
        if (this.strike.getCount() > 3 || this.ball.getCount() > 3) {
            throw new InternalError(ExceptionMessage.IMPOSSIBLE_RESULT);
        }
        if (this.strike.getCount() == 2 && this.ball.getCount() == 1) {
            throw new InternalError(ExceptionMessage.IMPOSSIBLE_RESULT);
        }
    }

    public int getStrikeCount() {
        return this.strike.getCount();
    }

    public int getBallCount() {
        return this.ball.getCount();
    }

    private boolean is3Strike() {
        return this.strike.getCount() == 3 && this.ball.getCount() == 0;
    }

    private boolean isOnlyBall() {
        return !this.strike.is() && this.ball.is();
    }

    private boolean isOnlyStrike() {
        return this.strike.is() && !this.ball.is();
    }

    private boolean isStrikeAndBall() {
        return this.strike.is() && this.ball.is();
    }

    public String getResultMessage() {
        if (is3Strike()) {
            return ResultMessage.THREE_STRIKE;
        }
        if (isStrikeAndBall()) {
            return String.format(ResultMessage.STRIKE_BALL_MIX, this.ball.getCount(), this.strike.getCount());
        }
        if (isOnlyBall()) {
            return String.format(ResultMessage.BALL, this.ball.getCount());
        }
        if (isOnlyStrike()) {
            return String.format(ResultMessage.STRIKE, this.strike.getCount());
        }
        return ResultMessage.NOTHING;
    }

    public boolean isFinished() {
        return this.strike.getCount() == 3 && this.ball.getCount() == 0;
    }

    private void reset() {
        this.strike.reset();
        this.ball.reset();
    }
}
