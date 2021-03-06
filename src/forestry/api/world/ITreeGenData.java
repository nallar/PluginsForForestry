package forestry.api.world;

import net.minecraft.world.World;

public interface ITreeGenData {
	
	int getGirth(World world, int x, int y, int z);
	
	float getHeightModifier();
	
	boolean canGrow(World world, int x, int y, int z, int expectedGirth, int expectedHeight);
	
	void setLeaves(World world, int x, int y, int z);
}
