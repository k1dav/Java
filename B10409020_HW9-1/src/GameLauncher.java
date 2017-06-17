
/**
 *
 * @author k1dav
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GameLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int min = 0, max = 0, limit = 0, guessTimes = 0;
        String again = "Y";
        ArrayList<Integer> input = new ArrayList<Integer>();

        while (again.equals("Y")) {
            System.out.println("********** �q�Ʀr�C�� **********");
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("�п�J�q�Ʀr�d��̤p�ȡG");
                min = sc.nextInt();
                System.out.print("�п�J�q�Ʀr�d��̤j�ȡG");
                max = sc.nextInt();
                System.out.print("�п�J�q�Ʀr���ƭ���G");
                limit = sc.nextInt();
            } catch (Exception e) {
                System.out.println("��J���~�A�N���s����C");
            }

            Guess game = new Guess(min, max);

            for (int i = 1; i <= limit; i++) {
                int guessNum = 0;
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.printf("�Ʀr�d��G %d ~ %d \n", min, max);
                    System.out.print("�п�J�z�q���Ʀr�G");
                    guessNum = sc.nextInt();

                    while (guessNum < min || guessNum > max) {
                        System.out.println("�q���F! �z�q���Ʀr�W�X���׽d��I�Э��s��J�I");
                        System.out.print("�п�J�z�q���Ʀr�G");
                        guessNum = sc.nextInt();
                    }

                    input.add(guessNum);

                    switch (game.numCheck(guessNum)) {
                        case -1:
                            System.out.println("�q���F! �z�q���Ʀr�񵪮פp!");
                            min = guessNum;
                            break;
                        case 0:
                            System.out.println("���߱z�q��F!");
                            guessTimes = i;
                            i = limit;
                            break;
                        case 1:
                            System.out.println("�q���F! �z�q���Ʀr�񵪮פj!");
                            max = guessNum;
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("��J���~�A�N���s����C");
                }
            }

            System.out.println("*********** �C������ ***********");
            int inputSize = input.size();
            for (int i = 0; i < inputSize; i++) {
                System.out.printf("�� %d �q�G%d\n", i + 1, input.remove(0));
            }
            System.out.printf("�q�Ʀr���� %d ��\n", limit);
            System.out.printf("�z�`�@�q�F %d ��\n", guessTimes);
            System.out.printf("���T���סG %d \n", game.getAns());

            System.out.println("******** �A���@��(Y/N)? ********");
            System.out.println("�п�J (Y/N) �G");
            Scanner sc = new Scanner(System.in);
            again = sc.next().toUpperCase();
        }

    }

}
