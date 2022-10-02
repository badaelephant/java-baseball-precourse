package baseball.domain.game.result;

/**
 * 스트라이크 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Strike {

    private int count;

    public Strike() {
        this.count = 0;
    }

    public void check(boolean isMatch) {
        if (isMatch) {
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
