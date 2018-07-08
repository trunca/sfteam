MODULE = "OpenWebif"
DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python-cheetah-native rc-models"

RDEPENDS_${PN} = "\
	aio-grab \
	python-cheetah \
	python-compression\
	python-ipaddress\
	python-json \
	python-misc \
	python-numbers \
	python-pyopenssl \
	python-shell \
	python-unixadmin \
	"

inherit gitpkgv distutils-openplugins

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRCREV = "${AUTOREV}"
SRCREV_FORMAT = "${MODULE}"
SRCREV_extrarcmodels_pn-${PN} = "${AUTOREV}"

SRC_URI = "\
	git://github.com/E2OpenPlugins/e2openplugin-${MODULE}.git;protocol=git;name=${MODULE} \
	git://github.com/PLi-metas/extra_rc_models.git;protocol=git;destsuffix=extra_rc_models;name=extrarcmodels \
	"

SRC_URI_append_sh4 += " file://revert_grab_for_sh4.patch "

S="${WORKDIR}/git"

do_configure_prepend() {
	git --git-dir="${WORKDIR}/extra_rc_models/.git" --work-tree="${WORKDIR}/extra_rc_models" pull
	for i in $(find "${WORKDIR}/extra_rc_models/webif" -maxdepth 1 -type f -name "*.png")
	do
		cp -f "${i}" "${S}/plugin/public/images/boxes/"
	done
	for i in $(find "${WORKDIR}/extra_rc_models/webif" -maxdepth 1 -type f -name "*.html")
	do
		cp -f "${i}" "${S}/plugin/public/static/remotes/"
	done
	for i in $(find "${WORKDIR}/extra_rc_models" -maxdepth 1 -type f -name "*.png")
	do
		cp -f "${i}" "${S}/plugin/public/images/remotes/"
	done
	cp -f "${WORKDIR}/extra_rc_models/webif/owibranding.py" "${S}/plugin/controllers/models/"
}
		
# Just a quick hack to "compile" it
do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
	python -O -m compileall ${S}
}

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/${MODULE}"
do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"

python do_cleanup () {
    # contains: MACHINE, box image, remote image, remote map
    boxtypes = [
        ('dm800', 'dm800.jpg', 'dm_normal.png', 'dmm.html'),
        ('dm500hd', 'dm500hd.png', 'dm_normal.png', 'dmm.html'),
        ('dm500hdv2', 'dm500hd.png', 'dm_normal.png', 'dmm.html'),
        ('dm7020hd', 'dm7020hd.png', 'dmm2.png', 'dmm2.html'),
        ('dm7020hdv2', 'dm7020hd.png', 'dmm2.png', 'dmm2.html'),
        ('dm8000', 'dm8000.png', 'dmm1.png', 'dmm1.html'),
        ('dm800se', 'dm800se.png', 'dm_normal.png', 'dmm.html'),
        ('dm800sev2', 'dm800se.png', 'dm_normal.png', 'dmm.html'),
        ('dm7080', 'dm7080.png', 'dmm2.png', 'dmm2.html'),
        ('dm520', 'dm520.png', 'dmm2.png', 'dmm2.html'),
        ('dm820', 'dm820.png', 'dmm2.png', 'dmm2.html'),
        ('dm900', 'dm900.png', 'dmm2.png', 'dmm2.html'),
        ('dm920', 'dm900.png', 'dmm2.png', 'dmm2.html'),
        ('osmega', 'osmega.png', 'osmini.png', 'osmini.html'),
        ('osmini', 'osmini.png', 'osmini.png', 'osmini.html'),
        ('osminiplus', 'osminiplus.png', 'osmini.png', 'osmini.html'),
        ('osnino', 'osnino.png', 'edision1.png', 'edision1.html'),
        ('osninoplus', 'osninoplus.png', 'edision2.png', 'edision2.html'),
        ('formuler1', 'formuler1.png', 'formuler1.png', 'formuler1.html'),
        ('formuler3', 'formuler3.png', 'formuler1.png', 'formuler1.html'),
        ('formuler4', 'formuler4.png', 'formuler1.png', 'formuler1.html'),
        ('formuler4turbo', 'formuler4turbo.png', 'formuler1.png', 'formuler1.html'),
        ('gbquad4k', 'gbquad4k.png', 'gb7252.png', 'gb7252.html'),
        ('gbue4k', 'gbue4k.png', 'gb7252.png', 'gb7252.html'),
        ('hd11', 'hd11.png', 'hd1x00.png', 'hd1x00.html'),
        ('hd1100', 'hd1100.png', 'hd1x00.png', 'hd1x00.html'),
        ('hd1200', 'hd1200.png', 'hd1x00.png', 'hd1x00.html'),
        ('hd1265', 'hd1265.png', 'hd1x00.png', 'hd1x00.html'),
        ('hd1500', 'hd1500.png', 'hd1x00.png', 'hd1x00.html'),
        ('hd2400', 'hd2400.png', 'hd2400.png', 'hd2400.html'),
        ('hd500c', 'hd500c.png', 'hd1x00.png', 'hd1x00.html'),
        ('hd51', 'hd51.png', 'hd1x00.png', 'hd1x00.html'),
        ('hd530c', 'hd530c.png', 'hd1x00.png', 'hd1x00.html'),
        ('vs1000', 'vs1000.png', 'vs1x00.png', 'vs1x00.html'),
        ('vs1500', 'vs1500.png', 'vs1x00.png', 'vs1x00.html'),
        ('et1x000', 'et11000.png', 'et7000mini.png', 'et7000mini.html'),
        ('et7000mini', 'et7000mini.png', 'et7000mini.png', 'et7000mini.html'),
        ('mbmicro', 'mbmicro.png', 'miraclebox2.png', 'miraclebox2.html'),
        ('mbmicrov2', 'mbmicrov2.png', 'miraclebox2.png', 'miraclebox2.html'),
        ('mbtwinplus', 'mbtwinplus.png', 'miraclebox2.png', 'miraclebox2.html'),
        ('alphatriplehd', 'alphatriplehd.png', 'alphatriplehd.png', 'alphatriplehd.html'),
        ('spycat', 'spycat.png', 'spycat.png', 'spycat.html'),
        ('spycat4kmini', 'spycat4kmini.png', 'spycat.png', 'spycat.html'),
        ('spycatmini', 'spycatmini.png', 'spycat.png', 'spycat.html'),
        ('spycatminiplus', 'spycatminiplus.png', 'spycat.png', 'spycat.html'),
        ('vuduo', 'duo.png', 'vu_normal.png', 'vu_normal.html'),
        ('vuduo2', 'duo2.png', 'vu_duo2.png', 'vu_duo2.html'),
        ('vusolo', 'solo.png', 'vu_normal.png', 'vu_normal.html'),
        ('vusolo2', 'solo2.png', 'vu_normal.png', 'vu_normal.html'),
        ('vusolo4k', 'solo4k.png', 'vu_normal.png', 'vu_normal.html'),
        ('vusolose', 'solose.png', 'vu_normal.png', 'vu_normal.html'),
        ('vuultimo', 'ultimo.png', 'vu_ultimo.png', 'vu_ultimo.html'),
        ('vuultimo4k', 'ultimo4k.png', 'vu_normal.png', 'vu_normal.html'),
        ('vuuno', 'uno.png', 'vu_normal.png', 'vu_normal.html'),
        ('vuuno4k', 'uno4k.png', 'vu_normal.png', 'vu_normal.html'),
        ('vuzero', 'zero.png', 'vu_normal.png', 'vu_normal.html'),
        ('vuuno4kse', 'uno4kse.png', 'vu_normal_02.png', 'vu_normal_02.html'),
        ('vuzero4k', 'zero4k.png', 'vu_normal_02.png', 'vu_normal_02.html'),
        ('wetekplay', 'wetekplay.png', 'wetekplay.png', 'wetekplay.html'),
        ('xp1000', 'xp1000.png', 'xp_rc14_normal.png', 'xp1000.html'),
        ('xpeedc', 'xpeedlx.png', 'xpeedlx.png', 'xpeedlx.html'),
        ('fusionhd', 'fusionhd.png', 'fusionhd.png', 'fusionhd.html'),
        ('fusionhdse', 'fusionhdse.png', 'fusionhdse.png', 'fusionhdse.html'),
        ('galaxy4k', 'galaxy4k.png', 'galaxy4k.png', 'galaxy4k.html'),
        ('purehd', 'purehd.png', 'purehd.png', 'purehd.html'),
        ('purehdse', 'purehdse.png', 'purehd.png', 'purehd.html'),
        ('revo4k', 'revo4k.png', 'revo4k.png', 'revo4k.html'),
        ('et10000', 'et10000.png', 'et8000.png', 'et8000.html'),
        ('et4x00', 'et4x00.png', 'et_rc13_normal.png', 'et4x00.html'),
        ('et5x00', 'et5x00.png', 'et_rc5_normal.png', 'et5x00.html'),
        ('et6x00', 'et6x00.png', 'et_rc5_normal.png', 'et5x00.html'),
        ('et7x00', 'et7x00.png', 'et7x00.png', 'et7x00.html'),
        ('et9x00', 'et9x00.png', 'et_rc7_normal.png', 'et9x00.html'),
        ('et6500', 'et6500.png', 'et6500.png', 'et6500.html'),
        ('et7000', 'et7000.png', 'et7x00.png', 'et7x00.html'),
        ('et7500', 'et7000.png', 'et7x00.png', 'et7x00.html'),
        ('et8000', 'et8000.png', 'et8000.png', 'et8000.html'),
        ('et8500', 'et8500.png', 'et8000.png', 'et8000.html'),
        ('h3', 'h3.png', 'h3.png', 'h3.html'),
        ('h4', 'h4.png', 'h3.png', 'h3.html'),
        ('h5', 'h5.png', 'h3.png', 'h3.html'),
        ('h6', 'h5.png', 'h3.png', 'h3.html'),
        ('h7', 'h7.png', 'h3.png', 'h3.html'),
        ('h9', 'h9.png', 'h9.png', 'h9.html'),
        ('i55', 'i55.png', 'i55.png', 'i55.html'),
        ('lc', 'lc.png', 'sh1.png', 'sh1.html'),
        ('sh1', 'sh1.png', 'sh1.png', 'sh1.html'),
        ('vipercombo', 'vipercombo.png', 'amiko.png', 'amiko.html'),
        ('vipercombohdd', 'vipercombohdd.png', 'amiko1.png', 'amiko1.html'),
        ('vipert2c', 'vipert2c.png', 'amiko.png', 'amiko.html'),
        ('lunix3-4k', 'lunix3-4k.png', 'qviart.png', 'qviart.html'),
        ('lunix', 'lunix.png', 'qviart.png', 'qviart.html'),
        ('e4hd', 'e4hd.png', 'e4hd.png', 'e4hd.html'),
        ('spark', 'spark.jpg', 'spark.png', 'spark.html'),
        ('spark7162', 'spark7162.jpg', 'spark.png', 'spark7162.html'),
    ]

    import os

    pluginpath = "%s%s" % (d.getVar('D', True), d.getVar('PLUGINPATH', True))
    images = "%s/public/images/" % pluginpath
    keymaps = "%s/public/static/" % pluginpath

    target_box = 'unknown.png'
    target_remote = 'ow_remote.png'
    target_keymap = ''
    exception = ''

    for x in boxtypes:
        if x[0] == d.getVar('MACHINE', True):
            target_box = x[1]
            target_remote = x[2]
            target_keymap = x[3]
            if x[0] == 'et6x00':
                exception = 'et6500.png'
            elif x[0] == 'et7x00':
                exception = 'et7500.png'
            elif x[0] == 'xpeedc':
                exception = 'xpeedlx.png'
            break

    for root, dirs, files in os.walk(images + 'boxes', topdown=False):
        for name in files:
            if target_box != name and name != 'unknown.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(images + 'remotes', topdown=False):
        for name in files:
            if target_remote != name and name != 'ow_remote.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(keymaps + 'remotes', topdown=False):
        for name in files:
            if target_keymap != name:
                os.remove(os.path.join(root, name))
}

addtask do_cleanup after do_populate_sysroot before do_package

RREPLACES_${PN} = "enigma2-plugin-extensions-openwebif"
RCONFLICTS_${PN} = "enigma2-plugin-extensions-openwebif"
RPROVIDES_${PN} =+ "enigma2-plugin-extensions-openwebif"

PACKAGES =+ "${PN}-vxg ${PN}-vti-theme"
DESCRIPTION_${PN}-vxg = "Adds Google Chrome support to OpenWebif's WebTV"
DESCRIPTION_${PN}-vti-theme = "VTI theme files"
FILES_${PN}-vxg = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/vxg"
FILES_${PN}-vti-theme = "\
			${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/themes/absb \
			${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/controllers/views/responsive \
			"
RDEPENDS_${PN}-vxg =+ "${PN}"
RDEPENDS_${PN}-vti-theme =+ "${PN}"
RREPLACES_${PN}-vxg = "enigma2-plugin-extensions-openwebif-vxg"
RCONFLICTS_${PN}-vxg = "enigma2-plugin-extensions-openwebif-vxg"
RPROVIDES_${PN}-vxg =+ "enigma2-plugin-extensions-openwebif-vxg"
