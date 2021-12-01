package gamma02.vtubersparadise.items.BeckyBow;

public class BeckyBowL2 extends BeckyBowL1
{
    public BeckyBowL2(Properties properties)
    {
        super(properties);
    }

    @Override
    public double getArrowDamage(){
        return 8;
    }

    @Override public int level()
    {
        return 2;
    }
}
