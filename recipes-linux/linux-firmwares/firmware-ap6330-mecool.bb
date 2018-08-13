SUMMARY = "Firmware files for ap6330 mecool"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "file://firmware-ap6330-mecool.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware/brcm"
FILES_${PN} += "${sysconfdir}/wifi/"

do_install() {
    install -d ${D}${sysconfdir}/wifi/
    install -m 0755 config.txt  ${D}${sysconfdir}/wifi/config.txt
    install -d ${D}${base_libdir}/firmware/brcm
    install -m 0644 nvram_ap6330.txt ${D}${base_libdir}/firmware/brcm/nvram_ap6330.txt
    install -m 0644 bcm40183b2.hcd ${D}${base_libdir}/firmware/brcm/bcm40183b2.hcd
    install -m 0644 fw_bcm40183b2.bin ${D}${base_libdir}/firmware/brcm/fw_bcm40183b2.bin
    install -m 0644 fw_bcm40183b2_apsta.bin ${D}${base_libdir}/firmware/brcm/fw_bcm40183b2_apsta.bin
    install -m 0644 fw_bcm40183b2_p2p.bin ${D}${base_libdir}/firmware/brcm/fw_bcm40183b2_p2p.bin
}
