import java.util.Scanner;

public class Main {



    private static String result_final;
    private static String action;

    public static String getResult_final() {
        return result_final;
    }

    public static void setResult_final(String result_final) {
        Main.result_final = result_final;
    }
    public static String getAction() {
        return action;
    }



    public static void main(String[] args) {

        String expression = scanner();
        defining_an_action(expression);
        String[] splitExpression = expression.split(action);
        System.out.println(determining_the_type_of_numbers_and_giving_the_result(splitExpression));
    }
    public static String calc(String input){
        String expression = input;
        defining_an_action(expression);
        String[] splitExpression = expression.split(action);
        System.out.println(determining_the_type_of_numbers_and_giving_the_result(splitExpression));
        return result_final;
    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();
        int counter = 0;
        for (char element : expression.toCharArray()){
            if (element == '+') counter++;
            if (element == '-') counter++;
            if (element == '*') counter++;
            if (element == '/') counter++;
            if (element == 'I') counter++;
            if (element == 'V') counter++;
            if (element == 'X') counter++;
            for (int i = 0; i < 10; i++) {
                if(element ==(Integer.toString(i)).charAt(0)) counter++;
            }
        }
        if(counter < expression.toCharArray().length || expression.toCharArray().length <=2)
            try {
                throw new ExceptionСalculator();
            } catch (ExceptionСalculator e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(0);
            }
        return expression;
    }


    public static void defining_an_action(String expression) {
        int a, b, c, d;
        int addition = 0, subtraction = 0, multiplication = 0, division = 0;
        for (char element : expression.toCharArray()){
            if (element == '+') addition++;
            if (element == '-') subtraction++;
            if (element == '*') subtraction++;
            if (element == '/') subtraction++;
        }
        if (addition+subtraction+multiplication+division>1){
            try {
                throw new ExceptionСalculator();
            } catch (ExceptionСalculator e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        if (addition+subtraction+multiplication+division==0){
            try {
                throw new ExceptionСalculator();
            } catch (ExceptionСalculator e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }
        a = expression.indexOf("+");
        if (a > 0) {
            action = ("\\+");
            return;
        }
        b = expression.indexOf("-");
        if (b > 0) {
            action =("-");
            return;
        }
        c = expression.indexOf("*");
        if (c > 0) {
            action = ("\\*");
            return;
        }
        d = expression.indexOf("/");
        if (d > 0) {
            action = ("/");
            return;
        }
    }

    public static String determining_the_type_of_numbers_and_giving_the_result(String[] splitExpression) {
        String a, b;
        a = splitExpression[0];
        b = splitExpression[1];
        int int_a;
        int int_b;
        char[] broken_a = a.toCharArray();
        char[] broken_b = b.toCharArray();
        String first_character_a = String.valueOf(broken_a[0]);
        String first_character_b = String.valueOf(broken_b[0]);
        int counter_a = 0;
        int counter_b = 0;
        if(first_character_a.equals(Numbers.I.getName())){
            counter_a++;
        }
        if(first_character_a.equals(Numbers.V.getName())){
            counter_a++;
        }
        if(first_character_a.equals(Numbers.X.getName())){
            counter_a++;
        }
        if(first_character_a.equals("1")){
            counter_a--;
        }
        if(first_character_a.equals("2")){
            counter_a--;
        }
        if(first_character_a.equals("3")){
            counter_a--;
        }
        if(first_character_a.equals("4")){
            counter_a--;
        }
        if(first_character_a.equals("5")){
            counter_a--;
        }
        if(first_character_a.equals("6")){
            counter_a--;
        }
        if(first_character_a.equals("7")){
            counter_a--;
        }
        if(first_character_a.equals("8")){
            counter_a--;
        }
        if(first_character_a.equals("9")){
            counter_a--;
        }
        if(first_character_a.equals("0")){
            counter_a--;
        }
        if(first_character_b.equals(Numbers.I.getName())){
            counter_b++;
        }
        if(first_character_b.equals(Numbers.V.getName())){
            counter_b++;
        }
        if(first_character_b.equals(Numbers.X.getName())){
            counter_b++;
        }
        if(first_character_b.equals("1")){
            counter_b--;
        }
        if(first_character_b.equals("2")){
            counter_b--;
        }
        if(first_character_b.equals("3")){
            counter_b--;
        }
        if(first_character_b.equals("4")){
            counter_b--;
        }
        if(first_character_b.equals("5")){
            counter_b--;
        }
        if(first_character_b.equals("6")){
            counter_b--;
        }
        if(first_character_b.equals("7")){
            counter_b--;
        }
        if(first_character_b.equals("8")){
            counter_b--;
        }
        if(first_character_b.equals("9")){
            counter_b--;
        }
        if(first_character_b.equals("0")){
            counter_b--;
        }
        if (counter_a+counter_b==0){
            try {
                throw new ExceptionСalculator();
            } catch (ExceptionСalculator e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления ");
                System.exit(0);
            }
        }
        switch (first_character_a) {
            case "I":
                setResult_final(calculation_Roman(a, b));
                break;
            case "V":
                setResult_final(calculation_Roman(a, b));
                break;
            case "X":
                setResult_final(calculation_Roman(a, b));
                break;
            case "L":
                setResult_final(calculation_Roman(a, b));
                break;
            case "C":
                setResult_final(calculation_Roman(a, b));
                break;
            case "1":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "2":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "3":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "4":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "5":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "6":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "7":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "8":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "9":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "0":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
            case "10":
                int_a = Integer.parseInt(a);
                int_b = Integer.parseInt(b);
                setResult_final(String.valueOf(calculation(int_a, int_b)));
                break;
        }
        return getResult_final();
    }

    public static int calculation(int a, int b) {
        if (a>10 || b>10){
            try {
                throw new ExceptionСalculator();
            } catch (ExceptionСalculator e) {
                System.out.println("throws Exception //т.к. числа больше 10");
                System.exit(0);
            }
        }
        String action = Main.getAction();
        int result;
        if (action.equals("\\+")) {
            result = a + b;
            return result;
        } else if (action.equals("-")) {
            result = a - b;
            return result;
        } else if (action.equals("/")) {
            result = a / b;
            return result;
        } else if (action.equals("\\*")) {
            result = a * b;
            return result;
        }
        return -1;
    }


    public static String calculation_Roman(String a, String b) {
        int final_result;
        int result_a = 0;
        int result_b = 0;
        int max_a = 0;
        int max_b = 0;
        int index_big_number_a = 0;
        int index_big_number_b = 0;
        char[] broken_a = a.toCharArray();
        char[] broken_b = b.toCharArray();
        int[] array_a = new int[broken_a.length];
        int[] array_b = new int[broken_b.length];

        for (int i = 0; i < broken_a.length; i++) {
            switch (broken_a[i]) {
                case 'X':
                    array_a[i] = Numbers.X.getNumber();
                    break;
                case 'V':
                    array_a[i] = Numbers.V.getNumber();
                    break;
                case 'I':
                    array_a[i] = Numbers.I.getNumber();
                    break;
            }
        }
        for (int i = 0; i < broken_b.length; i++) {
            switch (broken_b[i]) {
                case 'X':
                    array_b[i] = Numbers.X.getNumber();
                    break;
                case 'V':
                    array_b[i] = Numbers.V.getNumber();
                    break;
                case 'I':
                    array_b[i] = Numbers.I.getNumber();
                    break;
            }
        }
        for (int i = 0; i < array_a.length; i++) {
            if (array_a[i] > max_a) {
                max_a = array_a[i];
                index_big_number_a = i;
            }
        }
        for (int i = 0; i < array_b.length; i++) {
            if (array_b[i] > max_b) {
                max_b = array_b[i];
                index_big_number_b = i;
            }
        }


        if (array_a.length == 1) {
            result_a = max_a;
        } else if (max_a == 1) {
            result_a = array_a.length;
        } else if (index_big_number_a > 0) {
            for (int i = 0; i < array_a.length - 1; i++) {
                result_a = max_a - array_a[i];
            }
        } else if (index_big_number_a == 0) {
            for (int i = 1; i < array_a.length; i++) {
                if (result_a > 0) {
                    result_a = result_a + array_a[i];
                } else
                    result_a = max_a + array_a[i];
            }
        }
        if (array_b.length == 1) {
            result_b = max_b;
        } else if (max_b == 1) {
            result_b = array_b.length;
        } else if (index_big_number_b > 0) {
            for (int i = 0; i < array_b.length - 1; i++) {
                result_b = max_b - array_b[i];
            }
        } else if (index_big_number_b == 0) {
            for (int i = 1; i < array_b.length; i++) {
                if (result_b > 0) {
                    result_b = result_b + array_b[i];
                } else
                    result_b = max_b + array_b[i];
            }
        }

        final_result = calculation(result_a, result_b);
        if(final_result<=0){
            try {
                throw new ExceptionСalculator();
            } catch (ExceptionСalculator e) {
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел и нолей");
                System.exit(0);
            }
        }
        int length = (int) (Math.log10(final_result) + 1);
        String str_final_result = null;
        switch (length) {
            case 3:
                str_final_result = "C";
                break;
            case 1:
                if (final_result == 9) {
                    str_final_result = "IX";
                } else if (final_result > 5) {
                    str_final_result = "V";
                    int j = final_result % 5;
                    for (int i = 0; i < j; i++) {
                        str_final_result = str_final_result + "I";
                    }
                } else if (final_result == 5) {
                    str_final_result = "V";
                } else if (final_result == 4) {
                    str_final_result = "IV";
                } else if (final_result < 4) {
                    str_final_result = "I";
                    for (int i = 0; i < final_result - 1; i++) {
                        str_final_result = str_final_result + "I";
                    }
                }
                break;
            case 2:
                String str_tenth = "X";
                int remains = final_result % 10;
                int tenth = final_result - remains;
                if (tenth == 50) {
                    str_tenth = "L";
                } else if (tenth == 40) {
                    str_tenth = "XL";
                } else if (tenth == 90) {
                    str_tenth = "XC";
                } else if (tenth < 40) {
                    for (int i = 0; i < tenth / 10 - 1; i++) {
                        str_tenth = str_tenth + "X";
                    }
                } else if (tenth > 50) {
                    str_tenth = "L";
                    for (int i = 0; i < (tenth % 50) / 10; i++) {
                        str_tenth = str_tenth + "X";
                    }
                }
                if (remains == 9) {
                    str_final_result = "IX";
                } else if (remains > 5) {
                    str_final_result = "V";
                    int j = remains % 5;
                    for (int i = 0; i < j; i++) {
                        str_final_result = str_final_result + "I";
                    }
                } else if (remains == 5) {
                    str_final_result = "V";
                } else if (remains == 4) {
                    str_final_result = "IV";
                } else if (remains < 4 && remains != 0) {
                    str_final_result = "I";
                    for (int i = 0; i < remains - 1; i++) {
                        str_final_result = str_final_result + "I";
                    }
                }
                if (str_final_result == null) {
                    str_final_result = str_tenth;
                } else {
                    str_final_result = str_tenth + str_final_result;
                }
                break;

        }
        return str_final_result;
    }
}

