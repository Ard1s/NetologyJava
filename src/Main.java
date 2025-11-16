import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println();
            System.out.println("Выберите операцию и выберите ее номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Для выхода введите end");

            String input = scanner.nextLine().trim();


            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int income = Integer.parseInt(scanner.nextLine().trim());
                    earnings += income;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    int expense = Integer.parseInt(scanner.nextLine().trim());
                    spendings += expense;
                    break;
                case 3:
                    chooseTaxSystem(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return Math.max(tax, 0);
    }

    public static void chooseTaxSystem(int earnings, int spendings) {
        int taxEarnings = taxEarnings(earnings);
        int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);

        System.out.println("Доходы: " + earnings + " руб.");
        System.out.println("Расходы: " + spendings + " руб.");

        if (taxEarnings == taxEarningsMinusSpendings) {
            System.out.println("Налоги на обеих системах одинаковые: " + taxEarnings + " руб.");
            System.out.println("Можете выбрать любую систему налогообложения.");
            return;
        }

        if (taxEarnings < taxEarningsMinusSpendings) {
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + taxEarnings + " рублей");
            System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings + " рублей");
            System.out.println("Экономия: " + (taxEarningsMinusSpendings - taxEarnings) + " рублей");
        } else {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings + " рублей");
            System.out.println("Налог на другой системе: " + taxEarnings + " рублей");
            System.out.println("Экономия: " + (taxEarnings - taxEarningsMinusSpendings) + " рублей");
        }
    }
}
