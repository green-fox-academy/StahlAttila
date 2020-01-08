package CharSequence;

import java.util.stream.IntStream;

public class Gnirts implements CharSequence {
    protected String field;

    public Gnirts(String field) {
        this.field = field;
    }

    @Override
    public int length() {
        return this.length();
    }

    @Override
    public char charAt(int index) {
        return this.field.charAt(field.length()-1-index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.field.substring(field.length()-end, field.length()-start);
    }
}
