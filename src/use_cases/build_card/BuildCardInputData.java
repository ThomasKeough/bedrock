package use_cases.build_card;

public class BuildCardInputData {
    final private boolean buildByName;
    final private String name;
    final private boolean buildByType;
    final private String type;
    final private boolean isMega;
    final private boolean hasHighHP;

    public BuildCardInputData(String name, boolean isMega)
    {
        this.name = name;
        this.buildByName = buildByName;
        this.type = type;
        this.buildByType = buildByType;
        this.hasHighHP = hasHighHP;
        this.isMega = isMega;
    }

    String getName() { return name;
    }

    String getType()
    {
        return type;
    }
}
