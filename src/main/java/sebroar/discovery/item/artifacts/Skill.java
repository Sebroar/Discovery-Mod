package sebroar.discovery.item.artifacts;

public class Skill {
	private final String skillName;
	private final SkillType skillType;
	private final boolean isArmorSkill;
	private final int id;
	private final int unlockLevel;
	private final int levels;
	private final int cooldown;
	private int currentLevel = 0;
	private boolean isUnlocked = currentLevel > 0;
	private int remainingTime;
	public Skill(String name, SkillType skillType, boolean isArmorSkill, int id, int unlock, int levels, int cooldown) {
		this.skillName = name;
		this.skillType = skillType;
		this.isArmorSkill = isArmorSkill;
		this.id = id;
		this.unlockLevel = unlock;
		this.levels = levels;
		this.cooldown = cooldown;
	}
	public Skill(String name, SkillType skillType, boolean isArmorSkill, int id) {
		this(name, skillType, isArmorSkill, id, 1, 1, 0);
	}
	public void setCoolingDown() {
		this.remainingTime = this.cooldown;
	}
	public void setCooldownTime(int time) {
		this.remainingTime = time;
	}
	public int getCooldownTime() {
		return this.cooldown;
	}
	public int getRemainingCooldown() {
		return this.remainingTime;
	}
	public boolean isCoolingDown() {
		return this.remainingTime == 0;
	}
	public int getCurrentLevel() {
		return this.currentLevel;
	}
	public void setLevel(int level) {
		this.currentLevel = level;
	}
	public int getMaxLevel() {
		return this.levels;
	}
	public boolean isUnlocked() {
		return this.isUnlocked;
	}
	public int getId() {
		return this.id;
	}
	public int getUnlockLevel() {
		return this.unlockLevel;
	}
	public boolean isArmorSkill() {
		return this.isArmorSkill;
	}
	public SkillType getSkillType() {
		return this.skillType;
	}
	public String getSkillName() {
		return this.skillName;
	}
	public class Ability extends Skill {
		public Ability(String name, SkillType skillType, boolean isArmorSkill, int levels, int cooldown) {
			super(name, skillType, isArmorSkill, -1, 5, levels, cooldown);
		}
	}
}
