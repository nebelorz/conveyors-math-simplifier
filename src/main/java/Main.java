
public class Main {

    public static void main(String[] args) {

        var conveyor = new Conveyor(300, 50, "PVC", 8, "FE", "RETRACTIL");
        var conveyorModel = new TR100();

        conveyor.calculateConveyor(conveyorModel);

        System.out.println(conveyor.printConveyorData());
    }
}