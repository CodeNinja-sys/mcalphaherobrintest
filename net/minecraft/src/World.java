/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluids;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCache;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkProviderLoadOrGenerate;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.Explosion;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.IWorldAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MetadataChunkBlock;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NextTickListEntry;
import net.minecraft.src.PathEntity;
import net.minecraft.src.Pathfinder;
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.TileEntity;
import net.minecraft.src.Vec3D;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldProviderHell;

public class World
implements IBlockAccess {
    public boolean field_4214_a = false;
    private List field_1051_z = new ArrayList();
    public List loadedEntityList = new ArrayList();
    private List field_1024_A = new ArrayList();
    private TreeSet scheduledTickTreeSet = new TreeSet();
    private Set scheduledTickSet = new HashSet();
    public List loadedTileEntityList = new ArrayList();
    public List playerEntities = new ArrayList();
    public long worldTime = 0L;
    private long field_1019_F = 0xFFFFFFL;
    public int skylightSubtracted = 0;
    protected int field_9437_g = new Random().nextInt();
    protected int field_9436_h = 1013904223;
    public boolean field_1043_h = false;
    private long field_1054_E = System.currentTimeMillis();
    protected int autosavePeriod = 40;
    public int difficultySetting;
    public Random rand = new Random();
    public int spawnX;
    public int spawnY;
    public int spawnZ;
    public boolean field_1033_r = false;
    public final WorldProvider worldProvider;
    protected List worldAccesses = new ArrayList();
    private IChunkProvider chunkProvider;
    public File field_9433_s;
    public File field_9432_t;
    public long randomSeed = 0L;
    private NBTTagCompound nbtCompoundPlayer;
    public long sizeOnDisk = 0L;
    public final String field_9431_w;
    public boolean field_9430_x;
    private ArrayList field_9428_I = new ArrayList();
    private int field_4204_J = 0;
    static int field_9429_y = 0;
    private Set field_9427_K = new HashSet();
    private int field_9426_L = this.rand.nextInt(12000);
    private List field_1012_M = new ArrayList();
    public boolean multiplayerWorld = false;

    public static NBTTagCompound func_629_a(File file, String s2) {
        File file1 = new File(file, "saves");
        File file2 = new File(file1, s2);
        if (!file2.exists()) {
            return null;
        }
        File file3 = new File(file2, "level.dat");
        if (file3.exists()) {
            try {
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_1138_a(new FileInputStream(file3));
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("Data");
                return nbttagcompound1;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public static void deleteWorld(File file, String s2) {
        File file1 = new File(file, "saves");
        File file2 = new File(file1, s2);
        if (!file2.exists()) {
            return;
        }
        World.deleteFiles(file2.listFiles());
        file2.delete();
    }

    private static void deleteFiles(File[] afile) {
        for (int i2 = 0; i2 < afile.length; ++i2) {
            if (afile[i2].isDirectory()) {
                World.deleteFiles(afile[i2].listFiles());
            }
            afile[i2].delete();
        }
    }

    @Override
    public WorldChunkManager func_4075_a() {
        return this.worldProvider.worldChunkMgr;
    }

    public World(File file, String s2) {
        this(file, s2, new Random().nextLong());
    }

    public World(String s2, WorldProvider worldprovider, long l2) {
        this.field_9431_w = s2;
        this.randomSeed = l2;
        this.worldProvider = worldprovider;
        worldprovider.registerWorld(this);
        this.chunkProvider = this.func_4081_a(this.field_9432_t);
        this.calculateInitialSkylight();
    }

    public World(World world, WorldProvider worldprovider) {
        this.field_1054_E = world.field_1054_E;
        this.field_9433_s = world.field_9433_s;
        this.field_9432_t = world.field_9432_t;
        this.field_9431_w = world.field_9431_w;
        this.randomSeed = world.randomSeed;
        this.worldTime = world.worldTime;
        this.spawnX = world.spawnX;
        this.spawnY = world.spawnY;
        this.spawnZ = world.spawnZ;
        this.sizeOnDisk = world.sizeOnDisk;
        this.worldProvider = worldprovider;
        worldprovider.registerWorld(this);
        this.chunkProvider = this.func_4081_a(this.field_9432_t);
        this.calculateInitialSkylight();
    }

    public World(File file, String s2, long l2) {
        this(file, s2, l2, null);
    }

    public World(File file, String s2, long l2, WorldProvider worldprovider) {
        this.field_9433_s = file;
        this.field_9431_w = s2;
        file.mkdirs();
        this.field_9432_t = new File(file, s2);
        this.field_9432_t.mkdirs();
        try {
            File file1 = new File(this.field_9432_t, "session.lock");
            try (DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file1));){
                dataoutputstream.writeLong(this.field_1054_E);
            }
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
        WorldProvider obj = new WorldProvider();
        File file2 = new File(this.field_9432_t, "level.dat");
        boolean bl2 = this.field_1033_r = !file2.exists();
        if (file2.exists()) {
            try {
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_1138_a(new FileInputStream(file2));
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("Data");
                this.randomSeed = nbttagcompound1.getLong("RandomSeed");
                this.spawnX = nbttagcompound1.getInteger("SpawnX");
                this.spawnY = nbttagcompound1.getInteger("SpawnY");
                this.spawnZ = nbttagcompound1.getInteger("SpawnZ");
                this.worldTime = nbttagcompound1.getLong("Time");
                this.sizeOnDisk = nbttagcompound1.getLong("SizeOnDisk");
                if (nbttagcompound1.hasKey("Player")) {
                    this.nbtCompoundPlayer = nbttagcompound1.getCompoundTag("Player");
                    int i2 = this.nbtCompoundPlayer.getInteger("Dimension");
                    if (i2 == -1) {
                        obj = new WorldProviderHell();
                    }
                }
            }
            catch (Exception exception1) {
                exception1.printStackTrace();
            }
        }
        if (worldprovider != null) {
            obj = worldprovider;
        }
        boolean flag = false;
        if (this.randomSeed == 0L) {
            this.randomSeed = l2;
            flag = true;
        }
        this.worldProvider = obj;
        this.worldProvider.registerWorld(this);
        this.chunkProvider = this.func_4081_a(this.field_9432_t);
        if (flag) {
            this.field_9430_x = true;
            this.spawnX = 0;
            this.spawnY = 64;
            this.spawnZ = 0;
            while (!this.worldProvider.canCoordinateBeSpawn(this.spawnX, this.spawnZ)) {
                this.spawnX += this.rand.nextInt(64) - this.rand.nextInt(64);
                this.spawnZ += this.rand.nextInt(64) - this.rand.nextInt(64);
            }
            this.field_9430_x = false;
        }
        this.calculateInitialSkylight();
    }

    protected IChunkProvider func_4081_a(File file) {
        return new ChunkProviderLoadOrGenerate(this, this.worldProvider.getChunkLoader(file), this.worldProvider.getChunkProvider());
    }

    public void func_4076_b() {
        if (this.spawnY <= 0) {
            this.spawnY = 64;
        }
        while (this.func_614_g(this.spawnX, this.spawnZ) == 0) {
            this.spawnX += this.rand.nextInt(8) - this.rand.nextInt(8);
            this.spawnZ += this.rand.nextInt(8) - this.rand.nextInt(8);
        }
    }

    public int func_614_g(int i2, int j2) {
        int k2 = 63;
        while (this.getBlockId(i2, k2 + 1, j2) != 0) {
            ++k2;
        }
        return this.getBlockId(i2, k2, j2);
    }

    public void func_6464_c() {
    }

    public void func_608_a(EntityPlayer entityplayer) {
        try {
            if (this.nbtCompoundPlayer != null) {
                entityplayer.readFromNBT(this.nbtCompoundPlayer);
                this.nbtCompoundPlayer = null;
            }
            this.entityJoinedWorld(entityplayer);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void saveWorld(boolean flag, IProgressUpdate iprogressupdate) {
        if (!this.chunkProvider.func_536_b()) {
            return;
        }
        if (iprogressupdate != null) {
            iprogressupdate.func_594_b("Saving level");
        }
        this.saveLevel();
        if (iprogressupdate != null) {
            iprogressupdate.displayLoadingString("Saving chunks");
        }
        this.chunkProvider.saveChunks(flag, iprogressupdate);
    }

    private void saveLevel() {
        this.func_663_l();
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setLong("RandomSeed", this.randomSeed);
        nbttagcompound.setInteger("SpawnX", this.spawnX);
        nbttagcompound.setInteger("SpawnY", this.spawnY);
        nbttagcompound.setInteger("SpawnZ", this.spawnZ);
        nbttagcompound.setLong("Time", this.worldTime);
        nbttagcompound.setLong("SizeOnDisk", this.sizeOnDisk);
        nbttagcompound.setLong("LastPlayed", System.currentTimeMillis());
        EntityPlayer entityplayer = null;
        if (this.playerEntities.size() > 0) {
            entityplayer = (EntityPlayer)this.playerEntities.get(0);
        }
        if (entityplayer != null) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            entityplayer.writeToNBT(nbttagcompound1);
            nbttagcompound.setCompoundTag("Player", nbttagcompound1);
        }
        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
        nbttagcompound2.setTag("Data", nbttagcompound);
        try {
            File file = new File(this.field_9432_t, "level.dat_new");
            File file1 = new File(this.field_9432_t, "level.dat_old");
            File file2 = new File(this.field_9432_t, "level.dat");
            CompressedStreamTools.writeGzippedCompoundToOutputStream(nbttagcompound2, new FileOutputStream(file));
            if (file1.exists()) {
                file1.delete();
            }
            file2.renameTo(file1);
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public boolean func_650_a(int i2) {
        if (!this.chunkProvider.func_536_b()) {
            return true;
        }
        if (i2 == 0) {
            this.saveLevel();
        }
        return this.chunkProvider.saveChunks(false, null);
    }

    @Override
    public int getBlockId(int i2, int j2, int k2) {
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return 0;
        }
        if (j2 < 0) {
            return 0;
        }
        if (j2 >= 128) {
            return 0;
        }
        return this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4).getBlockID(i2 & 0xF, j2, k2 & 0xF);
    }

    public boolean blockExists(int i2, int j2, int k2) {
        if (j2 < 0 || j2 >= 128) {
            return false;
        }
        return this.chunkExists(i2 >> 4, k2 >> 4);
    }

    public boolean checkChunksExist(int i2, int j2, int k2, int l2, int i1, int j1) {
        if (i1 < 0 || j2 >= 128) {
            return false;
        }
        j2 >>= 4;
        k2 >>= 4;
        i1 >>= 4;
        j1 >>= 4;
        for (int k1 = i2 >>= 4; k1 <= (l2 >>= 4); ++k1) {
            for (int l1 = k2; l1 <= j1; ++l1) {
                if (this.chunkExists(k1, l1)) continue;
                return false;
            }
        }
        return true;
    }

    private boolean chunkExists(int i2, int j2) {
        return this.chunkProvider.chunkExists(i2, j2);
    }

    public Chunk getChunkFromBlockCoords(int i2, int j2) {
        return this.getChunkFromChunkCoords(i2 >> 4, j2 >> 4);
    }

    public Chunk getChunkFromChunkCoords(int i2, int j2) {
        return this.chunkProvider.provideChunk(i2, j2);
    }

    public boolean setBlockAndMetadata(int i2, int j2, int k2, int l2, int i1) {
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return false;
        }
        if (j2 < 0) {
            return false;
        }
        if (j2 >= 128) {
            return false;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        return chunk.setBlockIDWithMetadata(i2 & 0xF, j2, k2 & 0xF, l2, i1);
    }

    public boolean setBlock(int i2, int j2, int k2, int l2) {
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return false;
        }
        if (j2 < 0) {
            return false;
        }
        if (j2 >= 128) {
            return false;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        return chunk.setBlockID(i2 & 0xF, j2, k2 & 0xF, l2);
    }

    @Override
    public Material getBlockMaterial(int i2, int j2, int k2) {
        int l2 = this.getBlockId(i2, j2, k2);
        if (l2 == 0) {
            return Material.air;
        }
        return Block.blocksList[l2].blockMaterial;
    }

    @Override
    public int getBlockMetadata(int i2, int j2, int k2) {
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return 0;
        }
        if (j2 < 0) {
            return 0;
        }
        if (j2 >= 128) {
            return 0;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        return chunk.getBlockMetadata(i2 &= 0xF, j2, k2 &= 0xF);
    }

    public void setBlockMetadataWithNotify(int i2, int j2, int k2, int l2) {
        if (this.setBlockMetadata(i2, j2, k2, l2)) {
            this.notifyBlockChange(i2, j2, k2, this.getBlockId(i2, j2, k2));
        }
    }

    public boolean setBlockMetadata(int i2, int j2, int k2, int l2) {
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return false;
        }
        if (j2 < 0) {
            return false;
        }
        if (j2 >= 128) {
            return false;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        chunk.setBlockMetadata(i2 &= 0xF, j2, k2 &= 0xF, l2);
        return true;
    }

    public boolean setBlockWithNotify(int i2, int j2, int k2, int l2) {
        if (this.setBlock(i2, j2, k2, l2)) {
            this.notifyBlockChange(i2, j2, k2, l2);
            return true;
        }
        return false;
    }

    public boolean setBlockAndMetadataWithNotify(int i2, int j2, int k2, int l2, int i1) {
        if (this.setBlockAndMetadata(i2, j2, k2, l2, i1)) {
            this.notifyBlockChange(i2, j2, k2, l2);
            return true;
        }
        return false;
    }

    public void func_665_h(int i2, int j2, int k2) {
        for (int l2 = 0; l2 < this.worldAccesses.size(); ++l2) {
            ((IWorldAccess)this.worldAccesses.get(l2)).func_934_a(i2, j2, k2);
        }
    }

    protected void notifyBlockChange(int i2, int j2, int k2, int l2) {
        this.func_665_h(i2, j2, k2);
        this.notifyBlocksOfNeighborChange(i2, j2, k2, l2);
    }

    public void func_680_f(int i2, int j2, int k2, int l2) {
        if (k2 > l2) {
            int i1 = l2;
            l2 = k2;
            k2 = i1;
        }
        this.func_701_b(i2, k2, j2, i2, l2, j2);
    }

    public void func_701_b(int i2, int j2, int k2, int l2, int i1, int j1) {
        for (int k1 = 0; k1 < this.worldAccesses.size(); ++k1) {
            ((IWorldAccess)this.worldAccesses.get(k1)).func_937_b(i2, j2, k2, l2, i1, j1);
        }
    }

    public void notifyBlocksOfNeighborChange(int i2, int j2, int k2, int l2) {
        this.notifyBlockOfNeighborChange(i2 - 1, j2, k2, l2);
        this.notifyBlockOfNeighborChange(i2 + 1, j2, k2, l2);
        this.notifyBlockOfNeighborChange(i2, j2 - 1, k2, l2);
        this.notifyBlockOfNeighborChange(i2, j2 + 1, k2, l2);
        this.notifyBlockOfNeighborChange(i2, j2, k2 - 1, l2);
        this.notifyBlockOfNeighborChange(i2, j2, k2 + 1, l2);
    }

    private void notifyBlockOfNeighborChange(int i2, int j2, int k2, int l2) {
        if (this.field_1043_h || this.multiplayerWorld) {
            return;
        }
        Block block = Block.blocksList[this.getBlockId(i2, j2, k2)];
        if (block != null) {
            block.onNeighborBlockChange(this, i2, j2, k2, l2);
        }
    }

    public boolean canBlockSeeTheSky(int i2, int j2, int k2) {
        return this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4).canBlockSeeTheSky(i2 & 0xF, j2, k2 & 0xF);
    }

    public int getBlockLightValue(int i2, int j2, int k2) {
        return this.getBlockLightValue(i2, j2, k2, true);
    }

    public int getBlockLightValue(int i2, int j2, int k2, boolean flag) {
        int l2;
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return 15;
        }
        if (flag && ((l2 = this.getBlockId(i2, j2, k2)) == Block.stairSingle.blockID || l2 == Block.tilledField.blockID)) {
            int j1 = this.getBlockLightValue(i2, j2 + 1, k2, false);
            int k1 = this.getBlockLightValue(i2 + 1, j2, k2, false);
            int l1 = this.getBlockLightValue(i2 - 1, j2, k2, false);
            int i22 = this.getBlockLightValue(i2, j2, k2 + 1, false);
            int j22 = this.getBlockLightValue(i2, j2, k2 - 1, false);
            if (k1 > j1) {
                j1 = k1;
            }
            if (l1 > j1) {
                j1 = l1;
            }
            if (i22 > j1) {
                j1 = i22;
            }
            if (j22 > j1) {
                j1 = j22;
            }
            return j1;
        }
        if (j2 < 0) {
            return 0;
        }
        if (j2 >= 128) {
            int i1 = 15 - this.skylightSubtracted;
            if (i1 < 0) {
                i1 = 0;
            }
            return i1;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        return chunk.getBlockLightValue(i2 &= 0xF, j2, k2 &= 0xF, this.skylightSubtracted);
    }

    public boolean canExistingBlockSeeTheSky(int i2, int j2, int k2) {
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return false;
        }
        if (j2 < 0) {
            return false;
        }
        if (j2 >= 128) {
            return true;
        }
        if (!this.chunkExists(i2 >> 4, k2 >> 4)) {
            return false;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        return chunk.canBlockSeeTheSky(i2 &= 0xF, j2, k2 &= 0xF);
    }

    public int getHeightValue(int i2, int j2) {
        if (i2 < -32000000 || j2 < -32000000 || i2 >= 32000000 || j2 > 32000000) {
            return 0;
        }
        if (!this.chunkExists(i2 >> 4, j2 >> 4)) {
            return 0;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, j2 >> 4);
        return chunk.getHeightValue(i2 & 0xF, j2 & 0xF);
    }

    public void neighborLightPropagationChanged(EnumSkyBlock enumskyblock, int i2, int j2, int k2, int l2) {
        int i1;
        if (this.worldProvider.field_6478_e && enumskyblock == EnumSkyBlock.Sky) {
            return;
        }
        if (!this.blockExists(i2, j2, k2)) {
            return;
        }
        if (enumskyblock == EnumSkyBlock.Sky) {
            if (this.canExistingBlockSeeTheSky(i2, j2, k2)) {
                l2 = 15;
            }
        } else if (enumskyblock == EnumSkyBlock.Block && Block.lightValue[i1 = this.getBlockId(i2, j2, k2)] > l2) {
            l2 = Block.lightValue[i1];
        }
        if (this.getSavedLightValue(enumskyblock, i2, j2, k2) != l2) {
            this.func_616_a(enumskyblock, i2, j2, k2, i2, j2, k2);
        }
    }

    public int getSavedLightValue(EnumSkyBlock enumskyblock, int i2, int j2, int k2) {
        if (j2 < 0 || j2 >= 128 || i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return enumskyblock.field_1722_c;
        }
        int l2 = i2 >> 4;
        int i1 = k2 >> 4;
        if (!this.chunkExists(l2, i1)) {
            return 0;
        }
        Chunk chunk = this.getChunkFromChunkCoords(l2, i1);
        return chunk.getSavedLightValue(enumskyblock, i2 & 0xF, j2, k2 & 0xF);
    }

    public void setLightValue(EnumSkyBlock enumskyblock, int i2, int j2, int k2, int l2) {
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return;
        }
        if (j2 < 0) {
            return;
        }
        if (j2 >= 128) {
            return;
        }
        if (!this.chunkExists(i2 >> 4, k2 >> 4)) {
            return;
        }
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        chunk.setLightValue(enumskyblock, i2 & 0xF, j2, k2 & 0xF, l2);
        for (int i1 = 0; i1 < this.worldAccesses.size(); ++i1) {
            ((IWorldAccess)this.worldAccesses.get(i1)).func_934_a(i2, j2, k2);
        }
    }

    @Override
    public float getLightBrightness(int i2, int j2, int k2) {
        return this.worldProvider.lightBrightnessTable[this.getBlockLightValue(i2, j2, k2)];
    }

    public boolean isDaytime() {
        return this.skylightSubtracted < 4;
    }

    public MovingObjectPosition rayTraceBlocks(Vec3D vec3d, Vec3D vec3d1) {
        return this.rayTraceBlocks(vec3d, vec3d1, false);
    }

    public MovingObjectPosition rayTraceBlocks(Vec3D vec3d, Vec3D vec3d1, boolean flag) {
        if (Double.isNaN(vec3d.xCoord) || Double.isNaN(vec3d.yCoord) || Double.isNaN(vec3d.zCoord)) {
            return null;
        }
        if (Double.isNaN(vec3d1.xCoord) || Double.isNaN(vec3d1.yCoord) || Double.isNaN(vec3d1.zCoord)) {
            return null;
        }
        int i2 = MathHelper.floor_double(vec3d1.xCoord);
        int j2 = MathHelper.floor_double(vec3d1.yCoord);
        int k2 = MathHelper.floor_double(vec3d1.zCoord);
        int l2 = MathHelper.floor_double(vec3d.xCoord);
        int i1 = MathHelper.floor_double(vec3d.yCoord);
        int j1 = MathHelper.floor_double(vec3d.zCoord);
        int k1 = 200;
        while (k1-- >= 0) {
            MovingObjectPosition movingobjectposition;
            if (Double.isNaN(vec3d.xCoord) || Double.isNaN(vec3d.yCoord) || Double.isNaN(vec3d.zCoord)) {
                return null;
            }
            if (l2 == i2 && i1 == j2 && j1 == k2) {
                return null;
            }
            double d2 = 999.0;
            double d1 = 999.0;
            double d22 = 999.0;
            if (i2 > l2) {
                d2 = (double)l2 + 1.0;
            }
            if (i2 < l2) {
                d2 = (double)l2 + 0.0;
            }
            if (j2 > i1) {
                d1 = (double)i1 + 1.0;
            }
            if (j2 < i1) {
                d1 = (double)i1 + 0.0;
            }
            if (k2 > j1) {
                d22 = (double)j1 + 1.0;
            }
            if (k2 < j1) {
                d22 = (double)j1 + 0.0;
            }
            double d3 = 999.0;
            double d4 = 999.0;
            double d5 = 999.0;
            double d6 = vec3d1.xCoord - vec3d.xCoord;
            double d7 = vec3d1.yCoord - vec3d.yCoord;
            double d8 = vec3d1.zCoord - vec3d.zCoord;
            if (d2 != 999.0) {
                d3 = (d2 - vec3d.xCoord) / d6;
            }
            if (d1 != 999.0) {
                d4 = (d1 - vec3d.yCoord) / d7;
            }
            if (d22 != 999.0) {
                d5 = (d22 - vec3d.zCoord) / d8;
            }
            int byte0 = 0;
            if (d3 < d4 && d3 < d5) {
                byte0 = i2 > l2 ? 4 : 5;
                vec3d.xCoord = d2;
                vec3d.yCoord += d7 * d3;
                vec3d.zCoord += d8 * d3;
            } else if (d4 < d5) {
                byte0 = j2 > i1 ? 0 : 1;
                vec3d.xCoord += d6 * d4;
                vec3d.yCoord = d1;
                vec3d.zCoord += d8 * d4;
            } else {
                byte0 = k2 > j1 ? 2 : 3;
                vec3d.xCoord += d6 * d5;
                vec3d.yCoord += d7 * d5;
                vec3d.zCoord = d22;
            }
            Vec3D vec3d2 = Vec3D.createVector(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord);
            vec3d2.xCoord = MathHelper.floor_double(vec3d.xCoord);
            l2 = (int)vec3d2.xCoord;
            if (byte0 == 5) {
                --l2;
                vec3d2.xCoord += 1.0;
            }
            vec3d2.yCoord = MathHelper.floor_double(vec3d.yCoord);
            i1 = (int)vec3d2.yCoord;
            if (byte0 == 1) {
                --i1;
                vec3d2.yCoord += 1.0;
            }
            vec3d2.zCoord = MathHelper.floor_double(vec3d.zCoord);
            j1 = (int)vec3d2.zCoord;
            if (byte0 == 3) {
                --j1;
                vec3d2.zCoord += 1.0;
            }
            int l1 = this.getBlockId(l2, i1, j1);
            int i22 = this.getBlockMetadata(l2, i1, j1);
            Block block = Block.blocksList[l1];
            if (l1 <= 0 || !block.canCollideCheck(i22, flag) || (movingobjectposition = block.collisionRayTrace(this, l2, i1, j1, vec3d, vec3d1)) == null) continue;
            return movingobjectposition;
        }
        return null;
    }

    public void playSoundAtEntity(Entity entity, String s2, float f2, float f1) {
        for (int i2 = 0; i2 < this.worldAccesses.size(); ++i2) {
            ((IWorldAccess)this.worldAccesses.get(i2)).playSound(s2, entity.posX, entity.posY - (double)entity.yOffset, entity.posZ, f2, f1);
        }
    }

    public void playSoundEffect(double d2, double d1, double d22, String s2, float f2, float f1) {
        for (int i2 = 0; i2 < this.worldAccesses.size(); ++i2) {
            ((IWorldAccess)this.worldAccesses.get(i2)).playSound(s2, d2, d1, d22, f2, f1);
        }
    }

    public void playRecord(String s2, int i2, int j2, int k2) {
        for (int l2 = 0; l2 < this.worldAccesses.size(); ++l2) {
            ((IWorldAccess)this.worldAccesses.get(l2)).playRecord(s2, i2, j2, k2);
        }
    }

    public void spawnParticle(String s2, double d2, double d1, double d22, double d3, double d4, double d5) {
        for (int i2 = 0; i2 < this.worldAccesses.size(); ++i2) {
            ((IWorldAccess)this.worldAccesses.get(i2)).spawnParticle(s2, d2, d1, d22, d3, d4, d5);
        }
    }

    public boolean entityJoinedWorld(Entity entity) {
        int i2 = MathHelper.floor_double(entity.posX / 16.0);
        int j2 = MathHelper.floor_double(entity.posZ / 16.0);
        boolean flag = false;
        if (entity instanceof EntityPlayer) {
            flag = true;
        }
        if (flag || this.chunkExists(i2, j2)) {
            if (entity instanceof EntityPlayer) {
                this.playerEntities.add((EntityPlayer)entity);
                System.out.println("Player count: " + this.playerEntities.size());
            }
            this.getChunkFromChunkCoords(i2, j2).addEntity(entity);
            this.loadedEntityList.add(entity);
            this.obtainEntitySkin(entity);
            return true;
        }
        return false;
    }

    protected void obtainEntitySkin(Entity entity) {
        for (int i2 = 0; i2 < this.worldAccesses.size(); ++i2) {
            ((IWorldAccess)this.worldAccesses.get(i2)).obtainEntitySkin(entity);
        }
    }

    protected void releaseEntitySkin(Entity entity) {
        for (int i2 = 0; i2 < this.worldAccesses.size(); ++i2) {
            ((IWorldAccess)this.worldAccesses.get(i2)).releaseEntitySkin(entity);
        }
    }

    public void setEntityDead(Entity entity) {
        entity.setEntityDead();
        if (entity instanceof EntityPlayer) {
            this.playerEntities.remove((EntityPlayer)entity);
        }
    }

    public void addWorldAccess(IWorldAccess iworldaccess) {
        this.worldAccesses.add(iworldaccess);
    }

    public void removeWorldAccess(IWorldAccess iworldaccess) {
        this.worldAccesses.remove(iworldaccess);
    }

    public List getCollidingBoundingBoxes(Entity entity, AxisAlignedBB axisalignedbb) {
        this.field_9428_I.clear();
        int i2 = MathHelper.floor_double(axisalignedbb.minX);
        int j2 = MathHelper.floor_double(axisalignedbb.maxX + 1.0);
        int k2 = MathHelper.floor_double(axisalignedbb.minY);
        int l2 = MathHelper.floor_double(axisalignedbb.maxY + 1.0);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0);
        for (int k1 = i2; k1 < j2; ++k1) {
            for (int l1 = i1; l1 < j1; ++l1) {
                if (!this.blockExists(k1, 64, l1)) continue;
                for (int i22 = k2 - 1; i22 < l2; ++i22) {
                    Block block = Block.blocksList[this.getBlockId(k1, i22, l1)];
                    if (block == null) continue;
                    block.getCollidingBoundingBoxes(this, k1, i22, l1, axisalignedbb, this.field_9428_I);
                }
            }
        }
        double d2 = 0.25;
        List list = this.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb.expands(d2, d2, d2));
        for (int j22 = 0; j22 < list.size(); ++j22) {
            AxisAlignedBB axisalignedbb1 = ((Entity)list.get(j22)).func_372_f_();
            if (axisalignedbb1 != null && axisalignedbb1.intersectsWith(axisalignedbb)) {
                this.field_9428_I.add(axisalignedbb1);
            }
            if ((axisalignedbb1 = entity.func_383_b_((Entity)list.get(j22))) == null || !axisalignedbb1.intersectsWith(axisalignedbb)) continue;
            this.field_9428_I.add(axisalignedbb1);
        }
        return this.field_9428_I;
    }

    public int calculateSkylightSubtracted(float f2) {
        float f1 = this.getCelestialAngle(f2);
        float f22 = 1.0f - (MathHelper.cos(f1 * 3.141593f * 2.0f) * 2.0f + 0.5f);
        if (f22 < 0.0f) {
            f22 = 0.0f;
        }
        if (f22 > 1.0f) {
            f22 = 1.0f;
        }
        return (int)(f22 * 11.0f);
    }

    public Vec3D func_4079_a(Entity entity, float f2) {
        float f1 = this.getCelestialAngle(f2);
        float f22 = MathHelper.cos(f1 * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f22 < 0.0f) {
            f22 = 0.0f;
        }
        if (f22 > 1.0f) {
            f22 = 1.0f;
        }
        int i2 = MathHelper.floor_double(entity.posX);
        int j2 = MathHelper.floor_double(entity.posZ);
        float f3 = (float)this.func_4075_a().func_4072_b(i2, j2);
        int k2 = this.func_4075_a().func_4073_a(i2, j2).getSkyColorByTemp(f3);
        float f4 = (float)(k2 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(k2 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(k2 & 0xFF) / 255.0f;
        return Vec3D.createVector(f4 *= f22, f5 *= f22, f6 *= f22);
    }

    public float getCelestialAngle(float f2) {
        return this.worldProvider.calculateCelestialAngle(this.worldTime, f2);
    }

    public Vec3D func_628_d(float f2) {
        float f1 = this.getCelestialAngle(f2);
        float f22 = MathHelper.cos(f1 * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f22 < 0.0f) {
            f22 = 0.0f;
        }
        if (f22 > 1.0f) {
            f22 = 1.0f;
        }
        float f3 = (float)(this.field_1019_F >> 16 & 0xFFL) / 255.0f;
        float f4 = (float)(this.field_1019_F >> 8 & 0xFFL) / 255.0f;
        float f5 = (float)(this.field_1019_F & 0xFFL) / 255.0f;
        return Vec3D.createVector(f3 *= f22 * 0.9f + 0.1f, f4 *= f22 * 0.9f + 0.1f, f5 *= f22 * 0.85f + 0.15f);
    }

    public Vec3D func_4082_d(float f2) {
        float f1 = this.getCelestialAngle(f2);
        return this.worldProvider.func_4096_a(f1, f2);
    }

    public int func_4083_e(int i2, int j2) {
        int k2;
        Chunk chunk = this.getChunkFromBlockCoords(i2, j2);
        for (k2 = 127; this.getBlockMaterial(i2, k2, j2).func_880_c() && k2 > 0; --k2) {
        }
        i2 &= 0xF;
        j2 &= 0xF;
        while (k2 > 0) {
            int l2 = chunk.getBlockID(i2, k2, j2);
            if (l2 == 0 || !Block.blocksList[l2].blockMaterial.func_880_c() && !Block.blocksList[l2].blockMaterial.getIsLiquid()) {
                --k2;
                continue;
            }
            return k2 + 1;
        }
        return -1;
    }

    public int func_696_e(int i2, int j2) {
        return this.getChunkFromBlockCoords(i2, j2).getHeightValue(i2 & 0xF, j2 & 0xF);
    }

    public float func_679_f(float f2) {
        float f1 = this.getCelestialAngle(f2);
        float f22 = 1.0f - (MathHelper.cos(f1 * 3.141593f * 2.0f) * 2.0f + 0.75f);
        if (f22 < 0.0f) {
            f22 = 0.0f;
        }
        if (f22 > 1.0f) {
            f22 = 1.0f;
        }
        return f22 * f22 * 0.5f;
    }

    public void scheduleBlockUpdate(int i2, int j2, int k2, int l2) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(i2, j2, k2, l2);
        int byte0 = 8;
        if (this.field_4214_a) {
            int i1;
            if (this.checkChunksExist(nextticklistentry.xCoord - byte0, nextticklistentry.yCoord - byte0, nextticklistentry.zCoord - byte0, nextticklistentry.xCoord + byte0, nextticklistentry.yCoord + byte0, nextticklistentry.zCoord + byte0) && (i1 = this.getBlockId(nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord)) == nextticklistentry.blockID && i1 > 0) {
                Block.blocksList[i1].updateTick(this, nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord, this.rand);
            }
            return;
        }
        if (this.checkChunksExist(i2 - byte0, j2 - byte0, k2 - byte0, i2 + byte0, j2 + byte0, k2 + byte0)) {
            if (l2 > 0) {
                nextticklistentry.setScheduledTime((long)Block.blocksList[l2].tickRate() + this.worldTime);
            }
            if (!this.scheduledTickSet.contains(nextticklistentry)) {
                this.scheduledTickSet.add(nextticklistentry);
                this.scheduledTickTreeSet.add(nextticklistentry);
            }
        }
    }

    public void func_633_c() {
        this.loadedEntityList.removeAll(this.field_1024_A);
        for (int i2 = 0; i2 < this.field_1024_A.size(); ++i2) {
            Entity entity = (Entity)this.field_1024_A.get(i2);
            int i1 = entity.field_657_ba;
            int k1 = entity.field_654_bc;
            if (!entity.field_621_aZ || !this.chunkExists(i1, k1)) continue;
            this.getChunkFromChunkCoords(i1, k1).func_1015_b(entity);
        }
        for (int j2 = 0; j2 < this.field_1024_A.size(); ++j2) {
            this.releaseEntitySkin((Entity)this.field_1024_A.get(j2));
        }
        this.field_1024_A.clear();
        for (int k2 = 0; k2 < this.loadedEntityList.size(); ++k2) {
            Entity entity1 = (Entity)this.loadedEntityList.get(k2);
            if (entity1.ridingEntity != null) {
                if (!entity1.ridingEntity.isDead && entity1.ridingEntity.riddenByEntity == entity1) continue;
                entity1.ridingEntity.riddenByEntity = null;
                entity1.ridingEntity = null;
            }
            if (!entity1.isDead) {
                this.func_667_e(entity1);
            }
            if (!entity1.isDead) continue;
            int j1 = entity1.field_657_ba;
            int l1 = entity1.field_654_bc;
            if (entity1.field_621_aZ && this.chunkExists(j1, l1)) {
                this.getChunkFromChunkCoords(j1, l1).func_1015_b(entity1);
            }
            this.loadedEntityList.remove(k2--);
            this.releaseEntitySkin(entity1);
        }
        for (int l2 = 0; l2 < this.loadedTileEntityList.size(); ++l2) {
            TileEntity tileentity = (TileEntity)this.loadedTileEntityList.get(l2);
            tileentity.updateEntity();
        }
    }

    public void func_667_e(Entity entity) {
        this.func_4084_a(entity, true);
    }

    public void func_4084_a(Entity entity, boolean flag) {
        int i2 = MathHelper.floor_double(entity.posX);
        int j2 = MathHelper.floor_double(entity.posZ);
        int byte0 = 16;
        if (!flag && !this.checkChunksExist(i2 - byte0, 0, j2 - byte0, i2 + byte0, 128, j2 + byte0)) {
            return;
        }
        entity.lastTickPosX = entity.posX;
        entity.lastTickPosY = entity.posY;
        entity.lastTickPosZ = entity.posZ;
        entity.prevRotationYaw = entity.rotationYaw;
        entity.prevRotationPitch = entity.rotationPitch;
        if (flag && entity.field_621_aZ) {
            if (entity.ridingEntity != null) {
                entity.func_350_p();
            } else {
                entity.onUpdate();
            }
        }
        if (Double.isNaN(entity.posX) || Double.isInfinite(entity.posX)) {
            entity.posX = entity.lastTickPosX;
        }
        if (Double.isNaN(entity.posY) || Double.isInfinite(entity.posY)) {
            entity.posY = entity.lastTickPosY;
        }
        if (Double.isNaN(entity.posZ) || Double.isInfinite(entity.posZ)) {
            entity.posZ = entity.lastTickPosZ;
        }
        if (Double.isNaN(entity.rotationPitch) || Double.isInfinite(entity.rotationPitch)) {
            entity.rotationPitch = entity.prevRotationPitch;
        }
        if (Double.isNaN(entity.rotationYaw) || Double.isInfinite(entity.rotationYaw)) {
            entity.rotationYaw = entity.prevRotationYaw;
        }
        int k2 = MathHelper.floor_double(entity.posX / 16.0);
        int l2 = MathHelper.floor_double(entity.posY / 16.0);
        int i1 = MathHelper.floor_double(entity.posZ / 16.0);
        if (!entity.field_621_aZ || entity.field_657_ba != k2 || entity.field_656_bb != l2 || entity.field_654_bc != i1) {
            if (entity.field_621_aZ && this.chunkExists(entity.field_657_ba, entity.field_654_bc)) {
                this.getChunkFromChunkCoords(entity.field_657_ba, entity.field_654_bc).func_1016_a(entity, entity.field_656_bb);
            }
            if (this.chunkExists(k2, i1)) {
                entity.field_621_aZ = true;
                this.getChunkFromChunkCoords(k2, i1).addEntity(entity);
            } else {
                entity.field_621_aZ = false;
            }
        }
        if (flag && entity.field_621_aZ && entity.riddenByEntity != null) {
            if (entity.riddenByEntity.isDead || entity.riddenByEntity.ridingEntity != entity) {
                entity.riddenByEntity.ridingEntity = null;
                entity.riddenByEntity = null;
            } else {
                this.func_667_e(entity.riddenByEntity);
            }
        }
    }

    public boolean checkIfAABBIsClear(AxisAlignedBB axisalignedbb) {
        List list = this.getEntitiesWithinAABBExcludingEntity(null, axisalignedbb);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Entity entity = (Entity)list.get(i2);
            if (entity.isDead || !entity.field_618_ad) continue;
            return false;
        }
        return true;
    }

    public boolean getIsAnyLiquid(AxisAlignedBB axisalignedbb) {
        int i2 = MathHelper.floor_double(axisalignedbb.minX);
        int j2 = MathHelper.floor_double(axisalignedbb.maxX + 1.0);
        int k2 = MathHelper.floor_double(axisalignedbb.minY);
        int l2 = MathHelper.floor_double(axisalignedbb.maxY + 1.0);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0);
        if (axisalignedbb.minX < 0.0) {
            --i2;
        }
        if (axisalignedbb.minY < 0.0) {
            --k2;
        }
        if (axisalignedbb.minZ < 0.0) {
            --i1;
        }
        for (int k1 = i2; k1 < j2; ++k1) {
            for (int l1 = k2; l1 < l2; ++l1) {
                for (int i22 = i1; i22 < j1; ++i22) {
                    Block block = Block.blocksList[this.getBlockId(k1, l1, i22)];
                    if (block == null || !block.blockMaterial.getIsLiquid()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBoundingBoxBurning(AxisAlignedBB axisalignedbb) {
        int i2 = MathHelper.floor_double(axisalignedbb.minX);
        int j2 = MathHelper.floor_double(axisalignedbb.maxX + 1.0);
        int k2 = MathHelper.floor_double(axisalignedbb.minY);
        int l2 = MathHelper.floor_double(axisalignedbb.maxY + 1.0);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0);
        for (int k1 = i2; k1 < j2; ++k1) {
            for (int l1 = k2; l1 < l2; ++l1) {
                for (int i22 = i1; i22 < j1; ++i22) {
                    int j22 = this.getBlockId(k1, l1, i22);
                    if (j22 != Block.fire.blockID && j22 != Block.lavaStill.blockID && j22 != Block.lavaMoving.blockID) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean func_682_a(AxisAlignedBB axisalignedbb, Material material, Entity entity) {
        int i2 = MathHelper.floor_double(axisalignedbb.minX);
        int j2 = MathHelper.floor_double(axisalignedbb.maxX + 1.0);
        int k2 = MathHelper.floor_double(axisalignedbb.minY);
        int l2 = MathHelper.floor_double(axisalignedbb.maxY + 1.0);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0);
        boolean flag = false;
        Vec3D vec3d = Vec3D.createVector(0.0, 0.0, 0.0);
        for (int k1 = i2; k1 < j2; ++k1) {
            for (int l1 = k2; l1 < l2; ++l1) {
                for (int i22 = i1; i22 < j1; ++i22) {
                    double d1;
                    Block block = Block.blocksList[this.getBlockId(k1, l1, i22)];
                    if (block == null || block.blockMaterial != material || !((double)l2 >= (d1 = (double)((float)(l1 + 1) - BlockFluids.func_288_b(this.getBlockMetadata(k1, l1, i22)))))) continue;
                    flag = true;
                    block.velocityToAddToEntity(this, k1, l1, i22, entity, vec3d);
                }
            }
        }
        if (vec3d.lengthVector() > 0.0) {
            vec3d = vec3d.normalize();
            double d2 = 0.004;
            entity.motionX += vec3d.xCoord * d2;
            entity.motionY += vec3d.yCoord * d2;
            entity.motionZ += vec3d.zCoord * d2;
        }
        return flag;
    }

    public boolean func_689_a(AxisAlignedBB axisalignedbb, Material material) {
        int i2 = MathHelper.floor_double(axisalignedbb.minX);
        int j2 = MathHelper.floor_double(axisalignedbb.maxX + 1.0);
        int k2 = MathHelper.floor_double(axisalignedbb.minY);
        int l2 = MathHelper.floor_double(axisalignedbb.maxY + 1.0);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0);
        for (int k1 = i2; k1 < j2; ++k1) {
            for (int l1 = k2; l1 < l2; ++l1) {
                for (int i22 = i1; i22 < j1; ++i22) {
                    Block block = Block.blocksList[this.getBlockId(k1, l1, i22)];
                    if (block == null || block.blockMaterial != material) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean func_707_b(AxisAlignedBB axisalignedbb, Material material) {
        int i2 = MathHelper.floor_double(axisalignedbb.minX);
        int j2 = MathHelper.floor_double(axisalignedbb.maxX + 1.0);
        int k2 = MathHelper.floor_double(axisalignedbb.minY);
        int l2 = MathHelper.floor_double(axisalignedbb.maxY + 1.0);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0);
        for (int k1 = i2; k1 < j2; ++k1) {
            for (int l1 = k2; l1 < l2; ++l1) {
                for (int i22 = i1; i22 < j1; ++i22) {
                    Block block = Block.blocksList[this.getBlockId(k1, l1, i22)];
                    if (block == null || block.blockMaterial != material) continue;
                    int j22 = this.getBlockMetadata(k1, l1, i22);
                    double d2 = l1 + 1;
                    if (j22 < 8) {
                        d2 = (double)(l1 + 1) - (double)j22 / 8.0;
                    }
                    if (!(d2 >= axisalignedbb.minY)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public Explosion func_12243_a(Entity entity, double d2, double d1, double d22, float f2) {
        return this.func_12244_a(entity, d2, d1, d22, f2, false);
    }

    public Explosion func_12244_a(Entity entity, double d2, double d1, double d22, float f2, boolean flag) {
        Explosion explosion = new Explosion(this, entity, d2, d1, d22, f2);
        explosion.field_12257_a = flag;
        explosion.func_12248_a();
        explosion.func_12247_b();
        return explosion;
    }

    public float func_675_a(Vec3D vec3d, AxisAlignedBB axisalignedbb) {
        double d2 = 1.0 / ((axisalignedbb.maxX - axisalignedbb.minX) * 2.0 + 1.0);
        double d1 = 1.0 / ((axisalignedbb.maxY - axisalignedbb.minY) * 2.0 + 1.0);
        double d22 = 1.0 / ((axisalignedbb.maxZ - axisalignedbb.minZ) * 2.0 + 1.0);
        int i2 = 0;
        int j2 = 0;
        float f2 = 0.0f;
        while (f2 <= 1.0f) {
            float f1 = 0.0f;
            while (f1 <= 1.0f) {
                float f22 = 0.0f;
                while (f22 <= 1.0f) {
                    double d3 = axisalignedbb.minX + (axisalignedbb.maxX - axisalignedbb.minX) * (double)f2;
                    double d4 = axisalignedbb.minY + (axisalignedbb.maxY - axisalignedbb.minY) * (double)f1;
                    double d5 = axisalignedbb.minZ + (axisalignedbb.maxZ - axisalignedbb.minZ) * (double)f22;
                    if (this.rayTraceBlocks(Vec3D.createVector(d3, d4, d5), vec3d) == null) {
                        ++i2;
                    }
                    ++j2;
                    f22 = (float)((double)f22 + d22);
                }
                f1 = (float)((double)f1 + d1);
            }
            f2 = (float)((double)f2 + d2);
        }
        return (float)i2 / (float)j2;
    }

    public void onBlockHit(int i2, int j2, int k2, int l2) {
        if (l2 == 0) {
            --j2;
        }
        if (l2 == 1) {
            ++j2;
        }
        if (l2 == 2) {
            --k2;
        }
        if (l2 == 3) {
            ++k2;
        }
        if (l2 == 4) {
            --i2;
        }
        if (l2 == 5) {
            ++i2;
        }
        if (this.getBlockId(i2, j2, k2) == Block.fire.blockID) {
            this.playSoundEffect((float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, "random.fizz", 0.5f, 2.6f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.8f);
            this.setBlockWithNotify(i2, j2, k2, 0);
        }
    }

    public Entity func_4085_a(Class class1) {
        return null;
    }

    public String func_687_d() {
        return "All: " + this.loadedEntityList.size();
    }

    @Override
    public TileEntity getBlockTileEntity(int i2, int j2, int k2) {
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        if (chunk != null) {
            return chunk.getChunkBlockTileEntity(i2 & 0xF, j2, k2 & 0xF);
        }
        return null;
    }

    public void setBlockTileEntity(int i2, int j2, int k2, TileEntity tileentity) {
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        if (chunk != null) {
            chunk.setChunkBlockTileEntity(i2 & 0xF, j2, k2 & 0xF, tileentity);
        }
    }

    public void removeBlockTileEntity(int i2, int j2, int k2) {
        Chunk chunk = this.getChunkFromChunkCoords(i2 >> 4, k2 >> 4);
        if (chunk != null) {
            chunk.removeChunkBlockTileEntity(i2 & 0xF, j2, k2 & 0xF);
        }
    }

    @Override
    public boolean isBlockOpaqueCube(int i2, int j2, int k2) {
        Block block = Block.blocksList[this.getBlockId(i2, j2, k2)];
        if (block == null) {
            return false;
        }
        return block.isOpaqueCube();
    }

    public void func_651_a(IProgressUpdate iprogressupdate) {
        this.saveWorld(true, iprogressupdate);
    }

    public boolean func_6465_g() {
        if (this.field_4204_J >= 50) {
            return false;
        }
        ++this.field_4204_J;
        try {
            boolean flag1;
            int i2 = 5000;
            while (this.field_1051_z.size() > 0) {
                if (--i2 <= 0) {
                    boolean flag;
                    boolean bl2 = flag = true;
                    return bl2;
                }
                ((MetadataChunkBlock)this.field_1051_z.remove(this.field_1051_z.size() - 1)).func_4127_a(this);
            }
            boolean bl3 = flag1 = false;
            return bl3;
        }
        finally {
            --this.field_4204_J;
        }
    }

    public void func_616_a(EnumSkyBlock enumskyblock, int i2, int j2, int k2, int l2, int i1, int j1) {
        this.func_627_a(enumskyblock, i2, j2, k2, l2, i1, j1, true);
    }

    public void func_627_a(EnumSkyBlock enumskyblock, int i2, int j2, int k2, int l2, int i1, int j1, boolean flag) {
        if (this.worldProvider.field_6478_e && enumskyblock == EnumSkyBlock.Sky) {
            return;
        }
        if (++field_9429_y == 50) {
            --field_9429_y;
            return;
        }
        int k1 = (l2 + i2) / 2;
        int l1 = (j1 + k2) / 2;
        if (!this.blockExists(k1, 64, l1)) {
            --field_9429_y;
            return;
        }
        int i22 = this.field_1051_z.size();
        if (flag) {
            int j22 = 4;
            if (j22 > i22) {
                j22 = i22;
            }
            for (int k22 = 0; k22 < j22; ++k22) {
                MetadataChunkBlock metadatachunkblock = (MetadataChunkBlock)this.field_1051_z.get(this.field_1051_z.size() - k22 - 1);
                if (metadatachunkblock.field_1299_a != enumskyblock || !metadatachunkblock.func_866_a(i2, j2, k2, l2, i1, j1)) continue;
                --field_9429_y;
                return;
            }
        }
        this.field_1051_z.add(new MetadataChunkBlock(enumskyblock, i2, j2, k2, l2, i1, j1));
        if (this.field_1051_z.size() > 100000) {
            this.field_1051_z.clear();
        }
        --field_9429_y;
    }

    public void calculateInitialSkylight() {
        int i2 = this.calculateSkylightSubtracted(1.0f);
        if (i2 != this.skylightSubtracted) {
            this.skylightSubtracted = i2;
        }
    }

    public void tick() {
        SpawnerAnimals.performSpawning(this);
        this.chunkProvider.func_532_a();
        int i2 = this.calculateSkylightSubtracted(1.0f);
        if (i2 != this.skylightSubtracted) {
            this.skylightSubtracted = i2;
            for (int j2 = 0; j2 < this.worldAccesses.size(); ++j2) {
                ((IWorldAccess)this.worldAccesses.get(j2)).func_936_e();
            }
        }
        ++this.worldTime;
        if (this.worldTime % (long)this.autosavePeriod == 0L) {
            this.saveWorld(false, null);
        }
        this.TickUpdates(false);
        this.func_4080_j();
    }

    protected void func_4080_j() {
        this.field_9427_K.clear();
        for (int i2 = 0; i2 < this.playerEntities.size(); ++i2) {
            EntityPlayer entityplayer = (EntityPlayer)this.playerEntities.get(i2);
            int j2 = MathHelper.floor_double(entityplayer.posX / 16.0);
            int l2 = MathHelper.floor_double(entityplayer.posZ / 16.0);
            int byte0 = 9;
            for (int j1 = -byte0; j1 <= byte0; ++j1) {
                for (int i22 = -byte0; i22 <= byte0; ++i22) {
                    this.field_9427_K.add(new ChunkCoordIntPair(j1 + j2, i22 + l2));
                }
            }
        }
        if (this.field_9426_L > 0) {
            --this.field_9426_L;
        }
        for (ChunkCoordIntPair chunkcoordintpair : this.field_9427_K) {
            int k2 = chunkcoordintpair.chunkXPos * 16;
            int i1 = chunkcoordintpair.chunkZPos * 16;
            Chunk chunk = this.getChunkFromChunkCoords(chunkcoordintpair.chunkXPos, chunkcoordintpair.chunkZPos);
            if (this.field_9426_L == 0) {
                EntityPlayer entityplayer1;
                this.field_9437_g = this.field_9437_g * 3 + this.field_9436_h;
                int k1 = this.field_9437_g >> 2;
                int j2 = k1 & 0xF;
                int l2 = k1 >> 8 & 0xF;
                int j3 = k1 >> 16 & 0x7F;
                int l3 = chunk.getBlockID(j2, j3, l2);
                if (l3 == 0 && this.getBlockLightValue(j2 += k2, j3, l2 += i1) <= this.rand.nextInt(8) && this.getSavedLightValue(EnumSkyBlock.Sky, j2, j3, l2) <= 0 && (entityplayer1 = this.getClosestPlayer((double)j2 + 0.5, (double)j3 + 0.5, (double)l2 + 0.5, 8.0)) != null && entityplayer1.getDistanceSq((double)j2 + 0.5, (double)j3 + 0.5, (double)l2 + 0.5) > 4.0) {
                    this.playSoundEffect((double)j2 + 0.5, (double)j3 + 0.5, (double)l2 + 0.5, "ambient.cave.cave", 0.7f, 0.8f + this.rand.nextFloat() * 0.2f);
                    this.field_9426_L = this.rand.nextInt(12000) + 6000;
                }
            }
            for (int l1 = 0; l1 < 80; ++l1) {
                this.field_9437_g = this.field_9437_g * 3 + this.field_9436_h;
                int k22 = this.field_9437_g >> 2;
                int i3 = k22 & 0xF;
                int k3 = k22 >> 8 & 0xF;
                int i4 = k22 >> 16 & 0x7F;
                byte byte1 = chunk.blocks[i3 << 11 | k3 << 7 | i4];
                if (!Block.tickOnLoad[byte1]) continue;
                Block.blocksList[byte1].updateTick(this, i3 + k2, i4, k3 + i1, this.rand);
            }
        }
    }

    public boolean TickUpdates(boolean flag) {
        int i2 = this.scheduledTickTreeSet.size();
        if (i2 != this.scheduledTickSet.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (i2 > 1000) {
            i2 = 1000;
        }
        for (int j2 = 0; j2 < i2; ++j2) {
            int k2;
            NextTickListEntry nextticklistentry = (NextTickListEntry)this.scheduledTickTreeSet.first();
            if (!flag && nextticklistentry.scheduledTime > this.worldTime) break;
            this.scheduledTickTreeSet.remove(nextticklistentry);
            this.scheduledTickSet.remove(nextticklistentry);
            int byte0 = 8;
            if (!this.checkChunksExist(nextticklistentry.xCoord - byte0, nextticklistentry.yCoord - byte0, nextticklistentry.zCoord - byte0, nextticklistentry.xCoord + byte0, nextticklistentry.yCoord + byte0, nextticklistentry.zCoord + byte0) || (k2 = this.getBlockId(nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord)) != nextticklistentry.blockID || k2 <= 0) continue;
            Block.blocksList[k2].updateTick(this, nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord, this.rand);
        }
        return this.scheduledTickTreeSet.size() != 0;
    }

    public void randomDisplayUpdates(int i2, int j2, int k2) {
        int byte0 = 16;
        Random random = new Random();
        for (int l2 = 0; l2 < 1000; ++l2) {
            int k1;
            int j1;
            int i1 = i2 + this.rand.nextInt(byte0) - this.rand.nextInt(byte0);
            int l1 = this.getBlockId(i1, j1 = j2 + this.rand.nextInt(byte0) - this.rand.nextInt(byte0), k1 = k2 + this.rand.nextInt(byte0) - this.rand.nextInt(byte0));
            if (l1 <= 0) continue;
            Block.blocksList[l1].randomDisplayTick(this, i1, j1, k1, random);
        }
    }

    public List getEntitiesWithinAABBExcludingEntity(Entity entity, AxisAlignedBB axisalignedbb) {
        this.field_1012_M.clear();
        int i2 = MathHelper.floor_double((axisalignedbb.minX - 2.0) / 16.0);
        int j2 = MathHelper.floor_double((axisalignedbb.maxX + 2.0) / 16.0);
        int k2 = MathHelper.floor_double((axisalignedbb.minZ - 2.0) / 16.0);
        int l2 = MathHelper.floor_double((axisalignedbb.maxZ + 2.0) / 16.0);
        for (int i1 = i2; i1 <= j2; ++i1) {
            for (int j1 = k2; j1 <= l2; ++j1) {
                if (!this.chunkExists(i1, j1)) continue;
                this.getChunkFromChunkCoords(i1, j1).getEntitiesWithinAABBForEntity(entity, axisalignedbb, this.field_1012_M);
            }
        }
        return this.field_1012_M;
    }

    public List getEntitiesWithinAABB(Class class1, AxisAlignedBB axisalignedbb) {
        int i2 = MathHelper.floor_double((axisalignedbb.minX - 2.0) / 16.0);
        int j2 = MathHelper.floor_double((axisalignedbb.maxX + 2.0) / 16.0);
        int k2 = MathHelper.floor_double((axisalignedbb.minZ - 2.0) / 16.0);
        int l2 = MathHelper.floor_double((axisalignedbb.maxZ + 2.0) / 16.0);
        ArrayList arraylist = new ArrayList();
        for (int i1 = i2; i1 <= j2; ++i1) {
            for (int j1 = k2; j1 <= l2; ++j1) {
                if (!this.chunkExists(i1, j1)) continue;
                this.getChunkFromChunkCoords(i1, j1).getEntitiesOfTypeWithinAAAB(class1, axisalignedbb, arraylist);
            }
        }
        return arraylist;
    }

    public List func_658_i() {
        return this.loadedEntityList;
    }

    public void func_698_b(int i2, int j2, int k2, TileEntity tileentity) {
        if (this.blockExists(i2, j2, k2)) {
            this.getChunkFromBlockCoords(i2, k2).setChunkModified();
        }
        for (int l2 = 0; l2 < this.worldAccesses.size(); ++l2) {
            ((IWorldAccess)this.worldAccesses.get(l2)).func_935_a(i2, j2, k2, tileentity);
        }
    }

    public int countEntities(Class class1) {
        int i2 = 0;
        for (int j2 = 0; j2 < this.loadedEntityList.size(); ++j2) {
            Entity entity = (Entity)this.loadedEntityList.get(j2);
            if (!class1.isAssignableFrom(entity.getClass())) continue;
            ++i2;
        }
        return i2;
    }

    public void func_636_a(List list) {
        this.loadedEntityList.addAll(list);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            this.obtainEntitySkin((Entity)list.get(i2));
        }
    }

    public void func_632_b(List list) {
        this.field_1024_A.addAll(list);
    }

    public void func_656_j() {
        while (this.chunkProvider.func_532_a()) {
        }
    }

    public boolean canBlockBePlacedAt(int i2, int j2, int k2, int l2, boolean flag) {
        int i1 = this.getBlockId(j2, k2, l2);
        Block block = Block.blocksList[i1];
        Block block1 = Block.blocksList[i2];
        AxisAlignedBB axisalignedbb = block1.getCollisionBoundingBoxFromPool(this, j2, k2, l2);
        if (flag) {
            axisalignedbb = null;
        }
        if (axisalignedbb != null && !this.checkIfAABBIsClear(axisalignedbb)) {
            return false;
        }
        if (block == Block.waterStill || block == Block.waterMoving || block == Block.lavaStill || block == Block.lavaMoving || block == Block.fire || block == Block.snow) {
            return true;
        }
        return i2 > 0 && block == null && block1.canPlaceBlockAt(this, j2, k2, l2);
    }

    public PathEntity getPathToEntity(Entity entity, Entity entity1, float f2) {
        int i2 = MathHelper.floor_double(entity.posX);
        int j2 = MathHelper.floor_double(entity.posY);
        int k2 = MathHelper.floor_double(entity.posZ);
        int l2 = (int)(f2 + 16.0f);
        int i1 = i2 - l2;
        int j1 = j2 - l2;
        int k1 = k2 - l2;
        int l1 = i2 + l2;
        int i22 = j2 + l2;
        int j22 = k2 + l2;
        ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i22, j22);
        return new Pathfinder(chunkcache).createEntityPathTo(entity, entity1, f2);
    }

    public PathEntity getEntityPathToXYZ(Entity entity, int i2, int j2, int k2, float f2) {
        int l2 = MathHelper.floor_double(entity.posX);
        int i1 = MathHelper.floor_double(entity.posY);
        int j1 = MathHelper.floor_double(entity.posZ);
        int k1 = (int)(f2 + 8.0f);
        int l1 = l2 - k1;
        int i22 = i1 - k1;
        int j22 = j1 - k1;
        int k22 = l2 + k1;
        int l22 = i1 + k1;
        int i3 = j1 + k1;
        ChunkCache chunkcache = new ChunkCache(this, l1, i22, j22, k22, l22, i3);
        return new Pathfinder(chunkcache).createEntityPathTo(entity, i2, j2, k2, f2);
    }

    public boolean isBlockProvidingPowerTo(int i2, int j2, int k2, int l2) {
        int i1 = this.getBlockId(i2, j2, k2);
        if (i1 == 0) {
            return false;
        }
        return Block.blocksList[i1].isIndirectlyPoweringTo(this, i2, j2, k2, l2);
    }

    public boolean isBlockGettingPowered(int i2, int j2, int k2) {
        if (this.isBlockProvidingPowerTo(i2, j2 - 1, k2, 0)) {
            return true;
        }
        if (this.isBlockProvidingPowerTo(i2, j2 + 1, k2, 1)) {
            return true;
        }
        if (this.isBlockProvidingPowerTo(i2, j2, k2 - 1, 2)) {
            return true;
        }
        if (this.isBlockProvidingPowerTo(i2, j2, k2 + 1, 3)) {
            return true;
        }
        if (this.isBlockProvidingPowerTo(i2 - 1, j2, k2, 4)) {
            return true;
        }
        return this.isBlockProvidingPowerTo(i2 + 1, j2, k2, 5);
    }

    public boolean isBlockIndirectlyProvidingPowerTo(int i2, int j2, int k2, int l2) {
        if (this.isBlockOpaqueCube(i2, j2, k2)) {
            return this.isBlockGettingPowered(i2, j2, k2);
        }
        int i1 = this.getBlockId(i2, j2, k2);
        if (i1 == 0) {
            return false;
        }
        return Block.blocksList[i1].isPoweringTo(this, i2, j2, k2, l2);
    }

    public boolean isBlockIndirectlyGettingPowered(int i2, int j2, int k2) {
        if (this.isBlockIndirectlyProvidingPowerTo(i2, j2 - 1, k2, 0)) {
            return true;
        }
        if (this.isBlockIndirectlyProvidingPowerTo(i2, j2 + 1, k2, 1)) {
            return true;
        }
        if (this.isBlockIndirectlyProvidingPowerTo(i2, j2, k2 - 1, 2)) {
            return true;
        }
        if (this.isBlockIndirectlyProvidingPowerTo(i2, j2, k2 + 1, 3)) {
            return true;
        }
        if (this.isBlockIndirectlyProvidingPowerTo(i2 - 1, j2, k2, 4)) {
            return true;
        }
        return this.isBlockIndirectlyProvidingPowerTo(i2 + 1, j2, k2, 5);
    }

    public EntityPlayer getClosestPlayerToEntity(Entity entity, double d2) {
        return this.getClosestPlayer(entity.posX, entity.posY, entity.posZ, d2);
    }

    public EntityPlayer getClosestPlayer(double d2, double d1, double d22, double d3) {
        double d4 = -1.0;
        EntityPlayer entityplayer = null;
        for (int i2 = 0; i2 < this.playerEntities.size(); ++i2) {
            EntityPlayer entityplayer1 = (EntityPlayer)this.playerEntities.get(i2);
            double d5 = entityplayer1.getDistanceSq(d2, d1, d22);
            if (!(d3 < 0.0) && !(d5 < d3 * d3) || d4 != -1.0 && !(d5 < d4)) continue;
            d4 = d5;
            entityplayer = entityplayer1;
        }
        return entityplayer;
    }

    public void func_693_a(int i2, int j2, int k2, int l2, int i1, int j1, byte[] abyte0) {
        int k1 = i2 >> 4;
        int l1 = k2 >> 4;
        int i22 = i2 + l2 - 1 >> 4;
        int j22 = k2 + j1 - 1 >> 4;
        int k22 = 0;
        int l22 = j2;
        int i3 = j2 + i1;
        if (l22 < 0) {
            l22 = 0;
        }
        if (i3 > 128) {
            i3 = 128;
        }
        for (int j3 = k1; j3 <= i22; ++j3) {
            int k3 = i2 - j3 * 16;
            int l3 = i2 + l2 - j3 * 16;
            if (k3 < 0) {
                k3 = 0;
            }
            if (l3 > 16) {
                l3 = 16;
            }
            for (int i4 = l1; i4 <= j22; ++i4) {
                int j4 = k2 - i4 * 16;
                int k4 = k2 + j1 - i4 * 16;
                if (j4 < 0) {
                    j4 = 0;
                }
                if (k4 > 16) {
                    k4 = 16;
                }
                k22 = this.getChunkFromChunkCoords(j3, i4).func_1004_a(abyte0, k3, l22, j4, l3, i3, k4, k22);
                this.func_701_b(j3 * 16 + k3, l22, i4 * 16 + j4, j3 * 16 + l3, i3, i4 * 16 + k4);
            }
        }
    }

    public void sendQuittingDisconnectingPacket() {
    }

    public void func_663_l() {
        try {
            File file = new File(this.field_9432_t, "session.lock");
            try (DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));){
                if (datainputstream.readLong() != this.field_1054_E) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
        }
        catch (IOException ioexception) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    public void setWorldTime(long l2) {
        this.worldTime = l2;
    }

    public void func_705_f(Entity entity) {
        int i2 = MathHelper.floor_double(entity.posX / 16.0);
        int j2 = MathHelper.floor_double(entity.posZ / 16.0);
        int byte0 = 2;
        for (int k2 = i2 - byte0; k2 <= i2 + byte0; ++k2) {
            for (int l2 = j2 - byte0; l2 <= j2 + byte0; ++l2) {
                this.getChunkFromChunkCoords(k2, l2);
            }
        }
        if (!this.loadedEntityList.contains(entity)) {
            this.loadedEntityList.add(entity);
        }
    }

    public boolean func_6466_a(EntityPlayer entityplayer, int i2, int j2, int k2) {
        return true;
    }

    public void func_9425_a(Entity entity, byte byte0) {
    }

    public void func_9424_o() {
        this.loadedEntityList.removeAll(this.field_1024_A);
        for (int i2 = 0; i2 < this.field_1024_A.size(); ++i2) {
            Entity entity = (Entity)this.field_1024_A.get(i2);
            int l2 = entity.field_657_ba;
            int j1 = entity.field_654_bc;
            if (!entity.field_621_aZ || !this.chunkExists(l2, j1)) continue;
            this.getChunkFromChunkCoords(l2, j1).func_1015_b(entity);
        }
        for (int j2 = 0; j2 < this.field_1024_A.size(); ++j2) {
            this.releaseEntitySkin((Entity)this.field_1024_A.get(j2));
        }
        this.field_1024_A.clear();
        for (int k2 = 0; k2 < this.loadedEntityList.size(); ++k2) {
            Entity entity1 = (Entity)this.loadedEntityList.get(k2);
            if (entity1.ridingEntity != null) {
                if (!entity1.ridingEntity.isDead && entity1.ridingEntity.riddenByEntity == entity1) continue;
                entity1.ridingEntity.riddenByEntity = null;
                entity1.ridingEntity = null;
            }
            if (!entity1.isDead) continue;
            int i1 = entity1.field_657_ba;
            int k1 = entity1.field_654_bc;
            if (entity1.field_621_aZ && this.chunkExists(i1, k1)) {
                this.getChunkFromChunkCoords(i1, k1).func_1015_b(entity1);
            }
            this.loadedEntityList.remove(k2--);
            this.releaseEntitySkin(entity1);
        }
    }
}

