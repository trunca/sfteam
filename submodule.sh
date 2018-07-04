#!/bin/sh
echo ""
echo "This is only for MastaG, Persian Prince and Hains with push access"
echo ""
echo "Stage 1: git pull for new changes"
echo ""
cd meta-amlogic
git checkout develop
git pull
cd ..
cd meta-azbox
git checkout develop
git pull
cd ..
cd meta-ceryon
git checkout develop
git pull
cd ..
cd meta-dags
git checkout develop
git pull
cd ..
cd meta-dinobot
git checkout develop
git pull
cd ..
cd meta-dream
git checkout sumo
git pull
cd ..
cd meta-entwopia
git checkout develop
git pull
cd ..
cd meta-fulan
git checkout sumo
git pull
cd ..
cd meta-ini
git checkout develop
git pull
cd ..
cd meta-octagon
git checkout develop
git pull
cd ..
cd meta-odin
git checkout develop
git pull
cd ..
cd meta-raspberrypi
git checkout sumo
git pull
cd ..
cd meta-xcore
git checkout develop
git pull
cd ..
echo "Stage 2: git add for new changes"
echo ""
git add *
git commit -S -m "Update submodules"
echo "Stage 3: git push for new changes"
echo ""
git push
echo "Done: all git repositories get updated to their latest versions!"
echo ""
