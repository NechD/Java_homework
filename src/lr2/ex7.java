//7. Создание классов и интерфейсов для работы с банковскими счетами:
//        	Создайте класс, который представляет банковский счет, и добавьте методы для депозита и снятия денег, а также для получения текущего баланса.
//        	Создайте интерфейс, который определяет методы, которые должны быть реализованы для каждого класса, чтобы создать новый банковский счет, совершить транзакции и получить текущий баланс.
//        	Реализуйте методы интерфейса в классе банковского счета и создайте объекты для работы с ними в своем приложении.


package lr2;


class Bank_account implements BankInterface {
    private double current_money;
    private int account_number;

    //конструктор для класса Bank_account
    public Bank_account(double current_money, int account_number) {
        this.current_money = current_money;
        this.account_number = account_number;
    }

    public void setCurrent_money(double current_money) {
        if (current_money >= 0) {
            this.current_money = current_money;
        } else {
            System.out.println("Количество денег на счете нельзя установить меньше 0");
        }
    }

    public double getCurrent_money() {
        System.out.println("Ваш баланс " + current_money + " рублей");
        return current_money;
    }

    public void MoneyToBank(double money) {
        if (money >= 0) {
            this.current_money = this.current_money + money;
            System.out.println("Вы положили на счет " + money + " рублей, на счете сейчас: "+ this.current_money);
        } else {
            System.out.println("Нельзя положить отрицательное число денег");
        }
    }

    public void MoneyFromBank(double money) {
        if (this.current_money - money >= 0) {
            this.current_money = this.current_money - money;
            System.out.println("Вы сняли " + money + "рублей, на счете осталось: "+ this.current_money);
        } else {
            System.out.println("Нельзя снять денег, больше чем есть");
        }
    }
}


interface BankInterface {
    public void MoneyFromBank(double money);
    public void MoneyToBank(double money);
    public double getCurrent_money();
}

    public class ex7 {
        public static void main(String[] args) {
            Bank_account num_1 = new Bank_account(1200, 2453);
            num_1.MoneyFromBank(300);
            num_1.MoneyToBank(200);
            num_1.getCurrent_money();
        }
    }