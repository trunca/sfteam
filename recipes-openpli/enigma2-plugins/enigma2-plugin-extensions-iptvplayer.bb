SUMMARY = "IPTV Player for E2"
DESCRIPTION = "IPTV Player for E2"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://IPTVPlayer/plugin.py;md5=91e5a739958c67f4f17e5e0d8689ffcd"
SRC_URI = "git://github.com/PLi-metas/iptvplayer-for-e2.git;protocol=http"

S = "${WORKDIR}/git"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

inherit allarch distutils-openplugins gettext

DEPENDS = "gettext-native python"
RRECOMMENDS_${PN} = " \
	python-core \
	enigma2-plugin-extensions-iptvplayer-deps \
	"

PACKAGES =+ " ${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa

