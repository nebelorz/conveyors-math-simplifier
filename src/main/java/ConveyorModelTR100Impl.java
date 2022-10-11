
public class ConveyorModelTR100Impl implements ConveyorModel{
    private float capBearing;
    private float capTotal;


    @Override
    public void capMeasures(int caseDiameter) {
        if (caseDiameter <= 16) {
            this.capBearing = 1f;
            this.capTotal = 8f;
        } else if (caseDiameter <= 40) {
            this.capBearing = 2f;
            this.capTotal = 10f;
        } else if (caseDiameter <= 50) {
            this.capBearing = 3.5f;
            this.capTotal = 7f;
        } else if (caseDiameter <= 60) {
            this.capBearing = 3.5f;
            this.capTotal = 5f;
        }
    }

    @Override
    public float getCapBearing() {
        return capBearing * 2; // *2 as two caps are used per conveyor
    }

    @Override
    public float getCapTotal() {
        return capTotal * 2; // *2 as two caps are used per conveyor
    }
}