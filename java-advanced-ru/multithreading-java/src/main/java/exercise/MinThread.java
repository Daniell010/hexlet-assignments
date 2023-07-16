package exercise;

// BEGIN
public class MinThread extends Thread {
    private final int[] numbers;
    private int minNumber;

    MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        minNumber = Arrays.stream(numbers).min().getAsInt();
    }

    public int getMinNumber() {
        return minNumber;
    }
}
// END
