# DungeonsMonster

Create a program that allows a user to explore a dungeon maze and fight monsters that they 
encounter along the way. Use the UML diagram on the next page, the example output, and the 
descriptions below to help you create your program.
Classes:
1. Entity – abstract - describes a character in the game
a. an Entity has a name and some hit points (maxHp is the maximum amount of hp an 
entity can have and hp is initialized to the maxHp).
b. heal method should reset the hp to the maxHp value (ie. does a full heal).
c. takeDamage method should decrease the Entity’s hp by the amount passed in, but it 
should never go below 0.
d. toString method should display the name and hp over maxHp (ex. 15/25).
2. Hero – describes the character that represents the user.
a. the Hero has a location on the map, a level, some gold, potions, and keys.
b. The Hero is constructed with a name, begins at level 1 at the start position of the map 
and is given default values for hp, gold, potions, and keys.
c. direction methods should update the Hero’s location (if that location is within the 
bounds of the map), reveal that location, get the character at that location, and then 
return it.
d. levelUp method increments the Hero’s level and loads the next map (note: the level 
should continue to increase, but the maps are numbered 1, 2, and 3, and should be 
repeated in that order (each finish is the next map’s start).
e. attack method should call the selected ability method. Each does a different amount 
of damage to the enemy within a random range and returns a string representing that 
damage.
f. attack menu method should return the string “1. Physical 2. Magical 3. Ranged” for 
the different types of attacks to choose from. Submenu method should return the 
selected menu from the interface.
g. toString should display the name, hp, level, gold, potions, keys, and map.
3. Map – represents the dungeon maze. Map is a Singleton.
a. a map has a 5x5 set of characters representing the types of rooms in the maze, and a 
5x5 set of booleans that allow you to determine if that room has been visited yet.
b. loadMap reads in the map from the file and stores it in the character array.
c. mapToString returns a string of the map with the Hero’s current position, revealed 
rooms, and any unrevealed rooms represented by ‘x’s.
4. Enemy – abstract - represents an enemy the Hero will encounter
a. Abstract attack method will be overridden by the different enemy types.
5. Warrior/Wizard/Ranger – the different types of enemies.
a. attack method randomly selects one of the enemy’s abilities to attack the Hero with. 
Each of the ability methods for each enemy type should do random damage to the 
Hero and return a string representing that damage.
6. Fighter/Magical/Archer – interfaces that define the abilities of the Hero and the enemies.
7. EnemyGenerator – factory to create random enemies to encounter on the map.
a. constructor reads the file and adds the different enemies and their base hp to the
HashMap (do not assume you know the length of the file).
b. generateEnemy method randomly selects an enemy from the map, then randomly 
selects an ability type (Fighter/Magical/Archer), then copies over the name and base
hp to construct a new enemy of that type. Use the level value passed in to modify the 
base hp so that as the Hero progresses through the levels, the difficulty will increase.
8. Main
a. prompt the user to enter a name, then construct a Hero with that name.
b. display the Hero with the map and have the user choose a direction.
c. get the resulting character from the hero’s direction methods
i. x – location was out of bounds
ii. n – nothing here
iii. s – start – item store where the Hero can buy potions or keys.
iv. f – finish – if the Hero has a key, then increase the Hero’s level and load the 
next map.
v. i – item – the Hero randomly finds a potion or a key.
vi. m – monster – create an enemy to fight then call monsterRoom.
d. monsterRoom displays the enemy and then repeatedly prompts the user to fight, run 
away, or drink a potion (only displayed if Hero has one). If they choose to fight, call 
the fight method. If they run away, then choose a random direction to move the Hero. 
Return true if the Hero is still alive after the encounter.
e. fight does a single round of damage by allowing the user to choose to do a physical,
magical, or ranged attack. Then, depending on their selection, displays the 
corresponding submenu. Those two selections are passed to the Hero’s attack method
to attack the enemy. The enemy then attacks back if it is still alive.
f. repeat from b until the user quits or the Hero dies.
Notes
• You can use the Point class from the java.awt library to keep the location of the Hero, or you can 
make your own Point class.
• As the Hero moves in the map some encounters are removed once they are finished. Item rooms 
and defeated monsters are removed, start, finish, and monsters that were not defeated (ie. Hero 
ran away) are not removed.
• The ability damage methods (ex. sword or fireball) should each do a different amount of random 
damage to the entity that is passed in. Return a string representing the attack with the amount of 
damage done to the entity (see example output). The amount of damage to be done is up to you, 
but try to make it proportional to the Hero’s mHp (ie. if the Hero only has 25 mHp, then the 
damage methods should probably have a random range of ~1-5 dmg). I need to test your
programs, so please do not make it overly difficult for me to get to level 4.
• Please do not add any extra instance variables or methods to the UML.
• Ask questions about any methods you do not fully understand
