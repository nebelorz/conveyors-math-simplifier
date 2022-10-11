
public class Main {

    public static void main(String[] args) {
        var conveyor = new Conveyor();
        conveyor.askConveyorInputs();

        ConveyorModel conveyorModel = conveyor.getConveyorModelObject();
        conveyor.calculateConveyor(conveyorModel);

        conveyor.printConveyorData();
    }

}