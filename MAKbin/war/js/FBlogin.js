FB.init({appId: '1408127162785258', status: true, cookie: true, xfbml: true});
  FB.Event.subscribe('auth.sessionChange', function(response) {
    if (response.session) {
      // A user has logged in, and a new cookie has been saved
    } else {
      // The user has logged out, and the cookie has been cleared
    }
  });
  
  FB.Event.subscribe('auth.login', function(resp) {
        window.location = 'http://makbin2014.appspot.com/archive.html';
    });
  
  
  