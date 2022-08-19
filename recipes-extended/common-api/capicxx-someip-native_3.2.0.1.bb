SUMMARY = "Common API C++ SOME/IP generator"

LAUNCHER_BASE = "commonapi-someip-generator"
LAUNCHER_LINK = "capicxx-someip-gen"

def get_src_path(d):
    if os.path.exists(os.path.join(d.getVar('MIFSA_LAYERDIR'),"/prebuild/tools/commonapi_someip_generator_fixed.zip")):
        return os.path.join(d.getVar('MIFSA_LAYERDIR'),"/prebuild/tools/commonapi_someip_generator_fixed.zip",";sha256sum=2e4f752e26749baafa7d03713fcd497e75da284e1dac985c31c400a77cb2e465")
    else:
        return "https://github.com/GENIVI/${_BPN}-tools/releases/download/${PV}/commonapi_someip_generator.zip;sha256sum=6e83a48db2e81fcdf774d7aa7472877bbcc18c52964cd125b08e5690d634fe4f"

SRC_URI = "${@get_src_path(d)}"

inherit native
require capicxx.inc
