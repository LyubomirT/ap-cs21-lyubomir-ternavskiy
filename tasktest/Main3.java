import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main3 {

    private static final int MIN_HEIGHT = 8;
    private static final int MAX_HEIGHT = 28;
    private static final int TRUNK_ROWS = 2;
    private static final int EXPANSION_ROWS = 4;
    private static final int LARGE_TREE = 20;

    // багато чого (списки, методи, наприклад) ми тут формально ще не вчили, я використав трохи своїх знань для того, щоб
    // зробити ялинку більш красивою, а не просто трикутником з чисел
    // через це вибачаюся за затримку
    // до речі, дуже схожу річ я нещодавно робив для себе на Расті (вчив форматування), тому вийшло досить швидко

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int h = RANDOM.nextInt(MIN_HEIGHT, MAX_HEIGHT + 1);
        List<Integer> branches = branchWidths(h);

        int treeW = branches.getLast() * 4; // новинка Джава 21

        System.out.printf("Tree height: %d rows%n%n", h);

        printCentered(String.format("%02d", RANDOM.nextInt(100)), treeW);
        for (int chunks : branches) { // foreach!
            printCentered(randomChunks(chunks), treeW);
        }
        for (int i = 0; i < TRUNK_ROWS; i++) {
            printCentered(randomChunks(1), treeW);
        }
    }

    private static List<Integer> branchWidths(int height) {
        int step = height >= LARGE_TREE ? 2 : 1;
        int rows = height - TRUNK_ROWS - 1;
        List<Integer> widths = new ArrayList<>();
        int chunks = 1;
        widths.add(chunks);
        for (int i = 1; i < EXPANSION_ROWS; i++) {
            chunks += step;
            widths.add(chunks);
        }
        int zigzagRows = rows - EXPANSION_ROWS;
        boolean shrink = zigzagRows % 2 == 0;
        for (int i = 0; i < zigzagRows; i++) {
            chunks += shrink ? -1 : 2;
            widths.add(chunks);
            shrink = !shrink;
        }
        return widths;
    }

    private static String randomChunks(int count) {
        Object[] numbers = RANDOM.ints(count, 0, 1001).boxed().toArray();
        return String.format("%04d".repeat(count), numbers);
    }

    private static void printCentered(String row, int treeWidth) {
        int padding = (treeWidth - row.length()) / 2;
        System.out.printf("%" + (padding + row.length()) + "s%n", row);
    }
}