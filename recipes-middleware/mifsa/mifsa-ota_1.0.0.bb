MIFSA_SRC = "mifsa-ota"

require mifsa-modules.inc

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

RDEPENDS_${PN} = " \
    bsdiff \
"
