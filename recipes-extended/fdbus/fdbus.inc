SRC_URI += " \
    file://fdbus_name_server.service \
    file://fdbus_host_server.service \
"

S = "${WORKDIR}/git/cmake"

inherit cmake
inherit systemd

DEPENDS = " \
    protobuf \
    protobuf-native \
"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES','systemd', d)}"
PACKAGECONFIG[systemd] = ",,systemd"
PACKAGECONFIG[systemd-host] = ",,systemd-host"

PACKAGES += "${PN}-host"
SYSTEMD_PACKAGES = "${PN} ${PN}-host"
SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('PACKAGECONFIG', 'systemd', 'fdbus_name_server.service', '', d)}"
SYSTEMD_SERVICE_${PN}-host = "${@bb.utils.contains('PACKAGECONFIG', 'systemd-host', 'fdbus_host_server.service', '', d)}"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_AUTO_ENABLE_${PN}-host = "enable"

FILES_${PN} += "${libdir}"
FILES_${PN}-dev += "${libdir}/cmake"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "\
    dev-so \
    already-stripped \
    installed-vs-shipped \
"

do_install_append() {
    if [ "${baselib}" = "lib64" ];then
        mv ${D}${exec_prefix}/lib ${D}${exec_prefix}/lib64
    fi
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/*.service ${D}${systemd_unitdir}/system
}
