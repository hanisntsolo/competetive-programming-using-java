import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderPing {

    public static void main(String[] args) {
        System.out.println("Program Started...");
        ProcessBuilder processBuilder = new ProcessBuilder();
        // linux
        // processBuilder.command("bash", "-c", "ls -lart");
        String path = "/home/hanisntsolo/Documents/_code-hanisntsolo/competetive-programming-using-java/sublime-text/script.sh";
        processBuilder.command(path);

        System.out.println("Command Processed!");

        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}