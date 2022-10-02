package baseball.domain.game.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class GameTest {
    @Test()
    @DisplayName("3스트라이크인 경우 게임상태가 종료됨 으로 바뀌는지 테스트")
    void checkFinishTest_3strike(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        Game game = new Game();
        game.updateGameResult(computerNumbers, playerNumbers);
        assertFalse(game.isPlaying());
    }
    @Test()
    @DisplayName("결과가 3스트라이크가 아닌경우 게임상태가 진행중인지 테스트")
    void checkFinishTest_nothing(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(4,5,6));
        Game game = new Game();
        game.updateGameResult(computerNumbers, playerNumbers);
        assertTrue(game.isPlaying());
    }
    @Test()
    @DisplayName("게임상태가 종료된 이후, 리셋하면 다시 게임중으로 바뀌는지 테스트")
    void gameResetTest(){
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        Game game = new Game();
        game.updateGameResult(computerNumbers, playerNumbers);
        assertFalse(game.isPlaying());
        game.resetGame();
        assertTrue(game.isPlaying());
    }
}
