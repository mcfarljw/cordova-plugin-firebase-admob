#import <Cordova/CDVPlugin.h>

@interface FirebaseAdmobPlugin : CDVPlugin

- (void)addTestDevice:(CDVInvokedUrlCommand*)command;
- (void)getTestDevices:(CDVInvokedUrlCommand*)command;
- (void)requestInterstitial:(CDVInvokedUrlCommand*)command;
- (void)setInterstitialAdUnitId:(CDVInvokedUrlCommand*)command;
- (void)showInterstitial:(CDVInvokedUrlCommand*)command;

@end
