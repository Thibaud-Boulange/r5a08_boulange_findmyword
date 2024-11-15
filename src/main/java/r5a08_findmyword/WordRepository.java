package r5a08_findmyword;

public interface WordRepository {
    public abstract String fetchWordByNumber(int number);
    public abstract int highestWordNumber();
}
