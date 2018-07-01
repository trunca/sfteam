# Extra repositories for PLi's OE: https://github.com/OpenPLi/openpli-oe-core

# Amlogic
* alien5
* k1plus
* k1pro
* k2pro
* k3pro
* wetekplay
* wetekplay2
* x8hp

# AZBox
* azboxhd
* azboxme
* azboxminime

# Ceryon
* 9910lx
* 9911lx
* e4hd
* e4hdcombo
* e4hdhybrid
* odin2hybrid
* odinplus
* protek4k
* sf208
* sf228
* sf238
* singleboxlcd
* twinboxlcd
* twinboxlcdci5

# DAGS
* force1
* force1plus
* force2
* force2nano
* force2plus
* force2plushv
* force2se
* force3uhd
* force3uhdplus
* force4
* iqonios100hd
* iqonios200hd
* iqonios300hd
* iqonios300hdv2
* mediaart200hd
* mediabox
* megaforce1plus
* megaforce2
* optimussos
* optimussos1
* optimussos1plus
* optimussos2
* optimussos2plus
* optimussos3plus
* roxxs200hd
* tm2t
* tm4ksuper
* tmnano
* tmnano2super
* tmnano2t
* tmnano3t
* tmnanom3
* tmnanose
* tmnanosecombo
* tmnanosem2
* tmnanosem2plus
* tmnanoseplus
* tmsingle
* tmtwin
* tmtwin4k
* valalinux
* worldvisionf1
* worldvisionf1plus

# Dinobot
* anadol4k
* axashis4kcombo
* axashis4kcomboplus
* dinobot4k
* dinobot4kl
* dinobot4kmini
* dinobot4kplus
* dinobot4kse
* mediabox4k

# Dreambox
* dm500hd
* dm500hdv2
* dm520
* dm7020hd
* dm7020hdv2
* dm7080
* dm800
* dm8000
* dm800se
* dm800sev2
* dm820
* dm900
* dm920

# Entwopia
* bre2ze
* enfinity
* evomini
* evominiplus
* marvel1
* viperslim
* x2plus

# Fulan
* spark
* spark7162

# INI
* atemio5x00
* atemio6000
* atemio6100
* atemio6200
* atemionemesis
* beyonwizt2
* beyonwizt3
* beyonwizt4
* bwidowx
* bwidowx2
* evoslim
* heroboxex4hd
* mbhybrid
* mbmini
* mbminiplus
* mbtwin
* mbultra
* opticumtt
* sezam1000hd
* sezam5000hd
* sezammarvel
* ventonhdx
* xpeedlx
* xpeedlx3
* xsolomini3

# Octagon
* sf4008
* sf5008

# Odin
* axase3
* axase3c
* axodin
* axodinc
* classm
* evo
* evoe3hd
* galaxym6
* genius
* geniuse3hd
* maram9
* starsatlx

# Raspberry Pi
* raspberrypi
* raspberrypi0
* raspberrypi2
* raspberrypi3

# XCore
* bcm7358
* spycat4k
* spycat4kcombo
* spycat4kmini
* vp7358ci (Sample)

# Ubuntu 18.04 LTS setup
* sudo dpkg-reconfigure dash

Answer: No

* sudo apt-get install autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git gzip help2man ncurses-bin libncurses5-dev libc6-dev libtool make texinfo patch perl pkg-config subversion tar texi2html wget chrpath libxml2-utils xsltproc python-setuptools libc6 genromfs mtd-utils dpkg-dev sshpass poedit translate-toolkit xclip linux-firmware linux-headers-`uname -r` linux-headers-generic linux-image-generic linux-libc-dev linux-source u-boot-tools upx-ucl doxygen repo optipng python-dev libglib2.0-dev pngquant default-jdk

# How to build an image (Example: dm800)
1. Clone openpli-oe-core somewhere:
* git clone -b develop https://github.com/OpenPLi/openpli-oe-core.git

2. Enter the openpli-oe-core directory:
* cd openpli-oe-core

3. Clone pli-extras:
* git clone https://github.com/PLi-metas/pli-extras.git

4. Initialize and update all repositories:
* pli-extras/update.sh

5. Build PLi image for your machine:
* MACHINE=dm800 make image

6. (Optional) Build the feed for your machine:
* MACHINE=dm800 make feed
```
Hint: Each time you run the command from step 4 all git repositories will get updated to their latest versions.
```
