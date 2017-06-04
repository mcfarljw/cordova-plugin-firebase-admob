var exec = require('cordova/exec');

module.exports = {
  addTestDevice: function (deviceId) {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'addTestDevice', [deviceId]);
      }
    );
  },
  getTestDevices: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'getTestDevices', []);
      }
    );
  },
  requestInterstitial: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'requestInterstitial', []);
      }
    );
  },
  setInterstitialAdUnitId: function (adUnitId) {
    return new Promise(
      function(resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'setInterstitialAdUnitId', [adUnitId]);
      }
    );
  },
  showInterstitial: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'FirebaseAdmobPlugin', 'showInterstitial', []);
      }
    );
  }
};
