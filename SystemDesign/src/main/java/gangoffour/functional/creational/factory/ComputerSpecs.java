package gangoffour.functional.creational.factory;

import java.util.Optional;
import java.util.stream.IntStream;

public class ComputerSpecs {

    private int cores;
    private int disks;
    private long memory;

    ComputerSpecs(ComputerSpecsBuilder builder) {
        this.cores = builder.cores;
        this.disks = builder.disks;
        this.memory = builder.memory;
    }

    public ComputerSpecs() {

    }

    public int getCores() {
        return cores;
    }

    public int getDisks() {
        return disks;
    }

    public long getMemory() {
        return memory;
    }

    @Override
    public int hashCode() {
        return IntStream.of(cores, disks, (int)(memory ^ (memory >>> 32)))
                .reduce(1, (hashcode, field) -> 37 * hashcode + field);
    }

    @Override
    public boolean equals(Object other) {
        return Optional.ofNullable(other)
                .filter(o -> this.getClass() == o.getClass())
                .map(Object::hashCode)
                .map(Integer.valueOf(hashCode())::equals)
                .orElse(Boolean.FALSE);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("ComputerSpecs [cores=")
                .append(cores)
                .append(", disks=")
                .append(disks)
                .append(", memory=")
                .append(memory)
                .append("]");
        return builder.toString();
    }

    public static class ComputerSpecsBuilder {

        private int cores = 1;

        private int disks = 1;

        private long memory = 2;

        public ComputerSpecsBuilder withCores(int cores) {
            this.cores = cores;
            return this;
        }

        public ComputerSpecsBuilder withDisks(int disks) {
            this.disks = disks;
            return this;
        }

        public ComputerSpecsBuilder withMemory(long memory) {
            this.memory = memory;
            return this;
        }

        public ComputerSpecs build() {
            return new ComputerSpecs(this);
        }

        public ComputerSpecsBuilder initFromSpec(ComputerSpecs specs) {
            this.cores = specs.getCores();
            this.disks = specs.getDisks();
            this.memory = specs.getMemory();
            return this;
        }

        public static ComputerSpecs buildStandardSpec() {
            return new ComputerSpecsBuilder()
                    .withCores(4)
                    .withDisks(2)
                    .withMemory(8)
                    .build();
        }

        public static ComputerSpecs buildExtendedSpec() {
            return new ComputerSpecsBuilder()
                    .withCores(8)
                    .withDisks(4)
                    .withMemory(16)
                    .build();
        }

    }


}
