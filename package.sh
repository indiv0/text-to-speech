#!/bin/bash
MCP_DIR="../forge/mcp"
PROJECT_DIR=$(pwd)
SRC_DIR=$PROJECT_DIR/src/main/java

mkdir out
rm -rf $MCP_DIR/src/minecraft/in/
cp -R $SRC_DIR/in $MCP_DIR/src/minecraft/

pushd $MCP_DIR
    ./recompile.sh
    ./reobfuscate.sh
    pushd $MCP_DIR/reobf/minecraft/
        cp $SRC_DIR/mcmod.info .
        ls
        zip -r $PROJECT_DIR/out/tts.zip . -i in mcmod.info
        rm -rf $MCP_DIR/src/minecraft/in
    popd

    rm -rf ./reobf/*
popd
