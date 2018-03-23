package recursion;

/**
 * Draws English ruler
 */
public class Ruler {

    public void drawRuler(int numberOfInches, int majorLength) {
        drawLine(majorLength, 0);
        for (int i = 1; i <= numberOfInches; i++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, i);
        }
    }

    private void drawInterval(int centerLength) {
        if (centerLength >= 1) {
            drawInterval(centerLength - 1);
            drawLine(centerLength);
            drawInterval(centerLength - 1);
        }
    }

    private void drawLine(int lineLength)  {
        drawLine(lineLength, -1);
    }

    private void drawLine(int lineLength, int lineLabel) {
        for (int i = 0; i < lineLength; i++) {
            System.out.print("-");
        }
        if (lineLabel >= 0) {
            System.out.print(" " + lineLabel);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Ruler ruler = new Ruler();
        ruler.drawRuler(3, 5);
    }

}
