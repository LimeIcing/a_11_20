import java.util.*;
import java.io.*;

public class Main20 {

    /*
    Write a modified version of the Vocabulary program developed in Chapter 10 that uses sets rather than ArrayList s to
    store its words. (The program will be noticeably shorter and will run faster!)
     */

    // TODO - Convert to use sets rather than arrayLists

    // This program reads two text files and compares the
    // vocabulary used in each.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        giveIntro();

        System.out.print("file #1 name? ");
        Scanner in1 = new Scanner(new File(console.nextLine()));
        System.out.print("file #2 name? ");
        Scanner in2 = new Scanner(new File(console.nextLine()));
        System.out.println();

        Set<String> set1 = getWords(in1);
        Set<String> set2 = getWords(in2);
        Set<String> common = getOverlap(set1, set2);

        reportResults(set1, set2, common);
    }

    public static Set<String> getWords(Scanner input) {
        input.useDelimiter("[^a-zA-Z']");
        Set<String> words = new TreeSet<>();

        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if (!next.isEmpty()) {
                words.add(next);
            }
        }

        return words;
    }

    public static Set<String> getOverlap(Set<String> set1, Set<String> set2) {
        Set<String> result = new TreeSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    // post: explains program to user
    public static void giveIntro() {
        System.out.println("This program compares two text files");
        System.out.println("and reports the number of words in");
        System.out.println("common and the percent overlap.");
        System.out.println();
    }

    public static void reportResults(Set<String> set1, Set<String> set2, Set<String> common) {
        System.out.println("file #1 words = " + set1.size());
        System.out.println("file #2 words = " + set2.size());
        System.out.println("common words = " + common.size());

        double pct1 = 100.0 * common.size() / set1.size();
        double pct2 = 100.0 * common.size() / set2.size();
        System.out.println("% of file 1 in overlap = " + pct1);
        System.out.println("% of file 2 in overlap = " + pct2);
    }
}
