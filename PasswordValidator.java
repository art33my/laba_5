import java.util.regex.*;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите пароль для проверки:");
            String password = scanner.nextLine();

            if (password == null || password.isEmpty()) {
                System.out.println("Пароль не может быть пустым.");
                return;
            }

            try {
                Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
                Matcher matcher = pattern.matcher(password);

                if (matcher.matches()) {
                    System.out.println("Пароль корректный!");
                } else {
                    System.out.println("Пароль не соответствует требованиям.");
                }

            } catch (PatternSyntaxException e) {
                System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
            } catch (IllegalStateException e) {
                System.out.println("Ошибка при проверке пароля: " + e.getMessage());
            }
        }
    }
}
