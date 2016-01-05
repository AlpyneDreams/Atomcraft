/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.blocks;

public interface IBlockAC {
	
	/**
	 * Returns the block's mod-unique internal name
	 * that follows the format: "block_name".
	 * The internal name is automatically generated
	 * based on the unlocalized name.
	 * 
	 * @return The block's mod-unique internal name.
	 */
	String getName();
	
	/**
	 * Returns the block's mod-unique internal name
	 * that follows the format: "block_name".
	 * The internal name is automatically generated
	 * based on the unlocalized name.
	 * 
	 * @param meta The block's damage value metadata.
	 * @return The block's mod-unique internal name.
	 */
	String getName(int meta);
}
