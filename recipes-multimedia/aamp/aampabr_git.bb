DESCRIPTION = "AAMP ABR library"
HOMEPAGE = "https://github.com/rdkcmf/rdk-aampabr"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

PV = "0.1.gitr${SRCPV}"

SRC_URI = "git://github.com/rdkcmf/rdk-aampabr.git;protocol=git;branch=stable2"
#SRCREV = "e26f47a03c2648e049c7605cf4a471cda3d37464"
SRCREV = "baf59ee4fa697809ed9a11552c02e36a02e28fd7"

S = "${WORKDIR}/git"

inherit cmake

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"
FILES_${PN} += "${libdir}/lib*.so"

# Fixme, something is pointing to a non-symlink and that pulls in -dev packages
INSANE_SKIP_${PN} = "dev-deps"
