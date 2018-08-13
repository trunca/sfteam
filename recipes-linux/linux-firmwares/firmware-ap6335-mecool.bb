SUMMARY = "Firmware files for ap6335 mecool"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "file://firmware-ap6335-mecool.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware/brcm"
FILES_${PN} += "${sysconfdir}/wifi/"

do_install() {
    install -d ${D}${sysconfdir}/wifi/
    install -m 0755 config.txt  ${D}${sysconfdir}/wifi/config.txt
    install -d ${D}${base_libdir}/firmware/brcm
    install -m 0644 nvram_ap6335.txt ${D}${base_libdir}/firmware/brcm/nvram_ap6335.txt
    install -m 0644 nvram_ap6335e.txt ${D}${base_libdir}/firmware/brcm/nvram_ap6335e.txt
    install -m 0644 bcm4335c0.hcd ${D}${base_libdir}/firmware/brcm/bcm4335c0.hcd
    install -m 0644 fw_bcm4339a0_ag.bin ${D}${base_libdir}/firmware/brcm/fw_bcm4339a0_ag.bin
    install -m 0644 fw_bcm4339a0_ag_apsta.bin ${D}${base_libdir}/firmware/brcm/fw_bcm4339a0_ag_apsta.bin
    install -m 0644 fw_bcm4339a0_ag_p2p.bin ${D}${base_libdir}/firmware/brcm/fw_bcm4339a0_ag_p2p.bin
    install -m 0644 fw_bcm4339a0e_ag.bin ${D}${base_libdir}/firmware/brcm/fw_bcm4339a0e_ag.bin
    install -m 0644 fw_bcm4339a0e_ag_apsta.bin ${D}${base_libdir}/firmware/brcm/fw_bcm4339a0e_ag_apsta.bin
    install -m 0644 fw_bcm4339a0e_ag_p2p.bin ${D}${base_libdir}/firmware/brcm/fw_bcm4339a0e_ag_p2p.bin
}
