
public class Imambek implements java.io.Serializable {
    private int[][] desktop;
    private int level;
    private int[][] level7, level8, level9;
    public Imambek() {
        level = 7;
        level7 = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 4, 4, 4, 0, 0, 2},
                {2, 0, 0, 0, 3, 3, 3, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 2, 2, 2, 2, 2, 2},
                {2, 1, 3, 4, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        level8 = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 0, 0, 0, 0, 2, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 2, 0, 3, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 1, 3, 4, 0, 0, 0, 2},
                {2, 0, 3, 2, 2, 2, 2, 0, 0, 2},
                {2, 0, 4, 2, 2, 2, 2, 0, 4, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        level9 = new int[][] {
                {2, 2, 2, 2, 0, 0, 2, 2, 2, 2},
                {2, 0, 0, 2, 2, 2, 0, 4, 0, 2},
                {2, 0, 0, 2, 2, 0, 0, 3, 0, 2},
                {2, 0, 0, 2, 2, 0, 0, 3, 4, 2},
                {2, 0, 4, 2, 1, 0, 2, 3, 0, 2},
                {2, 0, 3, 2, 0, 0, 2, 4, 0, 2},
                {2, 4, 3, 0, 0, 2, 2, 0, 0, 2},
                {2, 0, 3, 0, 0, 2, 2, 0, 0, 2},
                {2, 0, 4, 0, 2, 2, 2, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };


    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int[][] getLevel() {
        if (level == 7) {
            desktop = level7;
        } else if (level == 8) {
            desktop = level8;
        } else if (level == 9) {
            desktop = level9;
        }
        return desktop;
    }
}
