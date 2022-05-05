package valleysmountains;

public class Valleys {

    private static final String DOWNHILL = "D";
    private static final String UPHILL = "U";

    public static int countingValleys(int steps, String path) {
        // Write your code here
        if (path == null || path.isBlank() || steps == 0) {
            return 0;
        }

        int valleysCount = 0;
        int seaLevel = 0;

        for (int i = 0; i < steps; i++) {
            var step = path.substring(i, i+1);
            if (step.equals(DOWNHILL)) {
                seaLevel--;
            } if (step.equals(UPHILL)) {
                seaLevel++;
                if (seaLevel == 0) {
                    valleysCount ++;
                }
            }

        }

        return valleysCount;
    }
}
