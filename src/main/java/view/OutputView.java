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

    public static void printLadderSpecific(final Map<Person, String> result, final Person person) {
        System.out.println("실행결과");

        System.out.println(person.getName() + " : " + result.get(person));
    }

    public static void printLadderAll(final Map<Person, String> result) {
        for (Person participant : result.keySet()) {
            System.out.println(participant.getName() + " : " + result.get(participant));
        }
    }

    public static void printNotExistedParticipant() {
        System.out.println("해당 이름을 가진 참여자가 존재하지 않습니다. 다시 입력해 주세요.");
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
