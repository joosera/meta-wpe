SUMMARY = "AAMP ABR library"
DESCRIPTION = "ABR (Automatic BitRate) Library is an independent library for automatic bitrate switching.\
    ABR will start at a reasonable bitrate and will ramp up or down, depending on network conditions."
HOMEPAGE = "https://github.com/rdkcmf/rdk-aampabr"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

PV = "0.1.gitr${SRCPV}"

SRC_URI = "git://github.com/rdkcmf/rdk-aampabr.git;branch=stable2;protocol=https"
SRCREV = "baf59ee4fa697809ed9a11552c02e36a02e28fd7"

S = "${WORKDIR}/git"

inherit cmake

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"
FILES:${PN} += "${libdir}/lib*.so"

# Fixme, something is pointing to a non-symlink and that pulls in -dev packages
INSANE_SKIP:${PN} = "dev-deps"

