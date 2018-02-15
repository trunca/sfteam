#!/bin/sh
SCRIPTPATH="$( cd "$(dirname "$0")" ; pwd -P )"
cd "${SCRIPTPATH}"
git submodule sync
git submodule update --init
METAS="$(ls | grep meta- | tr '\n' ' ' | sed 's/ $//g')"
cd ..
# Regenerate bblayers.conf so we can add our own
make init update
for i in ${METAS}
do
	sed -i "s/\"$/ ${SCRIPTPATH}\/${i}\"/g" build/conf/bblayers.conf
done
sed -i "s/\"$/ ${SCRIPTPATH}\"/g" build/conf/bblayers.conf
