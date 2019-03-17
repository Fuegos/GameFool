abstract class BuilderPack {
    protected Pack result;

    public void reset() {
        result = Pack.getInstanse();
    }

    public Pack getPack() {
        return this.result;
    }

    public abstract void buildCards();

    public abstract void buildTrump();
}
