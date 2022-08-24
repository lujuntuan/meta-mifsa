SUMMARY ?= "mifsa-image-mt2735"
DESCRIPTION ?= "mifsa image for mt2735"

inherit core-image

require include/mifsa-image.inc

IMAGE_INSTALL_remove += " \
"

IMAGE_INSTALL_append += " \
    mifsa-gnss \
    mifsa-ota \
"
