package baseball.domain.game.result;

import java.util.List;

/**
 * 볼 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Ball {

    private int count;

    public Ball() {
        this.count = 0;
    }

    public void check(List<Integer> answerList, Integer number, Integer index) {
        if (answerList.contains(number) && !answerList.get(index).equals(number)) {
            this.count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    public void reset() {
        this.count = 0;
    }

    public boolean is() {
        return this.count > 0;
    }
}
