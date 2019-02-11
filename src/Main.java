import java.util.function.Function;

public class Main {

    static class GradientDescent {
        double getGradientDescent(Function<Double, Double> dF, double startPoint, double learningRate) {
            double epsilon = 0.00001;
            double lastStepSize = 10;

            while (lastStepSize > epsilon) {
                double lastPoint = startPoint;
                startPoint -= learningRate * dF.apply(lastPoint);
                lastStepSize = Math.abs(lastPoint - startPoint);
            }

            return startPoint;
        }
    }

    public static void main(String[] args) {
        Main.GradientDescent gd = new GradientDescent();
        // let F(x) = x^2 - x
        // then:
        Function<Double, Double> dF = x -> (2 * x - 1);
        System.out.println("Result: " + gd.getGradientDescent(dF, 0.0, 0.001));
    }
}
