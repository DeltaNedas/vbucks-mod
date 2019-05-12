package deltanedas.vbucks_mod.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockVBuck extends BaseBlock {
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	private static AxisAlignedBB[] boundingBox = new AxisAlignedBB[6];
	
	public BlockVBuck(String name, float lightLevel) {
		super(name, Material.IRON, lightLevel);
		blockHardness = 5.0F;
		blockResistance = 15.0F;
		setHarvestLevel("Pickaxe", 3);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
		boundingBox[0] = new AxisAlignedBB(0f, 0f, 0f, 1.0f, 0.25f, 1.0f); // Up
		boundingBox[1] = new AxisAlignedBB(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f); // Down
		boundingBox[2] = new AxisAlignedBB(1.0f, 0f, 0.75f, 0f, 1.0f, 1.0f); // North
		boundingBox[3] = new AxisAlignedBB(0f, 0f, 0f, 0.25f, 1.0f, 1.0f); // East
		boundingBox[4] = new AxisAlignedBB(0f, 0f, 0f, 1.0f, 1.0f, 0.25f); // South
		boundingBox[5] = new AxisAlignedBB(0.75f, 0f, 0f, 1.0f, 1.0f, 1.0f); // West
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
			return new BlockStateContainer(this, FACING);
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(FACING, facing);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing dir = EnumFacing.UP;
		switch(meta) {
		case 1:
			dir = EnumFacing.DOWN; break;
		case 2:
			dir = EnumFacing.NORTH; break;
		case 3:
			dir = EnumFacing.EAST; break;
		case 4:
			dir = EnumFacing.SOUTH; break;
		case 5:
			dir = EnumFacing.WEST; break;
		}
		return getDefaultState().withProperty(FACING, dir);
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		switch(state.getValue(FACING)) {
		case DOWN:
			meta = 1; break;
		case NORTH:
			meta = 2; break;
		case EAST:
			meta = 3; break;
		case SOUTH:
			meta = 4; break;
		case WEST:
			meta = 5; break;
		}
		return meta;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
			return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isOpaqueCube(@Nonnull IBlockState bs) {
		return false;
	}
	
	@Override
	public boolean isFullCube(@Nonnull IBlockState bs) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return boundingBox[this.getMetaFromState(state)];
	}
}
