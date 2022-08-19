SUMMARY ?= "${PN}"
SECTION ?= "base"
DESCRIPTION ?= "The ${PN} build for meta-mifsa"

inherit mifsa-license

MIFSA_SRC ?= ""
MIFSA_SRC_SEARCH ?= "${MIFSA_LAYERDIR}/../src"
MIFSA_SRC_TARGET = "${MIFSA_SRC_SEARCH}/mifsa/${MIFSA_SRC}"
MIFSA_BIN_DIR ?= "${MIFSA_LAYERDIR}/prebuild/mifsa"
MIFSA_BIN_NAME ?= "${PN}_${PV}_${TARGET_ARCH}_prebuild.tgz"

def mifsa_src_type(d):
    if d.getVar('MIFSA_SRC') != "" and os.path.exists(d.getVar('MIFSA_SRC_TARGET')):
        return "source"
    elif os.path.exists(d.getVar('MIFSA_BIN_DIR') + '/' + d.getVar('MIFSA_BIN_NAME')):
        return "prebuild"
    else:
        return "null"

MIFSA_SRC_TYPE = "${@mifsa_src_type(d)}"

SRC_URI += "${@bb.utils.contains('MIFSA_SRC_TYPE', 'source', 'file://mifsa/${MIFSA_SRC}', '', d)}"
S = "${@bb.utils.contains('MIFSA_SRC_TYPE', 'source', '${WORKDIR}/mifsa/${MIFSA_SRC}', '${WORKDIR}', d)}"
FILESEXTRAPATHS_prepend := "${MIFSA_SRC_SEARCH}:"

do_checksrc() {
    if [ "${MIFSA_SRC_TYPE}" = "null" ];then
        bbfatal "Can not find ${MIFSA_SRC_TARGET} or ${MIFSA_BIN_DIR}/${MIFSA_BIN_NAME}"
    fi
}

do_prebuild() {
    if [ "${MIFSA_SRC_TYPE}" = "source" ];then
        #generate-prebuild
        mkdir -p ${MIFSA_BIN_DIR}
        tar -zcf ${MIFSA_BIN_DIR}/${MIFSA_BIN_NAME} -C ${D} ./
    elif [ "${MIFSA_SRC_TYPE}" = "prebuild" ];then
        #install-prebuild
        install -d ${D}
        tar -zxf ${MIFSA_BIN_DIR}/${MIFSA_BIN_NAME} -C ${D} --no-same-owner
    fi
}

do_configure_prepend() {
    [ "${MIFSA_SRC_TYPE}" = "prebuild" ] && return
}

do_compile_prepend() {
    [ "${MIFSA_SRC_TYPE}" = "prebuild" ] && return
}

do_install_prepend() {
    [ "${MIFSA_SRC_TYPE}" = "prebuild" ] && return
}

do_fetch[prefuncs] += "do_checksrc"
do_install[postfuncs] += "do_prebuild"

EXPORT_FUNCTIONS do_prebuild

FILES_${PN} += "\
    ${libdir} \
    ${datadir} \
    "
FILES_${PN}-dev += "\
    ${libdir}/cmake \
    "
INSANE_SKIP_${PN} += "\
    dev-so \
    already-stripped \
    installed-vs-shipped \
    host-user-contaminated \
    "
FILES_SOLIBSDEV = ""
