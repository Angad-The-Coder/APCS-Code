public class Thing {
    private int num;// num belonging to this Thing
    private int direction; // 0 = N, 1 = E, 2 = S, 3 = W
    private Thing[] neighbors = new Thing[4];

    public Thing(int num, int direction) {
        this.num = num;
        this.direction = direction;
    }

    public void setNeighbor(int ind, Thing t) {
        neighbors[ind] = t;
    }

    public void setNeighbors(Thing[] newNeighbors) {
        this.neighbors = newNeighbors;
    }

    public Thing getNeighbor(int ind) {
        return neighbors[ind];
    }

    public Thing[] getNeighbors() {
        return neighbors;
    }

    public void setDirection(int dir) {
        this.direction = dir;
    }

    public int getDirection() {
        return direction;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String toString() {
        return super.toString() + " num: " + num + " dir: " + direction;
    }
}
