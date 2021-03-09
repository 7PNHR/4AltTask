public class Rectangle implements InterfaceElement {

    private InterfaceElement element;
    private int downIntend = 0;

    public Rectangle(InterfaceElement element) {
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
        return Assistant.getFrame(element, new char[]{'┌', '┐', '└', '┘', '─', '│'}, downIntend);
    }

    @Override
    public void enlargeSize(int width, int height) {
        downIntend = height;
        element.enlargeSize(width - 4, height);
    }

}
