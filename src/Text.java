public class Text implements InterfaceElement {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public int getWidth() {
        return text.length();
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public char[][] calculate() {
        char[] array = (text).toCharArray();
        return new char[][]{array};
    }

    @Override
    public void enlargeSize(int width, int height) {
        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = text.length(); i < width; i++) {
            stringBuilder.append(" ");
        }
        text = stringBuilder.toString();
    }

}
