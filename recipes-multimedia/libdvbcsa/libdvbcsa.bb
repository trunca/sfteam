SUMMARY = "Open implementation of the DVB Common Scrambling Algorithm, encrypt and decrypt "
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI[md5sum] = "3b6a93cd0fef52ca9ed233a3ed3ee386"
SRC_URI[sha256sum] = "02511b2d6b82793a2616757e54b5e582653b58b1a1c6ce60d7bc9ca05739bbd0"

SRCREV = "bc6c0b164a87ce05e9925785cc6fb3f54c02b026"

PV = "1.1.0"

SRC_URI = "https://code.videolan.org/videolan/libdvbcsa.git file://libdvbcsa.pc"

S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

do_install_append() {
    install -d ${D}${includedir}/dvbcsa/
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${S}/src/dvbcsa/dvbcsa.h ${D}${includedir}/dvbcsa/
    install -m 0644 ${WORKDIR}/libdvbcsa.pc ${D}${libdir}/pkgconfig/
}
