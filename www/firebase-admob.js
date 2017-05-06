var exec = require('cordova/exec');

function arrify(value) {
  return Array.isArray(value) ? value : [value];
}

module.exports = {
  addTestDevice: function(deviceIds) {
    return new Promise(
      function(resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'addTestDevice', [arrify(deviceIds)]);
      }
    );
  },
  getTestDevices: function() {
    return new Promise(
      function(resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'getTestDevices', []);
      }
    );
  },
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
