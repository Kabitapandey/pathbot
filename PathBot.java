import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathBot {
    static int x;
    static int y;
    static char dis = 'N';
    static String direction = "";

    static void movRight(String command, String dirVal) {

        switch (dis) {
            case 'N':
                x += Integer.parseInt(dirVal);
                dis = 'E';
                break;

            case 'E':
                y -= Integer.parseInt(dirVal);
                dis = 'S';
                break;

            case 'W':
                y += Integer.parseInt(dirVal);
                dis = 'N';
                break;

            case 'S':
                x -= Integer.parseInt(dirVal);
                dis = 'W';
                break;
            default:
                System.out.println("Invalid command");
                break;
        }

    }

    static void movLeft(String command, String dirVal) {

        switch (dis) {
            case 'N':
                x -= Integer.parseInt(dirVal);
                dis = 'W';
                break;

            case 'E':
                y += Integer.parseInt(dirVal);
                dis = 'N';
                break;

            case 'W':
                y -= Integer.parseInt(dirVal);
                dis = 'S';
                break;

            case 'S':
                x += Integer.parseInt(dirVal);
                dis = 'E';
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    static void findDir() {

        switch (dis) {
            case 'N':
                direction = "North";
                break;

            case 'E':
                direction = "East";
                break;

            case 'W':
                direction = "West";
                break;

            case 'S':
                direction = "South";
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    public static void main(String[] args) {
        String command;
        
        System.out.println("Enter a command:");

        Scanner sc=new Scanner(System.in);
        command=sc.nextLine();

        String dirVal = "";

        String regex = "^[LR]M\\d+(?:[LR]M\\d+)*$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            System.out.println("Invalid input format");
            return;
        }

        for (int i = 0; i < command.length(); i++) {

            int j = i + 2;
            if (command.charAt(i) == 'R' && command.charAt(i + 1) == 'M') {
                dirVal = "";
                while (j < command.length() && Character.isDigit(command.charAt(j))) {
                    dirVal += command.charAt(j);
                    j += 1;
                }

                movRight(command, dirVal);
            }

            if (command.charAt(i) == 'L' && command.charAt(i + 1) == 'M') {
                dirVal = "";
                while (j < command.length() && Character.isDigit(command.charAt(j))) {
                    dirVal += command.charAt(j);
                    j += 1;
                }

                movLeft(command, dirVal);
            }
        }

        findDir();
        System.out.println(direction + "(" + x + " , " + y + ")");
    }
}
