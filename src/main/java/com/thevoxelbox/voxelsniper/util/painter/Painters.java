package com.thevoxelbox.voxelsniper.util.painter;

import net.mcparkour.common.math.vector.Vector3i;

public final class Painters {

	private Painters() {
		throw new UnsupportedOperationException("Cannot create an instance of this class");
	}

	public static SpherePainter sphere() {
		return new SpherePainter();
	}

	public static CubePainter cube() {
		return new CubePainter();
	}

	public static CirclePainter circle() {
		return new CirclePainter();
	}

	public static SquarePainter square() {
		return new SquarePainter();
	}

	public static BlockPainter block(Painter painter) {
		Vector3i center = painter.getCenter();
		BlockSetter blockSetter = painter.getBlockSetter();
		return new BlockPainter(center, blockSetter);
	}
}
