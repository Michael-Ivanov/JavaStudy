package multithreadingtests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class MultithreadingReading {

    public static void main(String[] args) throws InterruptedException {
        new MultithreadingReading().starter();
    }

    private void starter() throws InterruptedException {
        File directory = new File("resources/files");
        File[] allFiles = directory.listFiles();
        if (allFiles != null) {
            Semaphore semaphore = new Semaphore(2);
            for (File file : allFiles) {
                System.out.println(file.toString());
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        try {
                            semaphore.acquire();
                            readFile(file);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }

                    }
                }).start();
            }
        }
    }
    private void readFile(File file) {

        System.out.println("Thread " + Thread.currentThread().getName() + " is working now on object " + this);

        try (FileReader fileReader = new FileReader(file)) {
            int input;
            while ((input = fileReader.read()) != -1) {
                System.out.print((char) input);
                Thread.sleep(500);
            }
//            System.out.println();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*class MyFileReader implements Runnable {

    private File file;

    public MyFileReader(){}

    public MyFileReader(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("New thread " + Thread.currentThread().getName() + " started with file " + file.getPath());

    }



    public void setFile(File file) {
        this.file = file;
    }
}*/
