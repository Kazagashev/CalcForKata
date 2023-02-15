import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        String znam = scr.nextLine();
        System.out.println(calc(znam));
    }
    static String calc(String input) throws Exception {
        String[]perevod = input.split(" ");
        if (perevod.length !=3) throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        String sign = perevod[1];
        boolean pravda;
        // переводим Римские в Арабские.
        if( Roman.pravda(perevod[0]) && Roman.pravda(perevod[2])){
            int a = Roman.convertToArabian(perevod[0]);

            int b = Roman.convertToArabian(perevod[2]);

            if (a < 1 || a >10 && b < 1 || b >10){
                throw new Exception("Числа должны быть от 1 до 10 ");
            }

            System.out.println(Roman.convertRoman(Roman.calcArabian(a,b,sign)));

        }
        else if(!Roman.pravda(perevod[0]) && !Roman.pravda(perevod[1])){
            int a = Integer.parseInt(perevod[0]);
            int b = Integer.parseInt(perevod[2]);
            if(a < 1 || a >10 && b < 1 || b >10){
                throw new Exception("Числа должны быть от 1 до 10 ");
            }

            System.out.println(Roman.calcArabian(a,b,sign));
        }

        else {
            throw new Exception("Числа должны быть в одном формате");
        }

        return "";
    }
}
class Roman{
    static String[] romanArray = new String[]{"0","I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
            "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL"
            ,"XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
            "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX"
            ,"LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};

    public static int convertToArabian(String roman)  {

        for (int i = 0;i < romanArray.length;i++){
            if (roman.equals(romanArray[i])){
                int num1 = i;
                return num1;
            }
        }
        return 0;
    }

    public static boolean pravda(String val){
        for (int i = 0;i < romanArray.length;i++){
            if(val.equals(romanArray[i])){
                return true;
            }
        }
        return false;
    }

    public static String convertRoman(int roman){

        return romanArray[roman];
    }

    public static int calcArabian(int a, int b, String sign){


        if (sign.equals("+")){
            return (a+b);
        }
        else if (sign.equals("-")){
            return (a-b);
        }
        else if (sign.equals("*")){
            return (a*b);
        }
        else if (sign.equals("/")){
            return (a/b);
        }
        return 0;
    }


}