SUMMARY = "the implementation of SOME/IP"
SECTION = "base"
LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

inherit cmake lib_package gitpkgv

DEPENDS = "boost dlt-daemon"

PREFERRED_VERSION_boost = "1.74.0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "17cc55f24d1c56f6a5dcca6065a227ca91d01c90"
SRC_URI = "git://github.com/GENIVI/${BPN}.git;protocol=https \
    file://0001-VSOMEIP-BUILD-BUGS.patch \
    "
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DINSTALL_LIB_DIR:PATH=${baselib}"

PACKAGES_remove += "${PN}-bin"
FILES_${PN} += "${bindir}/vsomeipd ${sysconfdir}/${BPN}"
FILES_${PN}-dev += "${libdir}/cmake"

BBCLASSEXTEND = "nativesdk"

do_install_append() {
    [ -d ${D}${exec_prefix}/etc ] && mv ${D}${exec_prefix}/etc ${D}
}
