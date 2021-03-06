# Extra repositories for PLi's OE: https://github.com/OpenPLi/openpli-oe-core

# Amlogic
* alien5
* k1plus
* k1pro
* k2pro
* k2prov2
* k3pro
* odroidc2
* wetekhub
* wetekplay
* wetekplay2
* x8hp

# AX
* triplex
* ultrabox

# AZBox
* azboxhd
* azboxme
* azboxminime

# BlackBox
* sogno8800hd
* uniboxhde

# BroadMedia
* bre2zet2c
* sf128
* sf138
* sf3038

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

# Clap
* cc1

# Cube
* cube

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
* mediabox
* optimussos
* optimussos1
* optimussos1plus
* optimussos2
* optimussos2plus
* optimussos3plus
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

# EBox
* ebox5000
* ebox5100
* ebox7358
* eboxlumi

# Entwopia
* bre2ze
* enfinity
* evomini
* evominiplus
* marvel1
* x2plus

# Fulan
* spark
* spark7162

# GB
* gb800se
* gb800seplus
* gb800solo
* gb800ue
* gb800ueplus
* gbipbox
* gbquad
* gbquadplus
* gbultrase
* gbultraue
* gbultraueh
* gbx1
* gbx2
* gbx3
* gbx3h

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

# IXUSS
* ixussone
* ixusszero

# Octagon
* sf4008
* sf5008
* sf8008

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

# Protek
* 9900lx

# Raspberry Pi
* raspberrypi
* raspberrypi0
* raspberrypi2
* raspberrypi3

# Tiviar
* tiviaraplus
* tiviarmin

# Tripledot
* enibox
* evoslimse
* evoslimt2c
* mago
* sf108
* sf98
* t2cable
* tyrant
* x1plus
* xcombo

# XCore
* bcm7358
* spycat4k
* spycat4kcombo
* spycat4kmini
* vp7358ci

# XT
* beyonwizu4
* et13000

# Ubuntu 18.04 LTS setup
* sudo dpkg-reconfigure dash

Answer: No

* sudo apt-get install autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git gzip help2man ncurses-bin libncurses5-dev libc6-dev libtool make texinfo patch perl pkg-config subversion tar texi2html wget chrpath libxml2-utils xsltproc python-setuptools libc6 genromfs mtd-utils dpkg-dev sshpass poedit translate-toolkit xclip linux-firmware linux-headers-`uname -r` linux-headers-generic linux-image-generic linux-libc-dev linux-source u-boot-tools upx-ucl doxygen repo optipng python-dev libglib2.0-dev pngquant default-jdk

# How to build an Open PLi image (PLi experience)
1. Clone openpli-oe-core somewhere:
* git clone -b develop https://github.com/OpenPLi/openpli-oe-core.git

2. Enter the openpli-oe-core directory:
* cd openpli-oe-core

3. Clone pli-extras:
* git clone -b develop https://github.com/PLi-metas/pli-extras.git

4. Initialize and update all repositories:
* cd pli-extras
* ./update.sh
* cd ..

5. Build PLi image for your machine (Example: dm7020hd):
* MACHINE=dm7020hd make image

6. (Optional) Build the feed for your machine:
* MACHINE=dm7020hd make feed
```
Hint: Each time you run the command from step 4 all git repositories will get updated to their latest versions.
```
# If you got machine error the next time you wanted to build an image:
* cd pli-extras
* ./update.sh
* cd ..
* MACHINE=dm7020hd make image

# How to build our vision image
5. Build our vision of enigma2 image for your machine (Example: dm7020hd):
* cd build
* source env.source
* MACHINE=dm7020hd bitbake vision-enigma2-image
