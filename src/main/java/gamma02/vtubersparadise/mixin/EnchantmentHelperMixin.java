package gamma02.vtubersparadise.mixin;

import gamma02.vtubersparadise.VTubersParadise;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.SweepingEnchantment;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.enchantment.EnchantmentHelper.getMaxEnchantmentLevel;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin
{

    /**
     * @author gamma_02 who else lmfao
     * @reason y e s
     */
    @Overwrite
    public static float getSweepingDamageRatio(LivingEntity entityIn) {
        int i = getMaxEnchantmentLevel(Enchantments.SWEEPING, entityIn);
        if(entityIn.getHeldItemMainhand().getItem() == VTubersParadise.NEON_BLADE_L1.get()){
            i = 10;
        }
        return i > 0 ? SweepingEnchantment.getSweepingDamageRatio(i) : 0.0F;
    }

}
