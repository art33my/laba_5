import java.util.regex.*;
import java.util.Scanner;

public class NumberFinder {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите текст для поиска чисел:");
            String text = scanner.nextLine();

            if (text == null || text.isEmpty()) {
                System.out.println("Текст не может быть пустым.");
                return;
            }

            try {
                Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+");
                Matcher matcher = pattern.matcher(text);

                StringBuilder foundNumbers = new StringBuilder();
                while (matcher.find()) {
                    foundNumbers.append(matcher.group()).append(" ");
                }

                if (foundNumbers.length() > 0) {
                    System.out.println("Найденные числа: " + foundNumbers.toString().trim());
                } else {
                    System.out.println("Чисел в тексте не найдено.");
                }

            } catch (PatternSyntaxException e) {
                System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
            } catch (IllegalStateException e) {
                System.out.println("Ошибка при обработке текста: " + e.getMessage());
            }
        }
    }
}
