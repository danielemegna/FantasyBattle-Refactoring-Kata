package codingdojo;

public class PlayerBuilder {

    private Equipment equipment = anEquipment();
    private Stats stats = new Stats(0);

    public static PlayerBuilder aPlayer() {
        return new PlayerBuilder();
    }

    public Player build() {
        return new Player(new Inventory(equipment), stats);
    }

    public PlayerBuilder withStatsStrength(int strength) {
        this.stats = new Stats(strength);
        return this;
    }

    private static Equipment anEquipment() {
        return new Equipment(
            new BasicItem("Round Shield", 0, 1.4f),
            new BasicItem("Excalibur", 20, 1.5f),
            new BasicItem("Helmet of swiftness", 0, 1.2f),
            new BasicItem("Ten league boots", 0, 0.1f),
            new BasicItem("Breastplate of steel", 0, 1.4f)

        );
    }
}
