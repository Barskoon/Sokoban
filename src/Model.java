public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;
    private int[][] goals;
    private Levels level;
    private int thisLevel;

    public Model (Viewer viewer) {
        this.viewer = viewer;
        restart();
    }

    private void restart() {
        thisLevel = 1;
        level = new Levels();
        init();
    }

    private void init() {
        try {
            desktop = level.getLevelClone();
        } catch (Exception e) {
            viewer.showErrorMessage("" + e);
            restart();
        }
        int[][] gamerPosition = findNumberInMatrix(desktop, 1);
        indexX = gamerPosition[0][0];
        indexY = gamerPosition[0][1];
        goals = findNumberInMatrix(desktop, 4);
    }
    private void checkGoal() {
        int inc = 0;
        while ( (goals[inc][0] != 0) && (goals[inc][1] != 0)) {
            if (desktop[goals[inc][0]][goals[inc][1]] == 0) {
                desktop[goals[inc][0]][goals[inc][1]] = 4;
            };
            inc = inc + 1;
        }
    }

    private void won() {
        boolean isWon = true;
        int inc = 0;
        while ( (goals[inc][0] != 0) && (goals[inc][1] != 0)) {
            if (desktop[goals[inc][0]][goals[inc][1]] != 3) {
                isWon = false;
            };

            inc = inc + 1;
        }
        if (isWon) {
            if (viewer.showDialogWon()) {
                if (thisLevel < 9) {
                    thisLevel = thisLevel + 1;
                } else {
                    restart();
                }
                level.setLevel(thisLevel);
                init();
                viewer.setLevelLabel(thisLevel);
                viewer.update();
            }
        }
    }

    public void goLevel(String command) {
        switch (command) {
            case "level1":
                thisLevel = 1;
                break;
            case "level2":
                thisLevel = 2;
                break;
            case "level3":
                thisLevel = 3;
                break;
            case "level4":
                thisLevel = 4;
                break;
            case "level5":
                thisLevel = 5;
                break;
            case "level6":
                thisLevel = 6;
                break;
            case "level7":
                thisLevel = 7;
                break;
            case "level8":
                thisLevel = 8;
                break;
            case "level9":
                thisLevel = 9;
                break;
            case "resetButton":
                break;
            default:
                return;
        }
        level.setLevel(thisLevel);
        viewer.update();
        init();
        viewer.update();
        viewer.setLevelLabel(thisLevel);
    }

    private int[][] findNumberInMatrix(int[][] desktop, int sokobanObject) {
        int[][] myGoals = new int[100][2];
        int inc = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == sokobanObject) {
                  myGoals[inc][0] = i;
                  myGoals[inc][1] = j;
                  inc = inc + 1;
                }
            }
        }
        return  myGoals;
    }

    public void move(String direction) {
        if (direction.equals("Up")) {
            moveUp();
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        } else if (direction.equals("Left")) {
            moveLeft();
        } else {
            return;
        }
        checkGoal();
        viewer.update();
        won();
    }

    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }
        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }
        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }
        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }
        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    public int[][] getDesktop() {
            return desktop;
        }
    public int getLevel() {
        return thisLevel;
    }
}
