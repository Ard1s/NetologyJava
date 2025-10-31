import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цену товара (в руб.):");
        int price = scanner.nextInt();
        System.out.print("Введите вес товара (в кг.):");
        int weight = scanner.nextInt();
        double customs = calculateCustoms(weight, price);
        System.out.print("Размер пошлины (в руб.) составит:" + customs);

    }

    public static double calculateCustoms(int weight, int price) {
        double result = 0;
        result = (price * 0.01) + (weight * 100);
        return result;
    }

}