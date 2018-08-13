SUMMARY = "Firmware files for ap6255 mecool"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "file://firmware-ap6255-mecool.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${sysconfdir}/wifi/
    install -d ${D}${base_libdir}/firmware/brcm
    install -m 0644 nvram_ap6255.txt ${D}${base_libdir}/firmware/brcm/nvram_ap6255.txt
    install -m 0644 BCM4345C0.hcd ${D}${base_libdir}/firmware/brcm/BCM4345C0.hcd
    install -m 0644 fw_bcm43455c0_ag.bin ${D}${base_libdir}/firmware/brcm/fw_bcm43455c0_ag.bin
    install -m 0644 fw_bcm43455c0_ag_apsta.bin ${D}${base_libdir}/firmware/brcm/fw_bcm43455c0_ag_apsta.bin
    install -m 0644 fw_bcm43455c0_ag_p2p.bin ${D}${base_libdir}/firmware/brcm/fw_bcm43455c0_ag_p2p.bin
}
