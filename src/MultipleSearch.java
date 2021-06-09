import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class MultipleSearch {
    double MultipleSearch(int source, int option, int level) throws IOException {
        File file;
        if(source==1){
            file = new File("dictionaryA.txt");
        }else if(source==2){
            file = new File("dictionaryB.txt");
        }else{
            file = new File("dictionaryC.txt");
        }
        FileReader fr = new FileReader(file);
        BufferedReader br;
        String s;


        final RandomAccessFile f = new RandomAccessFile(file, "r");

        ArrayList<String> passwords = new ArrayList<String>();
            br = new BufferedReader(new FileReader("randomPasswords.txt"));
            String line ;
            while( (line = br.readLine() ) != null) {
                passwords.add(line);
            }

        f.close();
        int totalPasswords=passwords.size();
        String input ="";
        int count = 0;
        br = new BufferedReader(fr);
        while ((s = br.readLine()) != null)
        {
            for(int i=0;i<passwords.size()-1;i++) {
                input=passwords.get(i);
                if (CheckPassword(s, input, option, level))
                {
                    count++;
                    passwords.remove(input);
                }
            }
        }

        fr.close();

        return (double)(((double)count*100/(double)totalPasswords));

    }

    private boolean CheckPassword(String s, String input, int option, int level) {
        if (s.equals(input)){
            return true;
        }
        switch (option){
            case 0:
            return false;
            case 1:
            case 2:
                return CheckCombinationsNumbers(s, input,option, level);
            case 3:
            case 4:
                return CheckCombinationsSigns(s, input, option, level);
            default:
                return false;
        }
    }



    private boolean CheckCombinationsNumbers(String s, String input, int option, int level) {
        if(option==1){
            for(int i=0;i<level;i++){
                if ((s+i).equals(input)){
                    return true;
                }
            }
        }
        if(option==2){
            for(int i=0;i<level;i++){
                if ((i+s).equals(input)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean CheckCombinationsSigns(String s, String input, int option, int level) {
        String characters =" !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        if(option==3){
            if(level==10){
                for(int i=0;i<characters.length();i++){
                    if ((s+characters.charAt(i)).equals(input)){
                        return true;
                    }
                }
            }else if (level==100) {
                for (int i = 0; i < characters.length(); i++) {
                    if ((s + characters.charAt(i)).equals(input)) {
                        return true;
                    }
                    for (int j = 0; j < characters.length(); j++) {
                        if ((s + characters.charAt(i) + characters.charAt(j)).equals(input)) {
                            return true;
                        }
                    }
                }
            }else if (level==1000) {
                for (int i = 0; i < characters.length(); i++) {
                    if ((s + characters.charAt(i)).equals(input)) {
                        return true;
                    }
                    for (int j = 0; j < characters.length(); j++) {
                        if ((s + characters.charAt(i) + characters.charAt(j)).equals(input)) {
                            return true;
                        }
                        for (int k = 0; k < characters.length(); k++) {
                            if ((s + characters.charAt(i) + characters.charAt(j)+ characters.charAt(k)).equals(input)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if(option==4){
            if(level==10){
                for(int i=0;i<characters.length();i++){
                    if ((characters.charAt(i)+s).equals(input)){
                        return true;
                    }
                }
            }else if (level==100) {
                for (int i = 0; i < characters.length(); i++) {
                    if ((s + characters.charAt(i)+s).equals(input)) {
                        return true;
                    }
                    for (int j = 0; j < characters.length(); j++) {
                        if ((characters.charAt(i) + characters.charAt(j)+s).equals(input)) {
                            return true;
                        }
                    }
                }
            }else if (level==1000) {
                for (int i = 0; i < characters.length(); i++) {
                    if (( characters.charAt(i)+s).equals(input)) {
                        return true;
                    }
                    for (int j = 0; j < characters.length(); j++) {
                        if ((characters.charAt(i) + characters.charAt(j)+s).equals(input)) {
                            return true;
                        }
                        for (int k = 0; k < characters.length(); k++) {
                            if ((characters.charAt(i) + characters.charAt(j)+ characters.charAt(k)+s).equals(input)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;

    }

    void GetRandomPasswords(int l, int seed) throws IOException {
        File file = new File("rockyou.txt");
        PrintWriter pw = new PrintWriter("randomPasswords.txt");
        final RandomAccessFile f = new RandomAccessFile(file, "r");
        Random generator = new Random(seed);
        for(int i=0;i<l;i++) {
            final long randomLocation = (long) (generator.nextFloat() * f.length());
            f.seek(randomLocation);
            f.readLine();
            String randomLine = f.readLine();


            System.out.println(randomLine);
            pw.write(randomLine+"\n");
        }
        f.close();
        pw.close();


    }
}
