#!/bin/bash

# Define variables
OVERLEAF_URL="https://www.overleaf.com"
PROJECT_ID="666369ba6ab65e33c0099183"
LOGIN_EMAIL="ds.pratap1997@gmail.com"
LOGIN_PASSWORD="Dh1@pratap"
LOCAL_PROJECT_DIR="/docker-infrastructure/docker-infrastructure/overleaf/zip"
GITHUB_REPO_URL="https://github.com/hanisntsolo/resume.git"

# Temporary files for cookies and login
COOKIES_FILE=$(mktemp)
LOGIN_PAYLOAD=$(mktemp)
ZIP_FILE=$(mktemp --suffix=.zip)
LOGIN_RESPONSE=$(mktemp)
DOWNLOAD_RESPONSE=$(mktemp)

# Log start
echo "Starting Overleaf to GitHub sync..."

# Prepare login payload
echo "Preparing login payload..."
cat > $LOGIN_PAYLOAD <<EOL
email=${LOGIN_EMAIL}&password=${LOGIN_PASSWORD}
EOL

# Log in to Overleaf and save cookies
echo "Logging into Overleaf..."
curl -s -c $COOKIES_FILE -b $COOKIES_FILE -d @${LOGIN_PAYLOAD} -X POST "${OVERLEAF_URL}/login" -o $LOGIN_RESPONSE
LOGIN_STATUS=$?
if [ $LOGIN_STATUS -ne 0 ]; then
    echo "Error: Login failed with status $LOGIN_STATUS"
    cat $LOGIN_RESPONSE
    exit 1
fi

# Check if login was successful by looking for a specific string in the response
if grep -q "Login failed" $LOGIN_RESPONSE; then
    echo "Error: Login failed. Check your email and password."
    cat $LOGIN_RESPONSE
    exit 1
fi

echo "Login successful."

# Download the project zip using the saved cookies
echo "Downloading project zip file..."
curl -s -L -b $COOKIES_FILE -o $ZIP_FILE "${OVERLEAF_URL}/project/${PROJECT_ID}/download/zip" -D $DOWNLOAD_RESPONSE
DOWNLOAD_STATUS=$?
if [ $DOWNLOAD_STATUS -ne 0 ]; then
    echo "Error: Download failed with status $DOWNLOAD_STATUS"
    cat $DOWNLOAD_RESPONSE
    exit 1
fi

# Check if the file downloaded is a valid zip file by checking its mime type
FILE_TYPE=$(file --mime-type -b $ZIP_FILE)
if [ "$FILE_TYPE" != "application/zip" ]; then
    echo "Error: The downloaded file is not a zip file. File type: $FILE_TYPE"
    cat $DOWNLOAD_RESPONSE
    exit 1
fi

echo "Download successful."

# Clean up temporary files
echo "Cleaning up temporary files..."
rm -f $LOGIN_PAYLOAD
rm -f $COOKIES_FILE
rm -f $LOGIN_RESPONSE
rm -f $DOWNLOAD_RESPONSE

# Extract the project zip file
echo "Extracting project zip file..."
unzip -o $ZIP_FILE -d "$LOCAL_PROJECT_DIR"
EXTRACTION_STATUS=$?
if [ $EXTRACTION_STATUS -ne 0 ]; then
    echo "Error: Extraction failed with status $EXTRACTION_STATUS"
    exit 1
fi
rm -f $ZIP_FILE
echo "Extraction successful."

# Navigate to the local project directory
cd "$LOCAL_PROJECT_DIR"

# Initialize Git repository if not already done
if [ ! -d .git ]; then
    echo "Initializing Git repository..."
    git init
    git remote add github "$GITHUB_REPO_URL"
else
    echo "Git repository already initialized."
fi

# Commit and push changes to GitHub
echo "Committing and pushing changes to GitHub..."
git add .
git commit -m "Update from Overleaf.com"
PUSH_STATUS=$?
if [ $PUSH_STATUS -ne 0 ]; then
    echo "Error: Git commit failed with status $PUSH_STATUS"
    exit 1
fi
git push github master
PUSH_STATUS=$?
if [ $PUSH_STATUS -ne 0 ]; then
    echo "Error: Git push failed with status $PUSH_STATUS"
    exit 1
fi
echo "Sync successful."

# Log end
echo "Overleaf to GitHub sync completed."
