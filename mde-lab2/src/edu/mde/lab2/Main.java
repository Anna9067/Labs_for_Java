package edu.mde.lab2;
import java.util.Scanner;
import java.text.NumberFormat;
public class Main {
    public static void main(String[] args) {

        double a = -7;
        double b = 5;
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть x: ");
        final double x = scanner.nextDouble();

        final Function expression1 = Sum.of(
                Multiplication.of(
                        Cbrt.of(
                                Abs.of(
                                        Sum.of(
                                                Multiplication.of(
                                                        Const.of(a),
                                                        Power.of(
                                                                Tan.of(Linear.X),
                                                                2
                                                        )
                                                ),
                                                Const.NEGATIVE_ONE
                                        )
                                )
                        ),
                        Power.of(
                                Linear.X,
                                2
                        )
                ),
                Multiplication.of(
                        Const.NEGATIVE_ONE,
                        Nlog.of(
                                Sum.of(
                                        Linear.X,
                                        Const.of(b)
                                )
                        )
                )
        );

        final NumberFormat nf_1 = NumberFormat.getInstance();
        System.out.format("f1(x) = %s", expression1.toPrettyString(nf_1)).println();
        System.out.format("f1'(x) = %s", expression1.derivative().toPrettyString(nf_1)).println();
        System.out.format("f("+ x + ") = %f", expression1.calculate(x)).println();
        System.out.format("f'("+ x + ") = %f", expression1.derivative().calculate(x)).println();

        final Function expression2 = Sum.of(
                Multiplication.of(
                        Linear.X,
                        Exponent.of(
                                Sqrt.of(
                                       Multiplication.of(
                                               Const.of(a),
                                               Linear.X
                                       )
                                )
                        )
                ),
                Multiplication.of(
                        Const.of(b),
                        Power.of(
                                Abs.of(
                                        Sin.of(
                                                Power.of(
                                                        Sum.of(
                                                                Multiplication.of(
                                                                        Const.of(a), Linear.X
                                                                ),
                                                                Const.of(b)
                                                        ),
                                                        3
                                                )
                                        )
                                ),
                                -1
                        )
                )

        );

        final NumberFormat nf_2 = NumberFormat.getInstance();
        System.out.format("f2(x) = %s", expression2.toPrettyString(nf_2)).println();
        System.out.format("f2'(x) = %s", expression2.derivative().toPrettyString(nf_2)).println();
        System.out.format("f("+ x + ") = %f", expression2.calculate(x)).println();
        System.out.format("f'("+ x + ") = %f", expression2.derivative().calculate(x)).println();
    }
}