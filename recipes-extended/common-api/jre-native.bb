SUMMARY = "Common API C++ generator need java run time"
LICENSE = "CLOSED"

S = "${WORKDIR}"

inherit native

do_install() {
    install -d "${D}${bindir}"
    ln -sf "/usr/bin/java" ${D}${bindir}/java
}

FILES_${PN} = "\
    ${bindir} \
"
PACKAGES = "${PN}"
