MIFSA_SRC = "mifsa-ota"

require mifsa-modules.inc

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

DEPENDS_append += " \
    openssl \
"

RDEPENDS_${PN}_append += " \
    bsdiff \
"

do_install_append() {
    install -d ${D}${sysconfdir}/
    install -m 0644 ${WORKDIR}/etc/* ${D}${sysconfdir}/
}
