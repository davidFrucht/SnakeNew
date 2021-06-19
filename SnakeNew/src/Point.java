/* David Frucht 19/06/2021 */


public class Point {

    public int X;
    public int Y;

    public Point(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }

    public void Set(Point p)
    {
        this.X = p.X;
        this.Y = p.Y;
    }

    public Boolean Equals(Point p)
    {
        return p.X == X && p.Y == Y;
    }

    @Override
    public String toString() {
        return String.format("Point (X: {" + this.X + "}, Y: {" + this.Y + "})");
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        this.Y = y;
    }

}


