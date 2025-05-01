package tp2.exo1;

public class Exo1 implements Exo1Interface {
    private int result;

    // Implementation of the addition method
    @Override
    public int additionner(int a, int b) {
        result = a + b;
        return result;
    }

    // Implementation of the getResult method
    @Override
    public int getResult() {
        return result;
    }
}
