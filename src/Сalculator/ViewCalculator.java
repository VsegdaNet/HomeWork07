package Сalculator;


import Сalculator.complexNumActivation.ComplexNumber;
import Сalculator.internalToDo.MethodOfCalculable;
import Сalculator.preView.InterfaceNewCalculate;


import java.util.Scanner;

public class ViewCalculator {

    private Scanner scanner = new Scanner(System.in);
    private final InterfaceNewCalculate newCalculator;

    public ViewCalculator(InterfaceNewCalculate newCalculator) {
        this.newCalculator = newCalculator;
    }

    public void run() {

        MethodOfCalculable calculator = newCalculator.create(promptComplexNum());

        while (true) {
            System.out.print("Введите доступные операции (+, -, *, /, =):\n");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "+":
                    calculator.sum(promptComplexNum());
                    break;
                case "-":
                    calculator.subtraction(promptComplexNum());
                    break;
                case "*":
                    calculator.multiplication(promptComplexNum());
                    break;
                case "/":
                    calculator.division(promptComplexNum());
                    break;
                case "=":
                    System.out.println("Result: " + calculator.getResult());
                    String cmd = prompt("Вы хотите продолжить (Y/N)?");
                    if (cmd.equals("Y")) {
                        calculator = newCalculator.create(promptComplexNum());
                        // continue;
                    }

                    break;
            }
        }
    }


    private ComplexNumber promptComplexNum() {
        System.out.println("введите аргумент: ");

        String input = scanner.nextLine();
        String[] inputStr = input.split("\\+");
        String a = inputStr[0];
        String b = inputStr[1].split("i")[0];
        ComplexNumber complexNumber = new ComplexNumber(Integer.parseInt(a), Integer.parseInt(b));


        while (!input.matches("^\\d+\\+\\d+i$") && !input.matches("^\\d+\\-\\d+i$")) {
            System.out.print(input + " ошибка ввода");
            System.out.println("\n Попробуйте еще раз");
            input = scanner.nextLine();
        }
        if (input.equals("^\\d+\\-\\d+i$")){
            inputStr = input.split("\\-");
            a = inputStr[0];
            b = inputStr[1].split("i")[0];
            complexNumber =  new ComplexNumber(Integer.parseInt(a), Integer.parseInt(b));
        }
        return complexNumber;
    }


    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
