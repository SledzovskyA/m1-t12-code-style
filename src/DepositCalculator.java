import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculateProfit();
    }

    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);
        return doRoundNumber(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return doRoundNumber(amount + amount * 0.06 * depositPeriod);
    }

    double doRoundNumber(double value) {
        double scaLe = Math.pow(10, 2);
        return Math.round(value * scaLe) / scaLe;
    }

    void calculateProfit() {
        double out = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        if (action == 1) {
            out = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
}
