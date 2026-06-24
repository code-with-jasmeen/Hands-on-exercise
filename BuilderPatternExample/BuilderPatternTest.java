package BuilderPatternExample;

public class BuilderPatternTest
{
    public static void main(String[] args) {

        // Gaming Computer
        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setGpu("NVIDIA RTX 4080")
                .setMotherboard("ASUS ROG Strix")
                .build();

        gamingPC.showConfig();

        System.out.println("\n----------------------------\n");

        // Office Computer
        Computer officePC = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("8GB")
                .setStorage("512GB SSD")
                .build();

        officePC.showConfig();
    }
}
