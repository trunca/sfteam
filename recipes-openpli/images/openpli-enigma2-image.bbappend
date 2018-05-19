# Ugly workaround to skip installing the rt7777 on receivers with kernel older than 3.3
TEST07 = "${@bb.utils.contains("TARGET_ARCH", "sh4", "", "rt7777", d)}"
TEST17 = "${@bb.utils.contains("MACHINE", "dm800", "", "${TEST07}", d)}"
TEST27 = "${@bb.utils.contains("MACHINE", "dm800se", "", "${TEST17}", d)}"
TEST37 = "${@bb.utils.contains("MACHINE", "dm8000", "", "${TEST27}", d)}"
TEST47 = "${@bb.utils.contains("MACHINE", "dm800sev2", "", "${TEST37}", d)}"
TEST57 = "${@bb.utils.contains("MACHINE", "dm500hd", "", "${TEST47}", d)}"
TEST67 = "${@bb.utils.contains("MACHINE", "dm7020hd", "", "${TEST57}", d)}"
TEST77 = "${@bb.utils.contains("MACHINE", "dm7020hdv2", "", "${TEST67}", d)}"
TEST87 = "${@bb.utils.contains("MACHINE", "dm520", "", "${TEST77}", d)}"
TEST97 = "${@bb.utils.contains("MACHINE", "dm7080", "", "${TEST87}", d)}"
TESTA7 = "${@bb.utils.contains("MACHINE", "dm820", "", "${TEST97}", d)}"
RT7777 = "${@bb.utils.contains("MACHINE", "dm500hdv2", "", "${TESTA7}", d)}"

# Add enigma2-plugin-extensions-openwebif-extras to replace enigma2-plugin-extensions-openwebif
ENIGMA2_PLUGINS_remove = " \
	enigma2-plugin-extensions-openwebif \
	"

# Ship some extra stuff with the image except for smallflash
ENIGMA2_PLUGINS_append = " \
	enigma2-plugin-extensions-openwebif-extras \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", " \
	enigma2-plugin-extensions-openwebif-extras-vti-theme \
	enigma2-plugin-softcams-oscam \
	enigma2-plugin-softcams-oscam-emu", d)} \
	"

IMAGE_INSTALL_append += " \
	${RT7777} \
	"
