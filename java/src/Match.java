import java.util.ArrayList;

public class Match {
    private Pack pack;
    private ArrayList<String> cache = new ArrayList<String>();
    private Player winPlayer;
    private String logs;

    public void createPack(String type) {
        if (type.compareTo("36") == 0) {
            Pack.deletePack();
            Director director = new Director();
            BuilderPack builderPack36 = new BuilderPack36();

            director.setBuilderPack(builderPack36);
            director.collectPack();

            this.pack = director.getBuilderPack();
        }
        else if (type.compareTo("54") == 0) {
            Pack.deletePack();
            Director director = new Director();
            BuilderPack builderPack56 = new BuilderPack56();

            director.setBuilderPack(builderPack56);
            director.collectPack();

            this.pack = director.getBuilderPack();
        }
    }

    public Pack getPack() {
        return this.pack;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public String getLogs() {
        return this.logs;
    }

    public void clearPack() {
        this.pack.allExtractCard();
    }

    public void setCache(String suite) {
        this.cache.add(suite);
    }

    public ArrayList<String> getCache() {
        return this.cache;
    }
}
