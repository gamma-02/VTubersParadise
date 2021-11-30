package gamma02.vtubersparadise.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class SlimeballProjectile extends ThrowableEntity implements IRendersAsItem
{
    private final boolean level2;
    @Nullable
    private final PlayerEntity owner;
    public SlimeballProjectile(EntityType<? extends SlimeballProjectile> type, Vector3d pos,
            World worldIn, boolean level3, PlayerEntity owner)
    {
        super(type, pos.getX(), pos.getY(), pos.getZ(), worldIn);
        this.owner = owner;

        this.level2 = level3;

    }

    public SlimeballProjectile(EntityType<? extends SlimeballProjectile> type, World worldIn) {
        super(type, worldIn);
        level2 = false;
        this.owner = null;

    }


    @Override public ItemStack getItem()
    {
        return Items.SLIME_BALL.getDefaultInstance();
    }

    @Override protected void onEntityHit(EntityRayTraceResult result)
    {
        if(level2){
            int canDo = MathHelper.nextInt(rand, 0, 1);
            if(canDo == 1){
                if(result.getEntity() instanceof LivingEntity){
                    LivingEntity entity = (LivingEntity) result.getEntity();
                    entity.addPotionEffect(new EffectInstance(Effects.POISON, 100, 1));
                }
            }


        }
        if(result.getEntity() instanceof LivingEntity && owner != null)
        {
            LivingEntity entity = (LivingEntity) result.getEntity();
            entity.attackEntityFrom(DamageSource.causePlayerDamage(owner), 5f);
        }
        super.onEntityHit(result);
    }

    @Override protected void registerData()
    {

    }

    @Override public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
