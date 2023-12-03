## Cycle
A sequence of elements where each one points to the next one, and the **last element** points to the **first element**.

## Example
* CS:GO Gun Game - When someone kills, their weapon is upgraded.
```java
private static final Cycle<Weapon> WEAPONS = Cycle.of(..., DEAGLE, FIVE_SEVEN, KNIFE);

public void onKill(Player killer)
{
    Weapon nextWeapon = WEAPONS.after(killer.getWeapon());
    killer.setWeapon(nextWeapon);
}
```

