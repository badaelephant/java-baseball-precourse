package baseball.domain.game.result;

import java.util.List;

/**
 * @info 게임의 결과의 일부인 Ball 클래스
 * @action 값의 비교를 통해 Ball count값을 더하거나, reset함.
 * @comment Ball의 경우 Strike가 아니어야하는 추가조건이 있으므로, contains뿐만아니라 인덱스 비교도 해줘야함.
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Ball {
    private int count;
    public Ball() {
        this.count = 0;
    }
    public void check(List<Integer> answerList, Integer number, Integer index) {
        if(answerList.contains(number) && answerList.get(index)!= number){
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
