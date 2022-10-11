
public abstract class CapMeasures {

    /** As of today (18/09/2022) the actual conveyor models which use cap and needs to be implemented are:
     * TR-050 (UL)
     * TR-100 (LI)
     * TR-200 (ME)
     * TR-300 (EM)
     */

    public float capBearing;
    public float capTotal;
    public String conveyorModel;


    public abstract void capMeasures(int caseDiameter);

    public float getCapBearing() {
        return capBearing * 2; // *2 as two caps are used per conveyor
    }

    public float getCapTotal() {
        return capTotal * 2; // *2 as two caps are used per conveyor
    }

    public String getConveyorModel() {
        return conveyorModel;
    }
}