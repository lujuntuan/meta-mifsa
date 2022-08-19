SUMMARY = "Genivi CommonAPI-Core"
SECTION = "libs"
LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

PROVIDES = "commonapi3"
PR = "r0"

inherit cmake lib_package pkgconfig

DEPENDS = "dlt-daemon"

SRCREV = "89720d3c63bbd22cbccc80cdc92c2f2dd20193ba"
SRC_URI = "git://github.com/GENIVI/capicxx-core-runtime.git;protocol=https \
    file://0001-CAPICXX-CORE-RUNTIME-BUILD-BUGS.patch \
    "
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DINSTALL_LIB_DIR:PATH=${baselib}"

FILES_${PN}-dev += "${libdir}/cmake"
