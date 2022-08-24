MIFSA_SRC = "mifsa-ota"

require mifsa-modules.inc

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

DEPENDS_append += " \
    openssl \
"

RDEPENDS_${PN}_append += " \
    bsdiff \
"
