package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getNumberInputFromPlayer(){
        Output.askPlayerInputNumber();
        return Console.readLine();
    }
    public static String getReplayInputFromPlayer(){
        Output.askPlayerInputReplay();
        return Console.readLine();
    }
}
