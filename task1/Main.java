import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // я не додавав ніякого хендлінгу аргументів
        System.out.println("java data types\n");
        System.out.println("byte: " + Byte.SIZE + " bits, from " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.SIZE + " bits, from " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("int: " + Integer.SIZE + " bits, from " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long: " + Long.SIZE + " bits, from " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("float: " + Float.SIZE + " bits, from " + (-Float.MAX_VALUE) + " to " + Float.MAX_VALUE);
        System.out.println("double: " + Double.SIZE + " bits, from " + (-Double.MAX_VALUE) + " to " + Double.MAX_VALUE);
        // + для конкатенації. але я знаю про String.format та System.out.printf
        System.out.println("char: " + Character.SIZE + " bits, from " + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE); // (int) - каст, бо інакше виводить символи, а не числові коди
        System.out.println("boolean: only true or false so no info, no defined size in jvm");

        // Межі char = числові коди символів (інакше були б символи, а не числа)
        // Для float і double це межі скінченних значень (тобто якщо взяти MIN_VALUE, то це буде найменше додатне число, а не кінцеве від'ємне)
        // саме тому я взяв -MAX_VALUE для від'ємного діапазону, а MIN_VALUE вивів окремо знизу:
        System.out.println("Smallest + float: " + Float.MIN_VALUE);
        System.out.println("Smallest + double: " + Double.MIN_VALUE);
        System.out.println();

        // try with resources щоб сканер автоматично закривався
        // можна також було try-catch для кожного типу окремо написати, але я лінивий :(
        // також можна readLine (Console або BufferedReader) і потім parse, але Ви у своєму прикладі використовуєте Scanner, тому я теж його використав
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("enter byte (from -128 to 127): ");
            byte b = Byte.parseByte(scanner.nextLine().trim()); // trim() щоб прибрати зайві пробіли на початку і в кінці
            System.out.println("byte = " + b);

            System.out.print("enter short (from -32768 to 32767): ");
            short s = Short.parseShort(scanner.nextLine().trim());
            System.out.println("short = " + s);

            System.out.print("enter int (integer number): ");
            int number = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("int = " + number);

            System.out.print("enter long (big integer number): ");
            long bigNumber = Long.parseLong(scanner.nextLine().trim());
            System.out.println("long = " + bigNumber);

            System.out.print("enter float (десяткове число, наприклад 1.2345): ");
            float f = Float.parseFloat(scanner.nextLine().trim());
            System.out.println("float = " + f);


            System.out.print("enter double (десяткове число, наприклад 1.2345678901234): ");
            double d = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("double = " + d);

            System.out.print("enter char (one character): ");
            String text = scanner.nextLine();

            if (text.length() != 1) {
                System.out.println("char must be 1 character long!!!");
                return;
            }

            // не має parseChar, так що ТЕОРЕТИЧНО можна взяти перший символ рядка, якщо він довжиною 1
            char symbol = text.charAt(0);
            System.out.println("char = " + symbol);


            System.out.print("enter bool (true/false): ");
            String answer = scanner.nextLine().trim();

            if (!answer.equalsIgnoreCase("true") && !answer.equalsIgnoreCase("false")) {
                System.out.println("bool must be true or false!!!");
                return;
            }
            boolean flag = Boolean.parseBoolean(answer);

            System.out.println("boolean = " + flag);
        } catch (NumberFormatException e) {
            System.out.println("invalid num or outside of range for the type!!!");
        }
    }
}
