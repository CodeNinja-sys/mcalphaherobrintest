/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockBloodStone;
import net.minecraft.src.BlockBookshelf;
import net.minecraft.src.BlockButton;
import net.minecraft.src.BlockCactus;
import net.minecraft.src.BlockChest;
import net.minecraft.src.BlockClay;
import net.minecraft.src.BlockCrops;
import net.minecraft.src.BlockDirt;
import net.minecraft.src.BlockDoor;
import net.minecraft.src.BlockFence;
import net.minecraft.src.BlockFire;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.BlockFlowing;
import net.minecraft.src.BlockFurnace;
import net.minecraft.src.BlockGlass;
import net.minecraft.src.BlockGrass;
import net.minecraft.src.BlockGravel;
import net.minecraft.src.BlockIce;
import net.minecraft.src.BlockJukeBox;
import net.minecraft.src.BlockLadder;
import net.minecraft.src.BlockLeaves;
import net.minecraft.src.BlockLever;
import net.minecraft.src.BlockLightStone;
import net.minecraft.src.BlockLog;
import net.minecraft.src.BlockMinecartTrack;
import net.minecraft.src.BlockMobSpawner;
import net.minecraft.src.BlockMushroom;
import net.minecraft.src.BlockObsidian;
import net.minecraft.src.BlockOre;
import net.minecraft.src.BlockOreBlock;
import net.minecraft.src.BlockPortal;
import net.minecraft.src.BlockPressurePlate;
import net.minecraft.src.BlockPumpkin;
import net.minecraft.src.BlockRedstoneOre;
import net.minecraft.src.BlockRedstoneTorch;
import net.minecraft.src.BlockRedstoneWire;
import net.minecraft.src.BlockReed;
import net.minecraft.src.BlockSand;
import net.minecraft.src.BlockSapling;
import net.minecraft.src.BlockSign;
import net.minecraft.src.BlockSlowSand;
import net.minecraft.src.BlockSnow;
import net.minecraft.src.BlockSnowBlock;
import net.minecraft.src.BlockSoil;
import net.minecraft.src.BlockSponge;
import net.minecraft.src.BlockStairs;
import net.minecraft.src.BlockStationary;
import net.minecraft.src.BlockStep;
import net.minecraft.src.BlockStone;
import net.minecraft.src.BlockTNT;
import net.minecraft.src.BlockTorch;
import net.minecraft.src.BlockWorkbench;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.StepSound;
import net.minecraft.src.StepSoundSand;
import net.minecraft.src.StepSoundStone;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class Block {
    public static final StepSound soundPowderFootstep;
    public static final StepSound soundWoodFootstep;
    public static final StepSound soundGravelFootstep;
    public static final StepSound soundGrassFootstep;
    public static final StepSound soundStoneFootstep;
    public static final StepSound soundMetalFootstep;
    public static final StepSound soundGlassFootstep;
    public static final StepSound soundClothFootstep;
    public static final StepSound soundSandFootstep;
    public static final Block[] blocksList;
    public static final boolean[] tickOnLoad;
    public static final boolean[] opaqueCubeLookup;
    public static final boolean[] isBlockContainer;
    public static final int[] lightOpacity;
    public static final boolean[] field_340_s;
    public static final int[] lightValue;
    public static final Block stone;
    public static final BlockGrass grass;
    public static final Block dirt;
    public static final Block cobblestone;
    public static final Block planks;
    public static final Block sapling;
    public static final Block bedrock;
    public static final Block waterStill;
    public static final Block waterMoving;
    public static final Block lavaStill;
    public static final Block lavaMoving;
    public static final Block sand;
    public static final Block gravel;
    public static final Block oreGold;
    public static final Block oreIron;
    public static final Block oreCoal;
    public static final Block wood;
    public static final BlockLeaves leaves;
    public static final Block sponge;
    public static final Block glass;
    public static final Block field_9267_N;
    public static final Block field_9266_O;
    public static final Block field_9265_P;
    public static final Block field_9264_Q;
    public static final Block field_9263_R;
    public static final Block field_9262_S;
    public static final Block field_9261_T;
    public static final Block field_9260_U;
    public static final Block field_9259_V;
    public static final Block field_9258_W;
    public static final Block field_9257_X;
    public static final Block field_9256_Y;
    public static final Block field_9255_Z;
    public static final Block field_9269_aa;
    public static final Block cloth;
    public static final Block field_9268_ac;
    public static final BlockFlower plantYellow;
    public static final BlockFlower plantRed;
    public static final BlockFlower mushroomBrown;
    public static final BlockFlower mushroomRed;
    public static final Block blockGold;
    public static final Block blockSteel;
    public static final Block stairDouble;
    public static final Block stairSingle;
    public static final Block brick;
    public static final Block tnt;
    public static final Block bookShelf;
    public static final Block cobblestoneMossy;
    public static final Block obsidian;
    public static final Block torchWood;
    public static final BlockFire fire;
    public static final Block mobSpawner;
    public static final Block stairCompactPlanks;
    public static final Block crate;
    public static final Block redstoneWire;
    public static final Block oreDiamond;
    public static final Block blockDiamond;
    public static final Block workbench;
    public static final Block crops;
    public static final Block tilledField;
    public static final Block stoneOvenIdle;
    public static final Block stoneOvenActive;
    public static final Block signPost;
    public static final Block doorWood;
    public static final Block ladder;
    public static final Block minecartTrack;
    public static final Block stairCompactCobblestone;
    public static final Block signWall;
    public static final Block lever;
    public static final Block pressurePlateStone;
    public static final Block doorSteel;
    public static final Block pressurePlatePlanks;
    public static final Block oreRedstone;
    public static final Block oreRedstoneGlowing;
    public static final Block torchRedstoneIdle;
    public static final Block torchRedstoneActive;
    public static final Block button;
    public static final Block snow;
    public static final Block blockIce;
    public static final Block blockSnow;
    public static final Block cactus;
    public static final Block blockClay;
    public static final Block reed;
    public static final Block jukebox;
    public static final Block fence;
    public static final Block pumpkin;
    public static final Block bloodStone;
    public static final Block slowSand;
    public static final Block lightStone;
    public static final BlockPortal portal;
    public static final Block pumpkinLantern;
    public int blockIndexInTexture;
    public final int blockID;
    protected float blockHardness;
    protected float blockResistance;
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;
    public StepSound stepSound = soundPowderFootstep;
    public float field_357_bm = 1.0f;
    public final Material blockMaterial;
    public float slipperiness = 0.6f;

    static {
        tickOnLoad = new boolean[256];
        opaqueCubeLookup = new boolean[256];
        isBlockContainer = new boolean[256];
        lightOpacity = new int[256];
        field_340_s = new boolean[256];
        lightValue = new int[256];
        field_9267_N = null;
        field_9266_O = null;
        field_9265_P = null;
        field_9264_Q = null;
        field_9263_R = null;
        field_9262_S = null;
        field_9261_T = null;
        field_9260_U = null;
        field_9259_V = null;
        field_9258_W = null;
        field_9257_X = null;
        field_9256_Y = null;
        field_9255_Z = null;
        field_9269_aa = null;
        field_9268_ac = null;
        soundPowderFootstep = new StepSound("stone", 1.0f, 1.0f);
        soundWoodFootstep = new StepSound("wood", 1.0f, 1.0f);
        soundGravelFootstep = new StepSound("gravel", 1.0f, 1.0f);
        soundGrassFootstep = new StepSound("grass", 1.0f, 1.0f);
        soundStoneFootstep = new StepSound("stone", 1.0f, 1.0f);
        soundMetalFootstep = new StepSound("stone", 1.0f, 1.5f);
        soundGlassFootstep = new StepSoundStone("stone", 1.0f, 1.0f);
        soundClothFootstep = new StepSound("cloth", 1.0f, 1.0f);
        soundSandFootstep = new StepSoundSand("sand", 1.0f, 1.0f);
        blocksList = new Block[256];
        stone = new BlockStone(1, 1).setHardness(1.5f).setResistance(10.0f).setStepSound(soundStoneFootstep);
        grass = (BlockGrass)new BlockGrass(2).setHardness(0.6f).setStepSound(soundGrassFootstep);
        dirt = new BlockDirt(3, 2).setHardness(0.5f).setStepSound(soundGravelFootstep);
        cobblestone = new Block(4, 16, Material.rock).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep);
        planks = new Block(5, 4, Material.wood).setHardness(2.0f).setResistance(5.0f).setStepSound(soundWoodFootstep);
        sapling = new BlockSapling(6, 15).setHardness(0.0f).setStepSound(soundGrassFootstep);
        bedrock = new Block(7, 17, Material.rock).setHardness(-1.0f).setResistance(6000000.0f).setStepSound(soundStoneFootstep);
        waterStill = new BlockFlowing(8, Material.water).setHardness(100.0f).setLightOpacity(3);
        waterMoving = new BlockStationary(9, Material.water).setHardness(100.0f).setLightOpacity(3);
        lavaStill = new BlockFlowing(10, Material.lava).setHardness(0.0f).setLightValue(1.0f).setLightOpacity(255);
        lavaMoving = new BlockStationary(11, Material.lava).setHardness(100.0f).setLightValue(1.0f).setLightOpacity(255);
        sand = new BlockSand(12, 18).setHardness(0.5f).setStepSound(soundSandFootstep);
        gravel = new BlockGravel(13, 19).setHardness(0.6f).setStepSound(soundGravelFootstep);
        oreGold = new BlockOre(14, 32).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep);
        oreIron = new BlockOre(15, 33).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep);
        oreCoal = new BlockOre(16, 34).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep);
        wood = new BlockLog(17).setHardness(2.0f).setStepSound(soundWoodFootstep);
        leaves = (BlockLeaves)new BlockLeaves(18, 52).setHardness(0.2f).setLightOpacity(1).setStepSound(soundGrassFootstep);
        sponge = new BlockSponge(19).setHardness(0.6f).setStepSound(soundGrassFootstep);
        glass = new BlockGlass(20, 49, Material.glass, false).setHardness(0.3f).setStepSound(soundGlassFootstep);
        cloth = new Block(35, 64, Material.cloth).setHardness(0.8f).setStepSound(soundClothFootstep);
        plantYellow = (BlockFlower)new BlockFlower(37, 13).setHardness(0.0f).setStepSound(soundGrassFootstep);
        plantRed = (BlockFlower)new BlockFlower(38, 12).setHardness(0.0f).setStepSound(soundGrassFootstep);
        mushroomBrown = (BlockFlower)new BlockMushroom(39, 29).setHardness(0.0f).setStepSound(soundGrassFootstep).setLightValue(0.125f);
        mushroomRed = (BlockFlower)new BlockMushroom(40, 28).setHardness(0.0f).setStepSound(soundGrassFootstep);
        blockGold = new BlockOreBlock(41, 39).setHardness(3.0f).setResistance(10.0f).setStepSound(soundMetalFootstep);
        blockSteel = new BlockOreBlock(42, 38).setHardness(5.0f).setResistance(10.0f).setStepSound(soundMetalFootstep);
        stairDouble = new BlockStep(43, true).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep);
        stairSingle = new BlockStep(44, false).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep);
        brick = new Block(45, 7, Material.rock).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep);
        tnt = new BlockTNT(46, 8).setHardness(0.0f).setStepSound(soundGrassFootstep);
        bookShelf = new BlockBookshelf(47, 35).setHardness(1.5f).setStepSound(soundWoodFootstep);
        cobblestoneMossy = new Block(48, 36, Material.rock).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep);
        obsidian = new BlockObsidian(49, 37).setHardness(10.0f).setResistance(2000.0f).setStepSound(soundStoneFootstep);
        torchWood = new BlockTorch(50, 80).setHardness(0.0f).setLightValue(0.9375f).setStepSound(soundWoodFootstep);
        fire = (BlockFire)new BlockFire(51, 31).setHardness(0.0f).setLightValue(1.0f).setStepSound(soundWoodFootstep);
        mobSpawner = new BlockMobSpawner(52, 65).setHardness(5.0f).setStepSound(soundMetalFootstep);
        stairCompactPlanks = new BlockStairs(53, planks);
        crate = new BlockChest(54).setHardness(2.5f).setStepSound(soundWoodFootstep);
        redstoneWire = new BlockRedstoneWire(55, 84).setHardness(0.0f).setStepSound(soundPowderFootstep);
        oreDiamond = new BlockOre(56, 50).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep);
        blockDiamond = new BlockOreBlock(57, 40).setHardness(5.0f).setResistance(10.0f).setStepSound(soundMetalFootstep);
        workbench = new BlockWorkbench(58).setHardness(2.5f).setStepSound(soundWoodFootstep);
        crops = new BlockCrops(59, 88).setHardness(0.0f).setStepSound(soundGrassFootstep);
        tilledField = new BlockSoil(60).setHardness(0.6f).setStepSound(soundGravelFootstep);
        stoneOvenIdle = new BlockFurnace(61, false).setHardness(3.5f).setStepSound(soundStoneFootstep);
        stoneOvenActive = new BlockFurnace(62, true).setHardness(3.5f).setStepSound(soundStoneFootstep).setLightValue(0.875f);
        signPost = new BlockSign(63, TileEntitySign.class, true).setHardness(1.0f).setStepSound(soundWoodFootstep);
        doorWood = new BlockDoor(64, Material.wood).setHardness(3.0f).setStepSound(soundWoodFootstep);
        ladder = new BlockLadder(65, 83).setHardness(0.4f).setStepSound(soundWoodFootstep);
        minecartTrack = new BlockMinecartTrack(66, 128).setHardness(0.7f).setStepSound(soundMetalFootstep);
        stairCompactCobblestone = new BlockStairs(67, cobblestone);
        signWall = new BlockSign(68, TileEntitySign.class, false).setHardness(1.0f).setStepSound(soundWoodFootstep);
        lever = new BlockLever(69, 96).setHardness(0.5f).setStepSound(soundWoodFootstep);
        pressurePlateStone = new BlockPressurePlate(70, Block.stone.blockIndexInTexture, EnumMobType.mobs).setHardness(0.5f).setStepSound(soundStoneFootstep);
        doorSteel = new BlockDoor(71, Material.iron).setHardness(5.0f).setStepSound(soundMetalFootstep);
        pressurePlatePlanks = new BlockPressurePlate(72, Block.planks.blockIndexInTexture, EnumMobType.everything).setHardness(0.5f).setStepSound(soundWoodFootstep);
        oreRedstone = new BlockRedstoneOre(73, 51, false).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep);
        oreRedstoneGlowing = new BlockRedstoneOre(74, 51, true).setLightValue(0.625f).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep);
        torchRedstoneIdle = new BlockRedstoneTorch(75, 115, false).setHardness(0.0f).setStepSound(soundWoodFootstep);
        torchRedstoneActive = new BlockRedstoneTorch(76, 99, true).setHardness(0.0f).setLightValue(0.5f).setStepSound(soundWoodFootstep);
        button = new BlockButton(77, Block.stone.blockIndexInTexture).setHardness(0.5f).setStepSound(soundStoneFootstep);
        snow = new BlockSnow(78, 66).setHardness(0.1f).setStepSound(soundClothFootstep);
        blockIce = new BlockIce(79, 67).setHardness(0.5f).setLightOpacity(3).setStepSound(soundGlassFootstep);
        blockSnow = new BlockSnowBlock(80, 66).setHardness(0.2f).setStepSound(soundClothFootstep);
        cactus = new BlockCactus(81, 70).setHardness(0.4f).setStepSound(soundClothFootstep);
        blockClay = new BlockClay(82, 72).setHardness(0.6f).setStepSound(soundGravelFootstep);
        reed = new BlockReed(83, 73).setHardness(0.0f).setStepSound(soundGrassFootstep);
        jukebox = new BlockJukeBox(84, 74).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep);
        fence = new BlockFence(85, 4).setHardness(2.0f).setResistance(5.0f).setStepSound(soundWoodFootstep);
        pumpkin = new BlockPumpkin(86, 102, false).setHardness(1.0f).setStepSound(soundWoodFootstep);
        bloodStone = new BlockBloodStone(87, 103).setHardness(0.4f).setStepSound(soundStoneFootstep);
        slowSand = new BlockSlowSand(88, 104).setHardness(0.5f).setStepSound(soundSandFootstep);
        lightStone = new BlockLightStone(89, 105, Material.glass).setHardness(0.3f).setStepSound(soundGlassFootstep).setLightValue(1.0f);
        portal = (BlockPortal)new BlockPortal(90, 14).setHardness(-1.0f).setStepSound(soundGlassFootstep).setLightValue(0.75f);
        pumpkinLantern = new BlockPumpkin(91, 102, true).setHardness(1.0f).setStepSound(soundWoodFootstep).setLightValue(1.0f);
        for (int i2 = 0; i2 < 256; ++i2) {
            if (blocksList[i2] == null) continue;
            Item.itemsList[i2] = new ItemBlock(i2 - 256);
        }
    }

    protected Block(int i2, Material material) {
        if (blocksList[i2] != null) {
            throw new IllegalArgumentException("Slot " + i2 + " is already occupied by " + blocksList[i2] + " when adding " + this);
        }
        this.blockMaterial = material;
        Block.blocksList[i2] = this;
        this.blockID = i2;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        Block.opaqueCubeLookup[i2] = this.isOpaqueCube();
        Block.lightOpacity[i2] = this.isOpaqueCube() ? 255 : 0;
        Block.field_340_s[i2] = this.unusedMethod();
        Block.isBlockContainer[i2] = false;
    }

    protected Block(int i2, int j2, Material material) {
        this(i2, material);
        this.blockIndexInTexture = j2;
    }

    protected Block setStepSound(StepSound stepsound) {
        this.stepSound = stepsound;
        return this;
    }

    protected Block setLightOpacity(int i2) {
        Block.lightOpacity[this.blockID] = i2;
        return this;
    }

    protected Block setLightValue(float f2) {
        Block.lightValue[this.blockID] = (int)(15.0f * f2);
        return this;
    }

    protected Block setResistance(float f2) {
        this.blockResistance = f2 * 3.0f;
        return this;
    }

    private boolean unusedMethod() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return true;
    }

    public int getRenderType() {
        return 0;
    }

    protected Block setHardness(float f2) {
        this.blockHardness = f2;
        if (this.blockResistance < f2 * 5.0f) {
            this.blockResistance = f2 * 5.0f;
        }
        return this;
    }

    protected void setTickOnLoad(boolean flag) {
        Block.tickOnLoad[this.blockID] = flag;
    }

    public void setBlockBounds(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.minX = f2;
        this.minY = f1;
        this.minZ = f22;
        this.maxX = f3;
        this.maxY = f4;
        this.maxZ = f5;
    }

    public float getBlockBrightness(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        return iblockaccess.getLightBrightness(i2, j2, k2);
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        if (l2 == 0 && this.minY > 0.0) {
            return true;
        }
        if (l2 == 1 && this.maxY < 1.0) {
            return true;
        }
        if (l2 == 2 && this.minZ > 0.0) {
            return true;
        }
        if (l2 == 3 && this.maxZ < 1.0) {
            return true;
        }
        if (l2 == 4 && this.minX > 0.0) {
            return true;
        }
        if (l2 == 5 && this.maxX < 1.0) {
            return true;
        }
        return !iblockaccess.isBlockOpaqueCube(i2, j2, k2);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return this.getBlockTextureFromSideAndMetadata(l2, iblockaccess.getBlockMetadata(i2, j2, k2));
    }

    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        return this.getBlockTextureFromSide(i2);
    }

    public int getBlockTextureFromSide(int i2) {
        return this.blockIndexInTexture;
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return AxisAlignedBB.getBoundingBoxFromPool((double)i2 + this.minX, (double)j2 + this.minY, (double)k2 + this.minZ, (double)i2 + this.maxX, (double)j2 + this.maxY, (double)k2 + this.maxZ);
    }

    public void getCollidingBoundingBoxes(World world, int i2, int j2, int k2, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(world, i2, j2, k2);
        if (axisalignedbb1 != null && axisalignedbb.intersectsWith(axisalignedbb1)) {
            arraylist.add(axisalignedbb1);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return AxisAlignedBB.getBoundingBoxFromPool((double)i2 + this.minX, (double)j2 + this.minY, (double)k2 + this.minZ, (double)i2 + this.maxX, (double)j2 + this.maxY, (double)k2 + this.maxZ);
    }

    public boolean isOpaqueCube() {
        return true;
    }

    public boolean canCollideCheck(int i2, boolean flag) {
        return this.isCollidable();
    }

    public boolean isCollidable() {
        return true;
    }

    public void updateTick(World world, int i2, int j2, int k2, Random random) {
    }

    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
    }

    public void onBlockDestroyedByPlayer(World world, int i2, int j2, int k2, int l2) {
    }

    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
    }

    public int tickRate() {
        return 10;
    }

    public void onBlockAdded(World world, int i2, int j2, int k2) {
    }

    public void onBlockRemoval(World world, int i2, int j2, int k2) {
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public int idDropped(int i2, Random random) {
        return this.blockID;
    }

    public float func_225_a(EntityPlayer entityplayer) {
        if (this.blockHardness < 0.0f) {
            return 0.0f;
        }
        if (!entityplayer.canHarvestBlock(this)) {
            return 1.0f / this.blockHardness / 100.0f;
        }
        return entityplayer.getCurrentPlayerStrVsBlock(this) / this.blockHardness / 30.0f;
    }

    public void dropBlockAsItem(World world, int i2, int j2, int k2, int l2) {
        this.dropBlockAsItemWithChance(world, i2, j2, k2, l2, 1.0f);
    }

    public void dropBlockAsItemWithChance(World world, int i2, int j2, int k2, int l2, float f2) {
        if (world.multiplayerWorld) {
            return;
        }
        int i1 = this.quantityDropped(world.rand);
        for (int j1 = 0; j1 < i1; ++j1) {
            int k1;
            if (world.rand.nextFloat() > f2 || (k1 = this.idDropped(l2, world.rand)) <= 0) continue;
            float f1 = 0.7f;
            double d2 = (double)(world.rand.nextFloat() * f1) + (double)(1.0f - f1) * 0.5;
            double d1 = (double)(world.rand.nextFloat() * f1) + (double)(1.0f - f1) * 0.5;
            double d22 = (double)(world.rand.nextFloat() * f1) + (double)(1.0f - f1) * 0.5;
            EntityItem entityitem = new EntityItem(world, (double)i2 + d2, (double)j2 + d1, (double)k2 + d22, new ItemStack(k1));
            entityitem.field_805_c = 10;
            world.entityJoinedWorld(entityitem);
        }
    }

    public float func_227_a(Entity entity) {
        return this.blockResistance / 5.0f;
    }

    public MovingObjectPosition collisionRayTrace(World world, int i2, int j2, int k2, Vec3D vec3d, Vec3D vec3d1) {
        this.setBlockBoundsBasedOnState(world, i2, j2, k2);
        vec3d = vec3d.addVector(-i2, -j2, -k2);
        vec3d1 = vec3d1.addVector(-i2, -j2, -k2);
        Vec3D vec3d2 = vec3d.getIntermediateWithXValue(vec3d1, this.minX);
        Vec3D vec3d3 = vec3d.getIntermediateWithXValue(vec3d1, this.maxX);
        Vec3D vec3d4 = vec3d.getIntermediateWithYValue(vec3d1, this.minY);
        Vec3D vec3d5 = vec3d.getIntermediateWithYValue(vec3d1, this.maxY);
        Vec3D vec3d6 = vec3d.getIntermediateWithZValue(vec3d1, this.minZ);
        Vec3D vec3d7 = vec3d.getIntermediateWithZValue(vec3d1, this.maxZ);
        if (!this.isVecInsideYZBounds(vec3d2)) {
            vec3d2 = null;
        }
        if (!this.isVecInsideYZBounds(vec3d3)) {
            vec3d3 = null;
        }
        if (!this.isVecInsideXZBounds(vec3d4)) {
            vec3d4 = null;
        }
        if (!this.isVecInsideXZBounds(vec3d5)) {
            vec3d5 = null;
        }
        if (!this.isVecInsideXYBounds(vec3d6)) {
            vec3d6 = null;
        }
        if (!this.isVecInsideXYBounds(vec3d7)) {
            vec3d7 = null;
        }
        Vec3D vec3d8 = null;
        if (vec3d2 != null && (vec3d8 == null || vec3d.distanceTo(vec3d2) < vec3d.distanceTo(vec3d8))) {
            vec3d8 = vec3d2;
        }
        if (vec3d3 != null && (vec3d8 == null || vec3d.distanceTo(vec3d3) < vec3d.distanceTo(vec3d8))) {
            vec3d8 = vec3d3;
        }
        if (vec3d4 != null && (vec3d8 == null || vec3d.distanceTo(vec3d4) < vec3d.distanceTo(vec3d8))) {
            vec3d8 = vec3d4;
        }
        if (vec3d5 != null && (vec3d8 == null || vec3d.distanceTo(vec3d5) < vec3d.distanceTo(vec3d8))) {
            vec3d8 = vec3d5;
        }
        if (vec3d6 != null && (vec3d8 == null || vec3d.distanceTo(vec3d6) < vec3d.distanceTo(vec3d8))) {
            vec3d8 = vec3d6;
        }
        if (vec3d7 != null && (vec3d8 == null || vec3d.distanceTo(vec3d7) < vec3d.distanceTo(vec3d8))) {
            vec3d8 = vec3d7;
        }
        if (vec3d8 == null) {
            return null;
        }
        int byte0 = -1;
        if (vec3d8 == vec3d2) {
            byte0 = 4;
        }
        if (vec3d8 == vec3d3) {
            byte0 = 5;
        }
        if (vec3d8 == vec3d4) {
            byte0 = 0;
        }
        if (vec3d8 == vec3d5) {
            byte0 = 1;
        }
        if (vec3d8 == vec3d6) {
            byte0 = 2;
        }
        if (vec3d8 == vec3d7) {
            byte0 = 3;
        }
        return new MovingObjectPosition(i2, j2, k2, byte0, vec3d8.addVector(i2, j2, k2));
    }

    private boolean isVecInsideYZBounds(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.yCoord >= this.minY && vec3d.yCoord <= this.maxY && vec3d.zCoord >= this.minZ && vec3d.zCoord <= this.maxZ;
    }

    private boolean isVecInsideXZBounds(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.xCoord >= this.minX && vec3d.xCoord <= this.maxX && vec3d.zCoord >= this.minZ && vec3d.zCoord <= this.maxZ;
    }

    private boolean isVecInsideXYBounds(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.xCoord >= this.minX && vec3d.xCoord <= this.maxX && vec3d.yCoord >= this.minY && vec3d.yCoord <= this.maxY;
    }

    public void onBlockDestroyedByExplosion(World world, int i2, int j2, int k2) {
    }

    public int func_234_g() {
        return 0;
    }

    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockId(i2, j2, k2);
        return l2 == 0 || Block.blocksList[l2].blockMaterial.getIsLiquid();
    }

    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        return false;
    }

    public void onEntityWalking(World world, int i2, int j2, int k2, Entity entity) {
    }

    public void onBlockPlaced(World world, int i2, int j2, int k2, int l2) {
    }

    public void onBlockClicked(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
    }

    public void velocityToAddToEntity(World world, int i2, int j2, int k2, Entity entity, Vec3D vec3d) {
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        return 0xFFFFFF;
    }

    public boolean isPoweringTo(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return false;
    }

    public boolean canProvidePower() {
        return false;
    }

    public void onEntityCollidedWithBlock(World world, int i2, int j2, int k2, Entity entity) {
    }

    public boolean isIndirectlyPoweringTo(World world, int i2, int j2, int k2, int l2) {
        return false;
    }

    public void func_237_e() {
    }

    public void harvestBlock(World world, int i2, int j2, int k2, int l2) {
        this.dropBlockAsItem(world, i2, j2, k2, l2);
    }

    public boolean canBlockStay(World world, int i2, int j2, int k2) {
        return true;
    }

    public void onBlockPlacedBy(World world, int i2, int j2, int k2, EntityLiving entityliving) {
    }

    static Class _mthclass$(String s2) {
        try {
            return Class.forName(s2);
        }
        catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}

