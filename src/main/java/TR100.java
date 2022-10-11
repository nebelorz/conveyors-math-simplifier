
public class TR100 extends CapMeasures {

    public TR100() {
        this.conveyorModel = "TR-100";
    }

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
}