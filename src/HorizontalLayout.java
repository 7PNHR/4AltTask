import java.util.Arrays;
import java.util.List;

public class HorizontalLayout implements InterfaceElement {

    private final List<InterfaceElement> elements;

    public HorizontalLayout(InterfaceElement... elements) {
        this.elements = Arrays.asList(elements);
    }

    @Override
    public int getWidth() {
        int width = 0;
        for (InterfaceElement element : elements) {
            width += element.getWidth();
        }
        return width + 1;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        for (InterfaceElement element : elements) {
            int height = element.getHeight();
            maxHeight = Math.max(height, maxHeight);
        }
        return maxHeight;
    }

    @Override
    public char[][] calculate() {
        int enlargedHeight = getHeight();
        for (InterfaceElement element : elements) {
            int delta = enlargedHeight - element.getHeight();
            element.enlargeSize(0, delta);
        }
        //Изменение размеров внутрених элементов
        char[][] horizontalLayout = new char[getHeight()][getWidth()];
        int currentWidth = 0;
        for (InterfaceElement element : elements) {
            int width = element.getWidth();
            int height = element.getHeight();
            char[][] insertedElement = element.calculate();
            for (int i = 0; i < element.getHeight(); i++) {
                System.arraycopy(insertedElement[i], 0, horizontalLayout[i], currentWidth, insertedElement[i].length);
            }
            currentWidth += width + 1;
            //Вставка внутрених элементов
        }
        return horizontalLayout;
    }

    @Override
    public void enlargeSize(int width, int height) {
    }
}
