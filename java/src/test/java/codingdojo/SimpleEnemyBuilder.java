package codingdojo;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

public class SimpleEnemyBuilder {

    private Armor armor = new SimpleArmor(5);
    private List<Buff> buffs = List.of(new BasicBuff(1.0f, 1.0f));

    public static SimpleEnemyBuilder anEnemy() {
        return new SimpleEnemyBuilder();
    }

    public SimpleEnemy build() {
        return new SimpleEnemy(armor, buffs);

    }

    public SimpleEnemyBuilder withArmorSoak(int soak) {
        return this.withArmor(new SimpleArmor(soak));
    }

    public SimpleEnemyBuilder withBuffs(Buff... buffs) {
        return withBuffs(Arrays.asList(buffs));
    }

    public SimpleEnemyBuilder withoutBuffs() {
        return this.withBuffs(emptyList());
    }

    private SimpleEnemyBuilder withArmor(Armor armor) {
        this.armor = armor;
        return this;
    }

    private SimpleEnemyBuilder withBuffs(List<Buff> buffs) {
        this.buffs = buffs;
        return this;
    }
}
