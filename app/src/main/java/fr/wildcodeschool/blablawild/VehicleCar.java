package fr.wildcodeschool.blablawild;

import android.renderscript.Sampler;

/**
 * Created by wilder on 12/03/18.
 */

public class VehicleCar extends VehicleAbstract {

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    private int kilometer;

    public VehicleCar(String brand, String model, int kilometer) {
        super(brand, model);
        this.kilometer = kilometer;
    }

    @Override
    public String getDescription() {
        return getBrand()+", "+getModel()+", "+ getKilometer();
    }
}
