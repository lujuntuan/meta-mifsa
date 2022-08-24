SUMMARY = "Binary delta tools and library"
HOMEPAGE = "https://github.com/clearlinux/bsdiff"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=0dbe7a50f028269750631fcbded3846a"

SRC_URI = "git://github.com/clearlinux/bsdiff.git;protocol=https"

PV = "1.0.4+git${SRCPV}"
SRCREV = "5c2c4c76ac31850e1bd854e9a9fcfacdcad70185"

S = "${WORKDIR}/git"

DEPENDS_BZIP2 = "bzip2-replacement-native"
DEPENDS_BZIP2_class-target = "bzip2"
DEPENDS = "xz zlib ${DEPENDS_BZIP2}"

inherit pkgconfig autotools

PACKAGECONFIG ??= ""
PACKAGECONFIG[tests] = "--enable-tests, --disable-tests, libcheck"

BBCLASSEXTEND = "native"
