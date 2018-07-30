ENIGMA2_OPTIONAL_append += "\
	enigma2-plugin-extensions-dreamplex \
	enigma2-plugin-extensions-install-ffmpeg \
	enigma2-plugin-extensions-install-exteplayer3 \
	enigma2-plugin-extensions-install-gstplayer \
	enigma2-plugin-extensions-iptvplayer \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-skins-dreamplexskins \
	enigma2-plugin-skins-mx-hq9w \
	enigma2-plugin-skins-mx-hq7 \
	enigma2-plugin-skins-glamouraurafhd \
	enigma2-plugin-skins-kravenfhd \
	enigma2-plugin-skins-kravenhd \
	enigma2-plugin-skins-kravenvb \
	enigma2-plugin-skins-sevenhd \
	enigma2-plugin-skins-xionhdf \
	enigma2-plugin-systemplugins-bh-skin-support \
	${@bb.utils.contains("MACHINE_FEATURES", "multitranscoding", "streamproxy", "", d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'qtplugins', 'enigma2-plugin-extensions-qthbbtv enigma2-plugin-extensions-qtstalker', '', d)} \
	"

OPTIONAL_PACKAGES_append += "\
	lirc \
	iptraf \
	smbnetfs \
	sshfs-fuse \
	upx \
	"
