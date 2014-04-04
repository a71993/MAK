(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1&appId=1408127162785258";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


  FB.Event.subscribe('auth.sessionChange', function(response) {
    if (response.session) {
      // A user has logged in, and a new cookie has been saved
    } else {
      // The user has logged out, and the cookie has been cleared
    }
  });
  
  FB.Event.subscribe('auth.login', function(resp) {
        window.location = 'http://makbin-heroku.herokuapp.com/mypastes';
    });
  
  
  