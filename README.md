# MIFSA OpenEmbedded/Yocto Project layer

This layer depends on:

URI: https://github.com/openembedded/openembedded-core

Support poky branch:

- sumo
- thud
- warrior
- dunfell
- hardknott
- gatesgarth

## How to use:

Put the required meta in the unified directory, for example:

```
poky
meta-openembedded
meta-mifsa
src/...
...
```

Then, set the environment variable for TEMPLATECONF, for example:

```
export TEMPLATECONF=/work/meta-mifsa/conf/template/qemu
```

Finally

```
source poky/oe-init-build-env
bitbake mifsa-image-qemu
```



## How to adapt:

TODO:

## Copyright:

Juntuan.Lu, 2020-2030, All rights reserved.
