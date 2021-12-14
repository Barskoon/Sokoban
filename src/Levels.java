import java.io.*;
import java.net.Socket;

public class Levels {
/********************************************************************************/
/**  Levels from Byte Code   **/

    int[][] level1 = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 4, 3, 0, 4, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 3, 0, 2},
            {2, 4, 0, 0, 1, 0, 0, 0, 0, 2},
            {2, 4, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 3, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 4, 0, 0, 0, 3, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    };
    int[][] level2 = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 3, 0, 0, 0, 0, 0, 2},
            {2, 0, 3, 2, 2, 2, 2, 0, 0, 2},
            {2, 0, 0, 2, 2, 2, 2, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 1, 2},
            {2, 4, 3, 2, 2, 2, 2, 2, 2, 2},
            {2, 4, 4, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    };
    int[][] level3 = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 2, 2, 2, 0, 3, 4, 2},
            {2, 0, 0, 2, 2, 0, 0, 0, 2, 2},
            {2, 0, 0, 2, 0, 0, 0, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 2, 2, 2, 2},
            {2, 3, 0, 3, 0, 1, 2, 2, 2, 2},
            {2, 0, 0, 2, 0, 0, 0, 2, 2, 2},
            {2, 0, 0, 2, 2, 0, 0, 0, 2, 2},
            {2, 4, 4, 2, 2, 2, 0, 3, 4, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    };

/********************************************************************************/
/**  Levels from Files   **/

    int[][] level4 = getLevelFromFile("levels/level4.sok");
    int[][] level5 = getLevelFromFile("levels/level5.sok");
    int[][] level6 = getLevelFromFile("levels/level6.sok");

/********************************************************************************/
/**  Levels from Server  **/

    int[][] level7 = getLevelFromServer(7);
    int[][] level8 = getLevelFromServer(8);
    int[][] level9 = getLevelFromServer(9);

/********************************************************************************/
/**  7 - 9 levels method    **/

    private int[][] getLevelFromServer(int lvl) {
        String hostName = "194.152.37.7";
        int portNumber = 4446;
        int[][] desktop = null;
        System.out.println("Connection to Server ...");
        try (
                Socket socket = new Socket(hostName, portNumber);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ) {
            Imambek object = (Imambek)in.readObject();
            object.setLevel(lvl);
            desktop = object.getLevel();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error: " + cnfe);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
        System.out.println("Close connection");
        return desktop;
    }

/********************************************************************************/
/**  4 - 6 levels methods   **/

    private int[][] getLevelFromFile(String directory) {
    int[][] desktop = null;
    try {
        desktop = fileLevels(directory);
    } catch (Exception exc) {
        System.out.println("Error! " + exc);
    }
    return desktop;
}
    private int[][] fileLevels(String fileName) throws Exception {
        File file = new File(fileName);
        String contentFile = getContentFile(file);
        int[][] desktop = convertStringIntoTwoDimensionArray(contentFile);
        return desktop;
    }
    private int[][] convertStringIntoTwoDimensionArray(String line) {
        int n = line.length();
        int row = 0;
        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol == '\n') {
                row = row + 1;
            }
        }
        int[][] array = new int[row][];
        int column = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                column = column + 1;
            } else if (symbol == '\n') {
                array[index] = new int[column];
                index = index + 1;
                column = 0;
            }
        }
        row = 0;
        column = 0;
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                array[row][column] = Integer.parseInt("" + symbol);
                column = column + 1;
            } else if (symbol == '\n') {
                row = row + 1;
                column = 0;
            }
        }
        return array;
    }
    private String getContentFile(File file) throws Exception {
        try (FileInputStream in = new FileInputStream(file)) {
            int size = (int)file.length();
            char[] array = new char[size + 1];
            int unicode;
            int index = 0;
            while ((unicode = in.read()) != - 1) {
                char symbol = (char) unicode;
                if (('0' <= symbol && symbol <= '4') || (symbol == '\n')) {
                    array[index] = symbol;
                    index = index + 1;
                }
            }

            array[index++] = '\n';
            String content = new String(array, 0, index);
            return content;
        } catch (FileNotFoundException fnfe) {
            throw new Exception("File Not Found Exception: " + fnfe);
        } catch (IOException ioe) {
            throw new Exception("Basic I/O Exception: " + ioe);
        }
    }

/********************************************************************************/
/**  Getter and Setter  **/

    int[][] thisLevel = level1;
    public int[][] getLevelClone() throws Exception{
       int[][] desktopClone = new int[thisLevel.length][];
       for (int i = 0; i < thisLevel.length; i++) {
           desktopClone[i] = thisLevel[i].clone();
       }
        return desktopClone;
    }
    public void setLevel(int level) {
        if (level == 1) {
            thisLevel = level1;
        } else if (level == 2) {
            thisLevel = level2;
        } else if (level == 3) {
            thisLevel = level3;
        } else if (level == 4) {
            thisLevel = level4;
        } else if (level == 5) {
            thisLevel = level5;
        } else if (level == 6) {
            thisLevel = level6;
        } else if (level == 7) {
            thisLevel = level7;
        } else if (level == 8) {
            thisLevel = level8;
        } else if (level == 9) {
            thisLevel = level9;
        } else {
            thisLevel = level1;
        }
    }

/** End **/
}
