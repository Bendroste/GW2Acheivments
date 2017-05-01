package Main;

import Daily.Daily;
import Daily.DailyAcheivments;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Ben Droste on 4/25/2017.
 */
public class main {
    public static void main(String[] args) throws java.io.IOException {
        Daily daily = new Daily();
        boolean run = true;
        while (run) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1: Daily Achievements Today");
            System.out.println("2: Daily Achievements Tomorrow");
            System.out.println("3: Account");
            System.out.println("4: Exit");
            System.out.println("Enter a number: ");
            int base = scanner.nextInt(); // Scans the next token of the input as an int.
            switch (base) {
                case 1: {
                    System.out.println();
                    System.out.println("1: PVE");
                    System.out.println("2: PVP");
                    System.out.println("3: WVW");
                    System.out.println("4: Fractals");
                    System.out.println("5: Festivals");
                    System.out.println("Enter a number: ");
                    int second = scanner.nextInt(); // Scans the next token of the input as an int.
                    switch (second) {
                        case 1:
                            print(daily.todayPve());
                            break;
                        case 2:
                            print(daily.todayPvp());
                            break;
                        case 3:
                            print(daily.todayWvw());
                            break;
                        case 4:
                            print(daily.todayFrac());
                            break;
                        case 5:
                            print(daily.todaySpecial());
                            break;
                        default:
                            break;
                    }
                }
                case 2: {
                    System.out.println();
                    System.out.println("1: PVE");
                    System.out.println("2: PVP");
                    System.out.println("3: WVW");
                    System.out.println("4: Fractals");
                    System.out.println("5: Festivals");
                    System.out.println("Enter a number: ");
                    int second = scanner.nextInt(); // Scans the next token of the input as an int.
                    switch (second) {
                        case 1:
                            print(daily.tomPve());
                            break;
                        case 2:
                            print(daily.tomPvp());
                            break;
                        case 3:
                            print(daily.tomWvw());
                            break;
                        case 4:
                            print(daily.tomFrac());
                            break;
                        case 5:
                            print(daily.tomSpecial());
                            break;
                        default:
                            break;
                    }
                }
                case 3:{
                    System.out.println("Under Development");
                    break;
                }
            }
        }
    }

    public static void print(ArrayList<DailyAcheivments> daily){
        if(daily.size() == 0){
            System.out.println("NO achievements");
        }
        for (int i = 0; i <daily.size(); i++) {
            System.out.println(daily.get(i).toString());
        }

    }

    public static String hello(){
        return "Hello World";
    }
}