SUMMARY = "mimalloc"
SECTION = "libs"
DESCRIPTION = "Mimalloc (pronounced 'me-malloc') is a general purpose allocator with excellent performance characteristics"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cd47cf280095d74b469beed1f28c8e77"
SRC_URI = "git://github.com/microsoft/mimalloc.git;protocol=https"
SRCREV = "38a03229c89afbf2722e48c63da696bf11589dee"
S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DMI_BUILD_SHARED=ON \
    -DMI_BUILD_STATIC=OFF \
    -DMI_BUILD_OBJECT=OFF \
    -DMI_BUILD_TESTS=OFF \
    -DMI_INSTALL_TOPLEVEL=ON \
"

FILES_${PN} += "${libdir}"
FILES_${PN}-dev += "${libdir}/cmake"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "\
    dev-so \
    already-stripped \
    installed-vs-shipped \
"
