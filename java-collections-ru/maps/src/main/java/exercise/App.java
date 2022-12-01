package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String str)  {
        Map<String, Integer> words = new HashMap<>();
        if(str.length() == 0) {
            return words;
        }
        var mass = str.split(" ");
        int counter = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int l = 0; l < mass.length ; l++) {
                if(mass[i].equals(mass[l])) {
                    counter++;
                }
            }
            words.put(mass[i], counter);
            counter = 0;
        }
        return words;
    }
    public static String toString (Map words) {
        if(words.size() == 0) {
            return "{}";
        }
        String result = "{\n"; //СОЗДАТЬ НОВЫЙ МАП И СКОПИРОВАТЬ ВСЕ В НЕГО
        String whitespace = "  ";
        Map<String, Integer> words2 = new HashMap<>();
        words2.putAll(words);
        for (Map.Entry<String, Integer> word: words2.entrySet()) {
           result += whitespace + word.getKey() + ": " + word.getValue() + "\n" ;
        }
        result += "}";
        return result;
    }
}
//END
