touch test3.sh
chmod 755 test3.sh
cat <<EOF >test3.sh
#!/bin/bash
echo file-transfer-started
sftp pk175202@eersqa.nam.nsroot.net:/home/feeders/pk175202 <<EOF
put test3.sh
bye
EOF
file=test3.sh
echo "EOF" >> $file 