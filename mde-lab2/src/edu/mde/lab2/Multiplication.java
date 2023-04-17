package edu.mde.lab2;
import java.text.NumberFormat;
public class Multiplication implements Function{
    private final Function f1;
    private final Function f2;
    public Multiplication(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }
    @Override
    public double calculate(double x) {
        return f1.calculate(x)*f2.calculate(x);
    }
    @Override
    public Function derivative() {
        return Sum.of(new Multiplication(f1.derivative(), f2), new Multiplication(f1, f2.derivative()));
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return f1.toPrettyString(nf) + " * " + f2.toPrettyString(nf);
    }
    public static Multiplication of(Function f1, Function f2) {
        return new Multiplication(f1, f2);
    }
}
