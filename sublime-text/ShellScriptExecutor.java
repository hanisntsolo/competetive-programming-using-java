
import java.lang.Process;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ShellScriptExecutor {

	public static void main(String[] args) throws Exception {
		try {
			 StringBuilder builder = new StringBuilder();
			 Process process = Runtime.getRuntime().exec("ps -ef");
			 String line = null;
			 try {
			 process.wait();
			 } catch (InterruptedException e) {
			       e.printStackTrace();
			 }
			 BufferedReader pReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			 String data = null;
			 while((data=pReader.readLine())!=null){
			      builder.append(line);
			 }
			 String result = builder.toString();
			 System.out.print(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}