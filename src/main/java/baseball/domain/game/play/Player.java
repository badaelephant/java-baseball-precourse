package baseball.domain.game.play;

import baseball.domain.messages.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 플레이어 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class Player {

    public List<Integer> pickNumbers(String inputNumbers) {
        checkStringInputValidation(inputNumbers);
        List<Integer> numbers = makeNumberList(inputNumbers);
        checkNumberListDuplication(numbers);
        return numbers;
    }

    private void checkNumberListDuplication(List<Integer> numbers) {
        Set<Integer> hashNumbers = new HashSet<>(numbers);
        if (numbers.size() != hashNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_INPUT);
        }
    }

    private List<Integer> makeNumberList(String inputNumbers) {
        String[] strNumbers = inputNumbers.split("");
        List<Integer> numbers = new ArrayList<>();
        for (String num : strNumbers) {
            checkInputRange(num);
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    private void checkStringInputValidation(String inputNumbers) {
        checkInputEmpty(inputNumbers);
        checkInputLength(inputNumbers);
    }

    private void checkInputEmpty(String inputNumbers) {
        if (inputNumbers.length() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT);
        }
    }

    private void checkInputLength(String inputNumbers) {
        if (inputNumbers.length() != GameRule.GAME_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_LENGTH_NOT_MATCH);
        }
    }

    private void checkInputRange(String inputNumber) {
        char number = inputNumber.charAt(0);
        if (number < '1' || number > '9') {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_NOT_IN_RANGE);
        }
    }

}
