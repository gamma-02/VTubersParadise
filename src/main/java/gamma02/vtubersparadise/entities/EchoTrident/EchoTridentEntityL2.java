package gamma02.vtubersparadise.entities.EchoTrident;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class EchoTridentEntityL2 extends EchoTridentEntityL1
{
    public EchoTridentEntityL2(EntityType<? extends EchoTridentEntityL1> type, World worldIn)
    {
        super(type, worldIn);
    }

    public EchoTridentEntityL2(EntityType<? extends EchoTridentEntityL1> type, World worldIn, LivingEntity thrower, ItemStack thrownStackIn)
    {
        super(type, worldIn, thrower, thrownStackIn);
    }

    public EchoTridentEntityL2(EntityType<? extends EchoTridentEntityL1> type, World worldIn, double x, double y, double z)
    {
        super(type, worldIn, x, y, z);
    }

    public EchoTridentEntityL2(EntityType<? extends EchoTridentEntityL1> type, FMLPlayMessages.SpawnEntity packet, World world)
    {
        super(type, world);
    }

    @Override
    public byte getLoyaltyLevel(){
        return (byte) 3;
    }
}
