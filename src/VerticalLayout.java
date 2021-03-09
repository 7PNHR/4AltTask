import java.util.Arrays;
import java.util.List;

public class VerticalLayout implements InterfaceElement {

    private final List<InterfaceElement> elements;

    public VerticalLayout(InterfaceElement... elements) {
        this.elements = Arrays.asList(elements);
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        for (InterfaceElement element : elements) {
            int width = element.getWidth();
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int height = 0;
        for (InterfaceElement element : elements) {
            height += element.getHeight();
        }
        return height;
    }

    @Override
    public char[][] calculate() {
        int width = getWidth();
        for (InterfaceElement element : elements) {
            element.enlargeSize(width, 0);
        }
        char[][] verticalLayout = new char[getHeight()][getWidth()];
        int currentHeight = 0;
        for (InterfaceElement element : elements) {
            int height = element.getHeight();
            char[][] insertedElement = element.calculate();
            for (int i = currentHeight; i < height + currentHeight; i++) {
                System.arraycopy(insertedElement[i - currentHeight], 0, verticalLayout[i], 0, insertedElement[i - currentHeight].length);
            }
            currentHeight += height;
        }
        return verticalLayout;
    }

    @Override
    public void enlargeSize(int width, int height) {}
}
