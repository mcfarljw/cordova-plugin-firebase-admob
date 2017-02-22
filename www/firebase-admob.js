var exec = require('cordova/exec');

module.exports = {
  requestInterstitial: function() {
    return new Promise(
      function(resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'requestInterstitial', []);
      }
    );
  },
  setInterstitialAdUnitId: function(adUnitId) {
    return new Promise(
      function(resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'setInterstitialAdUnitId', [adUnitId]);
      }
    );
  },
  showInterstitial: function() {
    return new Promise(
      function(resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'showInterstitial', []);
      }
    );
  }
};
