package baseball.domain.game.play;

import baseball.domain.messages.ExceptionMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 컴퓨터 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Computer {

    public List<Integer> generateNumbers() {
        final Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < GameRule.GAME_COUNT) {
            numbers.add(generateRandomNumber(numbers));
        }
        return new ArrayList<>(numbers);
    }

    private Integer generateRandomNumber(Set<Integer> numbers) {
        boolean repeat = true;
        int picked = 0;
        while (repeat) {
            picked = Randoms.pickNumberInRange(GameRule.MIN_NUM, GameRule.MAX_NUM);
            checkPikedNumberRange(picked);
            repeat = numbers.contains(picked);
        }
        return picked;
    }

    private void checkPikedNumberRange(int picked) {
        if (picked < 1 || picked > 9) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT);
        }
    }

}
