git init
git add .
echo "Please enter your commit comment: "
read commit
git commit -m "${commit}"
echo "ready to push"

function timeToPush() {
  local input=$1
  if [[ -v memo[$input] ]]; then
    echo "Would you like to use ${input} as the output?"
    read answer
    if [[ $answer -eq 'y']]; then
      return $input

  memo["$input"] = $input 

}
echo "Please enter the url: "
read url
timeToPush $url
git push ${url}
