import java.text.MessageFormat;
import java.util.Locale; // пам'ятаю такі проблеми з C#, здається в джаві теж щось таке було
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // у мене вінда англійська (щоб крапка була у десяткових числах)
        // але на всяк випадок встановив us бо у деяких системах може бути кома
        // ну, і для валюти буде долар $, а не будь-що інше
        // хоча чесно кажучи, перечитавши як воно працює, воно на парсинг сильно не впливає
        // джава все одно намагається парсити числа з крапкою, навіть якщо локаль інша
        // але поганого воно не зробить нічого :)
        System.out.println("formatted outputtt\n");
        System.out.println("Перевірка UTF-8 Привіт світ - if it outputs gibberish then your console is not UTF-8");

        try (Scanner scanner = new Scanner(System.in)) { // знову try with resources
            // знову nextLine та парсинг
            System.out.print("enter int (integer): ");
            int number = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("enter double (з крапкою - 12.3456): ");
            double d = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("enter string: ");
            String text = scanner.nextLine();

            System.out.print("enter bool (true/false): ");
            String answer = scanner.nextLine().trim();
            if (!answer.equalsIgnoreCase("true") && !answer.equalsIgnoreCase("false")) {
                System.out.println("bool must be true or flase!!!");
                return;
            }
            boolean flag = Boolean.parseBoolean(answer);
            System.out.println();

            // звичайна конкатенація
            System.out.println("[1/10] int = " + number + ", double = " + d + ", text = [" + text + "]");

            // MessageFormat
            System.out.println(MessageFormat.format("[2/10] text = [{2}], int = {0,number,integer}, money = {1,number,currency}",
                    number, d, text));
            System.out.println(MessageFormat.format("[3/10] int = {0,number,integer}; percent = {1,number,percent}; text = [{2}]",
                    number, d, text));
      
            /*
            ===============================================================================================================
            */

            // System.out.format ------ тут окремі рядки бо так мені легше читати, вибачте
            System.out.format("[4/10] int = %d | double = %f | text = [%s] | bool = %b%n", number, d, text, flag);

            System.out.format("[5/10] hex = %x | double = %.2f | text = [%20s]%n", number, d, text);

            System.out.format("[6/10] octal = %o | double = %.4f | text = [%-20s] | bool = %B%n", number, d, text, flag);

            System.out.format("[7/10] int = %+d | science = %.3e | textcut = [%.9s]%n", number, d, text);

            System.out.format("[8/10] int = %08d | double = %010.2f | textcut = [%12.9s]%n", number, d, text);

            //  дужки просто щоб бачити пробіли
            System.out.format("[9/10] int = %,d | double = %,.3f | text = [%-12.6s]%n", number, d, text);

            System.out.format("[10/10] int = [%10d] | double = %+.1f | text = [%S]%n", number, d, text);

            
        } catch (NumberFormatException e) {
            System.out.println("invalid num or outside of range for int!!!"); // повторний ввід поки не робив
            // зроблю на наступній практичній, може навіть якось інтегрую цикли чи методи
        }
    }
}
