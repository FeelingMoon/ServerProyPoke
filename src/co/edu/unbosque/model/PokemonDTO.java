package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * @author MiguelLinares
 * @author JohanSilva
 * @author MiguelRamirez
 * @author HaroldDuarte
 */
@SuppressWarnings("serial")
public class PokemonDTO implements Serializable {
	private int num, hp, attack, defense, spAtk, spDef, speed, mov1, mov2, mov3, mov4;
	private String mote, nom, type1, type2, desc, hab1, hab2, hab3, gif, wav;

	/**
	 * Empty constructor method
	 */
	public PokemonDTO() {
	}

	/**
	 * Constructor method
	 * 
	 * @param mote    Pokemons nickname
	 * @param num     Id of the pokemon
	 * @param hp      Health of the pokemon
	 * @param attack  Attack of the pokemon
	 * @param defense Defense of the pokemon
	 * @param spAtk   Special attack of the pokemon
	 * @param spDef   Special defense of the pokemon
	 * @param speed   Speed of the pokemon
	 * @param mov1    Movement of the pokemon
	 * @param mov2    Movement of the pokemon
	 * @param mov3    Movement of the pokemon
	 * @param mov4    Movement of the pokemon
	 * @param nom     Name of the pokemon
	 * @param type1   Type of the pokemon
	 * @param type2   Type of the pokemon
	 * @param desc    Description of the pokemon
	 * @param hab1    Hability of the pokemon
	 * @param hab2    Hability of the pokemon
	 * @param hab3    Hability of the pokemon
	 * @param gif     Gif of the pokemon
	 * @param wav     Sound of the pokemon
	 */
	public PokemonDTO(int num, int hp, int attack, int defense, int spAtk, int spDef, int speed, int mov1, int mov2,
			int mov3, int mov4, String mote, String nom, String type1, String type2, String desc, String hab1,
			String hab2, String hab3, String gif, String wav) {
		super();
		this.mote = mote;
		this.num = num;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.mov1 = mov1;
		this.mov2 = mov2;
		this.mov3 = mov3;
		this.mov4 = mov4;
		this.nom = nom;
		this.type1 = type1;
		this.type2 = type2;
		this.desc = desc;
		this.hab1 = hab1;
		this.hab2 = hab2;
		this.hab3 = hab3;
		this.gif = gif;
		this.wav = wav;
	}

	/**
	 * Method that gets and displays the attribute mote
	 * 
	 * @return Attribute num value
	 */
	public String getMote() {
		return mote;
	}

	/**
	 * Method that sets the attribute mote
	 * 
	 * @param num Number of the pokemon
	 */
	public void setMote(String mote) {
		this.mote = mote;
	}

	/**
	 * Method that gets and displays the attribute num
	 * 
	 * @return Attribute num value
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Method that sets the attribute num
	 * 
	 * @param num Number of the pokemon
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * Method that gets and displays the attribute HP
	 * 
	 * @return Attribute HP value
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Method that sets the attribute HP
	 * 
	 * @param hp Value of health
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Method that gets and displays the attribute Attack
	 * 
	 * @return Attribute attack value
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Method that sets the attribute Attack
	 * 
	 * @param attack Value of attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * Method that gets and displays the attribute defense
	 * 
	 * @return Attribute defense value
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Method that sets the attribute Defense
	 * 
	 * @param defense Value of defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * Method that gets and displays the attribute SpAtk
	 * 
	 * @return Attribute special attack value
	 */
	public int getSpAtk() {
		return spAtk;
	}

	/**
	 * Method that sets the attribute SpAtk
	 * 
	 * @param spAtk Value of special attack
	 */
	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}

	/**
	 * Method that gets and displays the attribute SpDef
	 * 
	 * @return Attribute special defense value
	 */
	public int getSpDef() {
		return spDef;
	}

	/**
	 * Method that sets the attribute SpDef
	 * 
	 * @param spDef Value of special defense
	 */
	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}

	/**
	 * Method that gets and displays the attribute Speed
	 * 
	 * @return Attribute Speed value
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Method that sets the attribute Speed
	 * 
	 * @param speed Value of speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Method that gets and displays the attribute Mov1
	 * 
	 * @return Attribute Mov1 value
	 */
	public int getMov1() {
		return mov1;
	}

	/**
	 * Method that sets the attribute Mov1
	 * 
	 * @param mov1 Value of move
	 */
	public void setMov1(int mov1) {
		this.mov1 = mov1;
	}

	/**
	 * Method that gets and displays the attribute Mov2
	 * 
	 * @return Attribute Mov2 value
	 */
	public int getMov2() {
		return mov2;
	}

	/**
	 * Method that sets the attribute Mov2
	 * 
	 * @param mov2 Value of move
	 */
	public void setMov2(int mov2) {
		this.mov2 = mov2;
	}

	/**
	 * Method that gets and displays the attribute Mov3
	 * 
	 * @return Attribute Mov3 value
	 */
	public int getMov3() {
		return mov3;
	}

	/**
	 * Method that sets the attribute Mov3
	 * 
	 * @param mov3 Value of move
	 */
	public void setMov3(int mov3) {
		this.mov3 = mov3;
	}

	/**
	 * Method that gets and displays the attribute Mov4
	 * 
	 * @return Attribute Mov4 value
	 */
	public int getMov4() {
		return mov4;
	}

	/**
	 * Method that sets the attribute Mov4
	 * 
	 * @param mov4 Value of move
	 */
	public void setMov4(int mov4) {
		this.mov4 = mov4;
	}

	/**
	 * Method that gets and displays the attribute name
	 * 
	 * @return Attribute name value
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Method that sets the attribute Nom
	 * 
	 * @param nom Value of name
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Method that gets and displays the attribute Type1
	 * 
	 * @return Attribute Type1 value
	 */
	public String getType1() {
		return type1;
	}

	/**
	 * Method that sets the attribute Type1
	 * 
	 * @param type1 Value of type
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}

	/**
	 * Method that gets and displays the attribute Type2
	 * 
	 * @return Attribute Type2 value
	 */
	public String getType2() {
		return type2;
	}

	/**
	 * Method that sets the attribute Type2
	 * 
	 * @param type2 Value of type
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}

	/**
	 * Method that gets and displays the attribute Desc
	 * 
	 * @return attribute Desc value
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Method that sets the attribute Desc
	 * 
	 * @param desc Value of description
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Method that gets and displays the attribute Hab1
	 * 
	 * @return Attribute Hab1 value
	 */
	public String getHab1() {
		return hab1;
	}

	/**
	 * Method that sets the attribute Hab1
	 * 
	 * @param hab1 Value of hability
	 */
	public void setHab1(String hab1) {
		this.hab1 = hab1;
	}

	/**
	 * Method that gets and displays the attribute Hab2
	 * 
	 * @return attribute Ha2 value
	 */
	public String getHab2() {
		return hab2;
	}

	/**
	 * Method that sets the attribute Hab2
	 * 
	 * @param hab2 Value of hability
	 */
	public void setHab2(String hab2) {
		this.hab2 = hab2;
	}

	/**
	 * Method that gets and displays the attribute Hab3
	 * 
	 * @return Attribute Hab3 value
	 */
	public String getHab3() {
		return hab3;
	}

	/**
	 * Method that sets the attribute Hab2
	 * 
	 * @param hab3 Value of hability
	 */
	public void setHab3(String hab3) {
		this.hab3 = hab3;
	}

	/**
	 * Method that gets and displays the attribute Gif
	 * 
	 * @return attribute Gif value
	 */
	public String getGif() {
		return gif;
	}

	/**
	 * Method that sets the attribute gif
	 * 
	 * @param gif Url of the gif
	 */
	public void setGif(String gif) {
		this.gif = gif;
	}

	/**
	 * Method that gets and displays the attribute Wav
	 * 
	 * @return attribute Wav value
	 */
	public String getWav() {
		return wav;
	}

	/**
	 * Method that sets the attribute wav
	 * 
	 * @param wav Url of the sound
	 */
	public void setWav(String wav) {
		this.wav = wav;
	}

	@Override
	public String toString() {
		return num + "-" + hp + "-" + attack + "-" + defense + "-" + spAtk + "-" + spDef + "-" + speed + "?&" + mov1
				+ "?&" + mov2 + "?&" + mov3 + "?&" + mov4 + "?&" + mote + "-" + nom + "-" + type1 + "-" + type2 + "-"
				+ desc + "-" + hab1 + "-" + hab2 + "-" + hab3 + "-" + gif + "-" + wav;
	}

	public String toString2() {
		return num + "-" + nom + "-" + type1 + "-" + type2 + "-" + gif + "-" + wav;
	}

}
