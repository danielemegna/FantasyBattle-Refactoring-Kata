package codingdojo;

public class PlayerBuilder {

    private Stats stats = new Stats(0);
    private BasicItem leftHandItem = ROUND_SHIELD;
    private BasicItem rightHandItem = EXCALIBUR_SWORD;
    private BasicItem headItem = HELMET_OF_SWIFTNESS;
    private BasicItem feetItem = TEN_LEAGUE_BOOTS;
    private BasicItem chestItem = BREASTPLATE_OF_STEEL;

    public static Player excaliburDefaultPlayer() {
        return aPlayer().build();
    }

    public static PlayerBuilder aPlayer() {
        return new PlayerBuilder();
    }

    public Player build() {
        Equipment equipment = new Equipment(
            this.leftHandItem,
            this.rightHandItem,
            this.headItem,
            this.feetItem,
            this.chestItem
        );
        return new Player(new Inventory(equipment), stats);
    }

    public PlayerBuilder withStatsStrength(int strength) {
        this.stats = new Stats(strength);
        return this;
    }

    public PlayerBuilder withLeftHand(BasicItem item) {
        this.leftHandItem = item;
        return this;
    }

    public PlayerBuilder withRightHand(BasicItem item) {
        this.rightHandItem = item;
        return this;
    }

    public PlayerBuilder withHead(BasicItem item) {
        this.headItem = item;
        return this;
    }

    public PlayerBuilder withFeet(BasicItem item) {
        this.feetItem = item;
        return this;
    }

    public PlayerBuilder withChest(BasicItem item) {
        this.chestItem = item;
        return this;
    }

    public static final BasicItem EXCALIBUR_SWORD = new BasicItem("Excalibur", 20, 1.5f);
    public static final BasicItem ROUND_SHIELD = new BasicItem("Round Shield", 0, 1.4f);
    public static final BasicItem HELMET_OF_SWIFTNESS = new BasicItem("Helmet of swiftness", 0, 1.2f);
    public static final BasicItem TEN_LEAGUE_BOOTS = new BasicItem("Ten league boots", 0, 0.1f);
    public static final BasicItem BREASTPLATE_OF_STEEL = new BasicItem("Breastplate of steel", 0, 1.4f);

}
