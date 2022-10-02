package baseball.domain.game.play;

import baseball.domain.messages.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 플레이어 테스트
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class PlayerTest {
    @Test()
    @DisplayName("번호변경 정상성공 케이스")
    void pickNumbersTest_success() {
        Player player = new Player();
        String inputNumbers = "123";
        List<Integer> pickedNumbers = player.pickNumbers(inputNumbers);
        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(2);
        expectedNumbers.add(3);
        assertEquals(expectedNumbers, pickedNumbers);
    }
    @Test()
    @DisplayName("[에러테스트] 사용자 입력이 없는 경우")
    void pickNumbersTest_exception_inputEmptyTest() {
        Player player = new Player();
        String numbers = "";
        try {
            player.pickNumbers(numbers);
        } catch (IllegalArgumentException e) {
            assertEquals(ExceptionMessage.EMPTY_INPUT, e.getMessage());
        }
    }
    @Test()
    @DisplayName("[에러테스트] 사용자 입력이 3자가 아닐경우")
    void pickNumbersTest_exception_inputLengthNotMatchTest() {
        Player player = new Player();
        String numbers = "123456";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> player.pickNumbers(numbers));
        assertEquals(ExceptionMessage.INPUT_LENGTH_NOT_MATCH, exception.getMessage());
    }
    @Test()
    @DisplayName("[에러테스트] 사용자 입력이 1~9사이의 숫자가 아닌경우")
    void pickNumbersTest_exception_makeNumberListTest() {
        Player player = new Player();
        String numbers = "100";
        String alphabets = "abc";
        Throwable exceptionNumber = assertThrows(IllegalArgumentException.class, () -> player.pickNumbers(numbers));
        Throwable exceptionAlphabet = assertThrows(IllegalArgumentException.class, () -> player.pickNumbers(alphabets));
        assertEquals(ExceptionMessage.INPUT_NUMBER_NOT_IN_RANGE, exceptionNumber.getMessage());
        assertEquals(ExceptionMessage.INPUT_NUMBER_NOT_IN_RANGE, exceptionAlphabet.getMessage());
    }
    @Test()
    @DisplayName("[에러테스트] 중복 입력인 경우")
    void pickNumbersTest_exception_duplicatedInputTest() {
        Player player = new Player();
        String inputNumbers = "112";
        try {
            player.pickNumbers(inputNumbers);
        } catch (IllegalArgumentException e) {
            assertEquals(ExceptionMessage.DUPLICATED_INPUT, e.getMessage());
        }
    }

}
