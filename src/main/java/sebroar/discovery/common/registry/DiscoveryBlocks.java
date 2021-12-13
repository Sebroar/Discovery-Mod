package sebroar.discovery.common.registry;

import java.util.function.Supplier;

import net.minecraft.block.*;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import sebroar.discovery.Discovery;
import sebroar.discovery.block.*;
import sebroar.discovery.block.DiscoveryGrassBlock;
import sebroar.discovery.block.material.DiscoveryMaterial;
import sebroar.discovery.block.trees.GrimbarkTree;
import sebroar.discovery.item.itemgroups.DiscoveryTabs;

@SuppressWarnings("unused")
public class DiscoveryBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Discovery.MODID);
	public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Discovery.MODID);
	
	//Registries
	public static final RegistryObject<Block> GRIMSTONE = registerBlock("grimstone", () -> new Block(properties(Material.STONE, MaterialColor.TERRACOTTA_CYAN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5f, 10f)), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	public static final RegistryObject<Block> GRIMSTONE_SLAB = registerBlock("grimstone_slab", () -> new SlabBlock(properties(Material.STONE, MaterialColor.TERRACOTTA_CYAN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5f, 10f)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMSTONE_STAIRS = registerBlock("grimstone_stairs", () -> new StairsBlock(() -> GRIMSTONE.get().defaultBlockState(), properties(Material.STONE, MaterialColor.TERRACOTTA_CYAN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5f, 10f)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMSTONE_WALL = registerBlock("grimstone_wall", () -> new WallBlock(properties(Material.STONE, MaterialColor.TERRACOTTA_CYAN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5f, 10f)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	
	public static final RegistryObject<Block> GRIM_DIRT = registerBlock("grim_dirt", () -> new Block(properties(Material.DIRT, MaterialColor.LAPIS).harvestTool(ToolType.SHOVEL).strength(0.5f)), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	
	public static final RegistryObject<Block> GRIM_GRASS = registerBlock("grim_grass", () -> new DiscoveryGrassBlock(properties(Material.GRASS, MaterialColor.TERRACOTTA_GREEN).randomTicks().strength(0.6f).sound(SoundType.GRASS), GRIM_DIRT, true), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	
	public static final RegistryObject<Block> GRIMBARK_LOG = registerBlock("grimbark_log", () -> log(MaterialColor.LAPIS, MaterialColor.COLOR_CYAN), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_WOOD = registerBlock("grimbark_wood", () -> woodBlock(MaterialColor.COLOR_CYAN), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	public static final RegistryObject<Block> STRIPPED_GRIMBARK_LOG = registerBlock("stripped_grimbark_log", () -> woodBlock(MaterialColor.LAPIS), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	public static final RegistryObject<Block> STRIPPED_GRIMBARK_WOOD = registerBlock("stripped_grimbark_wood", () -> woodBlock(MaterialColor.LAPIS), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_SAPLING = registerBlock("grimbark_sapling", () -> new SaplingBlock(new GrimbarkTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)), DiscoveryTabs.DISCOVERY_ITEMS);
	public static final RegistryObject<Block> GRIMBARK_PLANKS = registerBlock("grimbark_planks", () -> new Block(properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_SLAB = registerBlock("grimbark_slab", () -> new SlabBlock(properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_STAIRS = registerBlock("grimbark_stairs", () -> new StairsBlock(() -> GRIMBARK_PLANKS.get().defaultBlockState(), properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_FENCE = registerBlock("grimbark_fence", () -> new FenceBlock(properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_FENCE_GATE = registerBlock("grimbark_fence_gate", () -> new FenceGateBlock(properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_BUTTON = registerBlock("grimbark_button", () -> new WoodButtonBlock(properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_PRESSURE_PLATE = registerBlock("grimbark_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_TRAPDOOR = registerBlock("grimbark_trapdoor", () -> new TrapDoorBlock(properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD).noOcclusion().isValidSpawn(DiscoveryBlocks::never)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_DOOR = registerBlock("grimbark_door", () -> new DoorBlock(properties(Material.WOOD, MaterialColor.LAPIS).strength(2.0f, 3.0f).sound(SoundType.WOOD).noOcclusion()), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> GRIMBARK_LEAVES = registerBlock("grimbark_leaves", () -> leaves(MaterialColor.COLOR_LIGHT_BLUE), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	
	public static final RegistryObject<Block> DARKLIP = registerBlock("darklip", () -> new DarklipBlock(Effects.NIGHT_VISION, 8, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS).lightLevel((lightLevel) -> {
		return 3;
	})), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	
	public static final RegistryObject<Block> ABYSSIUM_ORE = registerBlock("abyssium_ore", () -> new Block(properties(Material.STONE, MaterialColor.TERRACOTTA_CYAN).strength(3f, 12.5f)), DiscoveryTabs.DISCOVERY_GENERATION_BLOCKS);
	public static final RegistryObject<Block> ABYSSIUM_BLOCK = registerBlock("abyssium_block", () -> new Block(properties(Material.METAL, MaterialColor.COLOR_RED).strength(4.5f, 14f).harvestTool(ToolType.PICKAXE).harvestLevel(3).requiresCorrectToolForDrops()), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	
	public static final RegistryObject<Block> PURIFICATION_ALTAR_ENERGY_PROVIDER = registerBlock("purification_altar_energy_provider", () -> new PurificationAltarEnergyProviderBlock(properties(DiscoveryMaterial.PURIFICATION_ALTAR, MaterialColor.DIAMOND).strength(-1.0f, 3600000.0f).noDrops().isValidSpawn(DiscoveryBlocks::never)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> PURIFICATION_ALTAR = registerBlock("purification_altar", () -> new PurificationAltarBlock(properties(DiscoveryMaterial.PURIFICATION_ALTAR, MaterialColor.DIAMOND).strength(-1.0f, 3600000.0f).noDrops().isValidSpawn(DiscoveryBlocks::never)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	public static final RegistryObject<Block> PURIFICATION_ALTAR_BRICKS = registerBlock("purification_altar_bricks", () -> new Block(properties(DiscoveryMaterial.PURIFICATION_ALTAR, MaterialColor.COLOR_BLUE).strength(-1.0f, 3600000.0f).noDrops().isValidSpawn(DiscoveryBlocks::never)), DiscoveryTabs.DISCOVERY_CONSTUCTION_BLOCKS);
	
	//helpers
	private static RotatedPillarBlock log(MaterialColor woodColor, MaterialColor barkColor) {
		return new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, (materialColor) -> {
			return materialColor.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? woodColor : barkColor;
		}).strength(2.0f).sound(SoundType.WOOD));
	}
	private static RotatedPillarBlock woodBlock(MaterialColor barkColor) {
		return new RotatedPillarBlock(properties(Material.WOOD, barkColor).strength(2.0f).sound(SoundType.WOOD));
	}
	private static AbstractBlock.Properties properties(Material material, MaterialColor mapColor) {
		return AbstractBlock.Properties.of(material, mapColor);
	}
	private static LeavesBlock leaves(MaterialColor leavesColor) {
		return new LeavesBlock(properties(Material.LEAVES, leavesColor).strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(DiscoveryBlocks::ocelotOrParrot).isSuffocating(DiscoveryBlocks::never).isViewBlocking(DiscoveryBlocks::never));
	}
	private static Boolean ocelotOrParrot(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entityType) {
		return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
	}
	private static Boolean always(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> type) {
		return (boolean)true;
	}
	private static Boolean never(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> type) {
		return (boolean)false;
	}
	private static boolean always(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}
	private static boolean never(BlockState state, IBlockReader reader, BlockPos pos) {
		return false;
	}
	
	//registry methods
	private static <T extends Block> RegistryObject<T> registerItemlessBlock(String registryName, Supplier<T> supplier) {
		return BLOCKS.register(registryName, supplier);
	}
	private static <T extends Block> RegistryObject<T> registerBlock(String registryName, Supplier<T> supplier, ItemGroup itemGroup) {
		RegistryObject<T> block = BLOCKS.register(registryName, supplier);
		RegistryObject<Item> blockItem = BLOCK_ITEMS.register(registryName, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
		return block;
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
		BLOCK_ITEMS.register(eventBus);
	}
}
