import java.io.*;
import java.util.Scanner;

public class DictionaryAttack {
    static Scanner in = new Scanner( System.in );

    static void singleSearch() throws IOException {
        int option=typeOfAttack();
        int level;
        if(option!=0){
            level =levelOfComplication();
        }
        int s= sourceOfDicitionary();
        long startmm = System.nanoTime();
        SingleSearch mm = new SingleSearch();
        int  passedmm =mm.SingleSearch();
        long elapsedTimemm = System.nanoTime() - startmm;
        System.out.println(passedmm);
        System.out.println((double)elapsedTimemm/1000000000+ "s");
    }

    static void multipleSearch() throws IOException {
        int option=typeOfAttack();
        int level = 0;
        if(option!=0){
            level =levelOfComplication();
        }
        int s= sourceOfDicitionary();


        MultipleSearch mm = new MultipleSearch();
        numberOfPasswords();
        long startmm = System.nanoTime();
        double  passedmm =mm.MultipleSearch(s, option, level);
        long elapsedTimemm = System.nanoTime() - startmm;
        System.out.println("Procentowo haseł odnaleziono: "+ passedmm);
        System.out.println("Czas trwania ataku: " +(double)elapsedTimemm/1000000000+ "s");
     //   System.out.println( "Wybrano opcję drugą" );
    }

    static void showMenu()
    {
        System.out.println("Atak słownikowy");
        System.out.println("Proszę wybrać rodzaj ataku:");
        System.out.println("1-Atak na pojedyńcze hasło");
        System.out.println("2-Atak na więcej haseł");
    }

    static void menu() throws IOException {
        int optionNumber;
        do
        {
            showMenu();
            optionNumber = in.nextInt();
            switch( optionNumber )
            {
                case 1 : singleSearch();
                    break;
                case 2 : multipleSearch();
                    break;
            }
        }
        while( optionNumber != 3 );
    }

    static int typeOfAttack(){
        int optionNumber;
        do
        {
        System.out.println("Proszę wybrać sposób kombinacji ataku:");
        System.out.println("0-Bez kombinacji");
        System.out.println("1-Liczby na końcu");
        System.out.println("2-Liczby na początku");
        System.out.println("3-Znaki specjalne na końcu");
        System.out.println("4-Znaki specjalne początku");
        optionNumber=in.nextInt();
        }
        while (!(optionNumber== 0 || optionNumber==1|| optionNumber==2|| optionNumber==3|| optionNumber==4));
        return optionNumber;
    }
    static int levelOfComplication(){
        int optionNumber;
        do
        {
            System.out.println("Proszę wybrać jeden z poniższych poziomów komplikacji ataku:");
            System.out.println("10");
            System.out.println("100");
            System.out.println("1000");
            System.out.println("10000");
            optionNumber=in.nextInt();
        }
        while (!(optionNumber== 10 || optionNumber==100|| optionNumber==1000|| optionNumber==10000));
        return optionNumber;
    }
    static int sourceOfDicitionary(){
        int optionNumber;
        do
        {
            System.out.println("Proszę wybrać rodzaj uzytego slownika:");
            System.out.println("1-Slownik segregowany rodzajem");
            System.out.println("2-Slownik na podstawie macierzy wag");
            System.out.println("3-Slownik z oryginalnego pliku tekstowego");
            optionNumber=in.nextInt();
        }
        while (!(optionNumber== 1 || optionNumber==2|| optionNumber==3));
        return optionNumber;
    }
    static int numberOfPasswords() throws IOException {
        int optionNumber;

            do{
            System.out.println("Czy hasla sa juz wygenerowane?");
            System.out.println("1-Tak ");
            System.out.println("2-Nie");
                optionNumber=in.nextInt();
            }
            while (!(optionNumber== 1 || optionNumber==2));
            int noPasswords;
            int seed;
            if(optionNumber==2) {
                System.out.println("Proszę podać ilość haseł:");
                noPasswords=in.nextInt();
                System.out.println("Proszę podać ziarno, lub 0 jeśli hasła mają być wygenerowane bez ziarna:");
                seed=in.nextInt();
                MultipleSearch mm = new MultipleSearch();
                mm.GetRandomPasswords(noPasswords, seed);
            }


        return optionNumber;
    }
    public static void main(String[] args) throws IOException {
    menu();


    }
}



