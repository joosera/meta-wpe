SUMMARY = "WPEFramework interfaces"
DESCRIPTION = "Thunder interfaces component"
HOMEPAGE = "https://github.com/rdkcentral/ThunderInterfaces"
SECTION = "wpe"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2f6c18f99faffa0e5d4ff478705c53f8"

require include/wpeframework-common.inc
DEPENDS:append = " wpeframework-tools-native wpeframework"

PR = "r0"
PV = "3.0+gitr${SRCPV}"
RECIPE_BRANCH ?= "master"

SRC_URI = "git://github.com/rdkcentral/ThunderInterfaces.git;protocol=git;branch=${RECIPE_BRANCH};protocol=https"
SRCREV ?= "bf5de3c2cf64b5abc6e04928b2480349972c409b"

inherit python3native

EXTRA_OECMAKE += "\
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_REFERENCE=${SRCREV} \
    -DPYTHON_EXECUTABLE=${PYTHON} \
"

do_install:append() {
    if ${@bb.utils.contains("DISTRO_FEATURES", "opencdm", "true", "false", d)}
    then
        install -m 0644 ${D}${includedir}/WPEFramework/interfaces/IDRM.h ${D}${includedir}/cdmi.h
    fi
}

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/* ${datadir}/WPEFramework/* ${PKG_CONFIG_DIR}/*.pc"
FILES:${PN}-dev += "${libdir}/cmake/*"
FILES:${PN} += "${includedir}/cdmi.h"

INSANE_SKIP:${PN} += "dev-so"
INSANE_SKIP:${PN}-dbg += "dev-so"

