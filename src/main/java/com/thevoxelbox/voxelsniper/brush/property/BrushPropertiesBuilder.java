package com.thevoxelbox.voxelsniper.brush.property;

import java.util.ArrayList;
import java.util.List;

public class BrushPropertiesBuilder {

    private String name;
    private String permission;
    private final List<String> aliases = new ArrayList<>(1);
    private BrushCreator creator;

    public BrushPropertiesBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public BrushPropertiesBuilder permission(final String permission) {
        this.permission = permission;
        return this;
    }

    public BrushPropertiesBuilder alias(final String alias) {
        this.aliases.add(alias);
        return this;
    }

    public BrushPropertiesBuilder creator(final BrushCreator creator) {
        this.creator = creator;
        return this;
    }

    public BrushProperties build() {
        if (this.name == null) {
            throw new RuntimeException("Brush name must be specified");
        }
        if (this.creator == null) {
            throw new RuntimeException("Brush creator must be specified");
        }
        return new BrushProperties(this.name, this.permission, this.aliases, this.creator);
    }
}
