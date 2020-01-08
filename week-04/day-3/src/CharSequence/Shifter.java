package CharSequence;

public class Shifter implements CharSequence{
    protected String field;
    protected Integer shift;

    public Shifter(String field, Integer shift) {
        this.field = field;
        this.shift = shift;
    }

    @Override
    public int length() {
        return field.length();
    }

    @Override
    public char charAt(int index) {
        return this.field.charAt(index + shift);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
