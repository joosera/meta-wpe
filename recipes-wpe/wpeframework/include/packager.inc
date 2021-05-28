# Provides configuration for the Packager Plugin
WPE_PACKAGER_AUTOSTART ??= "true"
WPE_PACKAGER_OUTOFPROCESS ??= "false"

# -----------------------------------------------------------------------------------------------------------
PACKAGECONFIG[packager] = "\
    -DPLUGIN_PACKAGER=ON \
    -DPLUGIN_PACKAGER_AUTOSTART="${WPE_PACKAGER_AUTOSTART}" \
    -DPLUGIN_PACKAGER_OUTOFPROCESS="${WPE_PACKAGER_OUTOFPROCESS}" \
    ,-DPLUGIN_PACKAGER=OFF,opkg \
"

# -----------------------------------------------------------------------------------------------------------