package ss1_introduction_to_java.baitap;

import java.util.Scanner;

public class SoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int number = scanner.nextInt();
        System.out.println(convert(number));
    }
    public static String readUnits(int number){
        switch (number){
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }
    public static String readDozens(int number){
        switch (number){
            case 1:
                return "teen";
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
            default:
                return "";
        }
    }
    public static String readHundreds(int number){
        switch (number){
            case 1:
                return "one hundreds";
            case 2:
                return "two hundreds";
            case 3:
                return "three hundreds";
            case 4:
                return "four hundreds";
            case 5:
                return "five hundreds";
            case 6:
                return "six hundreds";
            case 7:
                return "seven hundreds";
            case 8:
                return "eight hundreds";
            case 9:
                return "nine hundreds";
            default:
                return "";
        }
    }
    public static String convert(int number){
        int remainder = number%10;
        int integer = number/10;
        int remainder_hundreds = number%100;
        int integer_hundreds = number/100;
        if(integer == 0){
            return readUnits(number);
        }else if(integer>=1 && integer<10){
            if(integer == 1){
                switch (remainder){
                    case 0:
                        return "ten";
                    case 1:
                        return "eleven";
                    case 2:
                        return "twelve";
                    case 3:
                        return "thirteen";
                    case 5:
                        return "fifteen";
                    default:
                        return readUnits(remainder)+readDozens(integer);
                }
            }else {
                if(remainder==0){
                    return readDozens(integer);
                }else {
                    return readDozens(integer)+"-"+readUnits(remainder);
                }
            }
        }else {
            int x_remainder = remainder_hundreds%10;
            int y_integer = remainder_hundreds/10;
            String z;
            if(y_integer == 0){
                z = readUnits(remainder_hundreds);
            }else if(y_integer == 1){
                switch (remainder_hundreds){
                    case 0:
                        z = "ten";
                        break;
                    case 1:
                        z = "eleven";
                        break;
                    case 2:
                        z = "twelve";
                        break;
                    case 3:
                        z = "thirteen";
                        break;
                    case 5:
                        z = "fifteen";
                        break;
                    default:
                        z = readUnits(x_remainder)+readDozens(y_integer);
                        break;
                }
            }else {
                if(x_remainder == 0){
                    z = readDozens(y_integer);
                }else {
                    z = readDozens(y_integer)+"-"+readUnits(x_remainder);
                }
            }
            return readHundreds(integer_hundreds) + " and "+z;
        }
    }
}