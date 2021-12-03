package gamma02.vtubersparadise.items.EchoTrident;

import gamma02.vtubersparadise.entities.EchoTrident.EchoTridentEntityL1;
import gamma02.vtubersparadise.entities.ModEntities;
import gamma02.vtubersparadise.entities.NeonSwordEntity.NeonSwordEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class EchoTridentL1 extends SwordItem
{
    public EchoTridentL1(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.SPEAR;
    }

    /**
     * How long it takes to use or consume an item
     */

    @Override public int getUseDuration(ItemStack stack)
    {
        return 72000;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    @Override public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            int i = this.getUseDuration(stack) - timeLeft;
            if (i >= 10) {
                int j = EnchantmentHelper.getRiptideModifier(stack);
                if (j <= 0 || playerentity.isWet()) {
                    if (!worldIn.isRemote) {
                        if (j == 0) {
                            EchoTridentEntityL1 tridententity = new EchoTridentEntityL1(ModEntities.ECHO_TRIDENT_ENTITY_L1, worldIn, playerentity, stack);
                            tridententity.setDirectionAndMovement(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 2.5F + (float)j * 0.5F, 1.0F);
                            if (playerentity.abilities.isCreativeMode) {
                                tridententity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                            }

                            worldIn.addEntity(tridententity);
                            worldIn.playMovingSound(null, tridententity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            if (!playerentity.abilities.isCreativeMode) {
                                playerentity.inventory.deleteStack(stack);
                            }
                        }
                    }

                    playerentity.addStat(Stats.ITEM_USED.get(this));


                }
            }
        }
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        System.out.println("useItem lol");
        playerIn.setActiveHand(handIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
