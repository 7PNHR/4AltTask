public class Frame implements InterfaceElement {

    private final String heading;
    private final InterfaceElement element;
    private int downIntend = 0;

    public Frame(String heading, InterfaceElement element) {
        this.heading = heading;
        this.element = element;
    }

    @Override
    public int getWidth() {
        int width = 4;
        width += element.getWidth();
        return width;
    }

    @Override
    public int getHeight() {
        int height = 2 + downIntend;
        height += element.getHeight();
        return height;
    }

    @Override
    public char[][] calculate() {
        char[][] frame = Assistant.getFrame(element, new char[]{'╔', '╗', '╚', '╝', '═', '║'}, downIntend);
        if (frame[0].length - 6 < heading.length()) return null;//Проверка вставится ли имя рамки
        frame[0][2] = '\u0000';
        frame[0][3 + heading.length()] = '\u0000';
        for (int i = 3; i < 3 + heading.length(); i++) {
            frame[0][i] = heading.charAt(i - 3);
        }
        //Выше вставка имени рамки
        return frame;
    }

    @Override
    public void enlargeSize(int width, int height) {
        downIntend = height;
        element.enlargeSize(width - 4, height);
    }

}
