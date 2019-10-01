package id.ac.polinema.idealbodyweight.util;

import id.ac.polinema.idealbodyweight.R;

public class BodyMassIndex {

    private int height;
    private int mass;
    private float bmi;
    private String index;

    public BodyMassIndex(int height, int mass) {
        this.height = height;
        this.mass = mass;
        this.index = displayBmi();
    }

    public String getIndex() {
        return String.format(index);
    }

    public float calculateBmi() {
        bmi = mass / height^2;
        return bmi;
    }

    private String displayBmi() {
            String information = "";
        if (Float.compare(bmi, 18.5f) <=0 ) {
            information = "Kurang ideal";
        }
        if (Float.compare(bmi, 18.5f) <=0 && Float.compare(bmi, 24.99f) <=0) {
            information = "Normal";
        }
        return information;
    }
}
