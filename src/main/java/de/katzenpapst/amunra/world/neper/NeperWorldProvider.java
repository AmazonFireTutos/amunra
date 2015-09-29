package de.katzenpapst.amunra.world.neper;

import java.util.Random;

import de.katzenpapst.amunra.AmunRa;
import de.katzenpapst.amunra.world.AmunraWorldChunkManager;
import de.katzenpapst.amunra.world.AmunraWorldProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IExitHeight;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;

public class NeperWorldProvider extends AmunraWorldProvider  {

	/**
     * Determines the rate to spawn meteors in this planet. Lower means MORE
     * meteors.
     * <p/>
     * Typical value would be about 7. Return 0 for no meteors.
     *
     * @return
     */
	@Override
	public double getMeteorFrequency() {
		return 7;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 3;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 0;
	}

	@Override
	public float getThermalLevelModifier() {
		return 0;
	}

	@Override
	public float getWindLevel() {
		return 0;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return AmunRa.instance.moonNeper;
	}

	@Override
	public boolean useParachute() {
		return true;
	}

	@Override
	public Vector3 getPlayerSpawnLocation(WorldServer world,
			EntityPlayerMP player) {
		return getEntitySpawnLocation(world, player);
	}

	@Override
	public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity) {
		return new Vector3(entity.posX, 140, entity.posZ);
	}

	@Override
	public Vector3 getParaChestSpawnLocation(WorldServer world,
			EntityPlayerMP player, Random rand) {
		return new Vector3(player.posX - 5 + rand.nextInt(10), 150, player.posZ - 5 + rand.nextInt(10));
	}

	@Override
	public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player,
			boolean ridingAutoRocket) {
		// noop?

	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 0.85;
	}

	@Override
	public double getYCoordinateToTeleport() {
		return 800;
	}

	@Override
	public Vector3 getFogColor() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public Vector3 getSkyColor() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public boolean canRainOrSnow() {
		return false;
	}

	@Override
	public boolean hasSunset() {
		return true;
	}

	@Override
	public long getDayLength() {
		return 18000L;
	}

	@Override
	public boolean shouldForceRespawn() {
		return false;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return NeperChunkProvider.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return AmunraWorldChunkManager.class;
	}

	@Override
	protected float getRelativeGravity() {
		return 1;
	}

}
