package Сalculator.preView;

import Сalculator.complexNumActivation.ComplexNumber;
import Сalculator.internalToDo.Calculator;
import Сalculator.internalToDo.MethodOfCalculable;


public class NewCalculate implements  InterfaceNewCalculate{

    public MethodOfCalculable create(ComplexNumber arg) {
        return new Calculator(arg);
    }
}
