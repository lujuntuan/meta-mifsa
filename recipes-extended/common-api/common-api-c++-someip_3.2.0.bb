SUMMARY = "Genivi CommonAPI-SomeIP"
SECTION = "libs"
LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

inherit cmake lib_package gitpkgv

DEPENDS = "boost common-api-c++ vsomeip"

PREFERRED_VERSION_boost = "1.74.0"

SRCREV = "29cb5c81b67777d594a9ae83eb7d47874b147f7b"
SRC_URI = "git://github.com/GENIVI/capicxx-someip-runtime.git;protocol=https \
    file://0001-CAPICXX-SOMEIP-RUNTIME-BUILD-BUGS.patch \
    "
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DUSE_INSTALLED_COMMONAPI=ON -DINSTALL_LIB_DIR:PATH=${baselib}"

FILES_${PN}-dev += "${libdir}/cmake"
RDEPENDS_${PN}-dev = "vsomeip-dev"

BBCLASSEXTEND = "nativesdk"
