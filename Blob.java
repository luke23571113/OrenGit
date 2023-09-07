import java.nio.file.Files;
import java.nio.file.Path;

public class Blob{

    private String hash;

    public Blob(String fileName) throws Exception{
        Path filePath = Path.of(fileName);
        String fileContents = Files.readString(filePath);
        hash = getHash(fileContents);
        Path blobFilePath = Path.of("objects\\" + hash + ".txt");
        Files.writeString(blobFilePath, fileContents);
    }

    //hashes an array of bytes to a string using the Sha1 hash function
    public String getHash(String contents) {
        byte[] b = contents.getBytes();
        String result = "";
        for (int i=0; i < b.length; i++) {
          result +=
                Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    public String getHash(){
        return hash;
    }
}