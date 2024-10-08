package appeng.parts.automation;

import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import appeng.core.localization.GuiText;
import appeng.core.localization.Tooltips;
import appeng.items.parts.PartItem;
import appeng.util.EnchantmentUtil;

/**
 * Special part item for {@link AnnihilationPlanePart} to handle enchants and extended tooltips.
 */
public class AnnihilationPlanePartItem extends PartItem<AnnihilationPlanePart> {
    /**
     * Workaround to make annihilation planes combinable in anvils.
     * <p>
     * null = false, non-null = true
     */
    public static final ThreadLocal<Object> CALLING_DAMAGEABLE_FROM_ANVIL = ThreadLocal.withInitial(() -> null);

    public AnnihilationPlanePartItem(Properties properties) {
        super(properties, AnnihilationPlanePart.class, AnnihilationPlanePart::new);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public int getMaxDamage() {
        return CALLING_DAMAGEABLE_FROM_ANVIL.get() != null ? 1 : super.getMaxDamage();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> lines, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, lines, isAdvanced);

        var enchantments = EnchantmentHelper.getEnchantments(stack);
        if (enchantments.isEmpty()) {
            lines.add(Tooltips.of(GuiText.CanBeEnchanted));
        } else {
            lines.add(Tooltips.of(GuiText.IncreasedEnergyUseFromEnchants));
        }
    }

    @Override
    public void addToMainCreativeTab(CreativeModeTab.Output output) {
        super.addToMainCreativeTab(output);

        var silkTouch = new ItemStack(this);
        EnchantmentUtil.setEnchantments(silkTouch.getOrCreateTag(), Map.of(Enchantments.SILK_TOUCH, 1));
        output.accept(silkTouch);
    }
}
