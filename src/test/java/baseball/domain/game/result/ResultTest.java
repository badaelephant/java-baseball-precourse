package baseball.domain.game.result;

import baseball.domain.messages.ResultMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @Test
    @DisplayName("3스트라이크 후 게임종료 테스트")
    void checkResultTest_3Strike(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        Result result = new Result();
        result.checkResult(computerNumbers, playerNumbers);
        assertTrue(result.getStrikeCount()==3 && result.getBallCount()==0);
        assertEquals(ResultMessage.THREE_STRIKE, result.getResultMessage());
        assertTrue(result.isFinished());
    }
    @Test
    @DisplayName("게임결과 테스트-3Ball")
    void checkResultTest_3Ball(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(2,3,1));

        Result result = new Result();
        result.checkResult(computerNumbers, playerNumbers);
        assertTrue(result.getStrikeCount()==0 && result.getBallCount()==3);
        assertEquals(String.format(ResultMessage.BALL, 3), result.getResultMessage());
        assertFalse(result.isFinished());
    }
    @Test
    @DisplayName("게임결과 테스트-2Ball/1Strike")
    void checkResultTest_2Ball_1Strike(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(3,2,1));

        Result result = new Result();
        result.checkResult(computerNumbers, playerNumbers);
        assertTrue(result.getStrikeCount()==1 && result.getBallCount()==2);
        assertEquals(String.format(ResultMessage.STRIKE_BALL_MIX, 2, 1), result.getResultMessage());
        assertFalse(result.isFinished());
    }
    @Test
    @DisplayName("게임결과 테스트-2Strike")
    void checkResultTest_2Strike(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,4));

        Result result = new Result();
        result.checkResult(computerNumbers, playerNumbers);
        assertTrue(result.getStrikeCount()==2 && result.getBallCount()==0);
        assertEquals(String.format(ResultMessage.STRIKE, 2), result.getResultMessage());
        assertFalse(result.isFinished());
    }
    @Test
    @DisplayName("게임결과 테스트-1Ball")
    void checkResultTest_1Ball(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(4,1,5));

        Result result = new Result();
        result.checkResult(computerNumbers, playerNumbers);
        assertTrue(result.getStrikeCount()==0 && result.getBallCount()==1);
        assertEquals(String.format(ResultMessage.BALL, 1), result.getResultMessage());
        assertFalse(result.isFinished());
    }
    @Test
    @DisplayName("게임결과 테스트-Nothing")
    void checkResultTest_Nothing(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(4,5,6));

        Result result = new Result();
        result.checkResult(computerNumbers, playerNumbers);
        assertTrue(result.getStrikeCount()==0 && result.getBallCount()==0);
        assertEquals(ResultMessage.NOTHING, result.getResultMessage());
        assertFalse(result.isFinished());
    }

    @Test
    @DisplayName("리셋기능 테스트: checkResult호출시 reset되는지")
    void resetTest(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));

        Result result = new Result();
        result.checkResult(computerNumbers, playerNumbers);
        assertTrue(result.getStrikeCount()==3 && result.getBallCount()==0);
        assertEquals(ResultMessage.THREE_STRIKE, result.getResultMessage());
        assertTrue(result.isFinished());
        List<Integer> newPlayerNumbers = new ArrayList<>(Arrays.asList(2,3,4));
        result.checkResult(computerNumbers, newPlayerNumbers);
        assertTrue(result.getStrikeCount()==0 && result.getBallCount()==2);
        assertFalse(result.isFinished());
    }

}
