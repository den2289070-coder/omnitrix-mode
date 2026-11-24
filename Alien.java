package com.omnitrix.mod;

public enum Alien {
    //          размер  +HP   +урон  скорость(x)  броня  отдача  перезарядка способности
    HEATBLAST   (1.00f,   0,   2,    0.00,        0,     0.0,    40),
    WILDMUTT    (0.90f,   4,   3,    0.25,        0,     0.0,    60),
    DIAMONDHEAD (1.10f,   8,   3,   -0.10,       10,     0.5,    30),
    XLR8        (1.00f,  -4,   0,    0.80,        0,     0.0,   200),
    GREY_MATTER (0.35f, -10,   0,    0.10,        0,     0.0,   300),
    FOUR_ARMS   (1.30f,  20,   8,   -0.05,        4,     0.5,    80),
    STINKFLY    (0.90f,  -4,   0,    0.00,        0,     0.0,    60),
    RIPJAWS     (1.00f,   6,   4,    0.00,        2,     0.0,    40),
    UPGRADE     (1.00f,   0,   1,    0.10,        0,     0.0,   300),
    GHOSTFREAK  (1.00f,  -2,   1,    0.10,        0,     0.0,   300);

    public final float scale;
    public final double health, damage, speed, armor, knockback;
    public final int cooldown;

    Alien(float scale, double health, double damage, double speed, double armor, double knockback, int cooldown) {
        this.scale = scale; this.health = health; this.damage = damage; this.speed = speed;
        this.armor = armor; this.knockback = knockback; this.cooldown = cooldown;
    }

    public String key() { return name().toLowerCase(); }
    public String nameKey() { return "alien.omnitrix." + key(); }
    public String abilityKey() { return "ability.omnitrix." + key(); }
}
