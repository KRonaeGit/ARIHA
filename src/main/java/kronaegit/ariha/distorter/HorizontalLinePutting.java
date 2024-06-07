package kronaegit.ariha.distorter;

import java.awt.*;

public class HorizontalLinePutting extends CustomLinePutting {
    public HorizontalLinePutting(int ay, int by, int thickness, Color color) {
        super(0, ay, -1, by, thickness, color);
    }
}
