inherit mifsa
inherit cmake
inherit systemd

DEPENDS = " \
    mifsa-base \
"

DEPENDS += "protobuf-native fdbus"
#DEPENDS += "capicxx-core-native capicxx-someip-native common-api-c++-someip"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_LIBDIR=${baselib}"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES','systemd', d)}"
PACKAGECONFIG[systemd] = "-DMIFSA_SYSTEMD=ON,-DMIFSA_SYSTEMD=OFF,systemd"

MIFSA_SYSTEMD_FILE = "${@d.getVar("PN").replace("-", "_")}_server.service"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('PACKAGECONFIG', 'systemd', '${MIFSA_SYSTEMD_FILE}', '', d)}"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"

do_install_append() {
    if [ -d ${D}${libdir}/systemd/system ];then
        install -d ${D}${systemd_unitdir}
        mv ${D}${libdir}/systemd/system ${D}${systemd_unitdir}
        rm -rf ${D}${libdir}/systemd
    fi
}
