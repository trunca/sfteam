# OpenPLi repositories for extra receivers, plugins and skins:

## Dreambox:
* dm500hd
* dm500hdv2
* dm520 (Known as dm52x because it can be used for dm525 too)
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

## Fulan (spark):
* spark
* spark7162

## Raspberry Pi:
* raspberrypi
* raspberrypi0
* raspberrypi2
* raspberrypi3

## INI:
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

## Odin:
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

## Octagon:
* sf4008
* sf5008

## DAGS:
* force1
* force1plus
* force2
* force2nano
* force2plus
* force2plushv
* force2se
* force3uhd
* force3uhdplus
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

## Howto Build:

1. Clone openpli-oe-core somewhere:
* git clone -b develop https://github.com/OpenPLi/openpli-oe-core.git

2. Enter the openpli-oe-core directory:
* cd openpli-oe-core

3. Clone pli-extras:
* git clone https://github.com/PLi-metas/pli-extras.git

4. Initialize and update all repositories:
* pli-extras/update.sh

5. Build for your favourite machine:
* MACHINE=dm800 make image

6. Optional build the feed for your favourite machine:
* MACHINE=dm800 make feed

### Each time you run the command from step 4, all git repositories will get updated to their latest versions.
