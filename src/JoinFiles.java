import java.io.*;

public class JoinFiles {
    void JoinFilesa() throws IOException {
        PrintWriter pw = new PrintWriter("dictionaryA.txt");
        int[] lengs = new int[100];
        int[] temp = {8, 6, 7, 9, 10, 11, 12, 5, 13, 4, 14, 15, 16, 3, 17, 18, 2, 19, 1};
        String[] folders = {"b1", "b", "1", "bC1", "bC", "C1", "ab1", "ab", "C", "abC1", "a1", "abC", "aC1", "aC", "a"};
        for (int i = 0; i < 19; i++) {
            lengs[i] = temp[i];
        }
        for (int i = 19; i < 100; i++) {
            lengs[i] = i+1;
        }


        BufferedReader br = null;
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 100; i++) {
                try {
                    br = new BufferedReader(new FileReader("SortedPasswords\\" + folders[j] + "\\" + lengs[i] + ".txt"));

                    String line = br.readLine();

                    while (line != null) {
                        pw.println(line);
                        line = br.readLine();
                    }
                } catch (FileNotFoundException e) {

                }
            }
        }

            pw.flush();


            br.close();
            pw.close();

            System.out.println("Merged file1.txt and file2.txt into file3.txt");

    }
    void JoinFilesb() throws IOException {
        PrintWriter pw = new PrintWriter("dictionaryB.txt");
        int[] lengs = new int[100];
        int[] temp = {8, 6, 7, 9, 10, 11, 12, 5, 13, 4, 14, 15, 16, 3, 17, 18, 2, 19, 1};

        double[] row ={
                25.79
                , 17.78
                , 14.75
                , 14.37
                , 10.51
                , 4.72
                , 3.08
                , 2.86
                , 1.49
                , 1.46
                , 0.99
                , 0.69
                , 0.59
                , 0.24
                , 0.17
                , 0.13
                , 0.06
                , 0.06
                , 0.02
        };

        double[] col ={45.5, 29.67, 9.2, 8.5, 1.54, 1.26, 1.25, 1.21, 0.8, 0.6, 0.15, 0.15, 0.11, 0.05, 0.01};
        float[][] result = new float[row.length][col.length];
        for(int j=0;j<col.length;j++) {
            for (int i = 0; i < row.length; i++) {
                result[i][j] = (float)row[i] * (float)col[j];
            }
        }
        float[] resultSorted=new float[col.length*row.length];
        int[] resultSortedRow=new int[col.length*row.length];
        int[] resultSortedColumn=new int[col.length*row.length];
        float highest=0;
        int highestRow=0;
        int highestColumn=0;
        for(int k=0; k<col.length*row.length; k++) {
            highest=0;
            highestRow=0;
            highestColumn=0;
            for (int j = 0; j < col.length; j++) {
                for (int i = 0; i < row.length; i++) {
                    if(result[i][j]>highest){
                        highest=result[i][j];
                        highestRow =i;
                        highestColumn=j;
                    }
                }

            }
            result[highestRow][highestColumn]=-1;
            resultSortedRow[k]=highestRow;
            resultSortedColumn[k]=highestColumn;
            resultSorted[k]=highest;
        }


        String[] folders = {"b1", "b", "1", "bC1", "bC", "C1", "ab1", "ab", "C", "abC1", "a1", "abC", "aC1", "aC", "a"};
        for (int i = 0; i < 19; i++) {
            lengs[i] = temp[i];
        }
        for (int i = 19; i < 100; i++) {
            lengs[i] = i;
        }
        // BufferedReader object for file1.txt

        BufferedReader br = null;
        for (int j = 0; j < 15*19; j++) {

                try {
                    br = new BufferedReader(new FileReader("SortedPasswords\\" + folders[resultSortedColumn[j]] + "\\" + lengs[resultSortedRow[j]] + ".txt"));

                    String line = br.readLine();

                    while (line != null) {
                        pw.println(line);
                        line = br.readLine();
                    }
                } catch (FileNotFoundException e) {

                }

        }
        for (int j = 0; j < 15; j++) {
            for (int i = 20; i < 100; i++) {
                try {
                    br = new BufferedReader(new FileReader("SortedPasswords\\" + folders[j] + "\\" + lengs[i] + ".txt"));

                    String line = br.readLine();

                    while (line != null) {
                        pw.println(line);
                        line = br.readLine();
                    }
                } catch (FileNotFoundException e) {

                }
            }
        }

        pw.flush();

        br.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt into file3.txt");

    }
    void JoinFilesc() throws IOException {
        PrintWriter pw = new PrintWriter("dictionaryC.txt");


        BufferedReader br = null;

                try {
                    br = new BufferedReader(new FileReader("md5decryptor-uk.txt"));

                    String line = br.readLine();

                    while (line != null) {
                        pw.println(line);
                        line = br.readLine();
                    }
                } catch (FileNotFoundException e) {



        }

        pw.flush();


        br.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt into file3.txt");
    }

}
