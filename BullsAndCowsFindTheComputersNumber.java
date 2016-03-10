
package bullsandcowsfindthecomputersnumber;

import java.util.Random;
import java.util.Scanner;

public class BullsAndCowsFindTheComputersNumber {

    public static void main(String[] args) {
        boolean [] ArrayForUniqueNumber = new boolean [10]; //масив от булет тип, чийто елементи ще се менят от 0 в 1, след като индекса на дадения елемент бъде използван
        int [] ArrayForKeepingNumber = new int [4]; //масива, в който ще пазим генерираното число
        int [] ArrayBullsAndCows = new int [2]; // помощен масив, чрез който ще извеждаме текущите крави и бикове(0 елемент са биковете, 1 елемент са кравите)
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        GenerateUniqueNumber(ArrayForUniqueNumber, random, ArrayForKeepingNumber);//функция за генериране на 4 цифрено число без постарящи се цифри
    //    System.out.println(ArrayForKeepingNumber[0] + "" + ArrayForKeepingNumber[1] + "" + ArrayForKeepingNumber[2] + "" + ArrayForKeepingNumber[3]);
        while(ArrayBullsAndCows[0]<4){//този цикъл ще се изпълнява докато не получим 4 бика
            int guessedNumber = scanner.nextInt();
            ArrayBullsAndCows[0] = 0; // зануляваме биковете преди всяка проверка на числото
            ArrayBullsAndCows[1] = 0; // зануляваме кравите преди всяка проверка на числото
            CheckTheGuessedNumber(guessedNumber, ArrayBullsAndCows, ArrayForKeepingNumber); // функция, сравняваща предположението на потребителя с генерираното число на компютъра
            System.out.println(ArrayBullsAndCows[0] + " bulls and " + ArrayBullsAndCows[1] + " cows"); // извеждаме текущите крави и бикове на екрана
            
        }
        
    }
    
    public static void GenerateUniqueNumber(boolean Array[], Random random, int ArrayForKeepingNumber[]){
        int i = 0; //променлива, която брои генерираните числа
        while(i<4){ // цикъл за генерирането на 4 уникални числа
            int randomNumber = random.nextInt(10);
            if(Array[randomNumber]==false){ // ако генерираното от random функцията число е "свободно", то то се запазва...
            ArrayForKeepingNumber[i]=randomNumber; //... и числото с негов индекс ...
            Array[randomNumber]=true; // ... става "заето"
            i++;
            }
        }
    }
    
    public static void CheckTheGuessedNumber(int guessedNumber, int ArrayBullsAndCows [], int ArrayForKeepingNumber []){
        int [] ArrayGuessedNumber = new int [4]; //масив, в който ще съхраняваме текущото предположено число
        NumberFromStringToArray(guessedNumber, ArrayGuessedNumber); //функция, която преобразува числото в масив
       // System.out.println(ArrayGuessedNumber[0] + "" + ArrayGuessedNumber[1] + "" + ArrayGuessedNumber[2] + "" + ArrayGuessedNumber[3]);
        for(int p = 0;p < 4;p++){ // вложени цикли, с които сравняваме всяка цифра от генерираното число с ...
            for(int q = 0;q < 4;q++){ // ... всяко число от предположеното число
                if(ArrayForKeepingNumber[p]==ArrayGuessedNumber[q]){ // ако числата съвпадат ...
                    if(p==q) ArrayBullsAndCows[0]++; // ... и позициите също - това е бик
                    else ArrayBullsAndCows[1]++; //... а ако позициите им не съвпадат - крава
                }
            }
        }
    }
    
    public static void NumberFromStringToArray(int number, int array[]){
        int x = 10000 + number; // помощна променлива, нужна ни е в случай, че предположеното число започва с 0
        for(int i=3;i>=0;i--){
            array[i]=x%10; // една по една прехвърляме цифрите от предположеното число в масива
            x=x/10;
        }
    }
}
