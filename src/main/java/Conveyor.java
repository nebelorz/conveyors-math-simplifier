import java.util.Scanner;

public class Conveyor {

    private float EL;
    private float RL;
    private float AL;

    private float caseCut;
    private int caseDiameter;
    private String caseMaterial;

    private int axisDiameter;
    private String axisMaterial;
    private String axisFinish;

    private String conveyorModel;

    public Conveyor() {
    }

    public Conveyor(float EL, int caseDiameter, String caseMaterial, int axisDiameter, String axisMaterial, String axisFinish) {
        this.EL = EL;
        this.caseDiameter = caseDiameter;
        this.caseMaterial = caseMaterial;
        this.axisDiameter = axisDiameter;
        this.axisMaterial = axisMaterial;
        this.axisFinish = axisFinish;
    }

    private void calculateEL(float RL, int caseDiameter) {
        if (caseDiameter == 16) {
            this.EL = RL + 2;
        } else if (caseDiameter == 20 || caseDiameter == 30 || caseDiameter == 40 ) {
            this.EL = RL + 4;
        } else if (caseDiameter == 50 || caseDiameter == 60 || caseDiameter == 63) {
            this.EL = RL + 7;
        }
    }

    private void calculateRL(float EL, float capBearing) {
        this.RL = EL - capBearing;
    }

    private void calculateAL(float RL, int caseDiameter) {
        if (caseDiameter <= 20 && axisDiameter == 6) {
            this.AL = RL + 28f;
        } else if (caseDiameter > 20 && axisDiameter == 8 ||
                caseDiameter > 20 && axisDiameter == 10) {
            this.AL = RL + 34f;
        }
    }

    private void calculateCaseCut(float EL, float totalCap) {
        this.caseCut = (EL - totalCap);
    }

    public void calculateConveyor(ConveyorModel model) {
        // Calculates all conveyor measurements.
        model.capMeasures(this.caseDiameter);

        calculateRL(this.EL, model.getCapBearing());
        calculateAL(this.RL, this.caseDiameter);
        calculateCaseCut(this.EL, model.getCapTotal());
    }

    public ConveyorModel getConveyorModelObject() {
        // When more models get implemented, will be compared here.
        /*
        if (this.conveyorModel.equals("TR100")) {
            return new ConveyorModelTR100Impl();
        }
         */
        return new ConveyorModelTR100Impl();
    }

    public void askConveyorInputs() {
        var scanner = new Scanner(System.in);

        System.out.print("Model: ");
        this.conveyorModel = scanner.nextLine().toUpperCase();

        System.out.print("EL (milimetres): ");
        this.EL = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("[TUB] Diametre: ");
        this.caseDiameter = scanner.nextInt();
        scanner.nextLine();

        System.out.print("[TUB] Material: ");
        this.caseMaterial = scanner.nextLine().toUpperCase();

        System.out.print("[EIX] Diametre: ");
        this.axisDiameter = scanner.nextInt();
        scanner.nextLine();

        System.out.print("[EIX] Material: ");
        this.axisMaterial = scanner.nextLine().toUpperCase();

        System.out.print("[EIX] Acabat: ");
        this.axisFinish = scanner.nextLine().toUpperCase();
    }

    public void printConveyorData() {
        var stringBuilder = new StringBuilder();

        stringBuilder.append("\n|| DADES DEL RODET (").append(this.conveyorModel).append(") ||")
                .append(System.lineSeparator())
                .append("EL = ").append(this.EL).append(" mm.")
                .append(System.lineSeparator())
                .append("RL = ").append(this.RL).append(" mm.")
                .append(System.lineSeparator())
                .append("AL = ").append(this.AL).append(" mm.")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("TUB Material = ").append(this.caseMaterial)
                .append(System.lineSeparator())
                .append("TUB Diametre = ").append("⌀").append(this.caseDiameter)
                .append(System.lineSeparator())
                .append("TUB Tall = ").append(this.caseCut).append(" mm.")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("EIX Material = ").append(this.axisMaterial)
                .append(System.lineSeparator())
                .append("EIX Diametre = ").append("⌀").append(this.axisDiameter)
                .append(System.lineSeparator())
                .append("ACABAT = ").append(this.axisFinish)
                .append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    @Override
    public String toString() {
        return "Conveyor {" +
                "EL = " + EL +
                ", RL = " + RL +
                ", AL = " + AL +
                ", caseDiameter = " + caseDiameter +
                ", caseMaterial = '" + caseMaterial + '\'' +
                ", axisDiameter = " + axisDiameter +
                ", axisMaterial = '" + axisMaterial + '\'' +
                ", axisFinish = '" + axisFinish + '\'' +
                '}';
    }
}