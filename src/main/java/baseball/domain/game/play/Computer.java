package baseball.domain.game.play;

import baseball.domain.messages.ExceptionMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @info 게임을 구성하는 주요 플레이어인 컴퓨터 클래스
 * @action 각자리 1~9의 3자리 중복되지 않는 숫자를 랜덤하게 생성함
 * @comment 외부 API(Randoms)를 사용하기 때문에, 맞게 번호가 랜덤 추출 된것인지 간단하게 값 범위 검증(1~9)
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Computer {
    public List<Integer> generateNumbers() {
        final Set<Integer> numbers = new HashSet<>();
        while (numbers.size()< GameRule.GAME_COUNT){
            numbers.add(generateRandomNumber(numbers));
        }
        return new ArrayList<>(numbers);
    }
    private Integer generateRandomNumber(Set<Integer> numbers){
        boolean repeat = true;
        int picked = 0;
        while (repeat){
            picked = Randoms.pickNumberInRange(GameRule.MIN_NUM, GameRule.MAX_NUM);
            checkPikedNumberRange(picked);
            repeat = numbers.contains(picked);
        }
        return picked;
    }

    private void checkPikedNumberRange(int picked) {
        if(picked<1 || picked>9){
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_NOT_IN_RANGE);
        }
    }

}
