var boxArray = [];
var letters = ['W','O','R','M','W'];
var request = '?wordSize=3';
var guessesForWin;

var alpha = ['A','B','C','D','E','F','G','H','I','J','K','L','M',
'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];

axios.get('http://localhost:8080/HangManSpring/word/'+window.location.search.split("=")[1])
  .then((response) => {
    letters = response.data.toUpperCase().split('');
    var offset = 200;
    var incorrect = 0;
    const app = document.getElementById("app");
    for(var i = 0 ; i < letters.length ; i++){
      var input = document.createElement("label");
      input.setAttribute("id",i);
      input.setAttribute("class","hang-input");
      input.style.width = '50px';
      input.style.height = '50px';
      input.style.lineHeight = '50px';
      input.style.border = '1px solid white';
      input.style.borderRadius = '5px';
      input.innerHTML = "_";
      document.getElementById("letters").appendChild(input);
    }

    for(var i = 0 ; i < alpha.length ; i++){
      var button = document.createElement("button");
      button.addEventListener("click", (e) => {
        var notCompleted = false;
        if(letters.indexOf(e.target.id) > -1){
          e.target.setAttribute("class", "btn btn-success asdf");
          for(let i = 0 ; i < letters.length; i++){
            if(letters[i] === e.target.id){
              document.getElementById(i).innerHTML = letters[i];
              for(let letters in document.getElementsByClassName("hang-input")){
                if(document.getElementsByClassName("hang-input")[letters].innerHTML === "_"){
                  notCompleted = true;
                }
              }
            }
          }
        }else{
          notCompleted = true;
          e.target.setAttribute("class","btn btn-danger asdf");
          incorrect++;
          if(incorrect > 4){
            document.getElementById('killer').innerHTML = "You killed him!";
            let asdf = document.getElementsByClassName("asdf");
            while(asdf[0]){
              asdf[0].remove();
            }
          }
          document.getElementById('incorrect').innerHTML = incorrect;
        }
        if(!notCompleted){
          alert("You win!");
          let asdf = document.getElementsByClassName("asdf");
          while(asdf[0]){
            asdf[0].remove();
          }
        }
      });
      button.setAttribute("id",alpha[i]);
      button.setAttribute("class","btn btn-primary asdf");
      button.style.width = "50px";
      button.style.height = "50px";
      button.style.display = "inline";
      button.style.margin = "5px";
      button.style.cursor = "pointer";
      button.innerHTML = alpha[i];
      document.getElementById("letter-list").appendChild(button);
    }
  })
  .catch((error) => {
    console.log(error);
  });

document.getElementById('submit').addEventListener("click", (e) => {
  window.location.search = document.getElementById('selection').value;
});

document.getElementById('cheat').addEventListener("click", e => {
  let confirm = window.confirm("Are you sure you want to cheat?");
  if(confirm){
    for(var i = 0 ; i < letters.length ; i++){
      document.getElementById(i).innerHTML = letters[i];
    }
    let asdf = document.getElementsByClassName("asdf");
    while(asdf[0]){
      asdf[0].remove();
    }
  }
});
