#!/bin/sh

#*********************************************************************************
#  *Copyright(C): Juntuan.Lu, 2020-2030, All rights reserved.
#  *Author:  Juntuan.Lu
#  *Version: 1.0
#  *Date:  2022/04/01
#  *Email: 931852884@qq.com
#  *Description:
#  *Others:
#  *Function List:
#  *History:
#**********************************************************************************

if [ -z $BUILDDIR ];then
    BUILDDIR=$(pwd)
fi

if [ -f $BUILDDIR/conf/local.conf ] && [ $(grep -c "\[mifsa\]" $BUILDDIR/conf/local.conf) -ne '0' ];then
    echo "Configuration is already set, ignore"
    return
fi

echo "--- Start up mifsa yocto conf..."
echo "#[mifsa] Yocto Project Settings" >> $BUILDDIR/conf/local.conf
if [ -n "$MIRROR_URL" ]; then
    echo "INHERIT += \"own-mirrors\"" >> $BUILDDIR/conf/local.conf
    echo "CONNECTIVITY_CHECK_URIS = \"$MIRROR_URL/\"" >> $BUILDDIR/conf/local.conf
    echo "SOURCE_MIRROR_URL = \"$MIRROR_URL/\"" >> $BUILDDIR/conf/local.conf
    echo "BB_FETCH_PREMIRRORONLY = \"1\"" >> $BUILDDIR/conf/local.conf
    echo "BB_NO_NETWORK = \"0\"" >> $BUILDDIR/conf/local.conf
    export BB_NO_NETWORK=0
elif [ -n "$DEV_DL_DIR" ]; then
    echo "DL_DIR = \"$DEV_DL_DIR/\"" >> $BUILDDIR/conf/local.conf
    echo "BB_GENERATE_MIRROR_TARBALLS = \"1\"" >> $BUILDDIR/conf/local.conf
    echo "BB_NO_NETWORK = \"0\"" >> $BUILDDIR/conf/local.conf
    export BB_NO_NETWORK=0
fi
echo "#" >> $BUILDDIR/conf/local.conf
echo "--- Start up mifsa yocto conf done."
