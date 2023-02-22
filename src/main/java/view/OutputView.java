package view;

import domain.Bridge;
import domain.BridgeStatus;
import domain.Ladder;
import domain.Person;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String EMPTY_BRIDGE = "     ";
    private static final String EXIST_BRIDGE = "-----";

    public static void printLadder(final Ladder ladder) {
        System.out.println("사다리 결과");

        printParticipantsOf(ladder);

        System.out.println();

        printLinesOf(ladder);

        printResultCandidateOf(ladder);
    }

    private static void printParticipantsOf(final Ladder ladder) {
        for (String name : ladder.getParticipantNames()) {
            System.out.print(name + "\t");
        }
    }

    private static void printResultCandidateOf(final Ladder ladder) {
        List<String> resultCandidates = ladder.getResultCandidates();

        for (String resultCandidate : resultCandidates) {
            System.out.print(resultCandidate + "\t");
        }

        System.out.println();
    }

    public static void printLadderResult(final Map<Person, String> result, final String name) {
        System.out.println("실행결과");

        if (name.equals("all")) {
            printAll(result);
            return;
        }

        System.out.println(name + " : " + result.get(name));
    }

    private static void printAll(final Map<Person, String> result) {
        for (Person participant : result.keySet()) {
            System.out.println(participant + " : " + result.get(participant.getName()));
        }
    }

    private static void printLinesOf(final Ladder ladder) {
        for (Bridge bridge : ladder.getBridges()) {
            System.out.print("\t|");
            printBridgesOf(bridge);
            System.out.println();
        }
    }

    private static void printBridgesOf(final Bridge bridge) {
        for (BridgeStatus bridgeStatus : bridge.getBridges()) {
            System.out.print(printBridgeStatus(bridgeStatus));
            System.out.print("|");
        }
    }

    private static String printBridgeStatus(final BridgeStatus bridgeStatus) {
        if (bridgeStatus == BridgeStatus.EMPTY) {
            return EMPTY_BRIDGE;
        }

        return EXIST_BRIDGE;
    }
}
