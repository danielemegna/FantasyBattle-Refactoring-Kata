package codingdojo;

public interface TestCase {
    Player player();
    Target enemy();
    int expectedDamage();
}
