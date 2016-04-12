
//(function(){
  var exec = require('cordova/exec');
  var className = 'DeviceDetector';

  module.exports = {
    isTablet: function(suc, err){
      if(suc && err) {
        exec(suc, err, className, "isTablet", []);
      } else {
        new Error('Wrong parameters');
      }
    }
  };
//})();
