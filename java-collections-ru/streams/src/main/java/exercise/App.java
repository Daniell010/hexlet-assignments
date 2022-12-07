package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> list) {
        if(list == null) {
            return 0;
        }
      var quantity =   list.stream()
                .filter(num -> num.contains("@gmail.com"))
                .count();
        quantity += list.stream()
              .filter(num -> num.contains("@yandex.ru"))
                .count();
        quantity += list.stream()
                .filter(num -> num.contains("@hotmail.com"))
                .count();
        return quantity;
    }
}
// END
