git init
git add .
echo "Please enter your commit comment: "
read commit
git commit -m "${commit}"
echo "ready to push"
echo "Please enter the url: "
read url
git push ${url}
