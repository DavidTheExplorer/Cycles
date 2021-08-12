## Examples
* CS:GO Gun Game - When someone kills, their weapon is upgraded.
```java
private static final Cycle<Weapon> WEAPONS = CycleFactory.ordered(...., DEAGLE, FIVE_SEVEN, KNIFE);

public void onKill(Player killer)
{
    Weapon nextWeapon = WEAPONS.getNext(killer.getWeapon());
    killer.setWeapon(nextWeapon);
}
```

## Cycle
A sequence of elements where each one points to the next one, and the **last element** points to the **first element**.\
It is functionally the same as an immutable `Map`, offers straightforward methods, and its creation is concise.
