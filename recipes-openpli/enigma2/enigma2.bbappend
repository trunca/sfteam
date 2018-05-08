FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += " \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "git://github.com/PLi-metas/extra_rc_models.git;destsuffix=extra_rc_models;name=extra_rc_models", d)} \
        "

SRCREV[extra_rc_models] = "${AUTOREV}"
SRCREV_FORMAT = "enigma2"

do_configure_prepend() {
	if [ ! "${TARGET_ARCH}" == "sh4" ]
	then
		# Restore the files first in case we run configure twice between checking out the source
		git --git-dir="${S}/.git" --work-tree="${S}" checkout "${S}/data/rc_models/Makefile.am"
		git --git-dir="${S}/.git" --work-tree="${S}" checkout "${S}/data/rc_models/rc_models.cfg"
		git --git-dir="${WORKDIR}/extra_rc_models/.git" --work-tree="${WORKDIR}/extra_rc_models" pull
		for i in $(find "${WORKDIR}/extra_rc_models" -maxdepth 1 -type f -name "*.xml" -o -name "*.png")
		do
			file="$(echo "${i}" | sed 's:.*/::')"
			sed -i '${s/$/'" $file"'/}' "${S}/data/rc_models/Makefile.am"
			cp -f "${i}" "${S}/data/rc_models/"
		done
		cat "${WORKDIR}/extra_rc_models/rc_models.cfg" >> "${S}/data/rc_models/rc_models.cfg"
	fi
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PYTHON_RDEPS += " \
	python-service-identity \
"

SRC_URI_append_dm800 += " \
    file://e2_old_dvbapi.patch \
    file://fix-wrong-driver-date.patch \
"

inherit upx_compress

SRC_URI_append += " \
	${@bb.utils.contains("MACHINE_FEATURES", "dreambox", "\
	file://use-ioctl-22-for-h265.patch \
	file://fix-fp-version.patch \
	file://dual-tuner-letter-detection.patch \
	", "", d)} \
"

SRC_URI_append_dm900 += " \
    file://add-skin_display-dm9x0.patch \
    file://dm9x0-recoverymode.patch \
    file://add-support-2160p.patch \
    file://make-front-led-configurable.patch \
    file://adapt-res-to-dm9x0-display.patch \
    file://move-lcd-text-a-bit-to-the-right.patch \
    file://fix-framebuffer-and-use-ion-to-allocate-accel-memory.patch \
"

SRC_URI_append_dm920 += " \
    file://add-skin_display-dm9x0.patch \
    file://dm9x0-recoverymode.patch \
    file://add-support-2160p.patch \
    file://make-front-led-configurable.patch \
    file://adapt-res-to-dm9x0-display.patch \
    file://move-lcd-text-a-bit-to-the-right.patch \
    file://fix-framebuffer-and-use-ion-to-allocate-accel-memory.patch \
"

SRC_URI_append_dm8000 += " \
    file://fix-wrong-driver-date.patch \
"
