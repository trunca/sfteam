# Ugly workaround to skip installing the rt7777 on receivers with kernel older than 3.3
TEST01 = "${@bb.utils.contains("TARGET_ARCH", "sh4", "", "rt7777", d)}"
TEST02 = "${@bb.utils.contains("MACHINE", "dm800", "", "${TEST01}", d)}"
TEST03 = "${@bb.utils.contains("MACHINE", "dm800se", "", "${TEST02}", d)}"
TEST04 = "${@bb.utils.contains("MACHINE", "dm8000", "", "${TEST03}", d)}"
TEST05 = "${@bb.utils.contains("MACHINE", "dm800sev2", "", "${TEST04}", d)}"
TEST06 = "${@bb.utils.contains("MACHINE", "dm500hd", "", "${TEST05}", d)}"
TEST07 = "${@bb.utils.contains("MACHINE", "dm7020hd", "", "${TEST06}", d)}"
TEST08 = "${@bb.utils.contains("MACHINE", "dm7020hdv2", "", "${TEST07}", d)}"
TEST09 = "${@bb.utils.contains("MACHINE", "dm520", "", "${TEST08}", d)}"
TEST10 = "${@bb.utils.contains("MACHINE", "dm7080", "", "${TEST09}", d)}"
TEST11 = "${@bb.utils.contains("MACHINE", "dm820", "", "${TEST10}", d)}"
TEST12 = "${@bb.utils.contains("MACHINE", "dm500hdv2", "", "${TEST11}", d)}"
TEST13 = "${@bb.utils.contains("MACHINE", "ixussone", "", "${TEST12}", d)}"
RT7777 = "${@bb.utils.contains("MACHINE", "ixusszero", "", "${TEST13}", d)}"

# Add enigma2-plugin-extensions-openwebif-extras to replace enigma2-plugin-extensions-openwebif
ENIGMA2_PLUGINS_remove = " \
	enigma2-plugin-extensions-openwebif \
	"

# Ship some extra stuff with the image except for smallflash
ENIGMA2_PLUGINS_append = " \
	enigma2-plugin-extensions-openwebif-extras \
	${@bb.utils.contains('MACHINE_FEATURES', 'ci', 'enigma2-plugin-systemplugins-commoninterfaceassignment', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'dvd', 'enigma2-plugin-extensions-cdinfo enigma2-plugin-extensions-dvdplayer', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'fan', 'enigma2-plugin-systemplugins-tempfancontrol', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', '7seg', 'enigma2-plugin-systemplugins-vfdcontrol', '', d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", " \
	enigma2-plugin-extensions-openwebif-extras-vti-theme \
	enigma2-plugin-softcams-oscam \
	enigma2-plugin-softcams-oscam-emu", d)} \
	"

IMAGE_INSTALL_append += " \
	${RT7777} \
	${@bb.utils.contains('MACHINE_FEATURES', 'dvd', 'cdtextinfo', '', d)} \	
	"
