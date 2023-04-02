public class InvalidFileNumberException extends Exception {
    public InvalidFileNumberException(int fileNumber) {
        super("Invalid file number: " + fileNumber + ". File number must be 1, 2, or 3.");
    }
}

