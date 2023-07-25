package codingdojo.builders;

import codingdojo.*;

import java.util.List;

public class SimpleEnemyBuilder {

    private Armor armor = new SimpleArmor(5);
    private List<Buff> buffs = List.of(new BasicBuff(1.0f, 1.0f));

    public static SimpleEnemyBuilder anEnemy() {
        return new SimpleEnemyBuilder();
    }

    public SimpleEnemy build() {
        return new SimpleEnemy(armor, buffs);

    }

    public SimpleEnemyBuilder withArmor(Armor armor) {
        this.armor = armor;
        return this;
    }

    public SimpleEnemyBuilder withBuffs(List<Buff> buffs) {
        this.buffs = buffs;
        return this;
    }
}
