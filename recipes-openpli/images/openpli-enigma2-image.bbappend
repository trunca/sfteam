# Add enigma2-plugin-extensions-openwebif-extras to replace enigma2-plugin-extensions-openwebif
ENIGMA2_PLUGINS_remove += "\
	enigma2-plugin-extensions-openwebif \
	"

# Ship some extra stuff with the image except for smallflash STBs
ENIGMA2_PLUGINS_append += "\
	enigma2-plugin-extensions-openwebif-extras \
	${@bb.utils.contains('MACHINE_FEATURES', 'ci', 'enigma2-plugin-systemplugins-commoninterfaceassignment', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'dvd', 'enigma2-plugin-extensions-cdinfo enigma2-plugin-extensions-dvdplayer', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'fan', 'enigma2-plugin-systemplugins-extrafancontrol', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', '7seg', 'enigma2-plugin-systemplugins-vfdcontrol', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', '7segment', 'enigma2-plugin-systemplugins-vfdcontrol', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'multitranscoding', 'enigma2-plugin-systemplugins-transcodingsetup', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'fanctrl', 'enigma2-plugin-extensions-fancontrol2', '', d)} \
	"

IMAGE_INSTALL_append += "\
	${@bb.utils.contains('MACHINE_FEATURES', 'dvd', 'cdtextinfo', '', d)} \
	"

IMAGE_INSTALL_remove += "\
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "\
	samba-base \
	", "", d)} \
	"
