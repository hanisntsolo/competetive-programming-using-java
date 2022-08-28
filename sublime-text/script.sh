#!/bin/bash
hi="The world is one!"
echo HelloWorld
echo $hi
sftp pk175202@eersqa.nam.nsroot.net:/home/feeders/pk175202 << EOF
put script.sh
bye
EOF
echo File transfer complete!