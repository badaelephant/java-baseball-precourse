package baseball.domain.messages;

/**
 * 예외 메시지 클래스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.02
 */
public class ExceptionMessage {

    public static final String INPUT_LENGTH_NOT_MATCH = "입력이 주어진 길이와 다릅니다. 3글자만 입력해주세요";
    public static final String DUPLICATED_INPUT = "중복된 입력입니다.";
    public static final String EMPTY_INPUT = "빈 입력입니다.";
    public static final String INPUT_NUMBER_NOT_IN_RANGE = "주어진 범위의 입력에서 벗어났습니다. 1~9 사이의 숫자만 입력해주세요.";

    public static final String IMPOSSIBLE_RESULT = "해당 결과는 게임의 결과로 나올 수 없습니다.";
}
