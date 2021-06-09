import java.io.*;

public class SingleSearch {
    int SingleSearch() throws IOException {
        File f1 = new File("rockyou.txt");
        String[] words = null;
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String s;
        File file = new File("md5decryptor-uk.txt");
        final RandomAccessFile f = new RandomAccessFile(file, "r");
        final long randomLocation = (long) (Math.random() * f.length());
        f.seek(randomLocation);
        f.readLine();
        String randomLine = f.readLine();
        f.close();


        String input = randomLine;
        int count = 0;

        while ((s = br.readLine()) != null && count == 0)
        {
            if (s.equals(input))
            {
                count++;

            }
        }

        if (count != 0)
        {
            System.out.println("The given word " + input + " is present in the file");
        } else {
            System.out.println("The given " + input + " word is not present in the file");
        }

        fr.close();



return count;

    }
}
