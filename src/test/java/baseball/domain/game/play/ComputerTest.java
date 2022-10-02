package baseball.domain.game.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 컴퓨터 테스트
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class ComputerTest {
    @Test()
    @DisplayName("세자리 숫자가 잘 생성되는지 검증")
    void generateNumbersTest_threeNumbers() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.generateNumbers();

        assertEquals(3, numbers.size(), "3자리 숫자 생성");
    }

    @Test()
    @DisplayName("중복이 없는 숫자가 생성되는 지")
    void generateNumbersTest_noDuplication() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.generateNumbers();

        Set<Integer> numbersSet = new LinkedHashSet<>(numbers);

        assertEquals(numbers.size(), numbersSet.size(), "중복이 없는 숫자 생성");
    }

    @Test()
    @DisplayName("결과 값의 숫자가 전부 1~9 사이의 값인지 확인")
    void generateNumbersTest_numberInRange() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.generateNumbers();
        for(Integer number : numbers){
            assertTrue(number>0 && number<10);
        }
    }
}
