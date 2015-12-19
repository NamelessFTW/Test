//Ivan Ribeiro
//17 Dec 2015

package game.entity;

public enum MONSTERTYPE
{
	TROLL(4, 10),
	OGRE(5, 6);
	
	int damage;
	int health;
	
	MONSTERTYPE(int damage, int health)
	{
		this.damage = damage;
		this.health = health;
	}
	
	int getDamage()
	{
		return damage;
	}
	
	int getHealth()
	{
		return health;
	}
}
