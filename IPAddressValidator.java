import java.util.regex.*;
import java.util.Scanner;

public class IPAddressValidator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите IP-адрес для проверки:");
            String ipAddress = scanner.nextLine();

            if (ipAddress == null || ipAddress.isEmpty()) {
                System.out.println("IP-адрес не может быть пустым.");
                return;
            }

            try {
                Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
                Matcher matcher = pattern.matcher(ipAddress);

                if (matcher.matches()) {
                    System.out.println("IP-адрес корректный!");
                } else {
                    System.out.println("Некорректный IP-адрес.");
                }

            } catch (PatternSyntaxException e) {
                System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
            } catch (IllegalStateException e) {
                System.out.println("Ошибка при проверке IP-адреса: " + e.getMessage());
            }
        }
    }
}
