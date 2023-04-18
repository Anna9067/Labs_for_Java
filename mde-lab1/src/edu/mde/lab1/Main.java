package edu.mde.lab1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static double func1(double a, double b, double x){
        double f1 = Math.pow(x, 2)*Math.pow(Math.abs(a*Math.pow(Math.tan(x),2)-1),1.0/3)-Math.log(x+b);
        return f1;
    }
    public static double func2(double a, double b, double x){
        double f2=x*Math.exp(Math.pow(a*x,1.0/2))+b/Math.abs(Math.sin(Math.pow(a*x+b,3)));
        return f2;
    }
    //Вхідні дані за замовчуванням
    private double a = -7;
    private double b = 5;
    private double x = -0.1;
    public void scanValues() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть a: ");
        this.a = scanner.nextDouble();
        System.out.print("Введіть b: ");
        this.b = scanner.nextDouble();
        System.out.print("Введіть x: ");
        this.x = scanner.nextDouble();
    }
    public void printValues() {
        System.out.printf("%n a = %f", a); //System.out.printf(format, arguments);
        System.out.printf("%n b = %f", b);
        System.out.printf("%n x = %f", x);
    }
    public void printResultsOfFunc() {
        if(Double.isNaN(func1(a, b, x))) {
            System.out.println("f1(x) = невизначеність");
        } else {
            System.out.format("f1(x) = %f", func1(a, b, x)).println();
        }
        if(Double.isNaN(func2(a, b, x))) {
            System.out.println("f2(x) = невизначеність");
        } else {
        System.out.format("f2(x) = %f", func2(a, b, x)).println();
        }
    }

    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd.MM.yyyy', 'HH:mm:ss:SSS ");
    public static void printDate() {
        final Date now = new Date();
        System.out.format("Поточна дата і час з точністю до мілісекунд: %s", dateFormat.format(now)).println();
    }

    public void printMenu() {
        System.out.println("\nМеню: ");
        System.out.println("1. Введення значень вхідних даних");
        System.out.println("2. Виведення значень вхідних даних");
        System.out.println("3. Виведення обчислених значень заданих функцій");
        System.out.println("4. Виведення поточної дати і часу у заданому форматі");
        System.out.println("5. Вихід із меню");
    }
    public void selectMenuItem() {
        final Scanner scanner = new Scanner(System.in); //final робить подальшу зміну об'єкта неможливим
        while (true) {
            printMenu();
            System.out.print("Введіть обраний пункт меню: ");
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    scanValues();
                    break;
                case 2:
                    printValues();
                    break;
                case 3:
                    printResultsOfFunc();
                    break;
                case 4:
                    printDate();
                    break;
                case 5: return;
                default:
                    System.out.println("Такого пункту у меню немає!");
            }
        }
    }
    public static void main(String[] args) {
        final Main main = new Main();
        main.selectMenuItem();
        System.out.println("Роботу програми завершено");
    }
}