package application;

import java.util.ArrayList;
import java.util.List;

public class CalculatorSystem {
    private String number = "";
    private List<Integer> numberList = new ArrayList<Integer>();
    private List<String> operatorList = new ArrayList<String>();
    
    //入力された値を連結する
    public void addNumber(String number) {
        if(!this.number.isEmpty()) {
            this.number = this.number.concat(number);
        }else {
            this.number = number;
        }
    }
    
    //入力された値を数値にしてListに追加
    private boolean addNumberList() {
        if(number.isEmpty()) {
            return false;
        }
        numberList.add(Integer.parseInt(number));
        number = "";
        return true;
    }
    
    public void addOperator(String text) {
        addNumberList();
        operatorList.add(text);
    }
    
    public String calculator() {
        addNumberList();
        if(operatorList.isEmpty()) {
            if(numberList.isEmpty()) {
                return "";
            }else {
                return number;
            }
        }
        
        int answer = numberList.get(0);
        for(int i = 0; i < operatorList.size(); i++) {
            switch(operatorList.get(i)) {
                case "+":
                    answer = answer + numberList.get(i + 1);
                    break;
                case "-":
                    answer = answer - numberList.get(i + 1);
                    break;
                case "*":
                    answer = answer * numberList.get(i + 1);
                    break;
                case "/":
                    answer = answer / numberList.get(i + 1);
                    break;
            }
        }
        numberList.removeAll(numberList);
        operatorList.removeAll(operatorList);
        return String.valueOf(answer);
    }
}
