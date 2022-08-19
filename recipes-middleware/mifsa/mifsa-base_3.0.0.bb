inherit mifsa
inherit cmake

MIFSA_SRC = "mifsa-base"

DEPENDS = " \
    dlt-daemon \
"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_LIBDIR=${baselib}"

PACKAGECONFIG[dlt] = "-DMIFSA_DLT=ON,-DMIFSA_DLT=OFF"
PACKAGECONFIG ??= "dlt"
