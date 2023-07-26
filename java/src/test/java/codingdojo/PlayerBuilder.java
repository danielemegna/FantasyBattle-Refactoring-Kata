package codingdojo;

public class PlayerBuilder {

    private Stats stats = new Stats(0);
    private BasicItem rightHandItem = new BasicItem("Excalibur", 20, 1.5f);

    public static Player excaliburDefaultPlayer() {
        return aPlayer().build();
    }

    public static PlayerBuilder aPlayer() {
        return new PlayerBuilder();
    }

    public Player build() {
        Equipment equipment = new Equipment(
            new BasicItem("Round Shield", 0, 1.4f),
            this.rightHandItem,
            new BasicItem("Helmet of swiftness", 0, 1.2f),
            new BasicItem("Ten league boots", 0, 0.1f),
            new BasicItem("Breastplate of steel", 0, 1.4f)
        );
        return new Player(new Inventory(equipment), stats);
    }

    public PlayerBuilder withStatsStrength(int strength) {
        this.stats = new Stats(strength);
        return this;
    }

    public PlayerBuilder withRightHand(BasicItem rightHandItem) {
        this.rightHandItem = rightHandItem;
        return this;
    }
}
