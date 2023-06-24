package Сalculator.internalToDo;

import Сalculator.complexNumActivation.ComplexNumber;

public interface MethodOfCalculable {
    void sum(ComplexNumber arg);

    void subtraction(ComplexNumber arg);

    void multiplication(ComplexNumber arg);

    void division(ComplexNumber arg);

    ComplexNumber getResult();

}