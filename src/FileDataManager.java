import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDataManager {
    private static final String TODOPATH = "data/TODO.txt";
    private static final String INPROGRESSPATH = "data/inProgress.txt";
    private static final String DONEPATH = "data/done.txt";

    private static File todoFile;
    private static File inProgressFile;
    private static File doneFile;

    public static void setupDataBase() {
        todoFile = new File(TODOPATH);
        inProgressFile = new File(INPROGRESSPATH);
        doneFile = new File(DONEPATH);

        if (!todoFile.exists()) {
            createFile(todoFile);
        }
        if (!inProgressFile.exists()) {
            createFile(todoFile);
        }
        if (!doneFile.exists()) {
            createFile(todoFile);
        }
    }

    private static void createFile(File toCreate) {
        try {
            boolean didCreate = toCreate.createNewFile();
            if (!didCreate) {
                System.out.println("Created file successfully!");
            }
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public static void writeToDataBase(String data, int fileNumber) throws InvalidFileNumberException{
        FileOutputStream fos = null;

        try {
            fos = switch (fileNumber) {
                case 1 -> new FileOutputStream(todoFile);
                case 2 -> new FileOutputStream(inProgressFile);
                case 3 -> new FileOutputStream(doneFile);
                default -> throw new InvalidFileNumberException(fileNumber);
            };

            fos.write(data.getBytes());
            System.out.println("Wrote data to file successfully");
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public static void readFromDataBase(int fileNumber) throws InvalidFileNumberException{
        FileInputStream fos = null;

        try {
            long fileLength = 0;
            fos = switch (fileNumber) {
                case 1: {
                    fileLength = todoFile.length();
                    yield new FileInputStream(todoFile);
                }
                case 2: {
                    fileLength = inProgressFile.length();
                    yield new FileInputStream(inProgressFile);
                }
                case 3: {
                    fileLength = doneFile.length();
                    yield new FileInputStream(doneFile);
                }
                default: {
                    throw new InvalidFileNumberException(fileNumber);
                }
            };

            byte[] buffer = new byte[(int) fileLength];
            int byteRead = fos.read(buffer);
            System.out.println("Wrote data to file successfully");
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
}

