import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        //Scanner

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj imie: ");
//        String firstName = scanner.nextLine();
//        System.out.println("Podaj nazwisko: ");
//        String lastName = scanner.nextLine();
//        System.out.println("Uzytkownik: " + firstName + " " + lastName + " zostal/a zalogowany");
//
//        System.out.println("Podaj pierwsza liczbe: ");
//        int a = scanner.nextInt();
//
//        System.out.println("Podaj druga liczbe: ");
//        int b = scanner.nextInt();
//
//        System.out.println("Wynik dodawania to: " + (a + b));
//
//        //analogicznie dla double
//        scanner.nextDouble();

        //File writer - do odczytu

        FileWriter fileWriter = new FileWriter("file.txt");
        fileWriter.write("dupa\n");
        fileWriter.write("dupa\n");
        fileWriter.write("dupa\n");
        fileWriter.write("dupa\n");
        fileWriter.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("buffered.txt"));
        bufferedWriter.write("dupa");
        bufferedWriter.newLine();
        bufferedWriter.write("dupa");
        bufferedWriter.close();

        //READER trzeba castowac na chara bo inaczej zwraca Unicode czyli kod znaku np 65 A albo a 97
        FileReader fileReader = new FileReader("file.txt");
        int code;
        while ((code = fileReader.read()) != -1) {
            char c = (char) code;
            System.out.println(c);
        }
        fileReader.close();

        //Buffered Reader
        BufferedReader bufferedReader = new BufferedReader(new FileReader("buffered.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
        System.out.println("------------------------------");
//        System.out.println(bufferedReader.readAllLines()); //wypisujesz wszytkie linie w formie listy bo ta metoda zwraca List<String>
//        bufferedReader.close();

        //DO POCZYTANIA /todo
        //HashCode i Equals
        //Czym sa Interfejsy - bez spiny
        //podp. Tak jak klasy sa szablonem ktory okresla z czego ma sie skladac obiekt danej klasy, tak interfejs jest szablonem
        // okreslajacym co obiekt danej klasy potrafi zrobic (metody)

        // Zadanie: Praca z plikami – pełny zestaw
        //
        //Wykonaj wszystkie ponizsze kroki w jednym programie:
        //    1.    Zapisz 5 imion do pliku students.txt, kazde w osobnej linii.
        //    2.    Odczytaj plik linia po linii (uzywajac readLine) i wypisz kazde imie.
        //    3.    Policz ile jest linii w pliku (licznik w petli while).
        //    4.    Wypisz tylko te imiona, ktore zaczynaja sie na litere A.
        //    5.    Zapisz liczby od 1 do 10 do pliku numbers.txt, kazda liczba w osobnej linii.
        //    6.    Odczytaj plik numbers.txt i policz sume wszystkich liczb.
        //    7.    Dopisz 3 kolejne imiona do students.txt, uzywajac FileWriter("students.txt", true).
        //    8.    Odczytaj wszystkie linie z students.txt przy uzyciu readAllLines i wypisz je w formacie:
        //
        //1: imie1
        //2: imie2
        //
        //9.    Utworz kopie pliku students.txt o nazwie copy.txt.
        //    10.    Znajdz najdluzsza linie w pliku i wypisz ja na ekran.
        //    11.    Policz, ile razy w pliku wystepuje litera ‘a’ (male ‘a’).
        //    12.    Wczytaj wszystkie linie do List i wypisz cala liste w formacie:
        //
        //[linia1, linia2, linia3, ...]

        FileWriter students = new FileWriter("students.txt");
        students.write("Lukas Bielik\n");
        students.write("Sonia Bielikova\n");
        students.write("Sush Indyjski\n");
        students.write("Ciri the Cat\n");
        students.write("Kazik\n");
        students.write("Antygona\n");
        students.write("Ananas\n");
        students.close();

        BufferedReader studentsReader = new BufferedReader(new FileReader("students.txt"));
        BufferedWriter studentsWriter = new BufferedWriter(new FileWriter("students_copy.txt"));
        int counter = 0;
        String name;
        while ((name = studentsReader.readLine()) != null) {
            System.out.println("Wszyscy futrzaści studenci: " + name);
            counter++;
            studentsWriter.write(name +"\n");
            if (name.startsWith("A")) {
                System.out.println("Imie zaczynające się na A: " + name);
            }
        }
        System.out.println("Liczba linii: " + counter);
        studentsReader.close();
        studentsWriter.close();
        System.out.println("--------------------------");

        FileWriter numbers = new FileWriter("numbers.txt");
        numbers.write("1\n");
        numbers.write("2\n");
        numbers.write("3\n");
        numbers.write("4\n");
        numbers.write("5\n");
        numbers.write("6\n");
        numbers.write("7\n");
        numbers.write("8\n");
        numbers.write("9\n");
        numbers.write("10\n");
        numbers.close();

        BufferedReader numbersReader = new BufferedReader(new FileReader("numbers.txt"));
        int suma = 0;
        String line2;
        while ((line2 = numbersReader.readLine()) != null) {
            System.out.println(line2);
            suma += Integer.parseInt(line2);
        }
        System.out.println("Suma wynosi: " + suma);
        numbersReader.close();

        System.out.println("------------------------");
        FileWriter studentsNames = new FileWriter("students.txt", true);
        studentsNames.write("Vincent\n");
        studentsNames.write("Ziuta\n");
        studentsNames.close();

        BufferedReader studentsNamesReader = new BufferedReader(new FileReader("students.txt"));
        String name2;
        while ((name2 = studentsNamesReader.readLine()) != null) {
            System.out.println("Imie futrzanego studenta: " + name2);
        }
        studentsNamesReader.close();
        System.out.println("------------------------------");


        BufferedReader studenciReader = new BufferedReader(new FileReader("students_copy.txt"));
        List<String> allLines = new ArrayList<>();

        int maximum = 0;
        String maxLine;
        String longestLine = " ";
        int countA = 0;

        while ((maxLine = studenciReader.readLine()) != null) {
            allLines.add(maxLine);
            for (int i = 0; i < maxLine.length(); i++) {
                if (maxLine.charAt(i) == 'a') {
                    countA++;
                }
            }
            if (maxLine.length() > maximum) {
                maximum = maxLine.length();
                longestLine = maxLine;
            }
        }


        System.out.println("Najdłuższa linia: " + longestLine);
        System.out.println("Ilość wystąpień 'a': " + countA);
        System.out.println("Wszytskie linie: " + allLines);
        studenciReader.close();
        // GIT
        System.out.println("Testujemy gita! Jest GIT!");
        //tutaj dodalem jakies zmiany
        //zdanie dmowe zrobione
        // jak bd pytac czata to mow zjebowi ze na UI ma ci pokazywac a nie w konsoli!
        //DO POCZYTANIA ogolnie teorie o pull requestach commitach merge i tak dalej plus czym jest squashowanie commitow i czym
        //jest cherry pickowanie commitow
    }
}









