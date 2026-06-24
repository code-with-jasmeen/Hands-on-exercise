package BuilderPatternExample;

public class Computer
{
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String motherboard;

    // Private constructor
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.motherboard = builder.motherboard;
    }

    // Getters (optional)
    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    // Display method
    public void showConfig() {
        System.out.println("===== Computer Configuration =====");
        System.out.println("CPU        : " + cpu);
        System.out.println("RAM        : " + ram);
        System.out.println("Storage    : " + storage);
        System.out.println("GPU        : " + gpu);
        System.out.println("Motherboard: " + motherboard);
    }

    // Static Builder Class
    public static class Builder {

        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private String motherboard;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGpu(String gpu)
        {
            this.gpu = gpu;
            return this;
        }

        public Builder setMotherboard(String motherboard)
        {
            this.motherboard = motherboard;
            return this;
        }

        public Computer build()
        {
            return new Computer(this);
        }
    }
}

