# OpenPLi repositories for extra receivers, plugins and skins:

## Dreambox:
* DM7020HD
* DM7020HD V2
* DM7080
* DM800
* DM800Se
* DM800Se V2
* DM8000
* DM500HD
* DM500HD V2
* DM520
* DM820
* DM900
* DM920

## Fulan (spark):
* Spark7111
* Spark7162

## Raspberry Pi:
* Pi 1
* Pi 2
* Pi 3
* Pi 3 (64bit)
* Pi Zero

## INI:
* Atemio6000
* Atemio6100
* Atemio6200
* Atemio Nemesis
* Beyonwiz T2
* Beyonwiz T3
* Bwidow X2
* Herobox EX4 HD
* MB Hybrid
* MB Mini Plus
* Opticumtt
* Xsolo Mini 3

## Howto Build:

1. Clone openpli-oe-core somewhere:
..* git clone https://github.com/OpenPLi/openpli-oe-core.git

2. Enter the openpli-oe-core directory:
..* cd openpli-oe-core

3. Clone pli-extras:
..* git clone https://github.com/PLi-metas/pli-extras.git

4. Initialize and update all repositories:
..* pli-extras/update.sh

5. Build for your favourite machine:
..* cd build
..* source env.source
..* MACHINE=dm800 bitbake openpli-enigma2-image

6. Optional build the feed for your favourite machine:
..* MACHINE=dm800 bitbake openpli-enigma2-feed

### Each time you run the command from step 4, all git repositories will get updated to their latest versions.
