#!/bin/sh

url="http://localhost:8000"

if [ ! -z "$(which w3m)" ]; then
	w3m $url
elif [ ! -z "$(which lynx)" ]; then
	lynx $url
elif [ ! -z "$(which links)" ]; then
	links $url
else
	echo "Couldn't find w3m, lynx, or links!"
fi
