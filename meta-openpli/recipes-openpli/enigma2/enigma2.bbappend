FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RRECOMMENDS_${PN}_remove_exteplayeronly = " \
        gstreamer1.0-plugin-subsink \
        ${GST_BASE_RDEPS} \
        ${GST_GOOD_RDEPS} \
        ${GST_BAD_RDEPS} \
        ${GST_UGLY_RDEPS} \
        "

SRC_URI += " file://enigma2_bh_skin_support.patch "
