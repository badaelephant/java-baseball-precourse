package baseball.view;

import baseball.domain.messages.PlayMessage;

public class Output {
    public static void askPlayerInputNumber(){
        System.out.println(PlayMessage.ASK_INPUT);
    }
    public static void askPlayerInputReplay(){
        System.out.println(PlayMessage.ASK_REPLAY);
    }
    public static void printGameResultMessage(String gameResult){
        System.out.println(gameResult);
    }
    public static void printExceptionMessage(String exception) {
        System.out.println(exception);
    }
    public static void printGamePlayMessage(String playMessage){
        System.out.println(playMessage);
    }
}
