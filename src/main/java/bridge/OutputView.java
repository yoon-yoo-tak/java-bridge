package bridge;

import bridge.constant.GameCommand;
import bridge.constant.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static String upperSide;
    private static String lowerSide;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String connectedBridge) {
        System.out.println(connectedBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int gamePlayCount, String result, String connectedBridge) {
        System.out.println(Message.FINAL_RESULT.getMessage());
        System.out.println(connectedBridge);
        System.out.print(Message.GAME_RESULT.getMessage() + result);
        System.out.printf(Message.TOTAL_TRY.getMessage(), gamePlayCount);
    }

    public static void startGame() {
        System.out.println(Message.GAME_START.getMessage());
    }

    public static void printInputBridgeLength() {
        System.out.println(Message.INPUT_BRIDGE_SIZE.getMessage());
    }

    public static void printSelectDirection() {
        System.out.println(Message.SELECT_DIRECTION.getMessage());
    }

    public static void printRestartMessage() {
        System.out.println(Message.RESTART.getMessage());
    }

    public static void connectBridge(String bridgeComponent) {
        upperSide += bridgeComponent;
        lowerSide += bridgeComponent;
    }

    public static void recordResult(String currInput, String selectResult) {
        if (currInput.equals(GameCommand.GO_UP.getGameCommand())) {
            upperSide += selectResult;
            lowerSide += " ";
        }
        if (currInput.equals(GameCommand.GO_DOWN.getGameCommand())) {
            upperSide += " ";
            lowerSide += selectResult;
        }
    }
}
