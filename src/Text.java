public class Text implements InterfaceElement {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Text(String text) {
        this.text = text;
    }

    @Override
    public int getWidth() {
        return text.length();//Отступ слева и справа
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
        for (int i = text.length(); i < width; i++) {
            text += " ";
        }
    }

}
