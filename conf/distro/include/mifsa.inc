require conf/distro/poky.conf

DISTRO_FEATURES_append += "\
    systemd \
"

DISTRO_FEATURES_remove += "\
    sysvinit \
"

PREFERRED_VERSION_openssl = "1.1.%"
PREFERRED_VERSION_openssl-native = "1.1.%"
PREFERRED_VERSION_nativesdk-openssl = "1.1.%"

LICENSE_FLAGS_WHITELIST = "commercial"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"

INHERIT += "extrausers"
EXTRA_USERS_PARAMS = "usermod -P mifsa root;"
hostname_pn-base-files = "mifsa-$MACHINE"
