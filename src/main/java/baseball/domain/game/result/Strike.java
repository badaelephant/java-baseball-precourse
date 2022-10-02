package baseball.domain.game.result;

/**
 * @info 게임의 결과의 일부인 Strike 클래스
 * @action 값의 비교를 통해 Strike의 count값을 더하거나, reset함.
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Strike {
    private int count;
    public Strike() {
        this.count = 0;
    }
    public void check(boolean isMatch) {
        if(isMatch){
            this.count++;
        }
    }
    public int getCount() {
        return this.count;
    }
    public void reset() {
        this.count = 0;
    }
    public boolean is(){
        return this.count > 0;
    }

}
