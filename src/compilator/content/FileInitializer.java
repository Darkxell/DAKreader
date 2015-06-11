package compilator.content;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/** An object to put in memory a whole text file. Important RAM usage. */
public class FileInitializer {

	/** The file to be instancied */
	private String filepath;

	public FileInitializer(File file) {
		this.filepath = file.getAbsolutePath();
	}

	public FileInitializer(String filepath) {
		this.filepath = filepath;
	}

	/** Returns a Filearray Object containing the lines of your text file. */
	public FileArray getfilearray() {
		String filestring = "";
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(this.filepath));
			String line;
			while ((line = br.readLine()) != null)
				builder.append(line + "\n");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		filestring = builder.toString();
		filestring = filestring.toLowerCase();
		return new FileArray(filestring.split("\n"));
	}
}
