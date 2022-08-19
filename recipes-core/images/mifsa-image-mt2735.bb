SUMMARY ?= "mifsa-image-mt2735"
DESCRIPTION ?= "mifsa image for mt2735"

include ${METADIR}/meta-mediatek-mt2735/recipes-core/images/mtk-image-2735.bb

require include/mifsa-image.inc

IMAGE_INSTALL_append += " \
    mifsa-gnss \
"

IMAGE_INSTALL_remove += " \
    multi-user-test \
    iperf3 \
    tel-demo \
    curl \
"
