package top.hendrixshen.magiclib.impl.malilib;

import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.util.StringUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class TranslatableConfigHotkey extends ConfigHotkey {
    private final String guiDisplayName;

    public TranslatableConfigHotkey(String prefix, String name, String defaultStorageString) {
        super(name, defaultStorageString, String.format("%s.config.%s.comment", prefix, name),
                String.format("%s.config.%s.pretty_name", prefix, name));
        this.guiDisplayName = String.format("%s.config.%s.name", prefix, name);

    }

    public TranslatableConfigHotkey(String prefix, String name, String defaultStorageString, KeybindSettings settings) {
        super(name, defaultStorageString, settings, String.format("%s.config.%s.comment", prefix, name),
                String.format("%s.config.%s.pretty_name", prefix, name));
        this.guiDisplayName = String.format("%s.config.%s.name", prefix, name);
    }


    @Override
    public String getPrettyName() {
        String ret = super.getPrettyName();
        if (ret.contains("pretty_name")) {
            ret = StringUtils.splitCamelCase(this.getConfigGuiDisplayName());
        }
        return ret;
    }

    @Override
    public String getConfigGuiDisplayName() {
        return StringUtils.translate(this.guiDisplayName);
    }
}
