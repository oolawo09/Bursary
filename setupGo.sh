# !/bin/bash

#create directory structure for building Go in Jenkins
#dev systems should already have Go installed

if [ -d "gopath" ]; then
	rm -rf gopath
fi

mkdir -p gopath/src/pipeline
cp -r * gopath/src/pipeline

cd gopath

wget https://storage.googleapis.com/golang/go1.4.2.linux-amd64.tar.gz
tar xzf go1.4.2.linux-amd64.tar.gz

mkdir bin 
mkdir pkg

export GOROOT=`pwd`/go
export GOPATH=`pwd`
echo "*************"
echo "GOPATH=$GOPATH"
ls $GOPATH
echo "*************"
echo "GOROOT=$GOROOT"
ls $GOROOT
export PATH=$PATH:$GOROOT/bin:$GOPATH/bin


go version 
