SUMMARY = "Common API C++ core generator"

LAUNCHER_BASE = "commonapi-core-generator"
LAUNCHER_LINK = "capicxx-core-gen"

SRC_URI = "https://github.com/GENIVI/${_BPN}-tools/releases/download/${PV}/commonapi_core_generator.zip"
SRC_URI[sha256sum] = "d206b8281f95eaca0d6f1f794d22fbf69d515a879a452b4e9cf6b499fd0af0b2"

inherit nativesdk
require capicxx.inc
