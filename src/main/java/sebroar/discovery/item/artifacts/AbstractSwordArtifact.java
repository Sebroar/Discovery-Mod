package sebroar.discovery.item.artifacts;

import java.util.List;
import java.util.Set;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public abstract class AbstractSwordArtifact extends SwordItem {
	private static Set<Skill> skills;
	private static Skill ability;
	private int level = 1;
	private int selectedSkillIndex = 0;
	public AbstractSwordArtifact(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
		super(itemTier, damage, attackSpeed, properties.rarity(Rarity.create("ARTIFACT", TextFormatting.RED)));
	}
	protected static void addSkills(Skill... newSkills) {
		for (Skill skill : newSkills) {
			skills.add(skill);
		}
	}
	public static int activeSkillsAmount() {
		int i = 0;
		for (Skill skill: skills) {
			if (skill.getSkillType() == SkillType.ACTIVE) ++i;
		}
		return i;
	}
	public void cycleSkill() {
		if (activeSkillsAmount() > 1) {
			int i = selectedSkillIndex < skills.size() - 1 ? ++selectedSkillIndex : 0;
			Skill[] rawSkills = new Skill[skills.size()];
			rawSkills = skills.toArray(rawSkills);
			for (Skill skill = rawSkills[i]; skill.getSkillType() != SkillType.ACTIVE;) {
				i = i < skills.size() -1 ? ++i : 0;
			}
			selectedSkillIndex = i;
		}
	}
	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltips,
			ITooltipFlag flag) {
		tooltips.add(new StringTextComponent("artifact.tooltip.level" + this.level));
		tooltips.add(new StringTextComponent("artifact.tooltip.skills"));
		for (Skill skill : skills) {
			tooltips.add(new StringTextComponent(skill.getSkillName() + " - " + (skill.isUnlocked() ? "artifact.tooltip.level" + skill.getCurrentLevel() : "artifact.tooltip.skill.unlockLevel" + skill.getUnlockLevel())));
		}
		tooltips.add(new StringTextComponent("artifact.tooltip.lore." + this.getRegistryName()));
	}
}
