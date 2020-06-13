package main.streams;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StreamHandler {
    public ByteArrayOutputStream getOutContent() {
        return outContent;
    }

    public ByteArrayOutputStream getErrContent() {
        return errContent;
    }

    public PrintStream getOriginalOut() {
        return originalOut;
    }

    public PrintStream getOriginalErr() {
        return originalErr;
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
