public class Assistant {

    public static void drawFrame(int width, int height, char[][] frame, char[] symbols) {
        for (int i = 0; i < height; i++) {//i-номер строки
            for (int j = 0; j < width; j++) {//j-номер столбца
                if (i == 0 && j == 0) frame[0][0] = symbols[0];
                else if (i == 0 && j == width - 1) frame[i][j] = symbols[1];
                else if (i == height - 1 && j == 0) frame[i][j] = symbols[2];
                else if (i == height - 1 && j == width - 1) frame[i][j] = symbols[3];
                else if (i == 0 || i == height - 1) frame[i][j] = symbols[4];
                else if (j == 0 || j == width - 1) frame[i][j] = symbols[5];
            }
        }
    }

    public static char[][] getFrame(InterfaceElement element, char[] symbols, int downIntend) {
        char[][] elementInfo = element.calculate();
        int height = element.getHeight() + 2;
        int width = element.getWidth() + 4;
        char[][] frame = new char[height + downIntend][width];
        Assistant.drawFrame(width, height + downIntend, frame, symbols);        //Отрисовка рамки
        for (int i = 1; i < 1 + elementInfo.length; i++) {
            System.arraycopy(elementInfo[i - 1], 0, frame[i], 2, elementInfo[i - 1].length);
        }        //Вставка элемента который должен быть внутри
        return frame;
    }

}
