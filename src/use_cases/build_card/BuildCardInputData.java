package use_cases.build_card;

public class BuildCardInputData {
    final private String name;
    final private String type;
    final private boolean isMega;

    public BuildCardInputData(String name, boolean isMega)
    {
        this.name = name;
        this.isMega = isMega;
    }
    public BuildCardInputData(String name, String type, boolean isMega)
    {
        this.name = name;
        this.type = type;
        this.isMega = isMega;
    }

    public BuildCardInputData(String type, boolean isMega)
    {
        this.type = type;
        this.isMega = isMega;
    }

    String getName()
    {
        return name;
    }

    String getType()
    {
        return type;
    }

    boolean isMega()
    {
        return isMega;
    }
}
