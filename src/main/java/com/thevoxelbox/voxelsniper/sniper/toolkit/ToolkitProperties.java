package com.thevoxelbox.voxelsniper.sniper.toolkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class ToolkitProperties {

    private static final Material DEFAULT_BLOCK_MATERIAL = Material.AIR;
    private static final Material DEFAULT_REPLACE_BLOCK_MATERIAL = Material.AIR;
    private static final int DEFAULT_BRUSH_SIZE = 3;
    private static final int DEFAULT_VOXEL_HEIGHT = 1;
    private static final int DEFAULT_CYLINDER_CENTER = 0;

    private BlockData blockData;
    private BlockData replaceBlockData;
    private int brushSize;
    private int voxelHeight;
    private int cylinderCenter;
    @Nullable
    private Integer blockTracerRange;
    private boolean lightningEnabled;
    private final List<BlockData> voxelList = new ArrayList<>();

    public ToolkitProperties() {
        this.blockData = DEFAULT_BLOCK_MATERIAL.createBlockData();
        this.replaceBlockData = DEFAULT_REPLACE_BLOCK_MATERIAL.createBlockData();
        this.brushSize = DEFAULT_BRUSH_SIZE;
        this.voxelHeight = DEFAULT_VOXEL_HEIGHT;
    }

    public void reset() {
        resetBlockData();
        resetReplaceBlockData();
        this.brushSize = DEFAULT_BRUSH_SIZE;
        this.voxelHeight = DEFAULT_VOXEL_HEIGHT;
        this.cylinderCenter = DEFAULT_CYLINDER_CENTER;
        this.blockTracerRange = null;
        this.lightningEnabled = false;
        this.voxelList.clear();
    }

    public void resetBlockData() {
        this.blockData = DEFAULT_BLOCK_MATERIAL.createBlockData();
    }

    public void resetReplaceBlockData() {
        this.replaceBlockData = DEFAULT_REPLACE_BLOCK_MATERIAL.createBlockData();
    }

    public Material getBlockType() {
        return this.blockData.getMaterial();
    }

    public void setBlockType(final Material type) {
        this.blockData = type.createBlockData();
    }

    public Material getReplaceBlockType() {
        return this.replaceBlockData.getMaterial();
    }

    public void setReplaceBlockType(final Material type) {
        this.replaceBlockData = type.createBlockData();
    }

    public BlockTracer createBlockTracer(final Player player) {
        int distance = this.blockTracerRange == null ? Math.max(Bukkit.getViewDistance(), 3) * 16 - this.brushSize : this.blockTracerRange;
        return new BlockTracer(player, distance);
    }

    public void addToVoxelList(final BlockData blockData) {
        this.voxelList.add(blockData);
    }

    public void removeFromVoxelList(final BlockData blockData) {
        this.voxelList.remove(blockData);
    }

    public void clearVoxelList() {
        this.voxelList.clear();
    }

    public boolean isVoxelListContains(final BlockData blockData) {
        return this.voxelList.contains(blockData);
    }

    public BlockData getBlockData() {
        return this.blockData;
    }

    public void setBlockData(final BlockData blockData) {
        this.blockData = blockData;
    }

    public BlockData getReplaceBlockData() {
        return this.replaceBlockData;
    }

    public void setReplaceBlockData(final BlockData replaceBlockData) {
        this.replaceBlockData = replaceBlockData;
    }

    public int getBrushSize() {
        return this.brushSize;
    }

    public void setBrushSize(final int brushSize) {
        this.brushSize = brushSize;
    }

    public int getVoxelHeight() {
        return this.voxelHeight;
    }

    public void setVoxelHeight(final int voxelHeight) {
        this.voxelHeight = voxelHeight;
    }

    public int getCylinderCenter() {
        return this.cylinderCenter;
    }

    public void setCylinderCenter(final int cylinderCenter) {
        this.cylinderCenter = cylinderCenter;
    }

    @Nullable
    public Integer getBlockTracerRange() {
        return this.blockTracerRange;
    }

    public void setBlockTracerRange(@Nullable final Integer blockTracerRange) {
        this.blockTracerRange = blockTracerRange;
    }

    public boolean isLightningEnabled() {
        return this.lightningEnabled;
    }

    public void setLightningEnabled(final boolean lightningEnabled) {
        this.lightningEnabled = lightningEnabled;
    }

    public List<BlockData> getVoxelList() {
        return Collections.unmodifiableList(this.voxelList);
    }
}
