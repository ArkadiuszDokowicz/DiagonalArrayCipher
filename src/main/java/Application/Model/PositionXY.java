package Application.Model;

public class PositionXY {
    int positionX;
    int positionY;

    public PositionXY(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public String toString() {
        return "PositionXY{" +
                "X=" + positionX +
                ", Y=" + positionY +
                '}';
    }
}
