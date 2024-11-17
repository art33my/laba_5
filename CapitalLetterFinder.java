import java.util.regex.*;
import java.util.Scanner;

public class CapitalLetterFinder {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите текст для поиска заглавных букв после строчных:");
            String text = scanner.nextLine();

            if (text == null || text.isEmpty()) {
                System.out.println("Текст не может быть пустым.");
                return;
            }

            try {
                Pattern pattern = Pattern.compile("([a-z])([A-Z])");
                Matcher matcher = pattern.matcher(text);
                StringBuffer result = new StringBuffer();

                boolean found = false;
                while (matcher.find()) {
                    found = true;
                    matcher.appendReplacement(result, matcher.group(1) + "!" + matcher.group(2) + "!");
                }
                matcher.appendTail(result);

                if (found) {
                    System.out.println("Результат: " + result.toString());
                } else {
                    System.out.println("Совпадений не найдено.");
                }

            } catch (PatternSyntaxException e) {
                System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
            } catch (IllegalStateException e) {
                System.out.println("Ошибка при замене текста: " + e.getMessage());
            }
        }
    }
}
