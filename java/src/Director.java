public class Director {
    private BuilderPack builder;

    public void setBuilderPack(BuilderPack builder) {
        this.builder = builder;
    }

    public Pack getBuilderPack() {
        return builder.getPack();
    }

    public void collectPack() {
        builder.reset();
        builder.buildTrump();
        builder.buildCards();
    }
}
