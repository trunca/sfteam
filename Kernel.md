# bitbake fix:
```
export PATH=/location/openpli-oe-core/bitbake/bin:$PATH
export BBPATH=/location/openpli-oe-core/bitbake/bin
```
(Replace "location" with your path)

# Set build (Example: dm800)
* cd build
* source env.source

# Clean kernel
* MACHINE=dm800 bitbake -c clean virtual/kernel

# Customize kerenl configuration
* MACHINE=dm800 bitbake -c menuconfig virtual/kernel

# Compile kernel
* MACHINE=dm800 bitbake -f -c compile virtual/kernel

More information: https://www.openembedded.org/wiki/Kernel_Building
