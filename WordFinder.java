import java.util.regex.*;
import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите текст:");
            String text = scanner.nextLine();

            System.out.println("Введите начальную букву для поиска:");
            String startLetter = scanner.nextLine();

            if (text == null || text.isEmpty()) {
                System.out.println("Текст не может быть пустым.");
                return;
            }
            
            if (startLetter == null || startLetter.isEmpty() || !startLetter.matches("[a-zA-Z]")) {
                System.out.println("Неправильный символ для поиска.");
                return;
            }

            try {
                Pattern pattern = Pattern.compile("\\b" + startLetter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(text);

                boolean found = false;
                System.out.println("Найденные слова:");
                while (matcher.find()) {
                    found = true;
                    System.out.println(matcher.group());
                }

                if (!found) {
                    System.out.println("Совпадений не найдено.");
                }

            } catch (PatternSyntaxException e) {
                System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
            } catch (IllegalStateException e) {
                System.out.println("Ошибка при поиске слов: " + e.getMessage());
            }
        }
    }
}
