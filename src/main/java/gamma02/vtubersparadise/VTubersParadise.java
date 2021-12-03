package gamma02.vtubersparadise;

import gamma02.vtubersparadise.entities.HellTrident.*;
import gamma02.vtubersparadise.entities.SlimeballProjectile;
import gamma02.vtubersparadise.items.AstroScythe.AstroScytheL1;
import gamma02.vtubersparadise.items.AstroScythe.AstroScytheL2;
import gamma02.vtubersparadise.items.AstroScythe.AstroScytheL3;
import gamma02.vtubersparadise.items.BeckyBow.BeckyBowL1;
import gamma02.vtubersparadise.items.BeckyBow.BeckyBowL2;
import gamma02.vtubersparadise.items.BeckyBow.BeckyBowL3;
import gamma02.vtubersparadise.items.DisdeersClaws.DisdeersClawsL1;
import gamma02.vtubersparadise.items.EchoTrident.EchoTridentL1;
import gamma02.vtubersparadise.items.EchoTrident.EchoTridentL2;
import gamma02.vtubersparadise.items.EchoTrident.EchoTridentL3;
import gamma02.vtubersparadise.items.FireKatana.FireKatanaL1;
import gamma02.vtubersparadise.items.FireKatana.FireKatanaL2;
import gamma02.vtubersparadise.items.FireKatana.FireKatanaL3;
import gamma02.vtubersparadise.items.HellTrident.HellTridentL1;
import gamma02.vtubersparadise.items.HellTrident.HellTridentL2;
import gamma02.vtubersparadise.items.HellTrident.HellTridentL3;
import gamma02.vtubersparadise.items.NeonBlade.NeonBladeL1;
import gamma02.vtubersparadise.items.NeonBlade.NeonBladeL2;
import gamma02.vtubersparadise.items.NeonBlade.NeonBladeL3;
import gamma02.vtubersparadise.items.ShineSword.ShineSwordL1;
import gamma02.vtubersparadise.items.ShineSword.ShineSwordL2;
import gamma02.vtubersparadise.items.ShineSword.ShineSwordL3;
import gamma02.vtubersparadise.items.SlimeSword.SlimeSwordL1;
import gamma02.vtubersparadise.items.SlimeSword.SlimeSwordL2;
import gamma02.vtubersparadise.items.SlimeSword.SlimeSwordL3;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.system.CallbackI;
import software.bernie.example.client.renderer.entity.ExampleGeoRenderer;
import software.bernie.example.registry.EntityRegistry;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("vtubersparadise")
public class VTubersParadise
{


    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String ModID = "vtubersparadise";
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, "vtubersparadise");
    public static final RegistryObject<Item> SLIME_SWORD_L1 = Items.register("slime_sword_l1", () -> new SlimeSwordL1(
            ItemTier.NETHERITE, 6,  -2f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> SLIME_SWORD_L2 = Items.register("slime_sword_l2", () -> new SlimeSwordL2(
            ItemTier.NETHERITE, 6, -1.5f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> SLIME_SWORD_L3 = Items.register("slime_sword_l3", () -> new SlimeSwordL3(
            ItemTier.NETHERITE, 6, -1.5f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> HELL_TRIDENT_L1 = Items.register("hell_trident_l1", () -> new HellTridentL1(new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> HELL_TRIDENT_L2 = Items.register("hell_trident_l2", () -> new HellTridentL2(new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> HELL_TRIDENT_L3 = Items.register("hell_trident_l3", () -> new HellTridentL3(new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> NEON_BLADE_L1 = Items.register("neon_blade_l1", () -> new NeonBladeL1(ItemTier.NETHERITE, 4, -2, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> NEON_BLADE_L2 = Items.register("neon_blade_l2", () -> new NeonBladeL2(ItemTier.NETHERITE, 6, -1.5f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> NEON_BLADE_L3 = Items.register("neon_blade_l3", () -> new NeonBladeL3(ItemTier.NETHERITE, 8, -1.7f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ECHO_TRIDENT_L1 = Items.register("echo_trident_l1", () -> new EchoTridentL1(ItemTier.NETHERITE, 3, -2, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> ECHO_TRIDENT_L2 = Items.register("echo_trident_l2", () -> new EchoTridentL2(ItemTier.NETHERITE, 5, -1.4f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> ECHO_TRIDENT_L3 = Items.register("echo_trident_l3", () -> new EchoTridentL3(ItemTier.NETHERITE, 7, -1.6f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> SHINE_SWORD_L1 = Items.register("shine_sword_l1", () -> new ShineSwordL1(ItemTier.NETHERITE, 6, -2, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> SHINE_SWORD_L2 = Items.register("shine_sword_l2", () -> new ShineSwordL2(ItemTier.NETHERITE, 8, -1.1f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> SHINE_SWORD_L3 = Items.register("shine_sword_l3", () -> new ShineSwordL3(ItemTier.NETHERITE, 11, -1.2f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> BECKY_BOWL_L1 = Items.register("becky_bow_l1", () -> new BeckyBowL1(new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1), 1));
    public static final RegistryObject<Item> BECKY_BOWL_L2 = Items.register("becky_bow_l2", () -> new BeckyBowL2(new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1), 2));
    public static final RegistryObject<Item> BECKY_BOWL_L3 = Items.register("becky_bow_l3", () -> new BeckyBowL3(new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1), 3));
    public static final RegistryObject<Item> DISDEERS_CLAWS_L1 = Items.register("disdeers_claws_l1", () -> new DisdeersClawsL1(ItemTier.NETHERITE, 3, -2, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> DISDEERS_CLAWS_L2 = Items.register("disdeers_claws_l2", () -> new ShineSwordL3(ItemTier.NETHERITE, 5, -2f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));
    public static final RegistryObject<Item> DISDEERS_CLAWS_L3 = Items.register("disdeers_claws_l3", () -> new ShineSwordL3(ItemTier.NETHERITE, 7, -2f, new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT).maxStackSize(1)));


    public static final RegistryObject<Item> ASTRO_SCYTHE_L1 = Items.register("astro_scythe_l1", () -> new AstroScytheL1(
            ItemTier.NETHERITE, 5, 1f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ASTRO_SCYTHE_L2 = Items.register("astro_scythe_l2", () -> new AstroScytheL2(
            ItemTier.NETHERITE, 8, 1.5f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ASTRO_SCYTHE_L3 = Items.register("astro_scythe_l3", () -> new AstroScytheL3(
            ItemTier.NETHERITE, 11, 1.5f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> FIRE_KATANA_L1 = Items.register("fire_katana_l1", () -> new FireKatanaL1(
            ItemTier.NETHERITE, 3, 1.5f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> FIRE_KATANA_L2 = Items.register("fire_katana_l2", () -> new FireKatanaL2(
            ItemTier.NETHERITE, 6, 1.5f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> FIRE_KATANA_L3 = Items.register("fire_katana_l3", () -> new FireKatanaL3(
            ItemTier.NETHERITE, 8, 1.5f,
            new Item.Properties().isImmuneToFire().group(ItemGroup.COMBAT)));


//    public static final RegistryObject<EntityType<HellTridentEntityL2>> HELL_TRIDENT_ENTITY_L2 = EntityType.register("hell_trident_entity_l2", () -> net.minecraft.entity.EntityType.Builder.<HellTridentEntityL2>create(HellTridentEntityL2::new, EntityClassification.AMBIENT).size(0.5F, 0.9F).build("vtubersparadise"));
//    public static final RegistryObject<EntityType<HellTridentEntityL3>> HELL_TRIDENT_ENTITY_L3 = EntityType.register("hell_trident_entity_l3", () -> net.minecraft.entity.EntityType.Builder.<HellTridentEntityL3>create(HellTridentEntityL3::new, EntityClassification.AMBIENT).size(0.5F, 0.9F).build("vtubersparadise"));


    public VTubersParadise()
    {
      // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        Items.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);

    }



    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
    {

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("VTubersParadise", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}",
                event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent public void onServerStarting(FMLServerStartingEvent event)
    {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD) public static class RegistryEvents
    {
        @SubscribeEvent public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

}
