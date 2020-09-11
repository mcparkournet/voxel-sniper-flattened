package com.thevoxelbox.voxelsniper.brush;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.thevoxelbox.voxelsniper.brush.property.BrushProperties;
import org.jetbrains.annotations.Nullable;

public class BrushRegistry {

    private final Map<String, BrushProperties> brushesProperties = new HashMap<>();

    public void register(final BrushProperties properties) {
        List<String> aliases = properties.getAliases();
        for (final String alias : aliases) {
            this.brushesProperties.put(alias, properties);
        }
    }

    @Nullable
    public BrushProperties getBrushProperties(final String alias) {
        return this.brushesProperties.get(alias);
    }

    public Map<String, BrushProperties> getBrushesProperties() {
        return Collections.unmodifiableMap(this.brushesProperties);
    }
}
